package pkgServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgBeans.pkgVideos.clsVideoFile;
import pkgBeans.pkgVideos.clsVideoFileImplimentation;
import pkgBeans.pkgVideos.intVideoFileFunction;

/**
 * Servlet implementation class servAllvideoSearch
 */
public class servAllvideoSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	HttpSession session = request.getSession(false);
    	if(session==null){
    		session = request.getSession();
    		request.getRequestDispatcher("/index.jsp").forward(request, response);
    		
    	}
		String flag=request.getParameter("check");
		intVideoFileFunction VF =new clsVideoFileImplimentation();	
		Iterator<clsVideoFile> Video;										//Show All Video
		ArrayList<clsVideoFile>ComingVideo=VF.SelectVideoFile();
		if(!ComingVideo.isEmpty())
		{
			
			request.setAttribute("AllVideos",ComingVideo);
			if(flag.equals("Directory"))
			{
			request.getRequestDispatcher("/AllVideos.jsp").forward(request, response);
			}
			else if(flag.equals("Play"))
			{
			request.getRequestDispatcher("/AllvideoPlay.jsp").forward(request, response);
			}
			else
			{
				request.getRequestDispatcher("/AllvideoDownload.jsp").forward(request, response);
			}
			
			Video=ComingVideo.iterator();
			clsVideoFile abc;
			while(Video.hasNext())
			{
				abc=Video.next();
				System.out.println(abc.getsFileName()+abc.getsFileType()+" Size: "+VF.ProperQuantity(abc.getlSizeByte()));
			}
		}
		else
		{
			System.out.println("No row seleted");
		}
		
	
	
	}

}
