package com.in28minutes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{

	private UserValidationService service= new UserValidationService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    	request.setAttribute("name", request.getParameter("name"));
    	request.setAttribute("password", request.getParameter("password"));
    	
    	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response); 

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    	String name = request.getParameter("name");
	    	String password = request.getParameter("password");
	    	
	    	//request.setAttribute("name", request.getParameter("name"));
	     	//request.setAttribute("password", request.getParameter("password"));

	     	Boolean isValidUser= service.isUserValid(name,password);

	     	if (isValidUser) {
	     		request.setAttribute("name", request.getParameter("name"));
		     	request.setAttribute("password", request.getParameter("password"));
	     		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
			}else {
				request.setAttribute("errorMessage", "Invalid Credentials");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	    }
	}
	
	
    protected void doGet1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        	
        	PrintWriter writer = response.getWriter();
        	writer.println("<html>");
        	writer.println("<head>");
        	writer.println("<title>Yahoo from jsp</title>");
        	writer.println("<head>");
        	
        	writer.println("<body>");
        	writer.println("My First Servlet application");
        	writer.println("</body>");
        }
    
    
    
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	 	
			String value= request.getParameter("name");
	    	System.out.println(value);
	    	request.setAttribute("name", value);
	    	
	    	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response); 

	    } 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        	request.setAttribute("name", request.getParameter("name"));
        	request.setAttribute("password", request.getParameter("password"));
        	
        	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response); 

        } */
}
