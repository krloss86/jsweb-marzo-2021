<!-- DIRECTIVA -->
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>

<!-- SCRIPTLET -->
<%
	Collection<Producto> listado = (Collection<Producto>)request.getAttribute(ViewKeyEnums.UPLOAD_PREVIEW_KEY.name());
%>

<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="navbar.jsp"/>
		<div class="container-fluid">
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
					  <button type="submit" class="btn btn-primary">Subir</button>
					</form>
				</div>
				
			</div>	
		</div>
	</body>
</html>