package roger.coc.config.dataobject;

public class Donate {
	public static final String DONATE_TYPE_SPECIRIED="specified";
	private int type;
	private String troop;
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the troop
	 */
	public String getTroop() {
		return troop;
	}
	/**
	 * @param troop the troop to set
	 */
	public void setTroop(String troop) {
		this.troop = troop;
	}
}
