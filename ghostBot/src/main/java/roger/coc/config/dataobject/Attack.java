package roger.coc.config.dataobject;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Attack implements IBuild{

	private List<Strategy> strategyList;
	
	public Element getNode() {
		// TODO Auto-generated method stub
		return null;
	}

	public void parseNode(Element node) {
		// TODO Auto-generated method stub
		
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
