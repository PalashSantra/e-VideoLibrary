package pkgBeans.pkgVideos;

public class clsVideoFile {
	
	/**
	 * @author PALASH
	 */
	
	private int iFileID;
	private String sFileName;
	private String sFileType;
	private long lSizeByte;
	public clsVideoFile(int iFileID, String sFileName, String sFileType,
			long lSizeByte) {
		super();
		this.iFileID = iFileID;
		this.sFileName = sFileName;
		this.sFileType = sFileType;
		this.lSizeByte = lSizeByte;
	}
	public clsVideoFile() {
		// TODO Auto-generated constructor stub
	}
	public int getiFileID() {
		return iFileID;
	}
	public void setiFileID(int iFileID) {
		this.iFileID = iFileID;
	}
	public String getsFileName() {
		return sFileName;
	}
	public void setsFileName(String sFileName) {
		this.sFileName = sFileName;
	}
	public String getsFileType() {
		return sFileType;
	}
	public void setsFileType(String sFileType) {
		this.sFileType = sFileType;
	}
	public long getlSizeByte() {
		return lSizeByte;
	}
	public void setlSizeByte(long lSizeByte) {
		this.lSizeByte = lSizeByte;
	}
	
}
