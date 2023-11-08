<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.user.User"%>

<header class="header">

	<div class="container">
	
		<div class="row">
		
			<h2 class="brand"><a href="add_area.jsp">Just Do It</a></h2>
			
			<%
			
				User user = (User) session.getAttribute("user");
				
				if (user != null) { 
			
			%>
				
				<div class="user">
			
		 			<img 
		 			
		 				class="prof-img" 
		 				
		 				src="data:image/png;base64,<%= user.getImageBt() %>"
					
						alt="No Image!"
					
					>
					
					<h2 class="user-name">
					
						<%= user.getFull_name() %>
						
					</h2>
				
				</div>
				
				<a href="SignOut" class="sign-out-link">Sign Out</a>
				
			<% } else { %>
			
				<div class="user">
				
					<img 
					
						class="prof-img" 
						
						src="https://placehold.co/50x50/png" 
						
						alt="No Image"
						
					>
					
					<h2 class="user-name">Unknown</h2>
					
				</div>
				
			<% } %>
		
		</div>
	
	</div>

</header>
