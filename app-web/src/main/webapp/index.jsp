<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="styles.jsp"></jsp:include>
  </head>
  <body>
	<%@include file="navbar.jsp" %>
	<div class="container">
		<div class="row flex-xl-nowrap carrousel d-flex justify-content-center">
			<div class="col-xs-12 col-sm-12 col-md-10 col-lg-9 col-xl-8 col-xxl-7">
				<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
				  <div class="carousel-indicators">
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
				    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
				  </div>
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="<%=request.getContextPath()%>/assets/images/carrousel-1.jpg" class="d-block w-100" alt="">
				    </div>
				    <div class="carousel-item">
				      <img src="<%=request.getContextPath()%>/assets/images/carrousel-2.jpg" class="d-block w-100" alt="">
				    </div>
				    <div class="carousel-item">
				      <img src="<%=request.getContextPath()%>/assets/images/carrousel-2.jpg" class="d-block w-100" alt="">
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
			</div>
		</div>
		
		<div class="row row-cols-1 row-cols-md-3 g-4 mt-2">
			<div class="col-12">
				<h2>Categorías</h2>
			</div>
		  <div class="col-12 col-sm-6 col-md-4 col-lg-2">
		    <div class="card h-100">
		      <img src="<%=request.getContextPath()%>/assets/images/ceramica.jpg" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Card title</h5>
	<!-- 		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p> -->
					<a href="#" class="btn btn-primary">Ver mas</a>
		      </div>
		    </div>
		  </div>
		  <div class="col-12 col-sm-6 col-md-4 col-lg-2">
		    <div class="card h-100">
		      <img src="<%=request.getContextPath()%>/assets/images/plastico.jpg" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Plastico</h5>
	<!-- 		        <p class="card-text">This is a short card.</p> -->
					<a href="#" class="btn btn-primary">Ver mas</a>
		      </div>
		    </div>
		  </div>
		  <div class="col-12 col-sm-6 col-md-4 col-lg-2">
		    <div class="card h-100">
		      <img src="<%=request.getContextPath()%>/assets/images/porcelana.jpg" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Porcelana</h5>
	<!-- 		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content.</p> -->
					<a href="#" class="btn btn-primary">Ver mas</a>
		      </div>
		    </div>
		  </div>
		  <div class="col-12 col-sm-6 col-md-4 col-lg-2">
		    <div class="card h-100">
		      <img src="<%=request.getContextPath()%>/assets/images/vidrio.jpg" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Vidrios</h5>
	<!-- 		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p> -->
					<a href="#" class="btn btn-primary">Ver mas</a>
		      </div>
		    </div>
		  </div>
		<div class="col-12 col-sm-6 col-md-4 col-lg-2">
		    <div class="card h-100">
		      <img src="<%=request.getContextPath()%>/assets/images/calcos.jpg" class="card-img-top" alt="...">
		      <div class="card-body">
		        <h5 class="card-title">Calcos</h5>
	<!-- 		        <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p> -->
					<a href="#" class="btn btn-primary">Ver mas</a>
		      </div>
		    </div>
		  </div>
		</div>
	</div>
	<jsp:include page="scripts.jsp"></jsp:include>
  </body>
</html>