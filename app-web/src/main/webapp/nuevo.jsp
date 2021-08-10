<%@page import="ar.com.educacionit.domain.Marcas"%>
<%@page import="ar.com.educacionit.domain.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
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
		<h1>Nuevo Producto</h1>		
		<div class="row">
			<div class="col-12">
				<form action="<%=request.getContextPath()%>/controllers/NuevoProductoServlet" method="post">
				 	 <div class="form-group">
				    	<label for="exampleInputEmail1">Código</label>
				    	<input name="codigo" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">				    
				  	</div>
			  		<div class="form-group">
				    	<label for="exampleInputPassword1">Título</label>
				    	<input name="titulo" type="text" class="form-control" id="exampleInputPassword1">
				  	</div>
				  	<div class="form-group">
				    	<label for="exampleInputPassword1">Precio</label>
				    	<input name="precio" type="text" class="form-control" id="exampleInputPassword1">
				  	</div>
					<div class="form-group">
				    	<label for="exampleInputPassword1">Stock</label>
				    	<input name="stock" type="number" min="0" max="999" class="form-control" id="exampleInputPassword1">
				  	</div>
				  
					<div class="form-group">
		              <label for="country" class="form-label">Categoria</label>
		              <select name="categoriasId" class="form-select" id="country" required>
		                <option value="">Seleccione...</option>
		                <% 
		                	List<Categoria> categorias = (List<Categoria>)request.getAttribute("categorias"); 
		               
		                	for(Categoria categoria : categorias) {
		                %>
			                <option value="<%=categoria.getId()%>"><%=categoria.getDescripcion() %></option>
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
		                %>
			                <option value="<%=marca.getId()%>"><%=marca.getDescripcion() %></option>
						<%
		                	}
						%>
							                
		              </select>
		            </div>
				  <button type="submit" class="btn btn-primary mt-1">Grabar</button>
				</form>			
			</div>
		</div>
	</div>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>