package pkgBeans.pkgUsers;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pkgBeans.pkgAutoID.clsAutoIDImplimentation;
import pkgBeans.pkgAutoID.intAutoIDFunction;
import pkgBeans.pkgVideoDirectoryConnection.clsConnectionProvider;

public class clsUserImplimentation implements intUserFunction {

	/**
	 * @author PALASH
	 */
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private intAutoIDFunction AutoID;
	
	@Override
	/**
	 * Create UserDetail object,insert value into it without UserID, UserID is AutoNumber
	 *	 Call it to this function
	 *	 if function return false, not inserted,if true successfully inserted
	 */
	public boolean AddUser(clsUserDetail u){
		try{
			
			AutoID=new clsAutoIDImplimentation();
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			int ID=AutoID.GetAutoIDIndex(1);
			if (ID==-1) throw new Exception("AutoID error");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("INSERT INTO USERDETAIL VALUES (?,?,?,?,?,?,?,?)");
			pst.setInt(1,ID);
			pst.setString(2, u.getsUserName());
			pst.setString(3, u.getsEmail());
			pst.setInt(4, u.getiType());
			pst.setString(5, u.getsPassword());
			pst.setString(6, u.getsFirstName());
			pst.setString(7, u.getsLastName());
			pst.setString(8, u.getsGender());
			pst.executeUpdate();
			con.commit();
			clsConnectionProvider.CloseConnection(con);
			if (AutoID.UpdateAutoID(1))
				return true;
			else
				throw new Exception("AutoId not Updated");
		}
		catch(Exception e){
			System.out.println("Exception" + e.getMessage());
			return false;
		}
	}

