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
		<div class="row mt-2">
			<jsp:include page="profileNavBar.jsp"></jsp:include>
			<div class="col">				
				<div class="col-12">
					<h3>Detalle Orden nro: 1</h3>
					<div class="table-wrapper mt-3">
						<div class="col">
							<table class="table table-striped table-hover">
								<thead >
									<tr >
										<th >description</th>
										<th >totalPrice</th>
									</tr>
								</thead>
								<tbody >
									<tr >
										<td >order 1</td>
										<td >$10.00</td>
									</tr>
								</tbody>
							</table>
							<h4 >Dirección de entrega</h4>
							<table class="table table-striped table-hover">
								<thead >
									<tr >
										<th >street</th>
										<th >city</th>
										<th >state</th>
										<th >zip</th>
									</tr>
								</thead>
								<tbody >
									<tr >
										<td >aristobulo del valle 1257</td>
										<td >caba</td>
										<td >buenos aires</td>
										<td >1295</td>
									</tr>
								</tbody>
							</table>
							<h4 >Medio de Pago</h4>
							<table class="table table-striped table-hover">
								<thead >
									<tr >
										<th >description</th>
										<th >total</th>
									</tr>
								</thead>
								<tbody >
									<tr >
										<td >Efectivo</td>
										<td >$10.00</td>
									</tr>
								</tbody>
							</table>
							<table class="table">
								<tbody >
									<tr >
										<td ><a class="view"
											href="${pageContext.request.contextPath}/orders.jsp">
											<i class="bi bi-arrow-left-circle-fill"></i>
										</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="scripts.jsp"></jsp:include>
</body>