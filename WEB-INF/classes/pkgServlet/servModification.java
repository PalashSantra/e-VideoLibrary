package pkgServlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgBeans.pkgVideos.clsVideoFile;
import pkgBeans.pkgVideos.clsVideoFileImplimentation;
import pkgBeans.pkgVideos.intVideoFileFunction;

/**
 * Servlet implementation class servModification
 */
public class servModification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
    	if(session==null){
    		session = request.getSession();
    		request.getRequestDispatcher("/index.jsp").forward(request, response);
    		
    	}
	String OldFilename=request.getParameter("Ofilename");
	String NewFilename=request.getParameter("Nfilename");
	String OldFilePath="C:/apache-tomcat-7.0.41/apache-tomcat-7.0.41/webapps/data/"+OldFilename;
	String NewFilePath="C:/apache-tomcat-7.0.41/apache-tomcat-7.0.41/webapps/data/"+NewFilename;
	System.out.println("old"+OldFilePath);
	System.out.println("old"+NewFilePath);
	if(OldFilename.isEmpty() && NewFilename.isEmpty())
	{
	   response.getWriter().println("<h1><center>Write the name of the file in the text box.<br>This file is not found.</center></h1>");
	}
	else
	{
	File fileold=new File(OldFilePath);
	File filenew=new File(NewFilePath);
	int flag=0;
	if(fileold.exists())
	{
		fileold.renameTo(filenew);
		response.getWriter().println("<h1><center>The file is renamed</center></h1>");
		flag=1;
	
	}
	else
	{
		response.getWriter().println("<h1><center>the file is not exist</center></h1>");

	}
	if(flag==1)
	{
		clsVideoFile vold=new clsVideoFile();									
		vold.setsFileName(OldFilename);
		String format1 = "none";
    	
    	int index1 =OldFilename.lastIndexOf(".");
    	if(index1 > 0){
    	               format1 =OldFilename.substring(index1+1);
    	               format1 = format1.toLowerCase();
    	}
		vold.setsFileType("."+format1);
		response.getWriter().println("first format type:"+format1);
		vold.setlSizeByte(fileold.length());
		clsVideoFile vnew=new clsVideoFile();									
		vnew.setsFileName(NewFilename);
		String format2 = "none";
    	
    	int index2 =NewFilename.lastIndexOf(".");
    	if(index2 > 0){
    	               format2 =NewFilename.substring(index2+1);
    	               format2 = format2.toLowerCase();
    	}
		vnew.setsFileType("."+format2);
		response.getWriter().println("2nd format type:"+format2);
		vnew.setlSizeByte(filenew.length());
		response.getWriter().println("new file:"+vnew.getsFileName()+vnew.getsFileType());
		response.getWriter().println("old file is:"+vold.getsFileName()+vold.getsFileType());
		intVideoFileFunction VF =new clsVideoFileImplimentation();
		
		if(VF.UpdateVideoFile(vold,vnew))
		{
			response.getWriter().println("Updated succesfully");
		}
		else
		{
			response.getWriter().println("Not Updated Successfully");
		}
	
	
	}
	}
}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	{
			doPost(request, response);
	}
	}
}
