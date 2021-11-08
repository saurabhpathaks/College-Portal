package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collegeportal.beans.Message;
import collegeportal.beans.Upload_Post;
import collegeportal.parent.ParentTask;

/**
 * Servlet implementation class UploadPost
 */
@WebServlet("/UploadPost")
public class UploadPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPost() {
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
		
		String content=request.getParameter("uploadpost");
		
		Upload_Post up=new Upload_Post(content);
		ParentTask task=new ParentTask();
		boolean status=task.add_post(up);
		 if(status==true)
		 {
			request.setAttribute("ms", Message.FEEDBACK_SUCCESS);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/feedbackform.jsp");
			dispatcher.forward(request, response);
			
		 }
		
		
	}

}
