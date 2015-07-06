package roger.coc.config.dataobject;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

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

}
