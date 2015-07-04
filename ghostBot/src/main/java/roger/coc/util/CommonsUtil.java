package roger.coc.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

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
	
	public static void putTextIntoClipBoard(String str)
	{
		 Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		 Transferable tText = new StringSelection(str);
         clip.setContents(tText, null);
				 
	}
}
