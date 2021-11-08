package collegeportal.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import collegeportal.parent.ParentTask;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ParentTask task;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		task=new ParentTask();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
		HttpSession hs=request.getSession(false);
		String id=(String)hs.getAttribute("session_userid");
		ServletContext sc=getServletContext();
		String project_path=sc.getRealPath("/");
		System.out.println(project_path);
		String newpath=project_path+File.separator+id;
		System.out.println("newpath" +newpath);
		File f=new File(newpath);
		if(!f.exists())
		{
			f.mkdir();
			System.out.print("directory created");
		}
		
		Part p=request.getPart("uploadctrl");
		String filename=p.getSubmittedFileName();
		System.out.println("uploaded file name" +filename);
		
		
		InputStream is=p.getInputStream();
		
		boolean status=task.uploadDocs(is,f,filename);
		boolean update_status=task.updateProfile(filename, id);
		
		if(status && update_status)
		{
			response.sendRedirect("/collegeportal/jsp/parent/parent.jsp");
		}
		
	}

}
