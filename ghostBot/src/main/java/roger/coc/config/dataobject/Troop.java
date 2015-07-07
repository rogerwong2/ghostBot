package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import roger.coc.config.ConfigManager;

public class Troop implements IBuild{
	private String troop;
	private int num;
	/**
	 * @return the troop
	 */
	public String getTroop() {
		return troop;
	}
	/**
	 * @param troop the troop to set
	 */
	public void setTroop(String troop) {
		this.troop = troop;
	}
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("troop");
		root.appendChild(ConfigManager.getElement("name", troop));
		root.appendChild(ConfigManager.getElement("num", String.valueOf(num)));
		return root;
	}
	public void parseNode(Element node) {
		troop=node.getElementsByTagName("name").item(0).getNodeValue();
		num=Integer.valueOf(node.getElementsByTagName("num").item(0).getNodeValue());
	}


}
