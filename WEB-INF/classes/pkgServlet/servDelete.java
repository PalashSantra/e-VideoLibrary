package pkgServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgBeans.pkgVideos.clsVideoFile;
import pkgBeans.pkgVideos.clsVideoFileImplimentation;
import pkgBeans.pkgVideos.intVideoFileFunction;

/**
 * Servlet implementation class servDelete
 */
public class servDelete extends HttpServlet {
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
		PrintWriter out=response.getWriter();
		String name=request.getParameter("n3");
		System.out.println("the name is :"+name);
		if(name.isEmpty())
		{
			out.println("<h1><center>Write the name of the file in the text box.<br>This file is not found.</center></h1>");
		}
		else
		{
		String path="C:/apache-tomcat-7.0.41/apache-tomcat-7.0.41/webapps/data/"+name;
			int flag=0;
			File f=new File(path);
			
			if(f.exists())
			{
				
				f.delete();
				
				flag=1;
				
			}
			else
			{
				out.print("<h1><center>There is no such a file found</center></h1>");
			}
		if(flag==1)
		{

			clsVideoFile v=new clsVideoFile();									
			v.setsFileName(name);
			String format = "none";
	    	
	    	int index =name.lastIndexOf(".");
	    	if(index > 0){
	    	               format =name.substring(index+1);
	    	               format = format.toLowerCase();
	    	}
			v.setsFileType("."+format);
			//out.println(format);
			v.setlSizeByte(f.length());
			intVideoFileFunction VF =new clsVideoFileImplimentation();
			VF.DeleteVideoFile(v);
			out.print("<h1><center>Succesfully Deleted.</center></h1>");
		}
		}
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
