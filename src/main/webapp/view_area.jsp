<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.todo.Todo, com.user.User, java.util.List"%>

<!DOCTYPE html>

<html>

	<head>
	
		<meta charset="UTF-8">
		
		<title>JUST DO IT</title>
		
		<link rel="shortcut icon" type="image/png" href="images/favicon.png">
		
		<link rel="preconnect" href="https://fonts.googleapis.com">
		
		<link rel="preconnect" href="https://fonts.gstatic.com">
		
		<link href="https://fonts.googleapis.com/css2?family=Work+Sans:
		
			wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
		
		<link rel="stylesheet" href="css/all.main.css">
		
		<link rel="stylesheet" href="css/styles.css">
	
	</head>
	
	<body>
	
		<% if ((User) session.getAttribute("user") == null) {
				
				out.print(
						
					"<script type=\"text/javascript\">" +
					
						"sessionStorage.setItem(\"message\", \"You Shoud Sign In First!\");" +
						
						"sessionStorage.setItem(\"page\", \"index.jsp\");" +
						
						"window.location.assign(\"/just_do_it/error.jsp\")" +
						
					"</script>"
								
				);
				
		} else { %>
	
			<%@ include file="header.jsp" %>
			
			<section class="sec view">
			
				<div class="container">
				
					<div class="sec-head">
					
						<h2 class="sec-title">Just do it.</h2>
						
						<a href="add_area.jsp" class="target">Add</a>
					
					</div>
					
					<% 
					
						List <Todo> all_todos = (List <Todo>) request.getAttribute("all_todos");
					
						List <Todo> limit_todos = (List <Todo>) request.getAttribute("limit_todos");
					
						if (limit_todos.size() > 0) { 
					
					%>
					
					<div class="todos">
					
						<% for (Todo todo : limit_todos) { %>
						
							<div class="todo <%= todo.getIs_checked() ? "checked" : "" %>">
							
								<div class="info">
								
									<h3 class="todo-title"><%= todo.getTitle() %></h3>
									
									<span class="timestamp"><%= todo.getCreatedAt() %></span>
								
								</div>
								
								<div class="actions">
								
									<a href="CheckTodo?todo_id=<%= todo.getId() %>">
									
										<i class="fa-solid fa-check"></i>
									
									</a>
									
									<a 
									
										href="update_area.jsp?
										
										todo_title=<%= todo.getTitle() %>&
										
										todo_id=<%= todo.getId() %>"
									
									>
									
										<i class="fa-solid fa-pen-to-square"></i>
										
									</a>
									
									<a href="DeleteTodo?todo_id=<%= todo.getId() %>">
									
										<i class="fa-solid fa-trash">
									
									</i></a>
								
								</div>
							
							</div>
						
						<% } %>
					
					</div>
					
					<div class="pagination">
					
						<% 
						
							int counter = 0;
						
							for (int i = 0; i < all_todos.size(); i += 6) {
								
								counter++;
							
						%>
					
								<a href="View?page=<%= counter %>"><%= counter %></a>
						
						<% } %>
					
					</div>
					
					<% } else { %>
					
						<p class="no-items">No Todos To Show!</p>
						
					<% } %>
				
				</div>
			
			</section>
			
			<%@ include file="footer.jsp" %>
			
			<script src="js/all.min.js"></script>
		
		<% } %>
	
	</body>

</html>