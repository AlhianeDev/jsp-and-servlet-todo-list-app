<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	
<%@ page import="com.user.User"%>

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
		
		<link rel="stylesheet" href="css/styles.css">
	
	</head>
	
	<body>
	
		<%@ include file="header.jsp" %>
		
		<%
		
			if ((User) session.getAttribute("user") == null) {
				
				out.print(
						
					"<script type=\"text/javascript\">" +
					
						"sessionStorage.setItem(\"message\", \"You Shoud Sign In First!\");" +
						
						"sessionStorage.setItem(\"page\", \"index.jsp\");" +
						
						"window.location.assign(\"/just_do_it/error.jsp\")" +
						
					"</script>"
								
				);
				
			}
		
		%>
		
		<section class="sec add_sec">
			
			<div class="container">
			
				<div class="sec-head">
				
					<h2 class="sec-title">Just do it.</h2>
					
					<a href="View" class="target">View</a>
				
				</div>
				
				<form action="AddTodo" class="todo-form" method="get">
				
					<input type="text" name="todo-title" class="text-input" placeholder="Add a task">
					
					<input type="submit" class="submit-input" value="I Got This!">
				
				</form>
			
			</div>
		
		</section>
		
		<%@ include file="footer.jsp" %>
	
	</body>

</html>