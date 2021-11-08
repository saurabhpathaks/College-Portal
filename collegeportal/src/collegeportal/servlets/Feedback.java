package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collegeportal.beans.Feedbackbean;
import collegeportal.beans.Message;
import collegeportal.parent.ParentTask;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Feedback() {
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
		String name=request.getParameter("fname");
		String email=request.getParameter("emailid");
		String phone=request.getParameter("phone");
		String feed=request.getParameter("feedback");
		String rate=request.getParameter("rating");
		/* System.out.println(name+email+phn+feed); */ 
		 
		 Feedbackbean feedback=new Feedbackbean(name,email,phone,feed,rate);
		 ParentTask task=new ParentTask();
		 boolean status= task.givefeedback(feedback);
		 if(status==true)
		 {
			request.setAttribute("ms", Message.FEEDBACK_SUCCESS);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/feedbackform.jsp");
			dispatcher.forward(request, response);
			
		 }
			
		
	}
	}

