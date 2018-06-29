package pkgServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgBeans.pkgUsers.clsUserImplimentation;
import pkgBeans.pkgUsers.intUserFunction;

/**
 * Servlet implementation class servUserDelete
 */
public class servUserDelete extends HttpServlet {
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
    	else
    	{
		
		String UserName=request.getParameter("n");
		
			
		intUserFunction UF =new clsUserImplimentation();
		if(UF.DeleteUser(UserName)==1)											
			response.getWriter().println("<h1><center>Successfully Deleted</center></h1>");
		else
			response.getWriter().println("<h1><center>Not Deleted</center></h1>");
    	}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	doPost(request,response);

	}

	
}
