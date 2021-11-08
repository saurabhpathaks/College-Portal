package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collegeportal.beans.Message;
import collegeportal.beans.News_bean;
import collegeportal.student.AdminTask;

/**
 * Servlet implementation class Addnews
 */
@WebServlet("/Addnews")
public class Addnews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addnews() {
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
		String sub=request.getParameter("subject");
		String con=request.getParameter("content");
		String date=request.getParameter("date");
		News_bean nb=new News_bean(sub,con,date);
		AdminTask task=new AdminTask();
		boolean status=task.addNews(nb);
		if(status==true)
		{
			request.setAttribute("msg", Message.REGISTRATION_SUCCESS);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/index.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("msg", Message.REGISTRATION_FAIL);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/message.jsp");
			dispatcher.forward(request, response);
			
		}
	}

}
