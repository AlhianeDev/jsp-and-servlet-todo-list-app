package com.todo;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.PrintWriter;

import com.user.User;

public class UpdateTodo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public UpdateTodo() {
    	
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			
			out.print(
					
				"<script type=\"text/javascript\">" +
				
					"sessionStorage.setItem(\"message\", \"You Shoud Sign In First!\");" +
					
					"sessionStorage.setItem(\"page\", \"index.jsp\");" +
					
					"window.location.assign(\"/just_do_it/error.jsp\")" +
					
				"</script>"
							
			);
			
		} else {
		
			Todo todo = TodoDao.get_todo_by_id (
			
				Integer.parseInt((String) session.getAttribute("todo_id")),
				
				user.getId()
					
			);
			
			todo.setTitle(request.getParameter("todo-title"));
			
			int status = TodoDao.update_todo(todo);
			
			if (status > 0) {
				
				out.print(
					
					"<script type=\"text/javascript\">" +
					
						"sessionStorage.setItem(\"message\", \"Todo Updated Successfuly.\");" +
						
						"sessionStorage.setItem(\"page\", \"View\");" +
						
						"window.location.assign(\"/just_do_it/success.jsp\")" +
						
					"</script>"
						
				);
				
			} else {
				
				out.print(
						
					"<script type=\"text/javascript\">" +
					
						"sessionStorage.setItem(\"message\", \"Failed To Update Todo!\");" +
						
						"sessionStorage.setItem(\"page\", \"update_area.jsp\");" +
						
						"window.location.assign(\"/just_do_it/error.jsp\")" +
						
					"</script>"
							
				);
				
			}
		
		}
		
	}

}
