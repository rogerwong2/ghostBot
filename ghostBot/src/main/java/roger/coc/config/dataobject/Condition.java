package roger.coc.config.dataobject;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import roger.coc.config.ConfigManager;

import com.google.common.collect.Maps;

public class Condition implements IBuild{
	public static final String CONDITION_TYPE_RESOURCE_AND="resource-and";
	public static final String CONDITION_TYPE_RESOURCE_OR="resource-or";
	public static final String CONDITION_TYPE_RESOURCE_SUM="resource-sum";
	public static final String KEY_SUM="sum";
	private String type;
	private double gold;
	private double elixir;
	private double darkElixir;
	private Map<String,String> otherInfo=Maps.newHashMap();
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("condition");
		root.appendChild(ConfigManager.getElement("type", type));
		root.appendChild(ConfigManager.getElement("gold", String.valueOf(gold)));
		root.appendChild(ConfigManager.getElement("elixir", String.valueOf(elixir)));
		root.appendChild(ConfigManager.getElement("darkElixir", String.valueOf(darkElixir)));
		if(type.equals(CONDITION_TYPE_RESOURCE_SUM))
		{
			root.appendChild(ConfigManager.getElement("sum", otherInfo.get(KEY_SUM)));
		}
		return root;
	}
	public void parseNode(Element node) {
		type=node.getElementsByTagName("type").item(0).getNodeValue();
		gold=Double.valueOf(node.getElementsByTagName("gold").item(0).getNodeValue());
		elixir=Double.valueOf(node.getElementsByTagName("elixir").item(0).getNodeValue());
		darkElixir=Double.valueOf(node.getElementsByTagName("type").item(0).getNodeValue());
		if(type.equals(CONDITION_TYPE_RESOURCE_SUM))
		{
			otherInfo.put(KEY_SUM, node.getElementsByTagName("sum").item(0).getNodeValue());
		}
	}
	
	
}
