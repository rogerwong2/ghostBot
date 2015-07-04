package roger.coc.util;

import java.util.logging.Logger;

public class LogUtil {
	
	private static Logger logger=Logger.getLogger(LogUtil.class.getName());
	
	
	public static void  log(String s)
	{
		logger.info(s);
	}
}
