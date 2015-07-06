package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Train implements IBuild{
	public static final String TRAIN_TYPE_BARRACKLOOP="barrack-loop";
	private String type;
	private AttackCondition condition;
	private Brarack brarack1;
	private Brarack brarack2;
	private Brarack brarack3;
	private Brarack brarack4;
	private DarkBrarack darkbararack1;
	private DarkBrarack darkbararack2;
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
		return darkbararack1;
	}
	/**
	 * @param darkbararack1 the darkbararack1 to set
	 */
	public void setDarkbararack1(DarkBrarack darkbararack1) {
		this.darkbararack1 = darkbararack1;
	}
	/**
	 * @return the darkbararack2
	 */
	public DarkBrarack getDarkbararack2() {
		return darkbararack2;
	}
	/**
	 * @param darkbararack2 the darkbararack2 to set
	 */
	public void setDarkbararack2(DarkBrarack darkbararack2) {
		this.darkbararack2 = darkbararack2;
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
		// TODO Auto-generated method stub
		return null;
	}
	public void parseNode(Element node) {
		// TODO Auto-generated method stub
		
	}

}
