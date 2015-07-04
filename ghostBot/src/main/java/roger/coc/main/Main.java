package roger.coc.main;

import roger.coc.util.LogUtil;

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
		
		
	}
}
