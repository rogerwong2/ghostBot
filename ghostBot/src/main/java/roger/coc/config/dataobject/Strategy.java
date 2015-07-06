package roger.coc.config.dataobject;

import java.util.List;

import com.google.common.collect.Lists;

public class Strategy {
	private String name;
	private List<Condition> conditionList=Lists.newArrayList();
	private List<Action> actionList=Lists.newArrayList();
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the conditionList
	 */
	public List<Condition> getConditionList() {
		return conditionList;
	}
	/**
	 * @param conditionList the conditionList to set
	 */
	public void setConditionList(List<Condition> conditionList) {
		this.conditionList = conditionList;
	}
	/**
	 * @return the actionList
	 */
	public List<Action> getActionList() {
		return actionList;
	}
	/**
	 * @param actionList the actionList to set
	 */
	public void setActionList(List<Action> actionList) {
		this.actionList = actionList;
	}
}
