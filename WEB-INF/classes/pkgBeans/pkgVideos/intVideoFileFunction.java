package pkgBeans.pkgVideos;

import java.util.ArrayList;

public interface intVideoFileFunction {
	
	/**
	 * 
	 * @param v
	 * @return
	 * @author PALASH
	 */
	
	boolean AddVideoFile(clsVideoFile v);
	boolean DeleteVideoFile(clsVideoFile v);
	boolean UpdateVideoFile(clsVideoFile vOld,clsVideoFile vNew);
	ArrayList<clsVideoFile> SelectVideoFile();
	ArrayList<clsVideoFile> SearchVideoFile(clsVideoFile v);
	String ProperQuantity(long Size);
}
