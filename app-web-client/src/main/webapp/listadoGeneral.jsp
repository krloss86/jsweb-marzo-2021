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
	<div class="container-fluid">
<%-- 	<jsp:include page="mensajeria.jsp"/>	 --%>
		<div class="row">
			<div class="col-12">
				<nav aria-label="breadcrumb mt-2">
				  <ol class="breadcrumb">
				    <li class="breadcrumb-item"><a href="#">Home</a></li>
				    <li class="breadcrumb-item"><a href="#">Library</a></li>
				    <li class="breadcrumb-item active" aria-current="page">Data</li>
				  </ol>
				</nav>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-lg-3 col-xxl-2">
				<h5>Categorias</h5>
				<ul class="list-group">
				  <li class="list-group-item">Categroias</li>
				  <li class="list-group-item">A second item</li>
				  <li class="list-group-item">A third item</li>
				  <li class="list-group-item">A fourth item</li>
				  <li class="list-group-item">And a fifth one</li>
				</ul>
				<hr>
				<h5>Marcas</h5>
				<ul class="list-group">
				  <li class="list-group-item">Categroias</li>
				  <li class="list-group-item">A second item</li>
				  <li class="list-group-item">A third item</li>
				  <li class="list-group-item">A fourth item</li>
				  <li class="list-group-item">And a fifth one</li>
				</ul>
			</div>
			<div class="col">
				<div class="col-md-12 col-lg-3">
					Ordenar Por:
					<select class="form-select form-select-sm" aria-label=".form-select-sm example">
					  <option selected>Open this select menu</option>
					  <option value="1">One</option>
					  <option value="2">Two</option>
					  <option value="3">Three</option>
					</select>
				</div>
				<div class="row g-1 mt-1">
				  
				  <div class="col-xs-12 col-sm-6 col-md-6 col-lg-4 col-xxl-3">
				    <div class="card h-100">
				      <img src="${pageContext.request.contextPath}/assets/images/ceramica.jpg" 
				      	class="card-img-top" 
				      	alt="ceramica">
				      <div class="card-body">
				        <h5 class="card-title">Taza Cerámica</h5>
				        <p class="card-text">Color Blanco</p>
				        <a href="${pageContext.request.contextPath}/detalleArticulos.jsp" class="btn btn-primary w-100">Ver</a>
				      </div>
				      <div class="card-footer">
				        <form class="row g-0 p-0">
						  <div class="col">
						    <label for="cantidad" class="visually-hidden">Cantidad</label>
						    <input type="number" min="0" max="999" class="form-control" id="cantidad" placeholder="Cantidad">
						  </div>
						  <div class="col-auto">
						    <button type="submit" class="btn btn-primary mb-3">Agregar</button>
						  </div>
						</form>
				      </div>
				    </div>
				  </div>
				  
				  </div>
					<nav aria-label="Page navigation example">
					  <ul class="pagination justify-content-center">
					    <li class="page-item">
					      <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
					    </li>
					    <li class="page-item active"><a class="page-link" href="#">1</a></li>
					    <li class="page-item"><a class="page-link" href="#">2</a></li>
					    <li class="page-item"><a class="page-link" href="#">3</a></li>
					    <li class="page-item">
					      <a class="page-link" href="#">Next</a>
					    </li>
					  </ul>
					</nav>
				</div>
			</div>
		</div>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>