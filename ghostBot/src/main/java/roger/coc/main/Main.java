package roger.coc.main;

import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.WPARAM;

import roger.coc.constant.SystemConstant;
import roger.coc.util.CommonsUtil;
import roger.coc.util.LogUtil;
import roger.coc.util.Win32Util;
import roger.coc.util.w32.User32;

/**
 * @author zirui.wzr
 * bot entry
 */
public class Main {
	
	public static void main(String[] argvs)
	{
		if(!Initializer.Initialize())
		{
			LogUtil.log("initialize fail");
		}
		else
		{
			//Win32Util.zoomUp();
			CommonsUtil.putTextIntoClipBoard("ghostBot test,anything is ok!^_^ ÖÐÎÄ");
			Win32Util.ctrlV();
			BotLoopper.mainLopper();
		}
		
		
	}
}
