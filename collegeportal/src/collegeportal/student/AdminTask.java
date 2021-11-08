package collegeportal.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import collegeportal.beans.Login_Credentials;
import collegeportal.beans.News_bean;
import collegeportal.beans.Parent;
import collegeportal.beans.Student_bean;
import collegeportal.dbinfo.CrudOperation;


public class AdminTask 
{
	ArrayList<Parent>parentlist=new ArrayList<Parent>();
	ArrayList<News_bean>newslist=new ArrayList<News_bean>();
	ArrayList<Student_bean>studentlist=new ArrayList<Student_bean>();
   
	public boolean addNews(News_bean nb) {
		
		con=CrudOperation.createConnection();
		PreparedStatement psnews=null;
		
		String strnews="insert into news_table(subject,content,date) values(?,?,?)";
		try {
			psnews=con.prepareStatement(strnews);
			psnews.setString(1, nb.getSubject());
			psnews.setString(2, nb.getContent());
			psnews.setString(3, nb.getDate());
			System.out.println(psnews);
			int news_status=psnews.executeUpdate();
			  System.out.println(news_status);
			
			
		}catch(SQLException se) {
			se.printStackTrace();
		}
		
		
		
		return true;
		
		
	}
	
	
	
	public boolean deletestudent(String[]id)
	{
		con=CrudOperation.createConnection();
		boolean status=false;
		try{
			String strstudent="delete from student_details where student_id=?";
			String strlogin="delete from login where userid=?";
			PreparedStatement psstudent=con.prepareStatement(strstudent);
			PreparedStatement pslogin=con.prepareStatement(strlogin);
			for(int i=0;i<id.length;i++)
			{
				psstudent.setString(1, id[i]);
				pslogin.setString(1, id[i]);
				System.out.println(psstudent);
				System.out.println(pslogin);
				psstudent.addBatch();
				pslogin.addBatch();
				
			}
			int[] student_status=psstudent.executeBatch();
			int[] login_status=pslogin.executeBatch();
			
			int sflag=0,lflag=0;
			for(int i=0;i<student_status.length;i++)
			{
				if(student_status[i]<0)
				{
					sflag=0;
					break;
					
				}
			}
			for(int i=0;i<login_status.length;i++)
			{
				if(login_status[i]<0)
				{
					lflag=0;
					break;
				}
			}
			if(sflag==0 && lflag==0)
				status=true;
			
		}
		catch(SQLException se)
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			se.printStackTrace();
		}
		return status;
	}
	
	
	public boolean deleteParents(String[]ids) 
	{
	con=CrudOperation.createConnection();
	boolean status=false;
	try {
		String strdelete_parent="delete from parent_details where id=?";
		String strdelete_login="delete from login where userid=?";
		PreparedStatement psparent=con.prepareStatement(strdelete_parent);
		PreparedStatement pslogin=con.prepareStatement(strdelete_login);
		for(int i=0;i<ids.length;i++) {
			psparent.setString(1, ids[i]);
			pslogin.setString(1, ids[i]);
			System.out.println(psparent);
			System.out.println(pslogin);
			psparent.addBatch();
			
			pslogin.addBatch();
		}
		int[] parent_status=psparent.executeBatch();
		int[] login_status=pslogin.executeBatch();
		int pflag=0,lflag=0;
		for(int i=0;i<parent_status.length;i++) {
			if(parent_status[i]<0) {
				
				pflag=1;
				break;
				
			}
		}
		
		for(int i=0;i<login_status.length;i++)
		{
			if(login_status[i]<0) 
			{
				
				lflag=1;
				break;
				
			}
		}
		
		if(pflag==0 && lflag==0)
			status=true;
	}
	
	catch(SQLException se)
	{
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		se.printStackTrace();
	}
	return status;
	}
	
	
		public ArrayList<Parent> viewParents()
		{
			if(!parentlist.isEmpty())
				parentlist.clear();
			con=CrudOperation.createConnection();
			try {
				String strsql="select * from parent_details";
				PreparedStatement ps=con.prepareStatement(strsql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					Parent p=new Parent();
					p.setId(rs.getString("id"));
					p.setName(rs.getString("name"));
					p.setCity(rs.getString("city"));
					p.setPhone(rs.getString("phone"));
					
					parentlist.add(p);
					
					
					
				}
				
				
			}catch(SQLException se){
				se.printStackTrace();
			}
			return parentlist;
			
			
			
			
		}
		
		public ArrayList<Student_bean>viewstudent() {
			if(!studentlist.isEmpty())
				studentlist.clear();
			
			con=CrudOperation.createConnection();
			try {
				String strsql="select * from student_details";
				PreparedStatement ps=con.prepareStatement(strsql);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					Student_bean sb=new Student_bean();
					sb.setStudentid(rs.getString("student_id"));
					sb.setName(rs.getString("name"));
					sb.setEmail(rs.getString("email"));
					sb.setPhone(rs.getString("phone"));
					studentlist.add(sb);
				}		
		}catch(SQLException se) {
			
			se.printStackTrace();
			}
			
			return studentlist;
		}
			
			
			

	private Connection con;
	public  Student_bean viewprofile(String userid)
	{
		con=CrudOperation.createConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String strsql="select * from student_details where student_id=?";
		
		
		try {
			ps=con.prepareStatement(strsql);
			ps.setString(1, userid);
			rs=ps.executeQuery();
			if(rs.next()) 
			{
				String name=rs.getString("name");
				String pswd=rs.getString("password");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				Student_bean sb=new Student_bean(userid,pswd,name,email,phone);
				return sb;
			}
			
			
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return null;
		
	}
	public int editstudentprofile(Student_bean sb) {
		int updatestatus=0;
		con=CrudOperation.createConnection();
		String update="update student_details set email=?,phone=? where student_id=?";
		
		try {
			PreparedStatement ps=con.prepareStatement(update);
			
			ps.setString(1, sb.getEmail());
			ps.setString(2, sb.getPhone());
			ps.setString(3,sb.getStudentid());
			System.out.println(ps);
			
			updatestatus=ps.executeUpdate();
			System.out.println(updatestatus);
			return updatestatus;
			
		}catch(SQLException se) {
			se.printStackTrace();
		}

		return updatestatus;
	}
	public boolean accountcreation(Student_bean s,Login_Credentials lc)
	{
	con=CrudOperation.createConnection();
	PreparedStatement pslogin=null,psstudent=null;
	String strlogin="insert into login values(?,?,?)";
	String strstudent="insert into student_details(student_id, password, name, email, phone) values(?,?,?,?,?)";
	try {
		pslogin=con.prepareStatement(strlogin);
		psstudent=con.prepareStatement(strstudent);
		pslogin.setString(1, s.getStudentid());
		pslogin.setString(2, s.getPassword());
	    pslogin.setString(3, lc.getRole());
		System.out.println(pslogin);
		
		psstudent.setString(1, s.getStudentid());
		psstudent.setString(2, s.getPassword());
		psstudent.setString(3, s.getName());
		psstudent.setString(4, s.getEmail());
		psstudent.setString(5, s.getPhone());
		System.out.println(psstudent);
		int login_status=pslogin.executeUpdate();
		  System.out.println(login_status);
		  
		  
		int student_status=psstudent.executeUpdate();
		System.out.println(student_status);
		if(login_status>0 && student_status>0) {
		return true;
		}
	
		
	}
	catch(SQLException se) 
	{
	
	se.printStackTrace();
	}
	
	finally {
		try {
			if(pslogin!=null)
				pslogin.close();
			if(psstudent!=null)
				psstudent.close();
			
			
			
		}
		
		
		catch(SQLException se){
			se.printStackTrace();
		}
	}
	
	
	return false;

}
	
	
	public ArrayList<News_bean> viewnews()
	{
		if(!newslist.isEmpty())
			newslist.clear();
		con=CrudOperation.createConnection();
		try {
			String strsql="select * from news_table order by date desc limit 10";
			PreparedStatement ps=con.prepareStatement(strsql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				News_bean news=new News_bean();
				news.setNewsid(rs.getInt("newsid"));
				news.setSubject(rs.getString("subject"));
				news.setContent(rs.getString("content"));
				news.setDate(rs.getString("date"));
				newslist.add(news);	
			}
			
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		return newslist;	
	}
	public News_bean viewnews(int id)
	{
		
		con=CrudOperation.createConnection();
		News_bean news=new News_bean();
		try {
			String strsql="select * from news_table where newsid=?";
			PreparedStatement ps=con.prepareStatement(strsql);
			System.out.println(ps);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) 
			{
				
				news.setNewsid(rs.getInt("newsid"));
				news.setSubject(rs.getString("subject"));
				news.setContent(rs.getString("content"));
				news.setDate(rs.getString("date"));	
			}
			
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		return news;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
