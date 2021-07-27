<%@page import="ar.com.educacionit.domain.Categoria"%>
<%@page import="java.util.List"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
  <head>
	<link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/favicon.ico">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="styles.jsp"></jsp:include>
  </head>
  <body>
	<%@include file="navbar.jsp" %>
	<%--
	<div class="container-fluid">
		<div class="row flex-xl-nowrap carrousel d-flex justify-content-center mt-1">
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
		--%>
		<div class="container">
			<div class="row row-cols-1 row-cols-md-3 g-4 mt-2">
				<div class="col-12">
					<h2>Categorías</h2>
				</div>
				<%List<Categoria> list = (List<Categoria>)request.getAttribute(ViewKeyEnums.LIST_CATEGORIAS.name());%>
				<%for(Categoria entity: list) {%>
				<div class="col-12 col-sm-6 col-md-4 col-lg-3">
				    <div class="card h-100">
				      <img src="${pageContext.request.contextPath}/assets/images/ceramica.jpg" 
				      	class="card-img-top" 
				      	alt="<%=entity.getDescripcion()%>"
				      	style="height: 225px; width: 100%; display: block;">
				      <div class="card-body">
				        <h5 class="card-title">
				        	<%=entity.getDescripcion()%>
				        </h5>
		<!--			<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p> -->
						<a href="#" class="btn btn-primary">Ver mas</a>
				      </div>
				    </div>
				  </div>
				<%} %>		
				</div>
			</div>
<!-- 		</div> -->
	<jsp:include page="scripts.jsp"></jsp:include>
  </body>
</html>