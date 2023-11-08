package com.todo;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.PrintWriter;

import com.user.User;

public class DeleteTodo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public DeleteTodo() {
    	
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
		
			int status = TodoDao.delete_todo(
				
				Integer.parseInt(request.getParameter("todo_id")),
				
				((User) session.getAttribute("user")).getId()
					
			);
			
			if (status > 0) {
				
				out.print(
					
					"<script type=\"text/javascript\">" +
					
						"sessionStorage.setItem(\"message\", \"Todo Deleted Successfuly.\");" +
						
						"sessionStorage.setItem(\"page\", \"View\");" +
						
						"window.location.assign(\"/just_do_it/success.jsp\")" +
						
					"</script>"
						
				);
				
			} else {
				
				out.print(
						
					"<script type=\"text/javascript\">" +
					
						"sessionStorage.setItem(\"message\", \"Failed To Delete Todo!\");" +
						
						"sessionStorage.setItem(\"page\", \"View\");" +
						
						"window.location.assign(\"/just_do_it/error.jsp\")" +
						
					"</script>"
							
				);
				
			}
		
		}
		
	}

}
