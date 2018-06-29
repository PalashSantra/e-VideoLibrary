package pkgServlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgBeans.pkgVideos.clsVideoFile;
import pkgBeans.pkgVideos.clsVideoFileImplimentation;

/**
 * Servlet implementation class servParticularSearch
 */
public class servAdminParticularSearch extends HttpServlet {
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
    	
		String Vname=request.getParameter("query");
		clsVideoFile v3=new clsVideoFile();	
		v3.setsFileName(Vname);
		v3.setsFileType("");	
		clsVideoFileImplimentation VF=new clsVideoFileImplimentation();
		ArrayList<clsVideoFile>ComingVideo1=VF.SearchVideoFile(v3);
		if(!ComingVideo1.isEmpty())
		{
			
			
			request.setAttribute("check",1);
			request.setAttribute("Video", ComingVideo1);
			RequestDispatcher view = request.getRequestDispatcher("AdminParticularSearch.jsp");
			view.forward(request, response);
			
			
		}
		else
		{
			System.out.println("No row seleted");
			response.getWriter().print("<h1><center>OOps result is not found</h1></center>");
			response.getWriter().print("<center>Return to Search Page</center>");
			
			
		}
	}

	
	}


