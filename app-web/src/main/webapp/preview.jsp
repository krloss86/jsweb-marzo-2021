<!-- DIRECTIVA -->
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.Collection"%>
<!doctype html>
<html lang="en">
  	<head>
    	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<title>BootCamp</title>
		<jsp:include page="styles.jsp"></jsp:include>
  	</head>
	<body>
		<jsp:include page="navbar.jsp"/>
		<div class="container">
			<h1>Productos en archivo</h1>	
			<div class="row">
				<div class="col-12">
					<table class="table">
						  <thead>
						    <tr>
						      <th scope="col">CODIGO</th>
						      <th scope="col">TITULO</th>
						      <th scope="col">PRECIO</th>
								<th scope="col">STOCK</th>
								<th scope="col">MARCA</th>
								<th scope="col">CATEGORIA</th>
						    </tr>
						  </thead>
						  <tbody>
						   <!-- SCRIPTLET -->
							<%
								Collection<Articulos> listado = (Collection<Articulos>)session.getAttribute(ViewKeyEnums.UPLOAD_PREVIEW_KEY.name());
							%>
						   	<% for(Articulos articulo: listado) { %>
								<tr>
									<td><%=articulo.getCodigo() %></td>
									<td><%=articulo.getTitulo() %></td>
									<td><%=articulo.getPrecio() %></td>
									<td><%=articulo.getStock() %></td>
									<td><%=articulo.getMarcasId() %></td>
									<td><%=articulo.getCategoriasId() %></td>
								</tr>
							<% } %>
						  </tbody>
					</table>
				</div>
			</div>
			<div class="row">			
				<div class="col-md-12 col-md-8 col-lg-9 col-xl-6">
					<form action="<%=request.getContextPath() %>/controllers/CargarProductosServlet" method="post">
						<a class="btn btn-danger" href="<%=request.getContextPath() %>/upload.jsp" role="button">Cancelar</a>
					  	<button type="submit" class="btn btn-primary">Procesar</button>
					</form>
				</div>
				
			</div>	
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>