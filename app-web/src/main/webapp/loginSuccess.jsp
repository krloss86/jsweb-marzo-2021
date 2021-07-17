<%@page import="ar.com.educacionit.domain.User"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<!doctype html>
<html lang="en">
  <head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<title>BootCamp</title>
    	<jsp:include page="styles.jsp"></jsp:include>
  	</head>
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
			<div class="row mt-1">
				<% User user = (User) session.getAttribute(ViewKeyEnums.USUARIO.name()); %>
				<div class="col-12">				
					<div class="alert alert-info" role="alert">
						Bienvenido : <%=user.getUsername() %>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>	