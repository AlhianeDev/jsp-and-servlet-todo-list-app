package com.todo;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.PrintWriter;

import com.user.User;

public class AddTodo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public AddTodo() {
    	
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
		
			User user = (User) session.getAttribute("user");
			
			String todo_title = request.getParameter("todo-title");
			
			if (!todo_title.trim().equals("")) {
				
				Todo todo = new Todo (todo_title, user.getId());
				
				int status = TodoDao.save_todo(todo);
				
				if (status > 0) {
					
					out.print(
						
						"<script type=\"text/javascript\">" +
						
							"sessionStorage.setItem(\"message\", \"Todo Added Successfuly.\");" +
							
							"sessionStorage.setItem(\"page\", \"View\");" +
							
							"window.location.assign(\"/just_do_it/success.jsp\")" +
							
						"</script>"
							
					);
					
				} else {
					
					out.print(
							
						"<script type=\"text/javascript\">" +
						
							"sessionStorage.setItem(\"message\", \"Failed To Add Todo!\");" +
							
							"sessionStorage.setItem(\"page\", \"add_area.jsp\");" +
							
							"window.location.assign(\"/just_do_it/error.jsp\")" +
							
						"</script>"
								
					);
					
				}
				
			} else {
				
				out.print(
						
					"<script type=\"text/javascript\">" +
					
						"sessionStorage.setItem(\"message\", \"Failed To Add Todo, Title Is Required!\");" +
						
						"sessionStorage.setItem(\"page\", \"add_area.jsp\");" +
						
						"window.location.assign(\"/just_do_it/error.jsp\")" +
						
					"</script>"
								
				);
				
			}
		
		}

	}

}
