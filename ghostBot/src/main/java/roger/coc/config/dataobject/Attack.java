package roger.coc.config.dataobject;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import roger.coc.config.ConfigManager;

public class Attack implements IBuild{

	private List<Strategy> strategyList;
	
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("attack");
		for(Strategy stra:strategyList)
		{
			root.appendChild(stra.getNode());
		}
		return root;
	}

	public void parseNode(Element node) {
		NodeList nodeList=node.getElementsByTagName("strategy");
		for(int i=0;i<=nodeList.getLength()-1;i++)
		{
			Strategy stra=new Strategy();
			stra.parseNode((Element) nodeList.item(i));
			strategyList.add(stra);
		}
		
	}

	/**
	 * @return the strategyList
	 */
	public List<Strategy> getStrategyList() {
		return strategyList;
	}

	/**
	 * @param strategyList the strategyList to set
	 */
	public void setStrategyList(List<Strategy> strategyList) {
		this.strategyList = strategyList;
	}

	
}
