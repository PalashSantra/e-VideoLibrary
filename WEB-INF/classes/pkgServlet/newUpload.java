package pkgServlet;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pkgBeans.pkgVideos.clsVideoFile;
import pkgBeans.pkgVideos.clsVideoFileImplimentation;
import pkgBeans.pkgVideos.intVideoFileFunction;
 
public class newUpload extends HttpServlet {
private static final long serialVersionUID = 1L;
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	if(session==null){
    		session = request.getSession();
    		request.getRequestDispatcher("/index.jsp").forward(request, response);
    		
    	}
    	try {
			String name = null;
			Long size = null;
			String type = null;
			PrintWriter out=response.getWriter();
			String saveFile="";
			String contentType = request.getContentType();
			if((contentType != null)&&(contentType.indexOf("multipart/form-data") >= 0)){
			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
			byte dataBytes[] = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while(totalBytesRead < formDataLength){
			byteRead = in.read(dataBytes, totalBytesRead,formDataLength);
			totalBytesRead += byteRead;
			}
			
			String file = new String(dataBytes);
			saveFile = file.substring(file.indexOf("filename=\"") + 10);
			saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
			saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1,saveFile.indexOf("\""));
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			int pos;
			pos = file.indexOf("filename=\"");
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			pos = file.indexOf("\n", pos) + 1;
			int boundaryLocation = file.indexOf(boundary, pos) - 4;
			int startPos = ((file.substring(0, pos)).getBytes()).length;
			int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
			File ff = new File("C:/apache-tomcat-7.0.41/apache-tomcat-7.0.41/webapps/data/"+saveFile);
			FileOutputStream fileOut = new FileOutputStream(ff);
			fileOut.write(dataBytes, startPos, (endPos - startPos));
			fileOut.flush();
			fileOut.close();
			/*out.println("savefile :"+saveFile);
			out.println("name :"+ff.getName());
			out.println("size :"+ff.length());
			out.println("size :"+ff.getParent());
			out.println("size :"+ff.getParent());*/
			name=ff.getName();
			size=ff.length();
			String format = "none";
			String fileName = ff.getName();
			int index = fileName.lastIndexOf(".");
			if(index > 0){
			               format = fileName.substring(index+1);
			               format = format.toLowerCase();
			}
			//out.println(""+format);
			type=format;
   }
			/*out.println("savefile :"+saveFile);
			out.println("savefile :"+name);
			out.println("savefile :"+size);
			out.println("savefile :"+type);*/

			clsVideoFile v=new clsVideoFile();									//Creating Object
			//clsVideoFile v2=new clsVideoFile();									//Creating Object
			intVideoFileFunction VF =new clsVideoFileImplimentation();			//Creating Object for Function
			
			v.setsFileName(name);
			v.setsFileType("."+type);
			v.setlSizeByte(size);
			
			if(VF.AddVideoFile(v)){												//Adding New Video2
				out.println("<h1><center>VIDEO IS UPLOADED SUCCESSFULLY.</center></h1>");
			 
			}
			else
				out.println("<h1><center>UNSUCCESSFUL : VIDEO IS ALREADY IN SERVER</center></h1>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().print("<h1><center>NO FILE IS CHOSEN FOR UPLOADING</center></h1>");
			e.printStackTrace();
		}
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	doPost(request, response);
    }
}