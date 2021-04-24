<html>

<head>
	<jsp:include page="styles.jsp"></jsp:include>
</head>

<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<h1>login.jsp</h1>		
		<div class="row">
			<div class="col-12">
				<form action="loginController.jsp">
					<div class="form-group">
						<label for="exampleInputEmail1">Username</label> <input
							name="username" type="text" class="form-control"
							id="exampleInputEmail1" aria-describedby="emailHelp"> 
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							name="password" type="password" class="form-control"
							id="exampleInputPassword1">
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>