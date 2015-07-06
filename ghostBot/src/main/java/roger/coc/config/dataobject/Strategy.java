package roger.coc.config.dataobject;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.google.common.collect.Lists;

public class Strategy implements IBuild{
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
	public Element getNode() {
		// TODO Auto-generated method stub
		return null;
	}
	public void parseNode(Element node) {
		name=node.getElementsByTagName("name").item(0).getNodeValue();
		NodeList nl=null;
		nl=node.getElementsByTagName("condition");
		for(int i=0;i<=nl.getLength()-1;i++)
		{
			Condition condition=new Condition();
			//condition.pa
		}
		
	}

}
