package roger.coc.util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.imageio.ImageIO;

import org.sikuli.core.search.RegionMatch;
import org.sikuli.core.search.algorithm.TemplateMatcher;

import roger.coc.constant.GameConstant;
import aok.coc.util.RobotUtils;

import com.google.common.collect.Lists;
import com.sun.jna.platform.win32.WinDef.POINT;
import com.github.axet.lookup.OCR;

/**
 * @author zirui.wzr
 * image util such as ocr/img match/
 */
public class ImageUtil {

	public static Robot r;
	
	public static String ocr(BufferedImage image)
	{
		OCR ocr=new OCR(0.8f);
		ocr.loadFontsDirectory(ImageUtil.class, new File("fonts"));
		String str=ocr.recognize(image);
		return str;
	}
	
	public static List<int[]> imageMatch(BufferedImage source,BufferedImage pattern,double sens)
	{
		List<int[]> result=Lists.newArrayList();
		List<RegionMatch> doFindAll = TemplateMatcher.findMatchesByGrayscaleAtOriginalResolution(
				source, pattern, 20, sens);

			if(doFindAll!=null && doFindAll.size()!=0)
			{
				for(RegionMatch rm:doFindAll)
				{
					int[] rec=CommonsUtil.rec2array(rm.getBounds());
					result.add(new int[]{(rec[0]+rec[2])/2,(rec[1]+rec[3])/2});
				}
			}
		return result;
	}
	
	public static BufferedImage screenShot(int x1,int y1,int x2,int y2)
	{
		BufferedImage image=Win32Util.getScreenshot(x1, y1, x2, y2);
		saveScreenShot(image,"C:/coc/",String.valueOf(System.currentTimeMillis()));
		return image;
	}
	
	public static boolean compareColor(int c1,int c2,int sens)
	{
		int r1 = (c1 >> 16) & 0xFF;
		int r2 = (c2 >> 16) & 0xFF;

		int g1 = (c1 >> 8) & 0xFF;
		int g2 = (c2 >> 8) & 0xFF;

		int b1 = (c1 >> 0) & 0xFF;
		int b2 = (c2 >> 0) & 0xFF;

		if (Math.abs(r1 - r2) > sens || Math.abs(g1 - g2) > sens || Math.abs(b1 - b2) > sens) {
			return false;
		} else {
			return true;
		}
	}
	
	public static int parseNumber(BufferedImage image, int type, int xStart, int yStart, int maxSearchWidth) {
		
		//this func is used to parse loot ,type value say GameConstant
		String no = "";
		int curr = xStart;
		while (curr < xStart + maxSearchWidth) {
			Integer i = parseDigit(image, curr, yStart, type);
			if (i != null) {
				no += i;
				curr += GameConstant.widths[i] - 1;
			} else {
				curr++;
			}
		}
		if (!no.isEmpty()) {
			return Integer.parseInt(no);
		} else {
			return 0;
		}
	}
	
	public static File saveScreenShot(BufferedImage img, String filePath,String fileName) {
		try
		{
		if (!(fileName.toString().toLowerCase().endsWith(".png"))) {
			fileName = fileName.toString() + ".png";
		}
		File file = new File(filePath, fileName);
		if (!file.getParentFile().isDirectory()) {
			file.getParentFile().mkdirs();
		}
		ImageIO.write(img, "png", file);
		return file;
		}
		catch(Exception e)
		{
			LogUtil.log(e.toString());
			return null;
		}
	}
	
	private static Integer parseDigit(BufferedImage image, int xStart, int yStart, int type) {

		for (int i = 0; i < 10; i++) {
			boolean found = true;
			for (int j = 0; j < GameConstant.offsets[i].length; j++) {
				int actual = image.getRGB(xStart + GameConstant.offsets[i][j][0], yStart + GameConstant.offsets[i][j][1]);
				actual=actual & 0x00FFFFFF;
				int expected = GameConstant.colors[i][type][j];
				if (!RobotUtils.compareColor(actual, expected, GameConstant.COLOR_SENSITIVE)) {
					found = false;
					break;
				}
			}

			if (found) {
				return i;
			}
		}

		return null;
	}
	
	public static BufferedImage getImageFromSource(URL url)
	{
		try {
			return ImageIO.read(url);
		} catch (IOException e) {
			return null;
		}
	}
	
	public static BufferedImage getImageFromFile(String path)
	{
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			return null;
		}
	}
}
