package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import roger.coc.config.ConfigManager;

public class Spell extends Troop{
	@Override
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("troop");
		root.appendChild(ConfigManager.getElement("name", this.getTroop()));
		root.appendChild(ConfigManager.getElement("num", String.valueOf(this.getNum())));
		return root;
	}
}
