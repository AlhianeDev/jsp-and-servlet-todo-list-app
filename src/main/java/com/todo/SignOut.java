package com.todo;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.PrintWriter;

public class SignOut extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public SignOut() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("user") != null) session.removeAttribute("user");
		
		out.print(
				
			"<script type=\"text/javascript\">" +
			
				"sessionStorage.setItem(\"message\", \"You're Signing Out Successfuly.\");" +
				
				"sessionStorage.setItem(\"page\", \"index.jsp\");" +
				
				"window.location.assign(\"/just_do_it/success.jsp\")" +
				
			"</script>"
					
		);

	}

}
