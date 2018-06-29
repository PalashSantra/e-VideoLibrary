import javax.servlet.RequestDispatcher;

import pkgBeans.pkgUsers.clsUserDetail;
import pkgBeans.pkgUsers.clsUserImplimentation;
import pkgBeans.pkgUsers.intUserFunction;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clsUserDetail u=new clsUserDetail();
		u.setsUserName("gulam");
		u.setsPassword("rabbani");
		intUserFunction UF = new clsUserImplimentation();
		if(UF.CheckLogIn(u)==1)
		{		
			//session=request.getSession();
			//session.setAttribute("username", u.getsUserName());
			//.setAttribute("Type", "Admin");
			////RequestDispatcher rd=request.getRequestDispatcher("/home.jsp");
			//rd.forward(request, response);
			System.out.println("succsess");
		}
		else if(UF.CheckLogIn(u)==0)
		{
			//session=request.getSession();
			//session.setAttribute("username", u.getsUserName());
			//session.setAttribute("Type", "user");
		}
		else if(UF.CheckLogIn(u)==-1)
		{
			///session=request.getSession();
			//session.setAttribute("username", "invalid");
			//session.setAttribute("Type", "invalid");
		}
		else if(UF.CheckLogIn(u)==2)
		{
			System.out.println("Error Occurd");
		}
		
		
		}
	}

