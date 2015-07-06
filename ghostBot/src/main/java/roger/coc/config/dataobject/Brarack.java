package roger.coc.config.dataobject;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import roger.coc.config.ConfigManager;

import com.google.common.collect.Lists;

public class Brarack implements IBuild{
	private List<Troop> troops=Lists.newArrayList();

	/**
	 * @return the troops
	 */
	public List<Troop> getTroops() {
		return troops;
	}

	/**
	 * @param troops the troops to set
	 */
	public void setTroops(List<Troop> troops) {
		this.troops = troops;
	}

	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("barack");
		for(Troop troop:troops)
		{
			root.appendChild(troop.getNode());
		}
		return root;
	}

	public void parseNode(Element node) {
		NodeList nodeList=node.getElementsByTagName("troop");
		for(int i=0;i<=nodeList.getLength()-1;i++)
		{
			Element n=(Element) nodeList.item(i);
			Troop troop=new Troop();
			troop.parseNode(n);
			troops.add(troop);
		}
		
	}

}
