<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>

<html>
	<head>
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
		<div class="container">
			<jsp:include page="mensajeria.jsp"/>	
			
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
									<a class="btn btn-danger" onclick="guardarId(<%=aux.getId()%>)" href="#" role="button" data-toggle="modal" data-target="#exampleModal">Eliminar</a> | 
									<a class="btn btn-primary" href="<%=request.getContextPath()%>/CargarParaEditarProductoServlet?id=<%=aux.getId()%>" role="button">Editar</a> 
								</td>
							</tr>
						<%} %>
					</table>
				</div>
			</div>			
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Eliminar Producto</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        ¿Desea eliminar el producto?
		      </div>
		      <div class="modal-footer">
		      	<form id="eliminarForm" action="<%=request.getContextPath()%>/EliminarProductoServlet">
		      		<input name="id" type="hidden" id="idProductoEliminar">
		        	<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
		        	<button type="submit" class="btn btn-primary">Confirmar</button>
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
	</body>
</html>