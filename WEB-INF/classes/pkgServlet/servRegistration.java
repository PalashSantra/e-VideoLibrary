package pkgServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgBeans.pkgUsers.clsUserDetail;
import pkgBeans.pkgUsers.clsUserImplimentation;

/**
 * Servlet implementation class servRegistration
 */
public class servRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hiii");
		HttpSession session = request.getSession(false);
    	if(session==null){
    		session = request.getSession();
    		request.getRequestDispatcher("/index.jsp").forward(request, response);
    		
    	}
    	else
    	{
		
		clsUserDetail u = new clsUserDetail();
		clsUserImplimentation UI = new clsUserImplimentation();
		
		if(UI.GetMasterPassword().equals(request.getParameter("Mpass")))
		{
				u.setiType(1);
				System.out.println(request.getParameter("Mpass"));
		}
		else
			u.setiType(0);
		String sEmail = request.getParameter("Email");
		u.setsEmail(sEmail);
		System.out.println(sEmail);
		
		String sPassword = request.getParameter("PassWord");
		u.setsPassword(sPassword);
		System.out.println(sPassword);
		
		String sUserName = request.getParameter("Uname");
		u.setsUserName(sUserName);
		System.out.println(sUserName);
		
		String sFname = request.getParameter("Fname");
		u.setsFirstName(sFname);
		System.out.println(sFname);
		
		String sLname = request.getParameter("Lname");
		u.setsLastName(sLname);
		System.out.println(sLname);
		
		String sGender = request.getParameter("sgender");
		u.setsGender(sGender);
		System.out.println(sGender);
		
	
		if(UI.AddUser(u)){
			HttpSession s = request.getSession(false);
			if(s==null)
			{
				request.getRequestDispatcher("/home.jsp");
			}
			else
			{
				s.setAttribute("" +
						"state", "succesful");
				request.getRequestDispatcher("/RegistrationConfirmation.jsp").forward(request, response);
			}
		}
		else
		{
			HttpSession s = request.getSession(false);
			if(s==null)
				request.getRequestDispatcher("/home.jsp");
			else
			{
				System.out.println("unsuccess");
				s.setAttribute("state1", "unsuccesful");
				request.getRequestDispatcher("/Registration.jsp").forward(request, response);
			}
		}
	}
	}

}
