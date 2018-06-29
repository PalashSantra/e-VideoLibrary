package pkgBeans.pkgAutoID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import pkgBeans.pkgVideoDirectoryConnection.clsConnectionProvider;

public class clsAutoIDImplimentation implements intAutoIDFunction {
	
	/**
	 * @author PALASH
	 */
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	@Override
	public boolean UpdateAutoID(int iID){
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("UPDATE AUTOID SET INDEXNUM=INDEXNUM+1 WHERE TABID=?");
			pst.setInt(1, iID);
			pst.executeUpdate();
			con.commit();
			clsConnectionProvider.CloseConnection(con);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}


	@Override
	public int GetAutoIDIndex(int iID) {
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			int i=-1;
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("SELECT INDEXNUM FROM AUTOID WHERE TABID=?");
			pst.setInt(1, iID);
			rs=pst.executeQuery();
			rs.next();
			i=rs.getInt(1);
			con.commit();
			clsConnectionProvider.CloseConnection(con);
			return i;
		}
		catch(Exception e){
			System.out.println("error" +e);
			return -1;
		}
	}

}
