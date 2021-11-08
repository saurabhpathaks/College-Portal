package collegeportal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import collegeportal.student.AdminTask;

/**
 * Servlet implementation class DeleteStudent
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AdminTask task;
	public void init() throws ServletException 
	{
		task=new AdminTask();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStudent() {
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
		String[]studentid=request.getParameterValues("chk");
		boolean status=task.deletestudent(studentid);
		if(status==true)
		{
			response.sendRedirect("/collegeportal/admin/viewstudent.jsp");
		}
		
	}

}
