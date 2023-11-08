package com.user;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.PrintWriter;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Login() {
    	
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		User user = UserDao.sign_in(
				
			request.getParameter("username"),
			
			request.getParameter("password")
				
		);
		
		if (user != null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("user", user);
			
			request.getRequestDispatcher("add_area.jsp").forward(request, response);
			
		} else {
			
			out.print(
					
				"<script type=\"text/javascript\">" +
				
					"sessionStorage.setItem(\"message\", \"Failed To Sign In!\");" +
					
					"sessionStorage.setItem(\"page\", \"index.jsp\");" +
					
					"window.location.assign(\"/just_do_it/error.jsp\")" +
					
				"</script>"
							
			);
			
		}
		
	}

}
