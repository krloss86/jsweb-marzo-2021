<%@page import="ar.com.educacionit.domain.User"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
		<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
			<div class="row">
				<% User user = (User) session.getAttribute(ViewKeyEnums.USUARIO.name()); %>
				<div class="col-12">				
					<div class="alert alert-info" role="alert">
						Bienvenido : <%=user.getUsername() %>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>	