package pkgBeans.pkgUsers;

public class clsUserDetail {
	
	/**
	 * @author PALASH
	 */
	
	private int iUserID;
	private String sUserName;
	private String sEmail;
	private int iType; //1 for Admin 0 for User
	private String sPassword;
	private String sFirstName;
	private String sLastName;
	private String sGender;
	
	public clsUserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getiUserID() {
		return iUserID;
	}

	public int getiType() {
		return iType;
	}

	public void setiType(int iType) {
		this.iType = iType;
	}

	public String getsFirstName() {
		return sFirstName;
	}

	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	public String getsLastName() {
		return sLastName;
	}

	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public void setiUserID(int iUserID) {
		this.iUserID = iUserID;
	}

	public String getsUserName() {
		return sUserName;
	}

	public void setsUserName(String sUserName) {
		this.sUserName = sUserName;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}


	public String getsPassword() {
		return sPassword;
	}

	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}	
	
}
