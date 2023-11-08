<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		
			String subject = request.getParameter("subject");
			
			String message = request.getParameter("message");
		
		%>
		
		<section class="sec">
		
			<div class="container">
			
				<form action="contact.jsp" class="contact-form" method="post">
				
					<% if (subject != null && message != null) { %>
					
						<input type="text" name="subject" value="<%= subject %>"
						
						class="normal-input" placeholder="subject">
						
						<textarea class="normal-input textarea" name="message"
						
						 placeholder="Message"><%= message %></textarea>
						 
						<a class="submit-input"
						
						href="mailto:msrtest1899@gmail.com?subject=<%= subject %>&body=<%= subject %>">
						
							Send
						
						</a>
					
					<% } else { %>
					
						<input type="text" name="subject"
						
						class="normal-input" placeholder="subject">
						
						<textarea class="normal-input textarea" name="message"
						
						 placeholder="Message"></textarea>
						
						<input type="submit" class="submit-input" value="Tell Me">
						
					<% } %>
				
				</form>
			
			</div>
		
		</section>
		
		<%@ include file="footer.jsp" %>
	
	</body>

</html>