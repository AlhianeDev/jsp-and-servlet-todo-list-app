<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

	<head>
	
		<meta charset="UTF-8">
		
		<title>JUST DO IT</title>
		
		<link rel="shortcut icon" type="image/png" href="images/favicon.png">
		
		<link rel="preconnect" href="https://fonts.googleapis.com">
		
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		
		<link href="https://fonts.googleapis.com/css2?family=Work+Sans:
		
			wght@300;400;500;600;700;800;900&display=swap" rel="stylesheet">
		
		<link rel="stylesheet" href="css/styles.css">
	
	</head>
	
	<body>
	
		<%@ include file="header.jsp" %>
		
		<section class="sec sign-up-in">
		
			<div class="container">
			
				<form action="Login" class="sign-box" method="post">
				
					<input type="text" name="username" placeholder="Username">
					
					<input type="password" name="password" placeholder="Password">
					
					<input type="submit" value="Sign In">
					
					<p>Dont't have an account ? <a href="sign-up.jsp">Sign Up</a></p>
				
				</form>
			
			</div>
		
		</section>
		
		<%@ include file="footer.jsp" %>
	
	</body>

</html>
