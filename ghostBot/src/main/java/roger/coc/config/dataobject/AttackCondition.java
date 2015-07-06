package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import roger.coc.config.ConfigManager;

public class AttackCondition implements IBuild{
	private int troopMin;
	private boolean hasBk;
	private boolean hasAq;
	private int spellMin;
	/**
	 * @return the troopMin
	 */
	public int getTroopMin() {
		return troopMin;
	}
	/**
	 * @param troopMin the troopMin to set
	 */
	public void setTroopMin(int troopMin) {
		this.troopMin = troopMin;
	}
	/**
	 * @return the hasBk
	 */
	public boolean isHasBk() {
		return hasBk;
	}
	/**
	 * @param hasBk the hasBk to set
	 */
	public void setHasBk(boolean hasBk) {
		this.hasBk = hasBk;
	}
	/**
	 * @return the hasAq
	 */
	public boolean isHasAq() {
		return hasAq;
	}
	/**
	 * @param hasAq the hasAq to set
	 */
	public void setHasAq(boolean hasAq) {
		this.hasAq = hasAq;
	}
	/**
	 * @return the spellMin
	 */
	public int getSpellMin() {
		return spellMin;
	}
	/**
	 * @param spellMin the spellMin to set
	 */
	public void setSpellMin(int spellMin) {
		this.spellMin = spellMin;
	}
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("common");
		root.appendChild(ConfigManager.getElement("troopMin",String.valueOf(troopMin)));
		root.appendChild(ConfigManager.getElement("spellMin", String.valueOf(spellMin)));
		root.appendChild(ConfigManager.getElement("hasBk", String.valueOf(hasBk)));
		root.appendChild(ConfigManager.getElement("hasAq", String.valueOf(hasAq)));
		return root;
	}
	public void parseNode(Element node) {
		troopMin=Integer.valueOf(node.getElementsByTagName("troopMin").item(0).getNodeValue());
		spellMin=Integer.valueOf(node.getElementsByTagName("spellMin").item(0).getNodeValue());
		hasBk=Boolean.valueOf(node.getElementsByTagName("hasBk").item(0).getNodeValue());
		hasAq=Boolean.valueOf(node.getElementsByTagName("hasAq").item(0).getNodeValue());
	}
}
