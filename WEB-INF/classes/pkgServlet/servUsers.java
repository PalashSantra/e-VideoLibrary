package pkgServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkgBeans.pkgUsers.clsUserDetail;
import pkgBeans.pkgUsers.clsUserImplimentation;
import pkgBeans.pkgUsers.intUserFunction;

/**
 * Servlet implementation class servUsers
 */
public class servUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		intUserFunction UF =new clsUserImplimentation();	
		Iterator<clsUserDetail> User;										//Show All User
		ArrayList<clsUserDetail>ComingUser=UF.SelectUser();
		if(!ComingUser.isEmpty())
		{
			request.setAttribute("users",ComingUser);
			request.getRequestDispatcher("/AdminAllUsers.jsp").forward(request, response);
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
			response.getWriter().print("<h1><center>Oops! No Users found.<center></h1>");
		}
	}

}
