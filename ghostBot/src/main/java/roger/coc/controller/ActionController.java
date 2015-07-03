package roger.coc.controller;

/**
 * @author zirui.wzr
 * send command to game (attack/train troops/find enemy/etc...)
 */
public class ActionController {
	public static boolean openTrainDialog()
	{
		return true;
	}
	public static boolean closeTrainDialog()
	{
		return true;
	}

	public static boolean applyFriendlyTroop(String msg)
	{
		return true;
	}
	
	public static boolean openBarrack(int index)
	{
		return true;
	}
	

	public static boolean openDarkBarrack(int index)
	{
		return true;
	}
	

	public static boolean openSpellFactory(int index)
	{
		return true;
	}
	
	public static boolean openDarkSpellFactory(int index)
	{
		return true;
	}
	
	public static boolean openSearchEnemyDialog()
	{
		return true;
	}
	
	public static boolean doSearchEnemy()
	{
		return true;
	}
	
	public static boolean doSearchNextEnemy()
	{
		return true;
	}
	
	public static boolean putTroopsOn(int x,int y,int slot)
	{
		return true;
	}
	
	public static boolean closeLootDialog()
	{
		return true;
	}
}
