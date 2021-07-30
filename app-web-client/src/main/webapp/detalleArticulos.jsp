<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="styles.jsp"></jsp:include>
    <style>
      .container {
  		max-width: 960px;
	   }
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
  </head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
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
		<div class="row">
			<div class="col-12">
				<div class="card mb-3">
				  <div class="row g-0">
				    <div class="col-md-5">
				      <img src="${pageContext.request.contextPath}/assets/images/ceramica.jpg" 
				      	class="img-fluid rounded-start" 
				      	alt="ceramica">
				    </div>
				    <div class="col-md-7">
				      <div class="card-body">
				        <h5 class="card-title">Card title</h5>
				        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
<!-- 				        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p> -->
					      <div class="col-sm-12 col-md-12 col-lg-8 col-xxl-6">
								<div class="input-group mb-3 justify-content-center">
								  <button class="btn btn-warning" type="button" id="button-addon1">-</button>
								  <input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
								  <button class="btn btn-success" type="button" id="button-addon2">+</button>  
								</div>
							  <button type="submit" class="btn btn-primary w-100">Agregar</button>
							</div>
				      </div>
					  	<%--
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
						<div class="col-sm-12 col-md-12 col-lg-8 col-xxl-6">
							<div class="input-group mb-3 justify-content-center">
							  <button class="btn btn-warning" type="button" id="button-addon1">-</button>
							  <input type="text" class="form-control" placeholder="" aria-label="Example text with button addon" aria-describedby="button-addon1">
							  <button class="btn btn-success" type="button" id="button-addon2">+</button>  
							  <button type="submit" class="btn btn-primary">Agregar</button>
							</div>
						</div>
				    </div>
						--%>
				    </div>
				  </div>
				</div>	
			</div>
		</div>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>