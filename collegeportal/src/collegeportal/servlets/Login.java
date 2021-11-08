package collegeportal.servlets;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import college.commontask.LoginTask;
import collegeportal.beans.Login_Credentials;
import collegeportal.beans.Message;
/**
 * Servlet implementation class Login
 */
@WebServlet(description = "It is for Login Purpose", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userid=request.getParameter("userid");
		String userpass=request.getParameter("userpass");
		
		
		 System.out.println(userid+userpass); 
		Login_Credentials lc=new Login_Credentials();
		lc.setId(userid);
		lc.setPassword(userpass);
		LoginTask task=new LoginTask();
		String type=task.login(lc);
		if(!type.equalsIgnoreCase("invalid")) 
		{
			
		HttpSession hs= request.getSession();
		System.out.println(hs.getId());
		hs.setAttribute("session_userid", lc.getId());
		hs.setAttribute("role", type);
		if(type.equalsIgnoreCase("admin"))
		{
			
			response.sendRedirect("/collegeportal/admin/admin_home.jsp");
		}
		else if(type.equalsIgnoreCase("parent"))
		{
			
			response.sendRedirect("/collegeportal/jsp/parent/parent.jsp");
			
		}
		else if(type.equalsIgnoreCase("std"))
	    {
			response.sendRedirect("/collegeportal/jsp/student/student.jsp");
		}
		}
		else {
			
			request.setAttribute("msg",Message.LOGIN_ERROR);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/login.jsp");
			dispatcher.forward(request, response);
		}	
	}
	}
