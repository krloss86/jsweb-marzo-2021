<%@page import="ar.com.educacionit.web.enums.CarritoKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="styles.jsp"></jsp:include>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">   
  </head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container-fluid">
<%-- 	<jsp:include page="mensajeria.jsp"/>	 --%>
<%--
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
--%>
		<div class="row mt-2">
			<div class="col-md-4 col-lg-3 col-xxl-2">
				<h5>Categorias</h5>
				<ul class="list-group">
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
				  <li class="list-group-item">And a fifth one</li>
				</ul>
			</div>
			<%List<Articulos> items = (List<Articulos>)request.getAttribute(ViewKeyEnums.LISTADO.name());%>
			<%if(items != null && !items.isEmpty()) {%>
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
				<div class="row g-0 mt-1">
				<%
				for(Articulos item : items) {
				%>
				<!-- articulo -->
				  <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xxl-2">
				    <div class="card h-100">
				      <img src="${pageContext.request.contextPath}/assets/images/ceramica.jpg" 
				      	class="card-img-top" 
				      	alt="ceramica">
				      <div class="card-body">
				        <h5 class="card-title"><%=item.getTitulo() %></h5>
				        <p class="card-text"><%=item.getCodigo() %></p>
				        <a href="${pageContext.request.contextPath}/DetalleArticuloController?<%=CarritoKeyEnums.ID.name()%>=<%=item.getId()%>" class="btn btn-primary w-100">Ver</a>
				      </div>
				      <div class="card-footer">
				        <form id="form_<%=item.getId() %>" class="row g-0 p-0" action="${pageContext.request.contextPath}/CarritoController" method="post" onsubmit="return false;">
				        	<input type="hidden" name="<%=CarritoKeyEnums.ID.name()%>" value="<%=item.getId()%>">
						  	<div class="col">
						    	<label for="cantidad" class="visually-hidden">Cantidad</label>
						    	<input type="number" min="0" max="999" name="<%=CarritoKeyEnums.CANTIDAD.name()%>" class="form-control" id="<%=CarritoKeyEnums.CANTIDAD.name()%>_<%=item.getId() %>" placeholder="Cantidad">
						  	</div>
						  	<div class="col-auto">
						    	<button type="button" class="btn btn-primary mb-3 btnAdd" id="<%=item.getId() %>">
						    		<i class="bi bi-cart-plus"></i>
						    	</button>
						  	</div>
						</form>
				      </div>
				    </div>
				  </div>
				<!-- fin articulo -->
				<%
				}
				%>	  
				  </div>
					<nav aria-label="Page navigation example">
					  <ul class="pagination justify-content-center mt-2">
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
			<%
				}
			%>
			</div>
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
	<jsp:include page="footer.jsp"></jsp:include>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="module" src="${pageContext.request.contextPath}/js/carrito.js"></script>
</html>