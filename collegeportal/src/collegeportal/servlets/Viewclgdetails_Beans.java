package collegeportal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collegeportal.beans.College;

/**
 * Servlet implementation class Viewclgdetails
 */
@WebServlet("/Viewclgdetails_Beans")
public class Viewclgdetails_Beans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewclgdetails_Beans() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		College clg=(College)request.getAttribute("collegekey");
		
		out.print("<h1>Welcome!</h1>");
		
		out.print("<p>Your Name:"+clg.getName());
		out.print("<p>Your Email Id:"+clg.getEmail());
		out.print("<p>Your Phone: "+clg.getPhone());
		out.print("<p>Your Address: "+clg.getAddress());
		
		RequestDispatcher
		dispatcher=request.getRequestDispatcher("/html/country_flag.html");
		dispatcher.include(request, response);
		
		
	}

}
