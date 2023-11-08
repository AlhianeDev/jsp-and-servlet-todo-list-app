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
	
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		
		<script src="sweetalert2.all.min.js"></script>
		
		<script type="text/javascript">
		
 			Swal.fire({
				
			  position: 'center',
			  
			  icon: "error",
			  
			  title: sessionStorage.getItem("message"),
			  
			  showConfirmButton: false,
			  
			  timer: 3000
			  
			});
			
			window.setTimeout(() => {
				 
				window.location.assign("/just_do_it/" + sessionStorage.getItem("page"));
				 
			}, 3000);
		
		</script>
	
	</body>

</html>