package pkgServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckRegField
 */
public class CheckRegField extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("checking comp");
		String FirstName =request.getParameter("Fname");
		String LastName =request.getParameter("Lname");
		String UserName =request.getParameter("Uname");
		String  Password=request.getParameter("PassWord");
		String 	ConfPass =request.getParameter("CPassWord");
		String  Mail =request.getParameter("Email");
		String  gender =request.getParameter("sgender");
		String MPass =request.getParameter("Mpass");
		String maildom="blank";
		if(Mail.length()!=0)
		{
			if(Mail.indexOf('@')!=-1)
			{
				String[] Mailchk=Mail.split("@");
				 maildom=Mailchk[1].trim();
				 if(maildom.equals("gmail.com")|| maildom.equals("yahoo.com")||maildom.equals("hotmail.com"))
				 {
					 maildom="Cdom";
				 }
				 else
				 {
					 maildom="Wdom";
				 }
			}
			else
			{
				maildom="invalid";
			}
		}
		else
		{
			
		}
		
		//String[] Mailchk=Mail.split("@");
		//String maildom=Mailchk[1].trim();
		
		System.out.println("gender:"+gender);
		//System.out.println(""+gender);


		if (
				FirstName!=null && 
				LastName!=null && 
				UserName.length()>5 && 
				Password.length()>7 && 
				ConfPass.equals(Password)&& 
				Mail.indexOf('@')!=-1 &&				
				(
				 gender.equals("Male")|| 
				 gender.equals("Female") || 
				 gender.equals("Other")
			    )&&
			    maildom.equals("Cdom")
			)
			{
				System.out.println("i m forwarded");
				request.setAttribute("Master", MPass);
				RequestDispatcher go=request.getRequestDispatcher("/servRegistration");
				go.forward(request, response);
			}
			
		
		else
		{
				
				
				if(FirstName.length()==0)
				{
					System.out.println("fname is null");
					request.setAttribute("Fmessg","Not be null");
				}
				if(LastName.length()==0)
				{
					System.out.println("lname is null");
					request.setAttribute("Lmessg","Not be null");
				}
				if(UserName.length()<=5)
				{
					System.out.println("uname is null");
					request.setAttribute("Umessg","Atleast 6 character");

				}
				if(Password.length()<=7)
				{
					System.out.println("passname is null");
					request.setAttribute("Pmessg","Atleast 8 character");

				}
				if(ConfPass.equals(Password)==false)
				{
					System.out.println("cpass is not same");
					request.setAttribute("CPmessg","Must be same");

				}
				if(maildom.equals("blank")||maildom.equals("invalid")||maildom.equals("Wdom"))
				{
					System.out.println("mai");
					request.setAttribute("Emessg","Not a Valid Email");

				}
				if(
						 !gender.equals("Male")|| 
						 !gender.equals("Female") || 
						 !gender.equals("Other")

				  )
				{
					System.out.println("gender:"+gender);

					System.out.println("gender is not filled");
					request.setAttribute("Gmessg","Select Gender");

				}
				request.setAttribute("Ffield",FirstName);
				request.setAttribute("Lfield",LastName);
				request.setAttribute("Ufield",UserName);
				request.setAttribute("Mfield",Mail);
				request.setAttribute("Gfield",gender);

				
				System.out.println("i m forwarded in except");
				RequestDispatcher go=request.getRequestDispatcher("/Registration.jsp");
				go.forward(request, response);
	
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		{
			RequestDispatcher go=request.getRequestDispatcher("/Registration.jsp");
			go.forward(request, response);
		}
		
	}

}
