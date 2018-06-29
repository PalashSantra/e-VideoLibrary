import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import pkgBeans.pkgUsers.clsUserDetail;
import pkgBeans.pkgUsers.clsUserImplimentation;
import pkgBeans.pkgVideoDirectoryConnection.clsConnectionProvider;


public class Abc {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Iterator<clsUserDetail>User;
		clsUserDetail u=new clsUserDetail();
		u.setsUserName("palash");
		clsUserImplimentation UF=new clsUserImplimentation();
		ArrayList<clsUserDetail>ComingUser=UF.ProfileShow("palash");
		if(ComingUser!=null)
		{
			User=ComingUser.iterator();
			clsUserDetail abc;
			while(User.hasNext())
			{
				abc=User.next();
				System.out.println("User name "+abc.getsUserName());
				System.out.println("User Lastname "+abc.getsLastName());
				System.out.println("User Firstname "+abc.getsFirstName());
				System.out.println("User Emailname "+abc.getsEmail());
				System.out.println("User password "+abc.getsPassword());
			}
		}
		else
		{
			System.out.println("No row seleted");
		}
	}
}
