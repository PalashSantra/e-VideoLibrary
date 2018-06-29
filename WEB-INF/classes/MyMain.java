
import java.util.ArrayList;
import java.util.Iterator;

import pkgBeans.pkgUsers.*;
import pkgBeans.pkgVideos.*;
public class MyMain {

	/**
	 * @param args
	 * @author PALASH
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//For user Manupulation
		
		clsUserDetail u=new clsUserDetail();								//Creating Object
		clsUserDetail u2=new clsUserDetail();								//Creating Object
		intUserFunction UF =new clsUserImplimentation();					//Creating Object for Function
		
		String str ="MasterPassword";										//manually set the master password as user entry at registration
		
		/*u.setsUserName("palash");											//Initalize Object1
		u.setsEmail("palash534@gmail.com");
		u.setsPassword("santra");
		
		
		u2.setsUserName("asim");											//Initalize Object2
		u2.setsEmail("asim1993@gmail.com");
		u2.setsPassword("dinda");
		u2.setiType(0);														//for Normal User
		
		if(UF.SetMasterPassword(str))										//Set master Password
			System.out.println("Master Password Set");
		else
			System.out.println("Error Occured at Master Password Set");
		
		
		String AdminPass=UF.GetMasterPassword();							//Get Master Password
		
		if(AdminPass.equals(str))											//Checking for Registration using admin right
		{
			u.setiType(1);
			System.out.println("Admin Password Matched");
		}
		else
		{
			u.setiType(0);
			System.out.println("Admin Password Not Matched");
		}
		
		
		if(UF.AddUser(u))													//Adding New User
			System.out.println("Inserted");
		else
			System.out.println("Not Inserted");
		
		if(UF.AddUser(u2))													//Adding New User
			System.out.println("Inserted");
		else
			System.out.println("Not Inserted");
		
		/*Iterator<clsUserDetail> User;										//Show All User
		ArrayList<clsUserDetail>ComingUser=UF.SelectUser();
		if(ComingUser!=null)
		{
			User=ComingUser.iterator();
			clsUserDetail abc;
			while(User.hasNext())
			{
				abc=User.next();
				System.out.println(abc.getsUserName());
			}
		}
		else
		{
			System.out.println("No row seleted");
		}*/
		
		/*
		u.setsUserName("palash");
		Iterator<clsUserDetail> User;										//Show All User
		ArrayList<clsUserDetail>Coming=UF.SearchUser(u);
		if(ComingUser!=null)
		{
			User=ComingUser.iterator();
			clsUserDetail abc;
			while(User.hasNext())
			{
				abc=User.next();
				System.out.println(abc.getsUserName());
			}
		}
		else
		{
			System.out.println("No row seleted");
		}
		
		
		
		
		
		/*
		if(UF.CheckLogIn(u)==1)												//Check for Login
			System.out.println(u.getsUserName()+" is Admin");
		else if(UF.CheckLogIn(u)==0)
			System.out.println(u.getsUserName()+" is Normal");
		else if(UF.CheckLogIn(u)==-1)
			System.out.println("Invalid User");
		else if(UF.CheckLogIn(u)==2)
			System.out.println("Error Occured");
		
		if(UF.CheckLogIn(u2)==1)											//Check for Login
			System.out.println(u2.getsUserName()+" is Admin");
		else if(UF.CheckLogIn(u2)==0)
			System.out.println(u2.getsUserName()+" is Normal");
		else if(UF.CheckLogIn(u2)==-1)
			System.out.println("Invalid User");
		else if(UF.CheckLogIn(u2)==2)
			System.out.println("Error Occured");
		
		
		if(UF.UpdateUser(u))												//Updating User1
			System.out.println("Updated");
		else
			System.out.println("Updated");
		
		if(UF.UpdateUser(u2))												//Updating User2
			System.out.println("Updated");
		else
			System.out.println("Updated");
		
		if(UF.DeleteUser("palash"))											//Delete User1
			System.out.println("Deleted");
		else
			System.out.println("Deleted");
		
		if(UF.DeleteUser("asim"))											//Delete User2
			System.out.println("Deleted");
		else
			System.out.println("Deleted");
		
		
		
		//VideoFileManupulation
		
		
		clsVideoFile v=new clsVideoFile();									//Creating Object
		clsVideoFile v2=new clsVideoFile();									//Creating Object
		intVideoFileFunction VF =new clsVideoFileImplimentation();			//Creating Object for Function
		
		v.setsFileName("wake up");
		v.setsFileType(".avi");
		v.setlSizeByte(734003200);
		
		v2.setsFileName("ranbir");
		v2.setsFileType(".avi");
		v2.setlSizeByte(735003200);
		
		if(VF.AddVideoFile(v))												//Adding New Video
			System.out.println("Inserted");
		else
			System.out.println("Not Inserted");
		
		/*if(VF.AddVideoFile(v2))												//Adding New Video2
			System.out.println("Inserted");
		else
			System.out.println("Not Inserted");*/
		
		/*
		Iterator<clsVideoFile> Video;										//Show All Video
		ArrayList<clsVideoFile>ComingVideo=VF.SelectVideoFile();
		if(ComingVideo!=null)
		{
			Video=ComingVideo.iterator();
			clsVideoFile abc;
			while(Video.hasNext())
			{
				abc=Video.next();
				System.out.println(abc.getsFileName()+abc.getsFileType()+" Size: "+VF.ProperQuantity(abc.getlSizeByte()));
			}
		}
		else
		{
			System.out.println("No row seleted");
		}
		
		
		clsVideoFile v3=new clsVideoFile();									//Show Searched Video
		v3.setsFileName("ghaj");
		v3.setsFileType("");
		Iterator<clsVideoFile> Video1;										
		ArrayList<clsVideoFile>ComingVideo1=VF.SearchVideoFile(v3);
		if(ComingVideo1!=null)
		{
			System.out.println(""+ComingVideo1);
			Video1=ComingVideo1.iterator();
			System.out.println(""+Video1);
			clsVideoFile abc;
			while(Video1.hasNext())
			{
				abc=Video1.next();
				System.out.println(abc.getsFileName()+abc.getsFileType()+" Size: "+ VF.ProperQuantity(abc.getlSizeByte()));
			}
			
		}
		else
		{
			System.out.println("No row seleted");
		}
		*/
		//clsVideoFile vold=new clsVideoFile();	
		//clsVideoFile vNew =new clsVideoFile();
		//vNew.setsFileName("mms3");
		//vNew.setsFileType(".mp3");
		//vold.setsFileName("mms2");
		//vold.setsFileType(".mp4");
		
		/*
		if(VF.UpdateVideoFile(v,v2))										//Updating Video1
			System.out.println("Not Updated");
		else
			System.out.println("Updated");
		
		//if(VF.UpdateVideoFile(v2, vNew))									//Updating Video1
			//System.out.println("Updated");
		//else
			//System.out.println("Updated");
		
		
*/
	}

}
