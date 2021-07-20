<%@page import="ar.com.educacionit.domain.User"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page isELIgnored="false"%>
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
		<% User user = (User) session.getAttribute(ViewKeyEnums.USUARIO.name()); %>
		<main>
		  <div class="container py-4">
		    <header class="pb-3 mb-4 border-bottom">
		      <a href="${pageContext.request.contextPath}/" class="d-flex align-items-center text-dark text-decoration-none">
		        <span class="fs-4">Bienvenido: <%=user.getUsername() %></span>
		      </a>
		    </header>
		    <div class="p-5 mb-4 bg-light rounded-3">
		      <div class="container-fluid py-5">
		        <h1 class="display-5 fw-bold">Bienvenido</h1>
		        <p class="col-md-8 fs-4">Sistema de administración de productos</p>
     			<a class="btn btn-primary btn-lg" href="<%=request.getContextPath()%>/controllers/BuscarProductoServlet" role="button">
     				Ver Listado
     			</a> 
		      </div>
		    </div>
		    <footer class="pt-3 mt-4 text-muted border-top">
		      Bootcamp java - EducacionIt - 2021
		    </footer>
		  </div>
		</main>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>	