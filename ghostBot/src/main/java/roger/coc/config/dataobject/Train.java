package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import roger.coc.config.ConfigManager;

public class Train implements IBuild{
	public static final String TRAIN_TYPE_BARRACKLOOP="barrack-loop";
	private String type;
	private AttackCondition condition;
	private Brarack brarack1;
	private Brarack brarack2;
	private Brarack brarack3;
	private Brarack brarack4;
	private DarkBrarack darkbrarack1;
	private DarkBrarack darkbrarack2;
	private SpellFac spellFac;
	private DarkSpellFac darkSpellFac;
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
	 * @return the condition
	 */
	public AttackCondition getCondition() {
		return condition;
	}
	/**
	 * @param condition the condition to set
	 */
	public void setCondition(AttackCondition condition) {
		this.condition = condition;
	}
	/**
	 * @return the brarack1
	 */
	public Brarack getBrarack1() {
		return brarack1;
	}
	/**
	 * @param brarack1 the brarack1 to set
	 */
	public void setBrarack1(Brarack brarack1) {
		this.brarack1 = brarack1;
	}
	/**
	 * @return the brarack2
	 */
	public Brarack getBrarack2() {
		return brarack2;
	}
	/**
	 * @param brarack2 the brarack2 to set
	 */
	public void setBrarack2(Brarack brarack2) {
		this.brarack2 = brarack2;
	}
	/**
	 * @return the brarack3
	 */
	public Brarack getBrarack3() {
		return brarack3;
	}
	/**
	 * @param brarack3 the brarack3 to set
	 */
	public void setBrarack3(Brarack brarack3) {
		this.brarack3 = brarack3;
	}
	/**
	 * @return the brarack4
	 */
	public Brarack getBrarack4() {
		return brarack4;
	}
	/**
	 * @param brarack4 the brarack4 to set
	 */
	public void setBrarack4(Brarack brarack4) {
		this.brarack4 = brarack4;
	}
	/**
	 * @return the darkbararack1
	 */
	public DarkBrarack getDarkbararack1() {
		return darkbrarack1;
	}
	/**
	 * @param darkbararack1 the darkbararack1 to set
	 */
	public void setDarkbararack1(DarkBrarack darkbararack1) {
		this.darkbrarack1 = darkbararack1;
	}
	/**
	 * @return the darkbararack2
	 */
	public DarkBrarack getDarkbararack2() {
		return darkbrarack2;
	}
	/**
	 * @param darkbararack2 the darkbararack2 to set
	 */
	public void setDarkbararack2(DarkBrarack darkbararack2) {
		this.darkbrarack2 = darkbararack2;
	}
	/**
	 * @return the spellFac
	 */
	public SpellFac getSpellFac() {
		return spellFac;
	}
	/**
	 * @param spellFac the spellFac to set
	 */
	public void setSpellFac(SpellFac spellFac) {
		this.spellFac = spellFac;
	}
	/**
	 * @return the darkSpellFac
	 */
	public DarkSpellFac getDarkSpellFac() {
		return darkSpellFac;
	}
	/**
	 * @param darkSpellFac the darkSpellFac to set
	 */
	public void setDarkSpellFac(DarkSpellFac darkSpellFac) {
		this.darkSpellFac = darkSpellFac;
	}
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("train");
		root.appendChild(ConfigManager.getElement("type", type));
		root.appendChild(condition.getNode());
		root.appendChild(brarack1.getNode());
		root.appendChild(brarack2.getNode());
		root.appendChild(brarack3.getNode());
		root.appendChild(brarack4.getNode());
		root.appendChild(darkbrarack1.getNode());
		root.appendChild(darkbrarack2.getNode());
		root.appendChild(spellFac.getNode());
		root.appendChild(darkSpellFac.getNode());
		return root;
	}
	public void parseNode(Element node) {
		type=node.getElementsByTagName("type").item(0).getNodeValue();
		condition=new AttackCondition();
		condition.parseNode((Element)node.getElementsByTagName("attack-condition").item(0));
		brarack1=new Brarack();
		brarack2=new Brarack();
		brarack3=new Brarack();
		brarack4=new Brarack();
		brarack1.parseNode((Element)node.getElementsByTagName("brarack").item(0));
		brarack2.parseNode((Element)node.getElementsByTagName("brarack").item(1));
		brarack3.parseNode((Element)node.getElementsByTagName("brarack").item(2));
		brarack4.parseNode((Element)node.getElementsByTagName("brarack").item(3));
		darkbrarack1=new DarkBrarack();
		darkbrarack2=new DarkBrarack();
		darkbrarack1.parseNode((Element)node.getElementsByTagName("darkbrarack").item(0));
		darkbrarack2.parseNode((Element)node.getElementsByTagName("darkbrarack").item(1));
		spellFac=new SpellFac();
		spellFac.parseNode((Element)node.getElementsByTagName("spellFac").item(0));
		darkSpellFac=new DarkSpellFac();
		darkSpellFac.parseNode((Element)node.getElementsByTagName("darkspellfac").item(0));
		
	}

}
