package pkgServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class servPlayVideo
 */
public class servPlayVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inn");
		HttpSession session = request.getSession(false);
    	if(session==null){
    		session = request.getSession();
    		request.getRequestDispatcher("/index.jsp").forward(request, response);
    		
    	}
    	else
    	{
	String VideoName=request.getParameter("n1");
		System.out.println("serv");
		System.out.println("name:"+VideoName);
		//File file = new File(VideoName);
		//String absolutePath =file.getAbsolutePath();
	    //System.out.println("File path : " + absolutePath);
	    VideoName="../data/"+VideoName;
	    System.out.println(VideoName);
	    request.setAttribute("VideoPlay",VideoName);
	    RequestDispatcher view = request.getRequestDispatcher("play.jsp");
		view.forward(request, response);
	}
	}

}
