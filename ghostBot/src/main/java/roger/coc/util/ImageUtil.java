package roger.coc.util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import roger.coc.constant.GameConstant;
import aok.coc.util.RobotUtils;

import com.sun.jna.platform.win32.WinDef.POINT;

/**
 * @author zirui.wzr
 * image util such as ocr/img match/
 */
public class ImageUtil {

	private static Robot r;
	
	
	public static int[][] getImageCoord(BufferedImage source,BufferedImage pattern)
	{
		return null;
	}
	
	public static BufferedImage screenShot(int x1,int y1,int x2,int y2)
	{
		POINT point = new POINT(x1, y1);
		//clientToScreen(point);
		return r.createScreenCapture(new Rectangle(point.x, point.y, x2 - x1, y2 - y1));
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
	
	public static File saveScreenShot(BufferedImage img, String filePath,String fileName) throws IOException {
		if (!(fileName.toString().toLowerCase().endsWith(".png"))) {
			fileName = filePath.toString() + ".png";
		}
		File file = new File(filePath, fileName);
		if (!file.getParentFile().isDirectory()) {
			file.getParentFile().mkdirs();
		}
		ImageIO.write(img, "png", file);
		return file;
	}
	
	private static Integer parseDigit(BufferedImage image, int xStart, int yStart, int type) {

		for (int i = 0; i < 10; i++) {
			boolean found = true;
			for (int j = 0; j < GameConstant.offsets[i].length; j++) {
				int actual = image.getRGB(xStart + GameConstant.offsets[i][j][0], yStart + GameConstant.offsets[i][j][1]);
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
}
