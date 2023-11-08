package com.user;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.MultipartConfig;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.Part;

import java.io.IOException;

import java.io.PrintWriter;

@MultipartConfig
public class Register extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public Register() {
    	
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		Part part = request.getPart("prof_pic");
		
		int status = UserDao.sign_up(
				
			new User(
				
				request.getParameter("full_name"),
					
				null,
				
				request.getParameter("username"),
				
				request.getParameter("password")
				
			),
			
			part
				
		);
		
		if (status > 0) {
			
			out.print(
				
				"<script type=\"text/javascript\">" +
				
					"sessionStorage.setItem(\"message\", \"You're Signed Up Successfuly.\");" +
					
					"sessionStorage.setItem(\"page\", \"index.jsp\");" +
					
					"window.location.assign(\"/just_do_it/success.jsp\")" +
					
				"</script>"
					
			);
			
		} else if (status == -1) {
			
			out.print(
					
				"<script type=\"text/javascript\">" +
				
					"sessionStorage.setItem(\"message\", \"Failed To Sign Up, The Username That Used Is Already Exists!\");" +
					
					"sessionStorage.setItem(\"page\", \"sign-up.jsp\");" +
					
					"window.location.assign(\"/just_do_it/error.jsp\")" +
					
				"</script>"
							
				);
			
		} else {
			
			out.print(
					
				"<script type=\"text/javascript\">" +
				
					"sessionStorage.setItem(\"message\", \"Failed To Sign Up, Please Try Again!\");" +
					
					"sessionStorage.setItem(\"from_register\", \"error\");" +
					
					"window.location.assign(\"/just_do_it/error.jsp\")" +
					
				"</script>"
						
			);
			
		}
		
	}

}
