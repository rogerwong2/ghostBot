package roger.coc.util;

/**
 * @author zirui.wzr
 * other util
 */
public class CommonsUtil {
	
	private static final int DEFAULT_SLEEPTIME=200;
	
	public static void safeSleep()
	{
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			
		}
	}
	
	public static void safeSleep(long s)
	{
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			
		}
	}
}
