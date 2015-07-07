package roger.coc.config.dataobject;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import roger.coc.config.ConfigManager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Action implements IBuild{
	public static final String ACTION_TYPE_PUT="put";
	public static final String ACTION_TYPE_SLEEP="sleep";
	public static final String ACTION_TYPE_USE="use";
	private String type;
	private double value;
	private String target;
	private List<Double> pos=Lists.newArrayList();
	private Map<String,String> otherDate=Maps.newHashMap();
	private String payload;
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return the target
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		this.target = target;
	}
	/**
	 * @return the pos
	 */
	public List<Double> getPos() {
		return pos;
	}
	/**
	 * @param pos the pos to set
	 */
	public void setPos(List<Double> pos) {
		this.pos = pos;
	}
	/**
	 * @return the otherDate
	 */
	public Map<String, String> getOtherDate() {
		return otherDate;
	}
	/**
	 * @param otherDate the otherDate to set
	 */
	public void setOtherDate(Map<String, String> otherDate) {
		this.otherDate = otherDate;
	}
	@Override
	public Element getNode() {
		return ConfigManager.getElement("action", payload);
	}
	@Override
	public void parseNode(Element node) {
		payload=node.getNodeValue();
		String[] strs=payload.split(" ");
		type=strs[0];
		if(type.equals(ACTION_TYPE_PUT))
		{
			value=Double.valueOf(strs[1]);
			target=strs[2];
			//strs[3]==on
			strs=strs[4].split(",");
			for(String str:strs)
			{
				pos.add(Double.valueOf(str));
			}
		}
		else if(type.equals(ACTION_TYPE_SLEEP))
		{
			value=Double.valueOf(strs[1]);
		}
		else if(type.equals(ACTION_TYPE_USE))
		{
			target=strs[1];
		}
	}

}
