<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
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
			<jsp:include page="mensajeria.jsp"/>	
			<div class="row">
				<div class="col-12">
					<h1>Resultado</h1>		
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-12 mt-2">
					<h3 class="text-success">Productos Procesados</h3>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">CÓDIGO</th>
								<th scope="col">TITULO</th>
								<th scope="col">PRECIO</th>
								<th scope="col">STOCK</th>
								<th scope="col">MARCA</th>
								<th scope="col">CATEGORIA</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<%
							Collection<Articulos> productos = (Collection<Articulos>)request.getAttribute(ViewKeyEnums.LISTADO_OK.name());
						%>
						<% for(Articulos aux : productos){ %>
							<tr>
								<th scope="row"><%=aux.getId() %></th>
								<td><%=aux.getCodigo() %></td>
								<td><%=aux.getTitulo() %></td>
								<td><%=aux.getPrecio() %></td>
								<td><%=aux.getStock() %></td>
								<td><%=aux.getMarcasId() %></td>
								<td><%=aux.getCategoriasId() %></td>
							</tr>
						<%} %>
						<% if(productos.isEmpty()) { %>
							<tr>
								<td colspan="6">
									<p class="d-flex justify-content-center text-info ">No hay datos</p>
								</td>
							</tr>
						<%} %>
					</table>
					<a class="btn btn-primary mt-1" 
						href="<%=request.getContextPath()%>/controllers/BuscarProductoServlet?" role="button">
						Ver Listado
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12 mt-2">
					<h3 class="text-danger">Productos NO Procesados</h3>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">CÓDIGO</th>
								<th scope="col">TITULO</th>
								<th scope="col">PRECIO</th>
								<th scope="col">STOCK</th>
								<th scope="col">MARCA</th>
								<th scope="col">CATEGORIA</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<%
							Collection<Articulos> productosFail = (Collection<Articulos>)session.getAttribute(ViewKeyEnums.LISTADO_FAIL.name());
						%>
						<% for(Articulos aux : productosFail){ %>
							<tr>
								<th scope="row"></th>
								<td><%=aux.getCodigo() %></td>
								<td><%=aux.getTitulo() %></td>
								<td><%=aux.getPrecio() %></td>
								<td><%=aux.getStock() %></td>	
								<td><%=aux.getMarcasId() %></td>
								<td><%=aux.getCategoriasId() %></td>
							</tr>
						<%} %>
						<% if(productosFail.isEmpty()) { %>
							<tr>
								<td colspan="6">
									<p class="d-flex justify-content-center text-info ">No hay datos</p>
								</td>
							</tr>
						<%} %>
					</table>					
					<% 
						if(!productosFail.isEmpty()) { 
					%>			
						<form action="<%=request.getContextPath()%>/controllers/GenerarArchivoErrorServlet"
							method="post"
							target="_new">
							<div class="input-group">
								  <select class="form-select" id="inputGroupSelect04" aria-label="Example select with button addon" name="formato">
								    <option selected>...</option>
								    <option value="csv">CSV</option>
									<option value="xls">XLS</option>
<!-- 									<option value="pdf">PDF</option> -->
								  </select>
								  <button type="submit" class="btn btn-success" type="button">
								  	Generar Listado
								  </button>
							</div>
						 </form>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>