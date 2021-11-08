package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collegeportal.beans.College;

/**
 * Servlet implementation class College_details
 */
@WebServlet("/College_details_Beans")
public class College_details_Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public College_details_Beans() {
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
		int collegeid=Integer.parseInt(id);
		/*
		College college=new College();
		college.setName(name);
		college.setAddress(address);
		*/
		College college=new College(collegeid,name,email,phone,address);
		request.setAttribute("collegekey", college);
		RequestDispatcher rd=request.getRequestDispatcher("Viewclgdetails_Beans");
		rd.forward(request, response);
		
	}

}
