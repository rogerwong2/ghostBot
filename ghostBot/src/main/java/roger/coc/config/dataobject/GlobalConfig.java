package roger.coc.config.dataobject;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import roger.coc.config.ConfigManager;

import com.google.common.collect.Lists;

/**
 * @author zirui.wzr
 * 全局配置对象
 */
public class GlobalConfig implements IBuild{
	private String name;
	private Common common;
	private Train train;
	private Attack attack;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the common
	 */
	public Common getCommon() {
		return common;
	}
	/**
	 * @param common the common to set
	 */
	public void setCommon(Common common) {
		this.common = common;
	}
	/**
	 * @return the train
	 */
	public Train getTrain() {
		return train;
	}
	/**
	 * @param train the train to set
	 */
	public void setTrain(Train train) {
		this.train = train;
	}

	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("ghostconfig");
		//add name node
		root.appendChild(ConfigManager.getElement("name", name));
		//add common node
		Element commonEle=common.getNode();
		root.appendChild(commonEle);
		//add train node
		root.appendChild(train.getNode());		
		//add attack node
		Element attackEle=attack.getNode();
		root.appendChild(attackEle);
		return root;
	}
	public void parseNode(Element document) {
		name=document.getElementsByTagName("name").item(0).getNodeValue();
		common=new Common();
		common.parseNode((Element)document.getElementsByTagName("common").item(0));
		train=new Train();
		train.parseNode((Element)document.getElementsByTagName("train").item(0));
		attack=new Attack();
		attack.parseNode((Element)document.getElementsByTagName("attack").item(0));
	}

}
