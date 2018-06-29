package pkgBeans.pkgVideoDirectoryConnection;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class clsConnectionProvider {
		
		/**
		 * @author PALASH
		 */
		
		static String sUrl,sUser,sPassword;
		static{
			sUrl="jdbc:oracle:thin:@localhost:1521:xe";
			sUser="palash";
			sPassword="santra";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println("Connection Not loaded");
			}
		}
		public static void SetConnectionParameter(String Url,String User,String Password){
			sUrl=Url;
			sUser=User;
			sPassword=Password;
		}
		public static Connection OpenConnection() throws SQLException{
			Connection con = DriverManager.getConnection(sUrl,sUser, sPassword);
			return con;
		}
		public static void CloseConnection(Connection con) throws SQLException{
			con.close();
		}
}
