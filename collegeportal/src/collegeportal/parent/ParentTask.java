 package collegeportal.parent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import collegeportal.beans.City;
import collegeportal.beans.Feedbackbean;
import collegeportal.beans.Hostel;
import collegeportal.beans.Login_Credentials;
import collegeportal.beans.Parent;
import collegeportal.beans.Upload_Post;
import collegeportal.beans.Videos;
import collegeportal.dbinfo.CrudOperation;

public class ParentTask 
{
	public int editprofile(Parent p) 
	{
		int updatestatus=0;
		con=CrudOperation.createConnection();
		String strupdate="update parent_details set city=?,phone=? where id=?";
		try {
		PreparedStatement ps=con.prepareStatement(strupdate);
		ps.setString(1,p.getCity());
		ps.setString(2,p.getPhone());
		ps.setString(3, p.getId());
		System.out.println(ps);

		updatestatus=ps.executeUpdate();
		System.out.println(updatestatus);
		System.out.println(updatestatus);
		
		
		}catch(SQLException se) {
			se.printStackTrace();
		}
		return updatestatus;
	}
	
	
	
	
	
	Connection con;
	public Parent viewProfile(String userid)
	{
	PreparedStatement ps=null;
	ResultSet rs=null;
	String strsql="select * from parent_details where id=?";
	con=CrudOperation.createConnection();
	try {
		ps=con.prepareStatement(strsql);
		ps.setString(1, userid);
		rs=ps.executeQuery();
		if(rs.next()) {
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String language=rs.getString("languages");
			String gender=rs.getString("gender");
			String city=rs.getString("city");
			Parent p=new Parent(userid,name,phone,language,gender,city);
			p.setPicname(rs.getString("picname"));
          		return p;
          		}
	}
	catch(SQLException se) 
		{
			se.printStackTrace();
		}
	 
	return null;	
	}

