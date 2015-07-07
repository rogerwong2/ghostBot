package roger.coc.config.dataobject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import roger.coc.config.ConfigManager;

public class DarkSpellFac extends SpellFac{

	@Override
	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("darkspellfac");
		for(Spell spell:this.getSpellList())
		{
			root.appendChild(spell.getNode());
		}
		return root;
	}
}
