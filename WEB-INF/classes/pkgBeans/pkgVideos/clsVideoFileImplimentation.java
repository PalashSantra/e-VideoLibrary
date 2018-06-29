package pkgBeans.pkgVideos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import pkgBeans.pkgAutoID.clsAutoIDImplimentation;
import pkgBeans.pkgAutoID.intAutoIDFunction;
import pkgBeans.pkgVideoDirectoryConnection.clsConnectionProvider;

public class clsVideoFileImplimentation implements intVideoFileFunction {

	/**
	 * @author PALASH
	 */
	
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	private intAutoIDFunction AutoID;
	
	@Override
	/**
	//Create VideoFile object,insert value into it without FileID, FileID is AutoNumber
	//Call it to this function
	//if function return false, not inserted,if true successfully inserted
	 * (non-Javadoc)
	 * @see pkgBeans.pkgVideos.intVideoFileFunction#AddVideoFile(pkgBeans.pkgVideos.clsVideoFile)
	 */
	public boolean AddVideoFile(clsVideoFile v) {
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			AutoID=new clsAutoIDImplimentation();
			int ID=AutoID.GetAutoIDIndex(2);
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("INSERT INTO VIDEOFILE VALUES (?,?,?,?)");
			pst.setInt(1,ID);
			pst.setString(2, v.getsFileName());
			pst.setString(3, v.getsFileType());
			pst.setLong(4, v.getlSizeByte());
			pst.executeUpdate();
			con.commit();
			clsConnectionProvider.CloseConnection(con);
			if(AutoID.UpdateAutoID(2))
				return true;
			else throw new Exception("AutoId not Updated");
		}
		catch(Exception e){
			System.out.println("Exception" + e.getMessage());
			return false;
		}
	}

	@Override
	/**
	//Create VideoFile object,insert value into it only FileName, FileType
	//Call it to this function
	//if function return false, not deleted,if true successfully inserted
	 * (non-Javadoc)
	 * @see pkgBeans.pkgVideos.intVideoFileFunction#DeleteVideoFile(pkgBeans.pkgVideos.clsVideoFile)
	 */
	public boolean DeleteVideoFile(clsVideoFile v){
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("DELETE VIDEOFILE WHERE FILENAME=? AND FILETYPE=?");
			pst.setString(1,v.getsFileName());
			pst.setString(2, v.getsFileType());
			pst.executeUpdate();
			con.commit();
			clsConnectionProvider.CloseConnection(con);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception" + e.getMessage());
			return false;
		}
	}

	@Override
	/**
	//Create VideoFile object for old,insert value into it only FileName, FileType
	//Create VideoFile object for new,insert value into it only FileName, FileType
	//Call both to this function(old,new) this sequence
	//if function return false, not updated,if true successfully inserted
	 * (non-Javadoc)
	 * @see pkgBeans.pkgVideos.intVideoFileFunction#UpdateVideoFile(pkgBeans.pkgVideos.clsVideoFile, pkgBeans.pkgVideos.clsVideoFile)
	 */
	public boolean UpdateVideoFile(clsVideoFile vOld,clsVideoFile vNew){
		try{
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("UPDATE VIDEOFILE SET FILENAME=?,FILETYPE=? WHERE FILENAME=? AND FILETYPE=?");
			pst.setString(1, vNew.getsFileName());
			System.out.println(vNew.getsFileName());
			pst.setString(2, vNew.getsFileType());
			System.out.println(vNew.getsFileType());
			pst.setString(3, vOld.getsFileName());
			System.out.println(vOld.getsFileName());
			pst.setString(4, vOld.getsFileType());
			System.out.println(vOld.getsFileType());
			int i=pst.executeUpdate();
			con.commit();
			System.out.println("updated succesfully:"+i);
			clsConnectionProvider.CloseConnection(con);
			return true;
		}
		catch(Exception e){
			System.out.println("Exception" + e.getMessage());
			return false;
		}
	}

	@Override
	/**
	//return all affected videos in a ArrayList,if no row affected it return null
	//use Iterator to fetch the VideoFile rows
	 * (non-Javadoc)
	 * @see pkgBeans.pkgVideos.intVideoFileFunction#SelectVideoFile()
	 */
	public ArrayList<clsVideoFile> SelectVideoFile() {
		try{
			ArrayList<clsVideoFile> Data=new ArrayList<clsVideoFile>();
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("SELECT * FROM VIDEOFILE");
			rs=pst.executeQuery();
			while(rs.next()){
				clsVideoFile Video=new clsVideoFile();
				Video.setiFileID(rs.getInt(1));
				Video.setsFileName(rs.getString(2));
				Video.setsFileType(rs.getString(3));
				Video.setlSizeByte(rs.getLong(4));
				Data.add(Video);
			}
			
			clsConnectionProvider.CloseConnection(con);
			return Data;
		}
		catch(Exception e){
			System.out.println("Exception" + e.getMessage());
			return null;
		}
	}

	@Override
	/**
	//Create VideoFile object,insert value into it only FileName, FileType
	//both can be blank,any combination possible
	//Call it to this function
	//return all affected Videos in a ArrayList,if no row affected it return null
	//use Iterator to fetch the VideoFile rows
	 * (non-Javadoc)
	 * @see pkgBeans.pkgVideos.intVideoFileFunction#SearchVideoFile(pkgBeans.pkgVideos.clsVideoFile)
	 */
	public ArrayList<clsVideoFile> SearchVideoFile(clsVideoFile v){
		try{
			ArrayList<clsVideoFile> Data=new ArrayList<clsVideoFile>();
			//clsConnectionProvider.SetConnectionParameter("", "", "");
			con=clsConnectionProvider.OpenConnection();
			pst=con.prepareStatement("SELECT * FROM VIDEOFILE WHERE FILENAME LIKE ? AND FILETYPE LIKE ?");
			pst.setString(1, "%"+v.getsFileName()+"%");
			pst.setString(2, "%"+v.getsFileType()+"%");
			rs=pst.executeQuery();
			
			while(rs.next()){
				clsVideoFile Video=new clsVideoFile();
				Video.setiFileID(rs.getInt(1));
				Video.setsFileName(rs.getString(2));
				Video.setsFileType(rs.getString(3));
				Video.setlSizeByte(rs.getLong(4));
				Data.add(Video);
			}
			clsConnectionProvider.CloseConnection(con);
			return Data;
		}
		catch(Exception e){
			System.out.println("Exception" + e.getMessage());
			return null;
		}
	}

	@Override
	/**
	//call it with size byte,it will return string with MB
	 * (non-Javadoc)
	 * @see pkgBeans.pkgVideos.intVideoFileFunction#ProperQuantity(long)
	 */
	public String ProperQuantity(long Size) {
		String str = null;
		double i=0;
		i=(Size/(1024*1024));
		str=i+" MB";
		return str;
	}
}
