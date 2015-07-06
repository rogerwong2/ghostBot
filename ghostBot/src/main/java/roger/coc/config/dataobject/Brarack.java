package roger.coc.config.dataobject;

import java.util.List;

import com.google.common.collect.Lists;

public class Brarack {
	private List<Troop> troops=Lists.newArrayList();

	/**
	 * @return the troops
	 */
	public List<Troop> getTroops() {
		return troops;
	}

	/**
	 * @param troops the troops to set
	 */
	public void setTroops(List<Troop> troops) {
		this.troops = troops;
	}
}
