<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Login</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
<link href="css/signin.css" rel="stylesheet" type="text/css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Poppins%3A400%2C500%2C600%2C700%2C300&#038;ver=4.8.3'
	type='text/css' media='all' />
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Montserrat%3A400%2C700&#038;ver=4.8.3'
	type='text/css' media='all' />
<link rel='stylesheet' href='css/bootstrap2.css'	type='text/css' media='all' />
<link rel='stylesheet' href='css/font-awesome.css' type='text/css' media='all' />
<link rel='stylesheet' href='css/reset.css'	type='text/css' media='all' />
<link rel='stylesheet' href='css/style2.css' type='text/css' media='all' />
<script type='text/javascript' src='js/jquery.js'></script>
<style type="text/css">
body {
	background:
		url('img/body-bg.png');
}

.btn-success, .btn-large {
	background-color: #49635c;
}
</style>
<script>
    history.forward();
</script>
</head>
<body class="home blog">
<div class="body-content container">	

	<div class="row home_content_wrapper">
			<div class="feature_content col-md-12">
				<div class="two_col-div row">
					<div class="col-md-4 col-sm-4 feature_box"></div>
					<div class="col-md-4 col-sm-4">
					<h5 style="color: red;">
						 ${msg} 
					</h5>
					<div class="feature_inner" style="background-color: green; color: white; height: 480px;">
					<div class="widget_inner">
						

			<form action="LoginServlet" method="post">

				<h1>Login</h1>

				<div class="login-fields">

					<p style="color:white;">Please enter your details</p>

					<div class="field">
						<label for="exampleInputName2">Username</label> <input type="text"
							class="login username-field" style="width: 305px;" name="username" placeholder="Username"
							required />
					</div>

					<div class="field">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="login password-field" name="password"
							placeholder="Password" required />
					</div>
				

					<!-- /password -->

				</div>
				<!-- /login-fields -->

				<div class="login-actions">

					<button class="btn btn-group-justified btn-large button" style="background-color: #1d3c50; color: white;">Sign In</button>
					<br /> <br /><br />
					New User?     <a href="Register.jsp" style="color: white;"><U>Register Here</U></a>
					<br /> <br />
					
					<br>
					
					<c:remove var="message" scope="session" />
				</div>
				<!-- .actions -->

			</form>

		</div>
	</div>
	</div>
	<div class="col-md-4 col-sm-4 feature_box"></div>
</div>
</div>
</div>
</div>
	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/signin.js"></script>
	
</body>
</html>
