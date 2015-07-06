package roger.coc.config.dataobject;

import java.util.Map;

import org.w3c.dom.Document;

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
	public Document getDocumentFromNode() {
		// TODO Auto-generated method stub
		return null;
	}
	public void parseDocument(Document document) {
		// TODO Auto-generated method stub
		
	}
	
}
