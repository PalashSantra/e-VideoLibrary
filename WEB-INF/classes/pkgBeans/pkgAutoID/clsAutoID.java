package pkgBeans.pkgAutoID;

public class clsAutoID {
	
	/**
	 * @author PALASH
	 */
	
	private int iID;
	private String sTabName;
	private int iIndex;
	public clsAutoID(int iID, String sTabName, int iIndex) {
		super();
		this.iID = iID;
		this.sTabName = sTabName;
		this.iIndex = iIndex;
	}
	public clsAutoID(int iID)
	{
		super();
		this.iID=iID;
	}
	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}
	public String getsTabName() {
		return sTabName;
	}
	public void setsTabName(String sTabName) {
		this.sTabName = sTabName;
	}
	public int getiIndex() {
		return iIndex;
	}
	public void setiIndex(int iIndex) {
		this.iIndex = iIndex;
	}
	
	
}
