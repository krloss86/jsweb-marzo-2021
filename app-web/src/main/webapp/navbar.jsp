<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.User"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
      	<%--
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        --%>
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
	    <form class="d-flex" action="<%=request.getContextPath()%>/BuscarProductoServlet" method="post">
			<input name="claveBusqueda" class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Buscar">
			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Buscar</button>
		</form>
		<%
			}
		%>
    </div>
  </div>
</nav>

<%--
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
	<a class="navbar-brand" href="<%=request.getContextPath()%>">Home</a>
	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	  <div class="collapse navbar-collapse" id="navbarColor01">
	    <ul class="navbar-nav me-auto">
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
	    <form class="d-flex" action="<%=request.getContextPath()%>/BuscarProductoServlet" method="post">
			<input name="claveBusqueda" class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Buscar">
			<button class="btn btn-secondary my-2 my-sm-0" type="submit">Buscar</button>
		</form>
		<%
			}
		%>
	  </div>
	 </div>
</nav>
--%>