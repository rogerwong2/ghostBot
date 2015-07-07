package roger.coc.util;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinGDI;
import com.sun.jna.platform.win32.WinNT;

import roger.coc.constant.SystemConstant;
import roger.coc.util.w32.Kernel32;
import roger.coc.util.w32.User32;
import roger.coc.util.w32.GDI32;


/**
 * @author zirui.wzr
 * this util is used for operating window such as zoom/click/type-in/etc...
 */
public class Win32Util {

	public static HWND			handler				= null;
	
	public static void clickPoint(int x,int y)
	{

		int lParam = makeParam(x, y);
		while(isCtrlKeyDown())
		{
			
		}
		User32.INSTANCE.SendMessage(handler, SystemConstant.WM_LBUTTONDOWN, 0x00000001, lParam);
		User32.INSTANCE.SendMessage(handler, SystemConstant.WM_LBUTTONUP, 0x00000000, lParam);
	}
	
	public static void ctrlV()
	{
		int lParam = 0x00000001 | (0x50 /*scancode*/<< 16) | 0x01000000 /*extended*/;
		WPARAM wparam = new WinDef.WPARAM(SystemConstant.VK_CONTROL);
		WPARAM wparamv = new WinDef.WPARAM(SystemConstant.VK_V);
		LPARAM lparamDown = new WinDef.LPARAM(lParam);
		LPARAM lparamUp = new WinDef.LPARAM(lParam | 1 << 30 | 1 << 31);
		User32.INSTANCE.PostMessage(handler, SystemConstant.WM_KEYDOWN, wparam, lparamDown);
		User32.INSTANCE.PostMessage(handler, SystemConstant.WM_KEYDOWN, wparamv, lparamDown);
		User32.INSTANCE.PostMessage(handler, SystemConstant.WM_KEYUP, wparamv, lparamUp);
		User32.INSTANCE.PostMessage(handler, SystemConstant.WM_KEYUP, wparam, lparamUp);
	
	}
	
	public static void zoomUp()
	{
		int lParam = 0x00000001 | (0x50 /*scancode*/<< 16) | 0x01000000 /*extended*/;

		WPARAM wparam = new WinDef.WPARAM(SystemConstant.VK_DOWN);
		LPARAM lparamDown = new WinDef.LPARAM(lParam);
		LPARAM lparamUp = new WinDef.LPARAM(lParam | 1 << 30 | 1 << 31);

		for (int i = 0; i < 10; i++) {
			while (isCtrlKeyDown()) {
			}
			User32.INSTANCE.PostMessage(handler, SystemConstant.WM_KEYDOWN, wparam, lparamDown);
			User32.INSTANCE.PostMessage(handler, SystemConstant.WM_KEYUP, wparam, lparamUp);
			CommonsUtil.safeSleep(1000);
		}
	}
	
	
	
	private static boolean isCtrlKeyDown() {
		return User32.INSTANCE.GetKeyState(SystemConstant.VK_CONTROL) < 0;
	}
	private static int makeParam(int low, int high) {
		// to work for negative numbers
		return (high << 16) | ((low << 16) >>> 16);
	}
	
	
	public static BufferedImage getScreenshot(int x1,int y1,int x2,int y2) {
        WinDef.HDC windowDC = User32.INSTANCE.GetDC(handler);
        WinDef.HBITMAP outputBitmap =
                GDI32.INSTANCE.CreateCompatibleBitmap(windowDC,
                x2-x1,y2-y1);
        try {
            WinDef.HDC blitDC = GDI32.INSTANCE.CreateCompatibleDC(windowDC);
            try {
                WinNT.HANDLE oldBitmap =
                		GDI32.INSTANCE.SelectObject(blitDC, outputBitmap);
                try {
                	GDI32.INSTANCE.BitBlt(blitDC,
                            0, 0, x2-x1, y2-y1,
                            windowDC,
                            x1, y1,
                            GDI32.SRCCOPY);
                } finally {
                    GDI32.INSTANCE.SelectObject(blitDC, oldBitmap);
                }
                WinGDI.BITMAPINFO bi = new WinGDI.BITMAPINFO(40);
                bi.bmiHeader.biSize = 40;
                boolean ok =
                		GDI32.INSTANCE.GetDIBits(blitDC, outputBitmap, 0, y2-y1,
                        (byte[]) null, bi, WinGDI.DIB_RGB_COLORS);
                if (ok) {
                    WinGDI.BITMAPINFOHEADER bih = bi.bmiHeader;
                    bih.biHeight = -Math.abs(bih.biHeight);
                    bi.bmiHeader.biCompression = 0;
                    return bufferedImageFromBitmap(blitDC, outputBitmap, bi);
                } else {
                    return null;
                }
            } finally {
            	GDI32.INSTANCE.DeleteObject(blitDC);
            }
        } finally {
        	GDI32.INSTANCE.DeleteObject(outputBitmap);
        }
    }
	
	private static BufferedImage bufferedImageFromBitmap(WinDef.HDC blitDC,
            WinDef.HBITMAP outputBitmap,
            WinGDI.BITMAPINFO bi) {
        WinGDI.BITMAPINFOHEADER bih = bi.bmiHeader;
        int height = Math.abs(bih.biHeight);
        final ColorModel cm;
        final DataBuffer buffer;
        final WritableRaster raster;
        int strideBits =
                (bih.biWidth * bih.biBitCount);
        int strideBytesAligned =
                (((strideBits - 1) | 0x1F) + 1) >> 3;
        final int strideElementsAligned;
        switch (bih.biBitCount) {
            case 16:
                strideElementsAligned = strideBytesAligned / 2;
                cm = new DirectColorModel(16, 0x7C00, 0x3E0, 0x1F);
                buffer =
                        new DataBufferUShort(strideElementsAligned * height);
                raster =
                        Raster.createPackedRaster(buffer,
                        bih.biWidth, height,
                        strideElementsAligned,
                        ((DirectColorModel) cm).getMasks(),
                        null);
                break;
            case 32:
                strideElementsAligned = strideBytesAligned / 4;
                cm = new DirectColorModel(32, 0xFF0000, 0xFF00, 0xFF);
                buffer =
                        new DataBufferInt(strideElementsAligned * height);
                raster =
                        Raster.createPackedRaster(buffer,
                        bih.biWidth, height,
                        strideElementsAligned,
                        ((DirectColorModel) cm).getMasks(),
                        null);
                break;
            default:
                throw new IllegalArgumentException("Unsupported bit count: " + bih.biBitCount);
        }
        final boolean ok;
        switch (buffer.getDataType()) {
            case DataBuffer.TYPE_INT: {
                int[] pixels = ((DataBufferInt) buffer).getData();
                ok = GDI32.INSTANCE.GetDIBits(blitDC, outputBitmap, 0, raster.getHeight(), pixels, bi, 0);
            }
            break;
            case DataBuffer.TYPE_USHORT: {
                short[] pixels = ((DataBufferUShort) buffer).getData();
                ok = GDI32.INSTANCE.GetDIBits(blitDC, outputBitmap, 0, raster.getHeight(), pixels, bi, 0);
            }
            break;
            default:
                throw new AssertionError("Unexpected buffer element type: " + buffer.getDataType());
        }
        if (ok) {
            return new BufferedImage(cm, raster, false, null);
        } else {
            return null;
        }
    }
	
}
