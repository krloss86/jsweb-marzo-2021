<!-- DIRECTIVA -->
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>

<!-- SCRIPTLET -->
<%
	Collection<Producto> listado = (Collection<Producto>)session.getAttribute(ViewKeyEnums.UPLOAD_PREVIEW_KEY.name());
%>

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
			<div class="row">
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">CODIGO</th>
					      <th scope="col">TITULO</th>
					      <th scope="col">PRECIO</th>
					      <th scope="col">TIPO</th>
					    </tr>
					  </thead>
					  <tbody>
					   
					   	<% for(Producto producto: listado) { %>
							<tr>
								<td><%=producto.getCodigo() %></td>
								<td><%=producto.getTitulo() %></td>
								<td><%=producto.getPrecio() %></td>
								<td><%=producto.getTipoProducto() %></td>
							</tr>
						<% } %>
					  </tbody>
				</table>
			</div>
			<div class="row">
			
				<div class="col-md-12 col-md-8 col-lg-9 col-xl-6">
					<form action="<%=request.getContextPath() %>/CargarProductosServlet" method="post">
						<a class="btn btn-warning" href="<%=request.getContextPath() %>/upload.jsp" role="button">Cancelar</a>
					  	<button type="submit" class="btn btn-success">Procesar</button>
					</form>
				</div>
				
			</div>	
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>