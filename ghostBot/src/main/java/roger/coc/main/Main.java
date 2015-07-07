package roger.coc.main;

import java.awt.image.BufferedImage;

import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.WPARAM;

import roger.coc.constant.SystemConstant;
import roger.coc.controller.ActionController;
import roger.coc.controller.DataReader;
import roger.coc.util.CommonsUtil;
import roger.coc.util.ImageUtil;
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
		//	ActionController.openTroopDialog();
			//ActionController.requestTroops("test");
			//ActionController.collectResource();
			BufferedImage image=ImageUtil.getImageFromFile("D:\\develop\\workspace\\pokubot\\pokubot-master\\pokubot\\src\\test\\resources\\parser_images\\222.png");//zort_1420312983010_0.png
			int[] result=new int[3];
			result[0]=DataReader.parseGold(image);
			result[1]=DataReader.parseElixir(image);
			result[2]=DataReader.parseDarkElixir(image);
			
		//	int[] result=DataReader.readEnemyResource();
			BotLoopper.mainLopper();
		}
		
		
	}
}
