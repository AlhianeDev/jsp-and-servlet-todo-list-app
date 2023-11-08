package com.todo;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.user.User;

public class View extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public View() {
    	
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
			
			List<Todo> all_todos = TodoDao.read_todos(
					
					((User) request.getSession().getAttribute("user")).getId()
						
			);
		
			List<Todo> limit_todos = TodoDao.read_limit_todos(
					
				((User) request.getSession().getAttribute("user")).getId(),
				
				request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1,
				
				6
					
			);
			
			request.setAttribute("all_todos", all_todos);
			
			request.setAttribute("limit_todos", limit_todos);
			
			request.getRequestDispatcher("view_area.jsp").forward(request, response);
		
		}
	
	}

}
