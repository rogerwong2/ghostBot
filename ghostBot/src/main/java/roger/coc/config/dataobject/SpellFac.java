package roger.coc.config.dataobject;

import java.util.List;

import org.w3c.dom.Document;

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

	public Document getDocumentFromNode() {
		// TODO Auto-generated method stub
		return null;
	}

	public void parseDocument(Document document) {
		// TODO Auto-generated method stub
		
	}
}
