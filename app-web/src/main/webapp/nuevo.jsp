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
				<form action="<%=request.getContextPath()%>/NuevoProductoServlet" method="post">
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
				    <label for="exampleInputPassword1">Tipo Producto</label>
				    <select name="tipoProducto" class="form-control">
						<option value="1">Herramientas</option>
					    <option value="2">Electrodomesticos</option>
					    <option value="3">Celulares</option>
					</select>
				  </div>
				  <button type="submit" class="btn btn-primary mt-1">Grabar</button>
				</form>			
			</div>
		</div>
	</div>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>