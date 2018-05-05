<!DOCTYPE html>
<html lang="en-US">
<head>
<meta charset="UTF-8" />
<title>Add New</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />

<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Poppins%3A400%2C500%2C600%2C700%2C300&#038;ver=4.8.3'
	type='text/css' media='all' />
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Montserrat%3A400%2C700&#038;ver=4.8.3'
	type='text/css' media='all' />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>

<style type="text/css">
body {
	background: url('img/bodybg.png');
}
</style>
<script>
    history.forward();
</script>
</head>

<body class="home blog">

	<%
		if (session.getAttribute("username") == null) {	
			response.sendRedirect("Login.jsp");
		}
	%>

		<div class="body-content container">
		<jsp:include page="./userHeader.jsp" />

		<div class="row home_content_wrapper">
			<div class="feature_content col-md-12">
			<h5 style="color: red;">
						 ${msg1} 
					</h5>
			
				<div class="two_col-div row">
				
					<div class="tabbable">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#multi" data-toggle="tab">Multi-Choice</a></li>
								<li><a href="#numerical" data-toggle="tab">Numerical</a></li>
							</ul>
						<br>
						<div class="tab-content">
							<div class="tab-pane active" id="multi" style="padding-top: 0px;">
								<div class="feature_content col-md-12">
								<div class="col-md-3 col-sm-3 feature_box"></div>
										<div class="col-md-5 col-sm-5 feature_box">
											<div class="feature_inner" style="height:640px;">
												<form action="AddQuestionServlet" method="post" class="form-horizontal">
													<div class="login-fields">

					<p style="color: black;">Please enter the details</p>
					<div class="field">
						<label for="question">Question</label> <input type="text"
							id="question" name="ques" value="" placeholder="Question"
							class="login username-field" style="width:400px;" required />
					</div>

					<div class="field">
<!-- 					<label for="options">Options</label> -->
						<label for="ch1">Choice A</label> <input type="text"
							id="ch1" name="ch1" value="" placeholder="Choice 1"
							class="login username-field" style="width:400px;" required />
					</div>

					<div class="field">
						<label for="ch2">Choice B</label> <input type="text"
							id="ch2" name="ch2" value="" placeholder="Choice 2"
							class="login username-field" style="width:400px;" required />
					</div>
					
					<div class="field">
						<label for="ch3">Choice C</label> <input type="text"
							id="ch3" name="ch3" value="" placeholder="Choice 3"
							class="login username-field" style="width:400px;" required />
					</div>
					
					<div class="field">
						<label for="ch4">Choice D</label> <input type="text"
							id="ch4" name="ch4" value="" placeholder="Choice 4"
							class="login username-field" style="width:400px;" required />
					</div>
					<div class="field">
						<label for="answer">Answer</label> <br/>
						<select	name="ans" class="select-input">
							<option value="A">A</option>
							<option value="B">B</option>
							<option value="C">C</option>
							<option value="D">D</option>
						</select>
					</div>
					<br/>
					<div class="field">
						<label for="hint">Hint</label> <input type="text"
							id="hint" name="hint" value="" placeholder="Hint"
							class="login username-field" style="width:400px;" required />
					</div>				
					
					<!-- /select -->
				</div>
				<!-- /login-fields -->

				<div class="login-actions" style="margin-top: 15px; margin-bottom: 0px;">
					<button type="submit" class="btn btn-success" value="submit">Add</button>
					
					<br/>
					<c:remove var="message" scope="session" />
				</div>
												</form>
											</div>
										</div>
									</div>
							
							</div>
					
							
							<div class="tab-pane" id="numerical" style="padding-top: 0px;">
								<div class="feature_content col-md-12">
								
									<div class="col-md-3 col-sm-3 feature_box"></div>
										<div class="col-md-5 col-sm-5 feature_box">
											<div class="feature_inner" style="height:370px;">
												<form action="AddQuestionServlet" method="get" class="form-horizontal">
													<div class="login-fields">

					<p style="color: black;">Please enter the details</p>
					<div class="field">
						<label for="question">Question</label> <input type="text"
							id="question" name="ques1" value="" placeholder="Question"
							class="login username-field" style="width:400px;" required />
					</div>

					<div class="field">
						<label for="answer">Answer</label> <input type="text"
							id="ans" name="ans1" value="" placeholder="Answer"
							class="login username-field" style="width:400px;" required />
					</div>

					<div class="field">
						<label for="hint">Hint</label> <input type="text"
							id="hint" name="hint1" value="" placeholder="Hint"
							class="login username-field" style="width:400px;" required />
					</div>
										
					<!-- /select -->
				</div>
				<!-- /login-fields -->

				<div class="login-actions" style="margin-top: 15px; margin-bottom: 0px;">
					<button type="submit" class="btn btn-success" value="submit">Add</button>
					
					<br/>
				</div>
												</form>
											</div>
										</div>
									</div>
							
							</div>
						
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>

</body>
</html>
