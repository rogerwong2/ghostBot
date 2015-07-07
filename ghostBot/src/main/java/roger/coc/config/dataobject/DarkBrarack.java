package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import roger.coc.config.ConfigManager;

public class DarkBrarack extends Brarack{
	@Override
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("darkbarack");
		for(Troop troop:this.getTroops())
		{
			root.appendChild(troop.getNode());
		}
		return root;
	}
}
