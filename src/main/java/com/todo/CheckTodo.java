package com.todo;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.PrintWriter;

import com.user.User;

public class CheckTodo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public CheckTodo() {
    	
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if ((User) session.getAttribute("user") == null) {
			
			out.print(
					
				"<script type=\"text/javascript\">" +
				
					"sessionStorage.setItem(\"message\", \"You Shoud Sign In First!\");" +
					
					"sessionStorage.setItem(\"page\", \"index.jsp\");" +
					
					"window.location.assign(\"/just_do_it/error.jsp\")" +
					
				"</script>"
							
			);
			
		} else {
		
			int status = TodoDao.check_todo(
				
				Integer.parseInt(request.getParameter("todo_id")),
				
				((User) session.getAttribute("user")).getId()
					
			);
			
			if (status > 0) {
				
				response.sendRedirect("View");
				
			} else {
				
				out.print(
						
					"<script type=\"text/javascript\">" +
					
						"sessionStorage.setItem(\"message\", \"Failed To Check Todo!\");" +
						
						"sessionStorage.setItem(\"page\", \"View\");" +
						
						"window.location.assign(\"/just_do_it/error.jsp\")" +
						
					"</script>"
							
				);
				
			}
		
		}
		
	}
	
}
