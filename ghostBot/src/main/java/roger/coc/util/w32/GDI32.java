package roger.coc.util.w32;

import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

public interface GDI32 extends com.sun.jna.platform.win32.GDI32,
		com.sun.jna.platform.win32.WinGDI, com.sun.jna.platform.win32.WinDef {

	GDI32 INSTANCE = (GDI32) Native.loadLibrary(GDI32.class);

	boolean BitBlt(HDC hdcDest, int nXDest, int nYDest, int nWidth,
			int nHeight, HDC hdcSrc, int nXSrc, int nYSrc, int dwRop);

	HDC GetDC(HWND hWnd);

	boolean GetDIBits(HDC dc, HBITMAP bmp, int startScan, int scanLines,
			byte[] pixels, BITMAPINFO bi, int usage);

	boolean GetDIBits(HDC dc, HBITMAP bmp, int startScan, int scanLines,
			short[] pixels, BITMAPINFO bi, int usage);

	boolean GetDIBits(HDC dc, HBITMAP bmp, int startScan, int scanLines,
			int[] pixels, BITMAPINFO bi, int usage);

	public static int SRCCOPY = 0xCC0020;
}

