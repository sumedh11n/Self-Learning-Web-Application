<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Register New User</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">

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
					<div class="col-md-3 col-sm-3 feature_box"></div>
					<div class="col-md-5 col-sm-5">
					<h4 style="color: red;">
						 ${msg} 
					</h4>
					<div class="feature_inner" style="background-color: green; color: white; height: 650px;">
					<div class="widget_inner">
						

			<form action="RegisterServlet" method="post">

				<h1>Registration</h1>

				<div class="login-fields">

					<p style="color: white;">Please provide your details</p>
					<div class="field">
						<label for="firstname">First Name</label> <input type="text"
							id="firstname" name="fname" value="" placeholder="First Name"
							class="login username-field" style="width:400px;" pattern="[A-Za-z]{2,}" required />
					</div>

					<div class="field">
						<label for="lastname">Last Name</label> <input type="text"
							id="lastname" name="lname" value="" placeholder="Last Name"
							class="login username-field" style="width:400px;" pattern="[A-Za-z]{2,}" required />
					</div>

					<div class="field">
						<label for="uname">Username</label> <input type="text" id="uname"
							name="uname" value="" placeholder="Username"
							class="login username-field" style="width:400px;" required />
					</div>
					<!-- /field -->

					<div class="field">
						<label for="password">Password:</label> <input type="password"
							id="password" name="passwd" value="" placeholder="Password"
							class="login password-field" style="width:400px;" required />
					</div>
					
					<div class="field">
						<label for="passwd">Confirm Password:</label> <input type="password"
							id="passwd" name="cpasswd" value="" placeholder="Password"
							class="login password-field" style="width:400px;" required />
					</div>
					<!-- /password -->

					<!-- /select -->
				</div>
				<!-- /login-fields -->

				<div class="login-actions">
					<button type="submit" class="btn btn-success" value="submit">Submit</button>
					
					<br/><br/><br/>
					<h3> <a href="Login.jsp" style="color: white; text-align: center;"><U>Sign In</U></a></h3>
					<br /> <br /> ${message} <br>
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
