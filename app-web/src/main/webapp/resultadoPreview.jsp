<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>

<html>
	<head>
		<jsp:include page="styles.jsp"/>
	</head>
	<body>
		<jsp:include page="navbar.jsp"/>
		<div class="container">
			<jsp:include page="mensajeria.jsp"/>	
			
			<div class="row">
				<div class="col-12 mt-2">
					<div class="alert alert-success">Productos Procesados Correctamente</div>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">CÓDIGO</th>
								<th scope="col">TITULO</th>
								<th scope="col">PRECIO</th>
								<th scope="col">TIPO</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<%
							Collection<Producto> productos = (Collection<Producto>)request.getAttribute(ViewKeyEnums.LISTADO_OK.name());
						%>
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
			<hr>
			<div class="row">
				<div class="col-12 mt-2">
					<div class="alert alert-danger">Productos No Procesados</div>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">CÓDIGO</th>
								<th scope="col">TITULO</th>
								<th scope="col">PRECIO</th>
								<th scope="col">TIPO</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<%
							Collection<Producto> productosFail = (Collection<Producto>)session.getAttribute(ViewKeyEnums.LISTADO_FAIL.name());
						%>
						<% for(Producto aux : productosFail){ %>
							<tr>
								<th scope="row"></th>
								<td><%=aux.getCodigo() %></td>
								<td><%=aux.getTitulo() %></td>
								<td><%=aux.getPrecio() %></td>
								<td><%=aux.getTipoProducto() %></td>
							</tr>
						<%} %>
					</table>
				</div>
			</div>
			
			<% 
				if(!productosFail.isEmpty()) { 
			%>
			<div class="row">
				<div class="col-12">
					<form class="form-inline"
					 	action="<%=request.getContextPath()%>/GenerarArchivoErrorServlet"
						method="post"
						target="_new">
						
						<select class="form-control" name="formato">
							<option value="csv">CSV</option>
							<option value="xls">XLS</option>
							<option value="pdf">PDF</option> 
						</select>
						<button type="submit" class="btn btn-primary">
							Generar listado de error
						</button>
					</form>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</body>
</html>