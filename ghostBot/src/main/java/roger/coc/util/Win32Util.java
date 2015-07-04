package roger.coc.util;

import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.WPARAM;

import roger.coc.constant.SystemConstant;
import roger.coc.util.w32.User32;


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
	
	public static void zoomUp()
	{
		int lParam = 0x00000001 | (0x50 /*scancode*/<< 16) | 0x01000000 /*extended*/;

		WPARAM wparam = new WinDef.WPARAM(SystemConstant.VK_DOWN);
		LPARAM lparamDown = new WinDef.LPARAM(lParam);
		LPARAM lparamUp = new WinDef.LPARAM(lParam | 1 << 30 | 1 << 31);

		for (int i = 0; i < 14; i++) {
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
	
	
}
