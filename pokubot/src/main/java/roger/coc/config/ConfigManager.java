package roger.coc.config;

/**
 * @author zirui.wzr
 * get/update bot config
 */
public class ConfigManager {
	
	private static GlobalConfig config;
	/**
	 * write config to hard disk
	 * @param congif
	 * @return
	 */
	public static boolean updateConfig(GlobalConfig congif)
	{
		return true;
	}
	
	
	/**
	 * read config from hard disk
	 * @return
	 */
	public static boolean refreshConfig()
	{
		return true;
	}
	
	
	/**
	 * get current config
	 * @return
	 */
	public static GlobalConfig getConfig()
	{
		return config;
	}
}
