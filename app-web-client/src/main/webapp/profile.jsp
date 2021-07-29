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
			<div class="col-md-4 col-lg-3 col-xxl-2">
				<h5>Categorias</h5>
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
				  
				  
				  
			  	</div>
			</div>
		</div>
	</div>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>