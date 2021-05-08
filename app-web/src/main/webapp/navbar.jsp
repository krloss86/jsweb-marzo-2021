<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.User"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="<%=request.getContextPath()%>">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
	<%
  		User user = (User)session.getAttribute(ViewKeyEnums.USUARIO.name());
	%>
	
	<%
		if(user == null) {
	%>
		<li class="nav-item">
        	<a class="nav-link" href="login.jsp">Login</a>
      	</li>
    <%
		}
    %>
    <%      
		if(user != null) {
    %>
	    <li class="nav-item">
	    	<a class="nav-link" href="upload.jsp">Cargar Archivo</a>
	    </li>
	    <li class="nav-item">
	       	<a class="nav-link" href="nuevo.jsp">Nuevo Producto</a>
	    </li>
		<li class="nav-item">
	       	<a class="nav-link" href="LogoutServlet">Logout</a>
	    </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="<%=request.getContextPath()%>/BuscarProductoServlet" method="post">
		<input name="claveBusqueda" class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Buscar">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
	</form>
	<%
		}
	%>
  </div>
</nav>