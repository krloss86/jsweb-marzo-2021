<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<!doctype html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<jsp:include page="styles.jsp"/>
	</head>
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
			
			<%
				if(request.getAttribute(ViewKeyEnums.ERROR_GENERAL.name()) != null) {
			%>		
				<div class="row">
					<div class="col-12">
						<div class="alert alert-danger" role="alert">
							<%=request.getAttribute(ViewKeyEnums.ERROR_GENERAL.name()) %>
						</div>
					</div>
				</div>
			<%
				}
			%>	
					
			<div class="row justify-content-md-center mt-2">
				<div class="col-12">
					<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
						<div class="form-group">
							<label for="exampleInputEmail1">Username</label> 
							<input name="username" 
								type="text" 
								class="form-control"
								id="exampleInputEmail1" 
								aria-describedby="emailHelp"> 
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> 
							<input name="password" 	
								type="password" 
								class="form-control"
								id="exampleInputPassword1">
						</div>
						<button type="submit" class="btn btn-primary">Login</button>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>