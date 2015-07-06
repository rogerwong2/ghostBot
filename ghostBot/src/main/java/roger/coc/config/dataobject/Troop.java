package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

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
	public Node getDocumentFromNode() {
		// TODO Auto-generated method stub
		return null;
	}
	public void parseDocument(Node document) {
		// TODO Auto-generated method stub
		
	}

}
