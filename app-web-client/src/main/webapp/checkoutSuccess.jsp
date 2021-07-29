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
	<div class="container">
<%-- 	<jsp:include page="mensajeria.jsp"/>	 --%>
		<div class="row mt-5">
			<div class="col align-self-center">
				<div class="tab-pane animated fadeIn active">
					<div class="alert alert-success" role="alert">
						<h3 class="head text-center">Se ha generado
							la orden N° 1</h3>
						<p >Te hemos enviado un mail con los datos.</p>
						<p >Podes ver el estado haciendo click</p>
						<a class="btn btn-success w-100"
							title="View Details" href="${pageContext.request.contextPath}/orderDetails.jsp"> Ver
							detalle de orden <i class="fa fa-arrow-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>