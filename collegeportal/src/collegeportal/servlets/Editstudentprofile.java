package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import collegeportal.beans.Student_bean;
import collegeportal.student.AdminTask;

/**
 * Servlet implementation class Editstudentprofile
 */
@WebServlet("/Editstudentprofile")
public class Editstudentprofile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Editstudentprofile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		  HttpSession hs=request.getSession(false); 
		  String id=(String)hs.getAttribute("session_userid");
		 
	
		String emailid=request.getParameter("email");
		String phn=request.getParameter("phone");
		
		
		Student_bean sb=new Student_bean();
		sb.setEmail(emailid);
		sb.setPhone(phn);
		sb.setStudentid(id);
		
		AdminTask task=new AdminTask();
		int status=task.editstudentprofile(sb);
		if(status>0)
		{
			response.sendRedirect("/collegeportal/jsp/student/viewprofile.jsp");
		}
		
		
		
	}

}