	public boolean givefeedback(Feedbackbean fb) 
	{
		con=CrudOperation.createConnection();
		PreparedStatement psfeed=null;
		String feedback="insert into feedback_table values(?,?,?,?,?,?)";
		try {
			psfeed=con.prepareStatement(feedback);
			psfeed.setString(1, fb.getName());
			psfeed.setString(2, fb.getEmail());
			psfeed.setString(3, fb.getPhone());
			psfeed.setString(4, fb.getFeedback());
			psfeed.setString(5, fb.getRating());
			
			int feed_status=psfeed.executeUpdate();
			if(feed_status>0) {
				return true;
			}
			
			
		}catch(SQLException se) {
			se.printStackTrace();
			
		}
		
		
		
		return true;
	}
	public boolean add_post(Upload_Post up) {
		
		
		con=CrudOperation.createConnection();
		PreparedStatement psup=null;
		boolean status=false;
		String post="insert into add_post(content) values(?)";
		try {
			psup=con.prepareStatement(post);
			psup.setString(1, up.getContent());
			System.out.println(psup);
			int post_status=psup.executeUpdate();
			if(post_status>0) {
				return true;
			}
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		return status;
	}
  public boolean registration(Parent p,Login_Credentials lc)
  {
	   con=CrudOperation.createConnection();
	  PreparedStatement pslogin=null,psparent=null;
	  String strlogin="insert into login values(?,?,?)";
	  String strparent="insert into parent_details(id, name, phone, languages, gender, city) values(?,?,?,?,?,?)";
	  
	  try {
		 pslogin=con.prepareStatement(strlogin);//passes query to RDBMS -> parser-.parsequery-complier-.compile
		 psparent=con.prepareStatement(strparent);
		  pslogin.setString(1, lc.getId());
		  pslogin.setString(2, lc.getPassword());
		  pslogin.setString(3, lc.getRole());
		  System.out.println(pslogin);
		  
		  psparent.setString(1, p.getId());
		  psparent.setString(2, p.getName());
		  psparent.setString(3, p.getPhone());
		  psparent.setString(4, p.getLanguage());
		  psparent.setString(5, p.getGender());
		  psparent.setString(6, p.getCity());
		  System.out.println(psparent);
		  
		  int login_status=pslogin.executeUpdate();
		  System.out.println(login_status);
		  
		  int parent_status=psparent.executeUpdate();
		  System.out.println(parent_status);
		  if(login_status>0 && parent_status>0) {		  
			  return true;
		  }  
	  }
	  catch(SQLException se) 
	  {
		  
		System.out.println(se.getErrorCode());
		
		if(se.getErrorCode()==1062)
		{
			return false;
			
		}
		se.printStackTrace();  
	  }
	  
	
  
  
  
  finally {
	  
	  
	 try {
		 
		 
		 if(pslogin!=null)
			 pslogin.close();
		 if(psparent!=null)
			 psparent.close();
		 
		 
	 } 
	 
	 catch(SQLException se)
	 {
		 
		 se.printStackTrace();
	 }
	 }
	  
	  
  
  
	  return false;
		
}

public boolean uploadDocs(InputStream is, File f, String filename)
{
	try {
		
			int size=is.available();
            byte[]data=new byte[size];
			int status=is.read(data);
			 System.out.println(status); 
			
			
			FileOutputStream fos=new FileOutputStream(f+File.separator+filename);
			fos.write(data);
			fos.close();
			System.out.println("Pic Uploaded");
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return true;
	
}
public boolean updateProfile(String filename,String id) 

{
	con=CrudOperation.createConnection();
	String str="update parent_details set picname=? where id=?";
	boolean status=false;
	try {
	PreparedStatement ps=con.prepareStatement(str);
	ps.setString(1, filename);
	ps.setString(2, id);
	
	int rs= ps.executeUpdate();
	if(rs>0)
	{
		return true;
	}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return status;
	
}
public boolean uploadpost(InputStream is, File f, String filename) {
	try {
		
			int size=is.available();
			byte[]data=new byte[size];
			int status=is.read(data);
			
			System.out.println(status);
			
			FileOutputStream fos=new FileOutputStream(f+File.separator+filename);
			fos.write(data);
			fos.close();
			System.out.println("Post Uploaded");
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return true;
	
}
public boolean updatePost(String filename,String id) 

{
	
	
	con=CrudOperation.createConnection();
	String str="update parent_details set picname=? where id=?";
	boolean status=false;
	try {
	PreparedStatement ps=con.prepareStatement(str);
	ps.setString(1, filename);
	ps.setString(2, id);
	
	int rs= ps.executeUpdate();
	if(rs>0)
	{
		return true;
	}
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return status;
	
}
public Videos viewVideos(int id)
{
	Videos video=null;
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	String strsql = "select * from video_details where video_id=?";
	con = CrudOperation.createConnection();
	
	try {

		ps = con.prepareStatement(strsql);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		if (rs.next()) 
		{
			
			
			  String name = rs.getString("videoname"); 
			  
			  String link =rs.getString("videolink");
			  
			  System.out.println(link);
			  
			  video = new Videos(name, link);
			 


		}
	} catch (SQLException se) {
		se.printStackTrace();
		
	}
	return video;

	
	
}

public boolean postVideo(Videos v) 
{
	con=CrudOperation.createConnection();
	PreparedStatement psvdo=null;
	String strvideo="insert into video_details(videoname, videolink) values(?,?)";
	try {
		psvdo=con.prepareStatement(strvideo);
		psvdo.setString(1, v.getVideoname());
		psvdo.setString(2, v.getVideolink());
		System.out.println(psvdo);
		int vdo_status=psvdo.executeUpdate();
		System.out.println(vdo_status);
		
		
		
	}catch(SQLException se) {
		se.printStackTrace();
	}
	
	return true;
	
	
	
}
ArrayList<City> citylist=new ArrayList<City>();
public ArrayList<City> viewcity()
{
	
	if(citylist.isEmpty())
         citylist.clear();
	con=CrudOperation.createConnection();
	try {
		String strsql="select * from city";
		PreparedStatement ps=con.prepareStatement(strsql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			City c=new City();
			c.setId(rs.getString("cityid"));
			c.setName(rs.getString("cityname"));
            citylist.add(c);
			
			
		}
		
		
	}catch(SQLException se){
		se.printStackTrace();
	}
	return citylist;
	
	
	
	
}
ArrayList<Hostel>hostellist=new ArrayList<Hostel>();
public ArrayList<Hostel> viewHostel(String cityid)
{
	Hostel h=null;
PreparedStatement ps=null;
ResultSet rs=null;
String strsql="select * from hostel where cityid=?";
con=CrudOperation.createConnection();
try {
	ps=con.prepareStatement(strsql);
	ps.setString(1, cityid);
	rs=ps.executeQuery();
	while(rs.next()) {
		int id=rs.getInt("hostelid");
		String name=rs.getString("hostelname");
		String address=rs.getString("address");
		 h=new Hostel(id,name,address);
		
      		hostellist.add(h);
      		}
}
catch(SQLException se) 
	{
		se.printStackTrace();
	}
 
    return hostellist;	
}
ArrayList<Videos>videolist=new ArrayList<Videos>();

public ArrayList<Videos> viewvideos()
{
	if(!videolist.isEmpty())
		videolist.clear();
	con=CrudOperation.createConnection();
	try {
	String strsql="select * from video_details order by date desc limit 10";
	PreparedStatement ps=con.prepareStatement(strsql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		Videos vdo=new Videos();
        vdo.setVideoname(rs.getString("videoname"));
        vdo.setVideolink(rs.getString("videolink"));
        videolist.add(vdo);
	}
	}catch(SQLException se) {
		se.printStackTrace();
	}
	
	return videolist;
	
		
}

}