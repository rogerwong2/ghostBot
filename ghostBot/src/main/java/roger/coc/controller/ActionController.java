package roger.coc.controller;

import java.awt.image.BufferedImage;
import java.util.List;

import com.google.common.collect.Lists;

import roger.coc.constant.GameConstant;
import roger.coc.constant.ImagePath;
import roger.coc.constant.SystemConstant;
import roger.coc.main.BotLoopper;
import roger.coc.util.CommonsUtil;
import roger.coc.util.ImageUtil;
import roger.coc.util.LogUtil;
import roger.coc.util.Win32Util;

/**
 * @author zirui.wzr
 * send command to game (attack/train troops/find enemy/etc...)
 */
public class ActionController {
	public static boolean openTroopDialog()
	{
		Win32Util.clickPoint(GameConstant.BTN_TROOP_OPEN[0], GameConstant.BTN_TROOP_OPEN[1]);
		CommonsUtil.safeSleep();
		return true;
	}
	public static boolean closeTROOPDialog()
	{
		Win32Util.clickPoint(GameConstant.BTN_TROOP_CLOSE[0], GameConstant.BTN_TROOP_CLOSE[1]);
		CommonsUtil.safeSleep();
		return true;
	}

	public static boolean requestTroops(String msg)
	{
		Win32Util.clickPoint(GameConstant.BTN_TROOP_REQTROOPS[0], GameConstant.BTN_TROOP_REQTROOPS[1]);
		CommonsUtil.safeSleep();
		Win32Util.clickPoint(GameConstant.BTN_REQTROOPS_INPUT[0], GameConstant.BTN_REQTROOPS_INPUT[1]);
		CommonsUtil.safeSleep();
		CommonsUtil.putTextIntoClipBoard(msg);
		CommonsUtil.safeSleep();
		Win32Util.ctrlV();
		CommonsUtil.safeSleep();
		Win32Util.clickPoint(GameConstant.BTN_REQTROOPS_CONFIRM[0], GameConstant.BTN_REQTROOPS_CONFIRM[1]);
		return true;
	}
	
	public static boolean openBarrack(int index)
	{
		//index must between 0-3
		if(index<0 || index>3)
		{
			return false;
		}
		Win32Util.clickPoint(GameConstant.BTN_TROOP_BRARACK[index][0], GameConstant.BTN_TROOP_BRARACK[index][1]);
		CommonsUtil.safeSleep();
		return true;
	}
	

	public static boolean openDarkBarrack(int index)
	{
		//index must between 0-1
		if(index<0 || index>1)
		{
			return false;
		}
		Win32Util.clickPoint(GameConstant.BTN_TROOP_DARKBRARACK[index][0], GameConstant.BTN_TROOP_DARKBRARACK[index][1]);
		CommonsUtil.safeSleep();
		return true;
	}
	

	public static boolean openSpellFactory()
	{
		Win32Util.clickPoint(GameConstant.BTN_TROOP_SPELLFAC[0], GameConstant.BTN_TROOP_SPELLFAC[1]);
		CommonsUtil.safeSleep();
		return true;
	}
	
	public static boolean openDarkSpellFactory(int index)
	{
		Win32Util.clickPoint(GameConstant.BTN_TROOP_DARKSPELLFAC[0], GameConstant.BTN_TROOP_DARKSPELLFAC[1]);
		CommonsUtil.safeSleep();
		return true;
	}
	
	public static boolean openSearchEnemyDialog()
	{
		Win32Util.clickPoint(GameConstant.BTN_ATTACK_OPEN[0],GameConstant.BTN_ATTACK_OPEN[1]);
		CommonsUtil.safeSleep();
		return true;
	}
	
	public static boolean doSearchEnemy()
	{
		Win32Util.clickPoint(GameConstant.BTN_ATTACK_FINDMATCH[0],GameConstant.BTN_ATTACK_FINDMATCH[1]);
		CommonsUtil.safeSleep();
		while(!StatusJudger.isReadyToAttack() && BotLoopper.isRunning)
		{
			CommonsUtil.safeSleep();
		}
		return true;
	}
	
