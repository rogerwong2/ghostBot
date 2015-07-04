package roger.coc.main;

import java.util.Locale;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinReg.HKEYByReference;

import aok.coc.util.w32.User32;
import roger.coc.awt.MessageBox;
import roger.coc.constant.SystemConstant;
import roger.coc.util.LogUtil;
import roger.coc.util.Win32Util;

/**
 * @author zirui.wzr
 * to initialize window handler and change resolution
 */
public class Initializer {
	
	public static boolean Initialize()
	{
		LogUtil.log("initialize start...");
		Locale.setDefault(Locale.ROOT);
		if(!initializeResolution())
		{
			return false;
		}
		if(!initializeWin32())
		{
			return false;
		}
		return true;
	}
	
	private static boolean initializeResolution()
	{
		try {
			HKEYByReference key = Advapi32Util.registryGetKey(WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\BlueStacks\\Guests\\Android\\FrameBuffer\\0", WinNT.KEY_READ | WinNT.KEY_WRITE);

			int w1 = Advapi32Util.registryGetIntValue(key.getValue(), "WindowWidth");
			int h1 = Advapi32Util.registryGetIntValue(key.getValue(), "WindowHeight");
			int w2 = Advapi32Util.registryGetIntValue(key.getValue(), "GuestWidth");
			int h2 = Advapi32Util.registryGetIntValue(key.getValue(), "GuestHeight");
	
			if (w1 == SystemConstant.DEFAULT_X && h1 == SystemConstant.DEFAULT_Y &&
				w2 == SystemConstant.DEFAULT_X && h2 == SystemConstant.DEFAULT_Y) {
				return true;
			}
			
			Advapi32Util.registrySetIntValue(key.getValue(), "WindowWidth", SystemConstant.DEFAULT_X );
			Advapi32Util.registrySetIntValue(key.getValue(), "WindowHeight", SystemConstant.DEFAULT_Y );
			Advapi32Util.registrySetIntValue(key.getValue(), "GuestWidth", SystemConstant.DEFAULT_X );
			Advapi32Util.registrySetIntValue(key.getValue(), "GuestHeight", SystemConstant.DEFAULT_Y );
			Advapi32Util.registrySetIntValue(key.getValue(), "FullScreen", 0);
			
			MessageBox.confirmationBox("Only resolution "+SystemConstant.DEFAULT_X+"*"+SystemConstant.DEFAULT_Y+" is supported, but your resolution is "+w1+"*"+h1+". But this bot has change the resolution to correct value, please restart your bluestacks!", "resolution error");

		}  catch (Exception e) {
			LogUtil.log(e.toString());
		}
		return false;
	}
	
	private static boolean initializeWin32()
	{
		HWND bsHwnd = User32.INSTANCE.FindWindow(null, SystemConstant.BS_WINDOW_NAME);
		if(bsHwnd==null)
		{
			LogUtil.log("can't find bluestack window,please insure bluestacks android simulator is running.");
			return false;
		}

		int[] rect = { 0, 0, 0, 0 };
		int result = User32.INSTANCE.GetWindowRect(bsHwnd, rect);
		if (result == 0) {
			LogUtil.log("can't find bluestack window,please insure bluestacks android simulator is running.");
			return false;
		}
		int bsX = rect[2] - rect[0];
		int bsY = rect[3] - rect[1];
		
		if (bsX == SystemConstant.DEFAULT_X && bsY == SystemConstant.DEFAULT_Y) {
			LogUtil.log("Only resolution "+SystemConstant.DEFAULT_X+"*"+SystemConstant.DEFAULT_Y+" is supported, but your resolution is "+bsX+"*"+bsY);
			return false;
		}
		Win32Util.handler=bsHwnd;
		
		return true;
	}
}
