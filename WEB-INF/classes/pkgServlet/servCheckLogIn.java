package pkgServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgBeans.pkgUsers.clsUserDetail;
import pkgBeans.pkgUsers.clsUserImplimentation;
import pkgBeans.pkgUsers.intUserFunction;

/**
 * Servlet implementation class servCheckLogIn
 */
public class servCheckLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	clsUserDetail u=new clsUserDetail();
	
	intUserFunction UF = new clsUserImplimentation();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		//System.out.println("hiii i am in");
		String sUserName=request.getParameter("username");
		String sPassword=request.getParameter("password");
		u.setsUserName(sUserName);
		u.setsPassword(sPassword);
		//System.out.println(sUserName);
		
		if(UF.CheckLogIn(u)==1)
		{		
			
			if(session==null)
			{
				
			System.out.println("in null");
			session=request.getSession();
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");                                                          
			rd.forward(request, response);
			
			}
			else
			{
				
				session.setAttribute("username", u.getsUserName());
				session.setAttribute("Type", "Admin");	
				Iterator<clsUserDetail>User;
				clsUserDetail ud=new clsUserDetail();
				ud.setsUserName((String)session.getAttribute("username"));
				String unm = (String) session.getAttribute("username");
				clsUserImplimentation NUF=new clsUserImplimentation();
				ArrayList<clsUserDetail>ComingUser=NUF.ProfileShow(unm);
				if(ComingUser!=null)
				{
					User=ComingUser.iterator();
					clsUserDetail abc;
					while(User.hasNext())
					{
						abc=User.next();
						System.out.println("here we go...");
						System.out.println("User name "+abc.getsUserName());
						System.out.println("User Lastname "+abc.getsLastName());
						System.out.println("User Firstname "+abc.getsFirstName());
						System.out.println("User Emailname "+abc.getsEmail());
						System.out.println("User password "+abc.getsPassword());
						session.setAttribute("nusername",abc.getsUserName());
						session.setAttribute("Fname", abc.getsFirstName());
						session.setAttribute("Lname", abc.getsLastName());
						session.setAttribute("Email", abc.getsEmail());
					
					}
					RequestDispatcher rd=request.getRequestDispatcher("/Admin.jsp");
					rd.forward(request, response);
				}
			}
		}
		else if(UF.CheckLogIn(u)==0)
		{
			
			if(session ==null){
			session=request.getSession();
			RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			}
			else
			{
				 
				session.setAttribute("username", u.getsUserName());
				session.setAttribute("Type", "user");
				Iterator<clsUserDetail>User;
				clsUserDetail ud=new clsUserDetail();
				ud.setsUserName((String)session.getAttribute("username"));
				String unm = (String) session.getAttribute("username");
				clsUserImplimentation NUF=new clsUserImplimentation();
				ArrayList<clsUserDetail>ComingUser=NUF.ProfileShow(unm);
				if(!ComingUser.isEmpty())
				{
					User=ComingUser.iterator();
					clsUserDetail abc;
					while(User.hasNext())
					{
						abc=User.next();
						session.setAttribute("nusername",abc.getsUserName());
						session.setAttribute("Fname", abc.getsFirstName());
						session.setAttribute("Lname", abc.getsLastName());
						session.setAttribute("Email", abc.getsEmail());
						
					}
					RequestDispatcher rd=request.getRequestDispatcher("/User.jsp");
					rd.forward(request, response);
				}
				
			}
		}
		else if(UF.CheckLogIn(u)==-1)
		{
			
			if (session==null)
			{
			session=request.getSession();
			session.setAttribute("username", "invalid");
			session.setAttribute("Type", "invalid");
			response.getWriter().println("<h1><center>Invalid Username or Password</center></h1>");
			}
			else
			{
				session.setAttribute("username", "invalid");
				session.setAttribute("Type", "invalid");
				response.getWriter().println("<h1><center>Invalid Username or Password</center></h1>");
			}
		}
		else if(UF.CheckLogIn(u)==2)
		{
			
			
			if (session==null)
			{
			
			session=request.getSession();
			session.setAttribute("username", "invalid");
			session.setAttribute("Type", "error");
			response.getWriter().println("<h1><center>Fill both text box.</center></h1>");
			}
			else
			{
				session.setAttribute("username", "invalid");
				session.setAttribute("Type", "invalid");
				response.getWriter().println("<h1><center>Fill both text box.</center></h1>");
			}
		}
		
		
		}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session;
		HttpSession session=request.getSession(false);
		if(session==null )
		{
		session=request.getSession();
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		else
		{
			String Type=(String)session.getAttribute("Type");
			if(Type.equals("Admin"))
			{
				Iterator<clsUserDetail>User;
				clsUserDetail ud=new clsUserDetail();
				ud.setsUserName((String)session.getAttribute("username"));
				String unm = (String) session.getAttribute("username");
				clsUserImplimentation NUF=new clsUserImplimentation();
				ArrayList<clsUserDetail>ComingUser=NUF.ProfileShow(unm);
				if(!ComingUser.isEmpty())
				{
					User=ComingUser.iterator();
					clsUserDetail abc;
					while(User.hasNext())
					{
						abc=User.next();
						session.setAttribute("nusername",abc.getsUserName());
						session.setAttribute("Fname", abc.getsFirstName());
						session.setAttribute("Lname", abc.getsLastName());
						session.setAttribute("Email", abc.getsEmail());
						
					}
					RequestDispatcher rd=request.getRequestDispatcher("/Admin.jsp");
					rd.forward(request, response);
				}
				
			}
			else if(Type.equals("user"))
			{
				Iterator<clsUserDetail>User;
				clsUserDetail ud=new clsUserDetail();
				ud.setsUserName((String)session.getAttribute("username"));
				String unm = (String) session.getAttribute("username");
				clsUserImplimentation NUF=new clsUserImplimentation();
				ArrayList<clsUserDetail>ComingUser=NUF.ProfileShow(unm);
				if(!ComingUser.isEmpty())
				{
					User=ComingUser.iterator();
					clsUserDetail abc;
					while(User.hasNext())
					{
						abc=User.next();
						session.setAttribute("nusername",abc.getsUserName());
						session.setAttribute("Fname", abc.getsFirstName());
						session.setAttribute("Lname", abc.getsLastName());
						session.setAttribute("Email", abc.getsEmail());
						
					}
					RequestDispatcher rd=request.getRequestDispatcher("/User.jsp");
					rd.forward(request, response);
				}
			}
			else if(Type.equals("invalid"))
			{
				response.getWriter().println("<h1><center>Invalid Username or Password</center></h1>");
			}
			else if(Type.equals("error"))
			{
				
				response.getWriter().println("<h1><center>Fill both text box.</center></h1>");
			}
			
		}
}
		
}
		
		
	
	


