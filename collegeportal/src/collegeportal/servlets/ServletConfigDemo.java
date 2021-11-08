package collegeportal.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigDemo
 */
@WebServlet(
		urlPatterns = { "/ServletConfigDemo" }, 
		initParams = { 
				@WebInitParam(name = "color", value = "blue"), 
				@WebInitParam(name = "picname", value = "card2.jpg")
		})
public class ServletConfigDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfigDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletConfig sc=getServletConfig();//return the reference of ServeletConfig
		String serverColor=sc.getInitParameter("color");
		String serverpic=sc.getInitParameter("picname");
		out.print("<body bgcolor="+serverColor+">");
		String picpath="/collegeportal/images/"+serverpic;
		out.print("<img src="+picpath+ " style='width:100px; height: 100px;'> ");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
