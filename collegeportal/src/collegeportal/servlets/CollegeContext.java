package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import collegeportal.beans.College;

/**
 * Servlet implementation class CollegeContext
 */
@WebServlet(name="CollegeContext", urlPatterns="/CollegeContext",loadOnStartup=1)
public class CollegeContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
	public void init() throws ServletException {
	   College college=new College(007,"Saurabh","saurabhpathak1905@gmail.com","9559123524","Lucknow");
		ServletContext sc=getServletContext();//will give the reference of Serveletcontext that is 
		//created at the time of deployment
		sc.setAttribute("collegedetails", college);
	   
	   
	   
	}
	
	
	
	
	
	
    public CollegeContext() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		response.sendRedirect("/collegeportal/jsp/showcollegedetails.jsp");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
