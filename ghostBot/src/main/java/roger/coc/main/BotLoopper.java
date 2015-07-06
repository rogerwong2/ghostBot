package roger.coc.main;

import roger.coc.config.ConfigManager;
import roger.coc.config.dataobject.GlobalConfig;
import roger.coc.util.CommonsUtil;
import roger.coc.util.LogUtil;

/**
 * @author Administrator
 * bot loopper
 */
public class BotLoopper {
	
	public static boolean isRunning=true;
	
	public static void mainLopper()
	{
		while(isRunning)
		{
			GlobalConfig config=ConfigManager.getConfig();
			// dosth
			LogUtil.log("unfinished");
			CommonsUtil.safeSleep(20000);
		}
	}
}
