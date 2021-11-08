package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collegeportal.beans.Message;
import collegeportal.beans.Videos;
import collegeportal.parent.ParentTask;

/**
 * Servlet implementation class VideoPost
 */
@WebServlet("/VideoPost")
public class VideoPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoPost() {
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
		String vidname=request.getParameter("videoname");
		String vidlinks=request.getParameter("links");
		Videos v=new Videos(vidname,vidlinks);
		ParentTask task=new ParentTask();
		boolean status=task.postVideo(v);
		if(status==true)
		{
			request.setAttribute("msg", Message.REGISTRATION_SUCCESS);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/displayvideos.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("msg", Message.REGISTRATION_FAIL);
			RequestDispatcher dispatcher =request.getRequestDispatcher("/jsp/message.jsp");
			dispatcher.forward(request, response);
			
		}
	}
		
		
	

}
