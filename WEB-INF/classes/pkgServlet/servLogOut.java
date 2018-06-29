package pkgServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class servLogOut
 */
public class servLogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession losession= request.getSession(false);
		if(losession==null)
		{
		losession=request.getSession(true);
		RequestDispatcher rdlo=request.getRequestDispatcher("/index.jsp");
		rdlo.forward(request, response);
		}
		else
		{
		losession.invalidate();
		 response.setHeader("pragma", "no-cache");  
         response.setHeader("Cache-control",  
                 "no-cache, no-store, must-revalidate");  
         response.setHeader("Expires", "0");  
		RequestDispatcher rdlo=request.getRequestDispatcher("/index.jsp");
		rdlo.forward(request, response);
		System.out.println("I m in Sevlet Logout");
		}
	}

}
