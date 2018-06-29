package pkgBeans.pkgUsers;

import java.util.ArrayList;

public interface intUserFunction {
	
	/**
	 * 
	 * @param u
	 * @return
	 * @author PALASH
	 */
	
	boolean AddUser(clsUserDetail u);
	int DeleteUser(String UserName);
	boolean UpdateUser(clsUserDetail u);
	ArrayList<clsUserDetail> SelectUser();
	ArrayList<clsUserDetail> SearchUser(clsUserDetail u);
	int CheckLogIn(clsUserDetail u);
	String GetMasterPassword();
	boolean SetMasterPassword(String Password);
}
