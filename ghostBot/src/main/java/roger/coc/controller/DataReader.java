package roger.coc.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;

import roger.coc.constant.GameConstant;
import roger.coc.util.ImageUtil;
import aok.coc.exception.BotBadBaseException;
import aok.coc.util.RobotUtils;

/**
 * @author zirui.wzr
 * read data from game (gold/elixir/etc)
 */
public class DataReader {
	
	/**
	 * read enemy resources 
	 * result[0] result[1] result[2] means gold elixir  dark-elixir
	 * @return
	 */
	public static int[] readEnemyResource()
	{
		BufferedImage image=ImageUtil.screenShot(GameConstant.ENEMY_LOOT[0], GameConstant.ENEMY_LOOT[1], GameConstant.ENEMY_LOOT[2], GameConstant.ENEMY_LOOT[3]);
		int[] result=new int[3];
		result[0]=parseGold(image);
		result[1]=parseElixir(image);
		result[2]=parseDarkElixir(image);
		return new int[3];
	}
	
	public static boolean lootHasDarkElixir(BufferedImage image)
	{
		if(image==null)
		{
			image=ImageUtil.screenShot(GameConstant.ENEMY_LOOT[0], GameConstant.ENEMY_LOOT[1], GameConstant.ENEMY_LOOT[2], GameConstant.ENEMY_LOOT[3]);
		}
		int deCheck = image.getRGB(20, 0);

		if (ImageUtil.compareColor(deCheck,GameConstant.COLOR_DE.getRGB(), 7)) {
			return true;
		} else {
			return false;
		
	}
	}
	
	public static int parseGold(BufferedImage image){
		if(image==null)
		{
			image=ImageUtil.screenShot(GameConstant.ENEMY_LOOT[0], GameConstant.ENEMY_LOOT[1], GameConstant.ENEMY_LOOT[2], GameConstant.ENEMY_LOOT[3]);
		}
		return ImageUtil.parseNumber(image, GameConstant.DIGIT_TYPE_GOLD, GameConstant.LOOT_GOLD_START[0], GameConstant.LOOT_GOLD_START[1] + (lootHasDarkElixir(image) ? 0 : 1), image.getWidth() - GameConstant.MAX_SEARCH_INDENT);
	}

	public static int parseElixir(BufferedImage image) {
		if(image==null)
		{
			image=ImageUtil.screenShot(GameConstant.ENEMY_LOOT[0], GameConstant.ENEMY_LOOT[1], GameConstant.ENEMY_LOOT[2], GameConstant.ENEMY_LOOT[3]);
		}
		return ImageUtil.parseNumber(image,  GameConstant.DIGIT_TYPE_ELIXIR, GameConstant.LOOT_ELIXIR_START[0], GameConstant.LOOT_ELIXIR_START[1] + (lootHasDarkElixir(image) ? 0 : 1), image.getWidth() - GameConstant.MAX_SEARCH_INDENT);
	}

	public static int parseDarkElixir(BufferedImage image)  {
		if(image==null)
		{
			image=ImageUtil.screenShot(GameConstant.ENEMY_LOOT[0], GameConstant.ENEMY_LOOT[1], GameConstant.ENEMY_LOOT[2], GameConstant.ENEMY_LOOT[3]);
		}
		if (!lootHasDarkElixir(image)) {
			return 0;
		}
		return ImageUtil.parseNumber(image,  GameConstant.DIGIT_TYPE_DE, GameConstant.LOOT_DE_START[0], GameConstant.LOOT_DE_START[1], image.getWidth() - GameConstant.MAX_SEARCH_INDENT);
	}

//	public static int parseTrophy(BufferedImage image) {
//		if(image==null)
//		{
//			image=ImageUtil.screenShot(GameConstant.ENEMY_LOOT[0], GameConstant.ENEMY_LOOT[1], GameConstant.ENEMY_LOOT[2], GameConstant.ENEMY_LOOT[3]);
//		}
//		if (!lootHasDarkElixir(image)) {
//			return ImageUtil.parseNumber(image, GameConstant.DIGIT_TYPE_ATTACKGROUP, 33, 62, image.getWidth() -  GameConstant.MAX_SEARCH_INDENT);
//		} else {
//			return ImageUtil.parseNumber(image,  GameConstant.DIGIT_TYPE_ATTACKGROUP, 33, 90, image.getWidth() -  GameConstant.MAX_SEARCH_INDENT);
//		}
//	}
}
