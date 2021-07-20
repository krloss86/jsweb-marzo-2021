<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>
<!doctype html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<jsp:include page="styles.jsp"/>
		<script type="text/javascript">
			function guardarId(id) {
				//funcion nativa de js
				document.getElementById('idProductoEliminar').value = id;
			}
		</script>
	</head>
	<body>
		<jsp:include page="navbar.jsp"/>
		<div class="container-fluid">
			<jsp:include page="mensajeria.jsp"/>			
			<div class="row">
				<div class="col-md-12 col-lg-2 mt-1">
					<h3>Filtrar:</h3>
					<form class="form-inline" action="<%=request.getContextPath()%>/controllers/BuscarProductoServlet" method="post">
<!-- 					<input type="hidden" name="titulo" value="" > -->
						<div class="form-group">
							<label>Titulo</label>
							<input name="titulo" type="text" class="form-control" id="titulo">
						</div>
						<div class="form-group">
							<label>Precio</label>
							<input name="precio" type="number" class="form-control" id="precio">
						</div>
						<div class="form-group">
						    <label for="exampleInputPassword1">Ordenar (Precio)</label>
						    <select name="orden" class="form-control">
								<option value="asc">Asc</option>
							    <option value="desc">Desc</option>
							</select>
						  </div>
						<button type="submit" class="btn btn-primary mt-1">
							Filtrar
						</button>
					</form>
				</div> 
				<div class="col-md-12 col-lg-10 mt-1">
					<h3>Resultados:</h3>
					<table class="table">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">C�DIGO</th>
								<th scope="col">TITULO</th>
								<th scope="col">PRECIO</th>
								<th scope="col">TIPO</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<%
							Collection<Producto> productos = (Collection<Producto>)request.getAttribute(ViewKeyEnums.LISTADO.name());
						%>
						<% for(Producto aux : productos){ %>
							<tr>
								<th scope="row"><%=aux.getId() %></th>
								<td><%=aux.getCodigo() %></td>
								<td><%=aux.getTitulo() %></td>
								<td><%=aux.getPrecio() %></td>
								<td><%=aux.getTipoProducto() %></td>
								<td>
									<div class="d-grid gap-2 d-md-flex justify-content-md-end">
										<button type="button" onclick="guardarId(<%=aux.getId()%>)" class="btn btn-danger me-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal">
											Eliminar
										</button>
										<a class="btn btn-primary" href="<%=request.getContextPath()%>/controllers/CargarParaEditarProductoServlet?id=<%=aux.getId()%>" role="button">Editar</a> 
									</div>
								</td>
							</tr>
						<%} %>
						<tr>
							<td colspan="3" align="right">Total</td>
							<td>$ <%=request.getAttribute(ViewKeyEnums.TOTAL.name())%></td>
							<td colspan="2"></td>
						</tr>
					</table>
				</div>
			</div>			
		</div>		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">�Desea eliminar el producto?</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        �Desea eliminar el producto?
		      </div>
		      <div class="modal-footer">
		        <form id="eliminarForm" action="<%=request.getContextPath()%>/controllers/EliminarProductoServlet">
		      		<input name="id" type="hidden" id="idProductoEliminar">
        	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>		        	
		        	<button type="submit" class="btn btn-primary">Confirmar</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>