package collegeportal.beans;


public class Videos {
	public Videos() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String videoname,videolink;
	
	
	
	public Videos(String videoname, String videolink) {
		super();
		this.videoname = videoname;
		this.videolink = videolink;
		
	}
	public String getVideoname() {
		return videoname;
	}
	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}
	public String getVideolink() {
		return videolink;
	}
	public void setVideolink(String videolink) {
		this.videolink = videolink;
	}
	
	

}
