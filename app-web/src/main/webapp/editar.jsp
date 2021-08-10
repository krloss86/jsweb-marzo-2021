<%@page import="ar.com.educacionit.domain.Marcas"%>
<%@page import="ar.com.educacionit.domain.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%
	//asumo que el servlet ya cargo el objeto producto
	Articulos articulo = (Articulos)request.getAttribute(ViewKeyEnums.PRODUCTO_EDITAR.name());
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
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
			<jsp:include page="mensajeria.jsp"/>
			<h1>Editar Producto Id: <%=articulo.getId()%></h1>		
			<div class="row">
				<div class="col-12">
					<form action="<%=request.getContextPath()%>/controllers/ActualizarProductoServlet" method="post">
						<div class="form-group">
						    <label for="exampleInputEmail0">ID</label>
						    <input name="id" readonly="readonly" value="<%=articulo.getId() %>" type="text" class="form-control" id="exampleInputEmail0" aria-describedby="emailHelp">				    
					  	</div>
					  	<div class="form-group">
					    	<label for="exampleInputEmail1">Código</label>
					    	<input name="codigo" readonly="readonly" value="<%=articulo.getCodigo() %>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">				    
					  	</div>
					  	<div class="form-group">
						    <label for="exampleInputPassword1">Título</label>
						    <input name="titulo" value="<%=articulo.getTitulo()%>" type="text" class="form-control" id="exampleInputPassword1">
					  	</div>
					  	<div class="form-group">
					    	<label for="exampleInputPassword1">Precio</label>
					    	<input name="precio" value="<%=articulo.getPrecio() %>" type="text" class="form-control" id="exampleInputPassword1">
					  	</div>
						<div class="form-group">
				    		<label for="exampleInputPassword1">Stock</label>
				    		<input name="stock" type="number" min="0" max="999" value="<%=articulo.getStock() %>" class="form-control" id="exampleInputPassword1">
				  		</div>
						<div class="form-group">
		              		<label for="country" class="form-label">Categoria</label>
		              		<select name="categoriasId" class="form-select" id="country" required>
			                	<option value="">Seleccione...</option>
			                	<% 
			                		List<Categoria> categorias = (List<Categoria>)request.getAttribute("categorias"); 
			               
			                		for(Categoria categoria : categorias) {
				                		String selected = categoria.getId().equals(articulo.getCategoriasId()) ? "selected" : "";
			                	%>
			                	<option <%=selected %> value="<%=categoria.getId()%>"><%=categoria.getDescripcion() %></option>
								<%
			                		}
								%>
		              		</select>
		            	</div>
		            	<div class="form-group">
		              		<label for="country" class="form-label">Marca</label>
		              		<select name="marcasId" class="form-select" id="country" required>
			                	<option value="">Seleccione...</option>
			                	<% 
			                	
			                		List<Marcas> marcas = (List<Marcas>)request.getAttribute("marcas"); 
			               
			                		for(Marcas marca : marcas) {
				                		String selected = marca.getId().equals(articulo.getMarcasId()) ? "selected" : "";
			                	%>
				                	<option <%=selected %> value="<%=marca.getId()%>"><%=marca.getDescripcion() %></option>
								<%
			                		}
								%>
		              		</select>
		            	</div>
					  <a class="btn btn-secondary mt-1" href="<%=request.getContextPath()%>/controllers/BuscarProductoServlet" role="button">Volver</a>
					  <button type="submit" class="btn btn-primary mt-1">Actualizar</button>
					</form>			
				</div>
			</div>
		</div>
	</body>
</html>