	@Override
	/**
	 *	Call this function with UserName
	 *	if function return false, not deleted,if true successfully deleted
	 * 
	 */
	public int DeleteUser(String UserName){
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("DELETE USERDETAIL WHERE USERNAME=?");
			pst.setString(1,UserName);
			int i=pst.executeUpdate();
			con.commit();
			clsConnectionProvider.CloseConnection(con);
			return i;
		}
		catch(Exception e){
			System.out.println("Exception" + e);
			return -1;
		}
	}

	@Override
	/**
	//Create UserDetail object,insert value into it without Username
	//Call it to this function
	//if function return false, not updated,if true successfully updated
	 * 
	 */
	public boolean UpdateUser(clsUserDetail u){
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("UPDATE USERDETAIL SET TYPE=?,EMAIL=?,PASSWORD=?,FIRSTNAME=?,LASTNAME=?,GENDER=? WHERE USERID=?");
			pst.setInt(1,u.getiType());
			pst.setString(2, u.getsEmail());
			pst.setString(3, u.getsPassword());
			pst.setString(4, u.getsFirstName());
			pst.setString(5, u.getsLastName());
			pst.setString(6, u.getsGender());
			pst.setInt(7,u.getiUserID());
			pst.executeUpdate();
			con.commit();
			con.close();
			clsConnectionProvider.CloseConnection(con);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception" + e);
			return false;
		}
	}

	@Override
	/**
	//return all users in a ArrayList,if no row affected it return null
	//use Iterator to fetch the UserDetail rows
	 * 
	 */
	public ArrayList<clsUserDetail> SelectUser() {
		try{
			ArrayList<clsUserDetail> Data=new ArrayList<clsUserDetail>();
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("SELECT * FROM USERDETAIL");
			rs=pst.executeQuery();
			while(rs.next()){
				clsUserDetail User=new clsUserDetail();
				User.setiUserID(rs.getInt("USERID"));
				User.setsUserName(rs.getString("USERNAME"));
				User.setsEmail(rs.getString("EMAIL"));
				User.setiType(rs.getInt("TYPE"));
				User.setsPassword(rs.getString("PASSWORD"));
				User.setsFirstName(rs.getString("FIRSTNAME"));
				User.setsLastName(rs.getString("LASTNAME"));
				User.setsGender(rs.getString("GENDER"));
				Data.add(User);
			}
			clsConnectionProvider.CloseConnection(con);
			return Data;
		}
		catch(Exception e){
			System.out.println("Exception" + e);
			return null;
		}
		
	}

	@Override
	/**
	//Create UserDetail object,insert value into it only UserName, Email
	//both can be blank,any combination possible
	//Call it to this function
	//return all affected users in a ArrayList,if no row affected it return null
	//use Iterator to fetch the UserDetail rows
	 * 
	 */
	public ArrayList<clsUserDetail> SearchUser(clsUserDetail u){
		try{
			ArrayList<clsUserDetail> Data=new ArrayList<clsUserDetail>();
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("SELECT * FROM USERDETAIL WHERE USERNAME LIKE ? AND EMAIL LIKE ?");
			pst.setString(1, u.getsUserName()+"%");
			pst.setString(2, u.getsEmail()+"%");
			rs=pst.executeQuery();
			while(rs.next()){
				clsUserDetail User=new clsUserDetail();
				User.setiUserID(rs.getInt("USERID"));
				User.setsUserName(rs.getString("USERNAME"));
				User.setsUserName(rs.getString("EMAIL"));
				User.setiUserID(rs.getInt("TYPE"));
				User.setsUserName(rs.getString("PASSWORD"));
				User.setsFirstName(rs.getString("FIRSTNAME"));
				User.setsLastName(rs.getString("LASTNAME"));
				User.setsGender(rs.getString("GENDER"));
				Data.add(User);
			}
			clsConnectionProvider.CloseConnection(con);
			return Data;
		}
		catch(Exception e){
			return null;
		}
	}
	public ArrayList<clsUserDetail> ProfileShow(String username){
		try{
			ArrayList<clsUserDetail> Data=new ArrayList<clsUserDetail>();
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("SELECT * FROM USERDETAIL WHERE USERNAME=?");
			
			pst.setString(1, username);
			rs=pst.executeQuery();
			//System.out.println("rs is:"+rs);
			
			while(rs.next()){
				System.out.println(rs.getString("USERNAME"));
				
				clsUserDetail User=new clsUserDetail();
				
				User.setiUserID(rs.getInt("USERID"));
				//System.out.println(rs.getString("USERNAME"));
				User.setsUserName(rs.getString("USERNAME"));
				//System.out.println(rs.getString("USERNAME"));
				User.setsEmail(rs.getString("EMAIL"));
				//System.out.println(rs.getString("USERNAME"));
				User.setiUserID(rs.getInt("TYPE"));
				//System.out.println(rs.getString("USERNAME"));
				User.setsPassword(rs.getString("PASSWORD"));
				//System.out.println(rs.getString("USERNAME"));
				User.setsFirstName(rs.getString("FIRSTNAME"));
				//System.out.println(rs.getString("USERNAME"));
				User.setsLastName(rs.getString("LASTNAME"));
				//System.out.println(rs.getString("USERNAME"));
				User.setsGender(rs.getString("GENDER"));
				//System.out.println(rs.getString("USERNAME"));
				
				Data.add(User);
			}
			clsConnectionProvider.CloseConnection(con);
			return Data;
		}
		catch(Exception e){
			System.out.println("Error"+e);
			return null;
		}
	}

	@Override
	/**
	//Create UserDetail object,insert value into it only UserName, Password
	//Call it to this function
	//return 1 if the user is Admin, 0 if it normal user, -1 for error password, 2 for user name doesn't match
	 * 
	 */
	public int CheckLogIn(clsUserDetail u){
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			int type;
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("SELECT TYPE,PASSWORD FROM USERDETAIL WHERE USERNAME=?");
			pst.setString(1, u.getsUserName());
			rs=pst.executeQuery();
			rs.next();
			System.out.println("hello");
			System.out.println(rs.getString(1));
			if(rs.getString("PASSWORD").equals(u.getsPassword()))
				type=rs.getInt("TYPE");
			else
				type=-1;
			clsConnectionProvider.CloseConnection(con);
			
			return type;
		}
		catch(Exception e){
			System.out.println("Exception" + e);
			return 2 ;
		}
	}

	@Override
	/**
	//get the Master password, for checking in admin registration
	 * (non-Javadoc)
	 * @see pkgBeans.pkgUsers.intUserFunction#GetMasterPassword()
	 */
	public String GetMasterPassword() {
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			String Password;
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("SELECT PASSWORD FROM MASTER");
			rs=pst.executeQuery();
			rs.next();
			Password=rs.getString("PASSWORD");
			con.commit();
			clsConnectionProvider.CloseConnection(con);
			return Password;
		}
		catch(Exception e){
			System.out.println("Exception" + e);
			return null ;
		}
	}

	@Override
	/**
	//by setting the Master Password Admin can change master password
	 * (non-Javadoc)
	 * @see pkgBeans.pkgUsers.intUserFunction#SetMasterPassword(java.lang.String)
	 */
	public boolean SetMasterPassword(String Password) {
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("UPDATE MASTER SET PASSWORD=?");
			pst.setString(1, Password);
			pst.executeUpdate();
			con.commit();
			clsConnectionProvider.CloseConnection(con);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
