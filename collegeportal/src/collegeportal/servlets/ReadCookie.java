package collegeportal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReadCookie
 */
@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadCookie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Cookie[] cookies=request.getCookies();
		 Cookie ck=null;
		 String data="";
		if(cookies!=null && cookies.length>1) 
		
		{
			for(int i=0;i<cookies.length;i++)
			{
			ck=cookies[i];
			if(ck.getName().equals("userinfo")) {
				data=ck.getValue();
			    break;
			
			
			
			}
			}
			
			String[]userdetails=data.split("#");
			System.out.println("Id is " +userdetails[0]);
			System.out.println("Password is " +userdetails[1]);
			System.out.println("Location is " +userdetails[2]);
			                   
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
