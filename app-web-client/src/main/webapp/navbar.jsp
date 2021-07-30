<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.User"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">      	
		    <li class="nav-item">
		    	<a class="nav-link" href="${pageContext.request.contextPath}/listadoGeneral.jsp">Productos</a>
		    </li>
		    <%--
		    <li class="nav-item">
		       	<a class="nav-link" href="${pageContext.request.contextPath}/contacto.jsp">Contacto</a>
		    </li>
		    --%>
		    <li class="nav-item">
		       	<a class="nav-link" href="${pageContext.request.contextPath}/secure/profile.jsp">Usuario</a>
		    </li>
	    </ul>
	    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		    <li>
				<a href="${pageContext.request.contextPath}/shoppingCart.jsp" class="btn btn-info position-relative">
				  Carrito
				  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
				    99+
				    <span class="visually-hidden">Articulos</span>
				  </span>
				</a>
		    </li>
	    </ul>
	    <form class="d-flex" action="${pageContext.request.contextPath}/listadoGeneral.jsp" method="post">
			<input name="claveBusqueda" class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Buscar">			
			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Buscar</button>
		</form>		
    </div>
  </div>
</nav>