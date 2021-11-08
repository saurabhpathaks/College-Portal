package collegeportal.beans;

public class News_bean {
	public int newsid;

	public News_bean(int newsid) {
		super();
		this.newsid = newsid;
	}
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String subject,content,date;
	
	public News_bean( String subject, String content, String date) {
		super();
		
		this.subject = subject;
		this.content = content;
		this.date = date;
	}
	public News_bean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
