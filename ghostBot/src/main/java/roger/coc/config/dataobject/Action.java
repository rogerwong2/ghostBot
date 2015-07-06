package roger.coc.config.dataobject;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Action {
	public static final String ACTION_TYPE_PUT="put";
	public static final String ACTION_TYPE_SLEEP="sleep";
	public static final String ACTION_TYPE_USE="use";
	private String type;
	private double value;
	private String target;
	private List<Double> pos=Lists.newArrayList();
	private Map<String,String> otherDate=Maps.newHashMap();
}
