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
		
		<link rel="stylesheet" href="css/all.main.css">
		
		<link rel="stylesheet" href="css/styles.css">
	
	</head>
	
	<body>
	
		<%@ include file="header.jsp" %>
		
		<section class="sec sign-up-in">
		
			<div class="container">
			
				<form class="sign-box"
				
					action="Register"
				
					enctype="multipart/form-data"
					
					method="post"
				
				>
				
					<input type="text" name="full_name" placeholder="Full Name">
					
					<input type="file" name="prof_pic" id="prof-pic">
					
					<label for="prof-pic" class="prof-pic">Choose Profile Picture</label>
				
					<input type="text" name="username" placeholder="Username">
					
					<input type="password" name="password" placeholder="Password">
					
					<input type="submit" value="Sign Up">
					
					<p>Already have an account ? <a href="index.jsp">Sign In</a></p>
				
				</form>
			
			</div>
		
		</section>
		
		<%@ include file="footer.jsp" %>
	
	</body>

</html>