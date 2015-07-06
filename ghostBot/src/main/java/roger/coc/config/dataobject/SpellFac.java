package roger.coc.config.dataobject;

import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import roger.coc.config.ConfigManager;

public class SpellFac implements IBuild{
	private List<Spell> spellList;

	/**
	 * @return the spellList
	 */
	public List<Spell> getSpellList() {
		return spellList;
	}

	/**
	 * @param spellList the spellList to set
	 */
	public void setSpellList(List<Spell> spellList) {
		this.spellList = spellList;
	}

	public Element getNode() {
		Document dc=ConfigManager.db.newDocument();
		Element root=dc.createElement("spellfac");
		for(Spell spell:spellList)
		{
			root.appendChild(spell.getNode());
		}
		return root;
	}

	public void parseNode(Element node) {
		NodeList nodeList=node.getElementsByTagName("spell");
		for(int i=0;i<=nodeList.getLength()-1;i++)
		{
			Element e=(Element) nodeList.item(i);
			Spell spell=new Spell();
			spell.parseNode(e);
			spellList.add(spell);
		}
		
	}


}
