package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import roger.coc.config.ConfigManager;

public class Donate implements IBuild{
	public static final String DONATE_TYPE_SPECIRIED="specified";
	private String type;
	private String troop;

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
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("donate");
		root.appendChild(ConfigManager.getElement("type", type));
		root.appendChild(ConfigManager.getElement("troop", troop));
		return root;
	}
	public void parseNode(Element node) {
		type=node.getElementsByTagName("type").item(0).getNodeValue();
		troop=node.getElementsByTagName("troop").item(0).getNodeValue();
		
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

}
