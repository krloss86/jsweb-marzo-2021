<%@page import="ar.com.educacionit.web.enums.DetalleArticuloKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.web.enums.CarritoKeyEnums"%>
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
	<div class="container">
		<jsp:include page="mensajeria.jsp"/>
		<%--	
		<div class="row mt-2">
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
		<div class="row">
			<div class="col-12">
				<h3>Detalle de articulo</h3>			
				<div class="card mb-3">
				  <div class="row g-0">
				    <div class="col-md-5">
				      <img src="${pageContext.request.contextPath}/assets/images/ceramica.jpg"  class="img-fluid rounded-start" alt="ceramica">
				    </div>
				    <div class="col-md-7">
			    	<%
						Articulos articulo = (Articulos)request.getAttribute(DetalleArticuloKeyEnums.ARTICULO.name());
				    %>
				      <div class="card-body">
				        <h5 class="card-title"><%=articulo.getTitulo() %></h5>
				        <p class="card-text"><%=articulo.getCodigo() %></p>
<!-- 				    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p> -->
						<form id="detalleArticuloForm" action="${pageContext.request.contextPath}/CarritoController" method="post" onsubmit="return false;">
				        	<input type="hidden" name="<%=CarritoKeyEnums.ID.name()%>" value="<%=articulo.getId()%>">
					      	<div class="col-sm-12 col-md-12 col-lg-8 col-xxl-6">
								<div class="input-group mb-3 justify-content-center">
								  <button class="btn btn-warning" type="button" id="btnDecrementar">
								  	<i class="bi bi-cart-dash"></i>
								  </button>
								  <input type="text" id="<%=CarritoKeyEnums.CANTIDAD.name()%>" name="<%=CarritoKeyEnums.CANTIDAD.name()%>" class="form-control" placeholder="cantidad" aria-label="" aria-describedby="button-addon1">
								  <button class="btn btn-success" type="button" id="btnIncrementar">
								  	<i class="bi bi-cart-plus"></i>
								  </button>  
								</div>
							  <button id="btnAdd" type="button" class="btn btn-primary w-100">
							  	<i class="bi bi-cart-plus"></i>
							  	Agregar
							  </button>
							</div>
						</form>
				      </div>					  	
				    </div>
				  </div>
				</div>	
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="scripts.jsp"></jsp:include>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="module" src="${pageContext.request.contextPath}/js/carrito.js"></script>   
</body>