<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%
	//asumo que el servlet ya cargo el objeto producto
	Producto aux = (Producto)request.getAttribute(ViewKeyEnums.PRODUCTO_EDITAR.name());
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
			<h1>Editar Producto Id: <%=aux.getId()%></h1>		
			<div class="row">
				<div class="col-12">
					<form action="<%=request.getContextPath()%>/controllers/ActualizarProductoServlet" method="post">
						<div class="form-group">
						    <label for="exampleInputEmail0">ID</label>
						    <input name="id" readonly="readonly" value="<%=aux.getId() %>" type="text" class="form-control" id="exampleInputEmail0" aria-describedby="emailHelp">				    
					  </div>
					  <div class="form-group">
					    <label for="exampleInputEmail1">Código</label>
					    <input name="codigo" readonly="readonly" value="<%=aux.getCodigo() %>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">				    
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Título</label>
					    <input name="titulo" value="<%=aux.getTitulo()%>" type="text" class="form-control" id="exampleInputPassword1">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Precio</label>
					    <input name="precio" value="<%=aux.getPrecio() %>" type="text" class="form-control" id="exampleInputPassword1">
					  </div>
					  <div class="form-group">
					    <label for="exampleInputPassword1">Tipo Producto</label>
					    <select name="tipoProducto" class="form-control">
							<option value="1">Herramientas</option>
						    <option value="2">Electrodomesticos</option>
						    <option value="3">Celulares</option>
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