	public static boolean doSearchNextEnemy()
	{
		Win32Util.clickPoint(GameConstant.BTN_ATTACK_FINDNEXTMATCH[0],GameConstant.BTN_ATTACK_FINDNEXTMATCH[1]);
		CommonsUtil.safeSleep();
		while(!StatusJudger.isReadyToAttack() && BotLoopper.isRunning)
		{
			CommonsUtil.safeSleep();
		}
		return true;
	}
	
	public static boolean putTroopsOn(int x,int y,int slot)
	{
		return putTroopsOn(Lists.newArrayList(new int[]{x,y}),slot);
	}
	
	public static boolean putTroopsOn(List<int[]> coords,int slot)
	{
		Win32Util.clickPoint(GameConstant.BTN_ATTACK_SLOTS[slot][0], GameConstant.BTN_ATTACK_SLOTS[slot][1]);
		CommonsUtil.safeSleep(200);
		if(coords==null || coords.size()==0)
		{
			return true;
		}
		clickSequence(coords,50);
		return true;
	}
	
	public static boolean closeLootDialog()
	{
		Win32Util.clickPoint(GameConstant.BTN_ATTACK_RETURNHOME[0],GameConstant.BTN_ATTACK_RETURNHOME[1]);
		CommonsUtil.safeSleep();
		return true;
	}
	
	public static boolean saySth(String msg)
	{
		Win32Util.clickPoint(GameConstant.BTN_CHAT_OPEN[0], GameConstant.BTN_CHAT_OPEN[1]);
		CommonsUtil.safeSleep();
		Win32Util.clickPoint(GameConstant.BTN_CHAT_INPUT[0], GameConstant.BTN_CHAT_INPUT[1]);
		CommonsUtil.safeSleep();
		CommonsUtil.putTextIntoClipBoard(msg);
		CommonsUtil.safeSleep();
		Win32Util.ctrlV();
		CommonsUtil.safeSleep();
		Win32Util.clickPoint(GameConstant.BTN_CHAT_SEND[0], GameConstant.BTN_CHAT_SEND[1]);
		CommonsUtil.safeSleep();
		Win32Util.clickPoint(GameConstant.BTN_CHAT_CLOSE[0], GameConstant.BTN_CHAT_CLOSE[1]);
		return true;
	}
	
	public static boolean collectResource()
	{
		BufferedImage image=ImageUtil.screenShot(0, 0, SystemConstant.DEFAULT_X,SystemConstant.DEFAULT_Y);
		BufferedImage pattern=null;
		List<int[]> coords=Lists.newArrayList();
		//collect gold
		pattern=ImageUtil.getImageFromSource(ActionController.class.getResource(ImagePath.IDLE_GOLD));
		coords=ImageUtil.imageMatch(image, pattern,0.5);
		LogUtil.log("find "+coords.size()+" gold!");
		clickSequence(coords,500);
		//collect 
		pattern=ImageUtil.getImageFromSource(ActionController.class.getResource(ImagePath.IDLE_ELIXIR));
		coords=ImageUtil.imageMatch(image, pattern,0.9);
		LogUtil.log("find "+coords.size()+" elixir!");
		clickSequence(coords,500);
		//de
		pattern=ImageUtil.getImageFromSource(ActionController.class.getResource(ImagePath.IDLE_DE));
		coords=ImageUtil.imageMatch(image, pattern,0.9);
		LogUtil.log("find "+coords.size()+" de!");
		clickSequence(coords,500);
		return true;
	}
	
	private static void clickSequence(List<int[]> coords,long interval)
	{
		if(coords==null || coords.size()==0) return;
		for(int[] point:coords)
		{
			Win32Util.clickPoint(point[0],point[1]);
			CommonsUtil.safeSleep(interval);
		}
	}
}
