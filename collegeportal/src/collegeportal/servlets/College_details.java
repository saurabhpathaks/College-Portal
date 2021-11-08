package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class College_details
 */
@WebServlet("/College_details")
public class College_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public College_details() {
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
		String id=request.getParameter("id");
		String name= request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String clgdetails=id+"#"+name+"#"+email+"#"+phone+"#"+address;
		request.setAttribute("college", clgdetails);
		RequestDispatcher rd=request.getRequestDispatcher("Viewclgdetails");
		rd.forward(request, response);
		
	}

}
