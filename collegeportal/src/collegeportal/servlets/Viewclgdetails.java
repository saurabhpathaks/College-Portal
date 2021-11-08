package collegeportal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Viewclgdetails
 */
@WebServlet("/Viewclgdetails")
public class Viewclgdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Viewclgdetails() {
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
		String str=(String)request.getAttribute("college");
		System.out.println(str);
		String[] clgdetails=str.split("#");
		out.print("<h1>Welcome!</h1>");
		out.print("<p style='font-family: Arial; font-size:20px;'> Your College Id:"+clgdetails[0]+"</p>");
		out.print("<p>Your Name:"+clgdetails[1]+"</p>");
		out.print("<p>Your Email Id:"+clgdetails[2]+"</p>");
		out.print("<p>Your Phone: "+clgdetails[3]+"</p>");
		out.print("<p>Your Address: "+clgdetails[4]+"</p>");
		
		RequestDispatcher
		dispatcher=request.getRequestDispatcher("/html/country_flag.html");
		dispatcher.include(request, response);
		
		
	}

}
