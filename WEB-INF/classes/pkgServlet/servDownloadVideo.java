package pkgServlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servDownloadVideo
 */
public class servDownloadVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
    	HttpSession session = request.getSession(false);
    	if(session==null){
    		session = request.getSession();
    		request.getRequestDispatcher("/index.jsp").forward(request, response);
    		
    	}
		String downloadfile=request.getParameter("n2");
		String fulldownload="../data/"+downloadfile;
 		 
		response.sendRedirect(fulldownload);
		//request.setAttribute("downloadIt",fulldownload);
		//RequestDispatcher down =request.getRequestDispatcher("/"+fulldownload);
		//down.forward(request, response);
		response.setContentType("application/x-download"); 
		response.setHeader("Content-Disposition", "attachment; filename=downloaded.pdf");
	
		   
		 ServletContext ctx = getServletContext();  
		 InputStream is = ctx.getResourceAsStream(fulldownload);  
		   
		 System.out.println(is.toString());  
		 int read =0;  
		   
		 byte[] bytes = new byte[1912135680];  
		 OutputStream os = response.getOutputStream();  
		   
		 while((read = is.read(bytes)) != -1)  
		 {  
		   
		    os.write(bytes, 0, read);  
		    
		 }  
		 System.out.println(read);  
		 os.flush();  
		 os.close();  
		   
		
		
	}

}
