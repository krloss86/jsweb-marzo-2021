<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page isELIgnored="false"%>
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
			<jsp:include page="mensajeria.jsp"/>
			<%--
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
						<button type="submit" class="btn btn-primary mt-1">Login</button>
					</form>
				</div>
			</div>
			--%>
			<section class="vh-100">
			  <div class="container-fluid">
			
			    <div class="row d-flex justify-content-center align-items-center h-100 mt-5">
			      <div class="col-md-9 col-lg-6 col-xl-5 mb-3">
			        <img src="${pageContext.request.contextPath}/assets/images/login.svg" class="img-fluid"
			          alt="Sample image">
			      </div>
			      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
			        <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
			
			          <!-- Email input -->
			          <div class="form-outline mb-4">
						<input name="username" 
							type="text" 
							class="form-control form-control-lg"
							id="exampleInputEmail1" 
							placeholder="Enter a valid email address"
							aria-describedby="emailHelp">
			            <label for="exampleInputEmail1">Username</label> 
			          </div>
			          <!-- Password input -->
			          <div class="form-outline mb-3">
						<input name="password" 	
							type="password" 
							class="form-control form-control-lg"
							placeholder="Enter password"
							id="exampleInputPassword1">
						<label for="exampleInputPassword1">Password</label> 
			          </div>
			   			<div class="text-center text-lg-start mt-4 pt-2">
			             	<button type="submit" class="btn btn-primary btn-lg mt-1 w-100">Login</button>       
			          </div>
			        </form>
			      </div>
			    </div>
			  </div>  
			</section>
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>