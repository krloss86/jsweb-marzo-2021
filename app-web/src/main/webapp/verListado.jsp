<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.services.impl.ProductoServiceImpl"%>
<%@page import="ar.com.educacionit.services.ProductoServices"%>
<%@page import="ar.com.educacionit.domain.User"%>
<%@page import="ar.com.educacionit.services.impl.LoginServiceImp"%>
<%@page import="ar.com.educacionit.services.LoginService"%>
<%
	ProductoServices ps = new ProductoServiceImpl();
	Collection<Producto> productos = ps.findAll();
%>
<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
		<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
			<div class="row">
				<div class="col-12 mt-2">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">CÓDIGO</th>
								<th scope="col">TITULO</th>
								<th scope="col">PRECIO</th>
								<th scope="col">TIPO</th>
							</tr>
						</thead>
						<% for(Producto aux : productos){ %>
							<tr>
								<th scope="row"><%=aux.getId() %></th>
								<td><%=aux.getCodigo() %></td>
								<td><%=aux.getTitulo() %></td>
								<td><%=aux.getPrecio() %></td>
								<td><%=aux.getTipoProducto() %></td>
							</tr>
						<%} %>
					</table>
				</div>
			</div>			
		</div>
	</body>
</html>