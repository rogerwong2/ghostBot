package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import roger.coc.config.ConfigManager;

public class Common implements IBuild{
	private String requestText;
	private Donate donate;
	/**
	 * @return the requestTest
	 */
	public String getRequestText() {
		return requestText;
	}
	/**
	 * @param requestTest the requestTest to set
	 */
	public void setRequestTest(String requestText) {
		this.requestText = requestText;
	}
	/**
	 * @return the donate
	 */
	public Donate getDonate() {
		return donate;
	}
	/**
	 * @param donate the donate to set
	 */
	public void setDonate(Donate donate) {
		this.donate = donate;
	}
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("common");
		//add name node
		root.appendChild(ConfigManager.getElement("request-text", requestText));
		//add common node
		root.appendChild(donate.getNode());
		return root;
	}
	public void parseNode(Element node) {
		requestText=node.getElementsByTagName("request-text").item(0).getNodeValue();
		donate=new Donate();
		donate.parseNode((Element) node.getElementsByTagName("donate").item(0));
	}
	
}
