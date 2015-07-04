package roger.coc.constant;

import java.awt.Color;

/**
 * @author zirui.wzr
 * coord for all the game's position
 */
public class GameConstant {

	//===================button====================
	
	
	
	//===================number====================
	private static final int[][]	OFFSET_ZERO				= new int[][] { { 6, 4 }, { 7, 7 }, { 10, 13 } };
	private static final int[][]	COLOR_ZERO				= new int[][] { { 0x989579, 0x39382E, 0x272720 },
															{ 0x978A96, 0x393439, 0x272427 },
															{ 0x909090, 0x363636, 0x262626 },
															{ 0x979797, 0x393939, 0x262626 }
															};

	private static final int[][]	OFFSET_ONE				= new int[][] { { 1, 1 }, { 1, 12 }, { 4, 12 } };
	private static final int[][]	COLOR_ONE				= new int[][] { { 0x979478, 0x313127, 0xD7D4AC },
															{ 0x968895, 0x312D31, 0xD8C4D6 },
															{ 0x8F8F8F, 0x2F2F2F, 0xCDCDCD },
															{ 0x979797, 0x313131, 0xD7D7D7 }
															};

	private static final int[][]	OFFSET_TWO				= new int[][] { { 1, 7 }, { 3, 6 }, { 7, 7 } };
	private static final int[][]	COLOR_TWO				= new int[][] { { 0xA09E80, 0xD8D4AC, 0x979579 },
															{ 0xA0919F, 0xD8C4D6, 0x978A96 },
															{ 0x989898, 0xCDCDCD, 0x909090 },
															{ 0xA0A0A0, 0xD8D8D8, 0x979797 }
															};

	private static final int[][]	OFFSET_THREE			= new int[][] { { 2, 3 }, { 4, 8 }, { 5, 13 } };
	private static final int[][]	COLOR_THREE				= new int[][] { { 0x7F7D65, 0x070706, 0x37362C },
															{ 0x7F737E, 0x070607, 0x373236 },
															{ 0x797979, 0x070707, 0x343434 },
															{ 0x7F7F7F, 0x070707, 0x373737 }
															};

	private static final int[][]	OFFSET_FOUR				= new int[][] { { 2, 3 }, { 3, 1 }, { 1, 5 } };
	private static final int[][]	COLOR_FOUR				= new int[][] { { 0x282720, 0x080806, 0x403F33 },
															{ 0x282428, 0x080708, 0x403A40 },
															{ 0x262626, 0x070707, 0x3D3D3D },
															{ 0x282828, 0x080808, 0x404040 }
															};

	private static final int[][]	OFFSET_FIVE				= new int[][] { { 5, 4 }, { 4, 9 }, { 6, 12 } };
	private static final int[][]	COLOR_FIVE				= new int[][] { { 0x060604, 0x040403, 0xB7B492 },
															{ 0x060606, 0x040404, 0xB7A7B6 },
															{ 0x060606, 0x040404, 0xAFAFAF },
															{ 0x060606, 0x040404, 0xB7B7B7 },
															};

	private static final int[][]	OFFSET_SIX				= new int[][] { { 5, 4 }, { 5, 9 }, { 8, 5 } };
	private static final int[][]	COLOR_SIX				= new int[][] { { 0x070605, 0x040403, 0x181713 },
															{ 0x070707, 0x040404, 0x181618 },
															{ 0x060606, 0x030303, 0x161616 },
															{ 0x070707, 0x040404, 0x181818 }
															};

	private static final int[][]	OFFSET_SEVEN			= new int[][] { { 5, 11 }, { 4, 3 }, { 7, 7 } };
	private static final int[][]	COLOR_SEVEN				= new int[][] { { 0x5E5C4B, 0x87856C, 0x5D5C4B },
															{ 0x5F565E, 0x877B86, 0x5F565E },
															{ 0x5A5A5A, 0x818181, 0x5A5A5A },
															{ 0x5E5E5E, 0x878787, 0x5D5D5D }
															};

	private static final int[][]	OFFSET_EIGHT			= new int[][] { { 5, 3 }, { 5, 10 }, { 1, 6 } };
	private static final int[][]	COLOR_EIGHT				= new int[][] { { 0x27261F, 0x302F26, 0x26261F },
															{ 0x282427, 0x302C30, 0x262326 },
															{ 0x252525, 0x2D2D2D, 0x242424 },
															{ 0x282828, 0x303030, 0x262626 }
															};

	private static final int[][]	OFFSET_NINE				= new int[][] { { 5, 5 }, { 5, 9 }, { 8, 12 } };
	private static final int[][]	COLOR_NINE				= new int[][] { { 0x302F26, 0x050504, 0x272720 },
															{ 0x302C30, 0x050505, 0x282427 },
															{ 0x2E2E2E, 0x050505, 0x262626 },
															{ 0x303030, 0x050505, 0x272727 }
															};

	public static final int[][][]	offsets					= new int[10][][];
	public static final int[][][]	colors					= new int[10][][];

	public static final int[]		widths					= new int[] { 13, 6, 10, 10, 12, 10, 11, 10, 11, 11 };
	public static final int[] ENEMY_LOOT=new int[]{17, 68, 138, 240};//x1,y1,x2,y2
	public static final int[] LOOT_GOLD_START=new int[]{33,0};
	public static final int[] LOOT_ELIXIR_START=new int[]{33,29};
	public static final int[] LOOT_DE_START=new int[]{33,57};
	public static final int COLOR_SENSITIVE=5;
	public static final int DIGIT_TYPE_GOLD=0;
	public static final int DIGIT_TYPE_ELIXIR=1;
	public static final int DIGIT_TYPE_DE=2;
	public static final int DIGIT_TYPE_ATTACKGROUP=3;
	public static final Color COLOR_DE= new Color(128, 117, 43);		// 0x80752B
	public static final int MAX_SEARCH_INDENT=43;

	
	//===================troop=====================
	
	
	
	static
	{
		offsets[0] = OFFSET_ZERO;
		offsets[1] = OFFSET_ONE;
		offsets[2] = OFFSET_TWO;
		offsets[3] = OFFSET_THREE;
		offsets[4] = OFFSET_FOUR;
		offsets[5] = OFFSET_FIVE;
		offsets[6] = OFFSET_SIX;
		offsets[7] = OFFSET_SEVEN;
		offsets[8] = OFFSET_EIGHT;
		offsets[9] = OFFSET_NINE;

		colors[0] = COLOR_ZERO;
		colors[1] = COLOR_ONE;
		colors[2] = COLOR_TWO;
		colors[3] = COLOR_THREE;
		colors[4] = COLOR_FOUR;
		colors[5] = COLOR_FIVE;
		colors[6] = COLOR_SIX;
		colors[7] = COLOR_SEVEN;
		colors[8] = COLOR_EIGHT;
		colors[9] = COLOR_NINE;
	}
}
