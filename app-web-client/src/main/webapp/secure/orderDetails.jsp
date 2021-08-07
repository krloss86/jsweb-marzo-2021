<%@page import="ar.com.educacionit.web.enums.OrdenesKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Ordenes"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="../styles.jsp"></jsp:include>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">       
  </head>
<body>
	<jsp:include page="../navbar.jsp"></jsp:include>
	<div class="container-fluid">
<%-- 	<jsp:include page="mensajeria.jsp"/>	 --%>
		<div class="row mt-2">
			<jsp:include page="profileNavBar.jsp"></jsp:include>
			<div class="col">				
				<div class="col-12">
					<%
						Ordenes orden = (Ordenes)session.getAttribute(OrdenesKeyEnums.ORDEN.name());
					%>
					<h3>Detalle Orden nro: <%=orden.getId() %></h3>
					<div class="table-wrapper mt-3">
						<div class="col">
							<table class="table table-striped table-hover">
								<thead >
									<tr >
										<th >Fecha Orden</th>
										<th >Precio Total</th>
									</tr>
								</thead>
								<tbody >
									<tr >
										<td ><%=orden.getFechaCreacion() %></td>
										<td ><%=orden.getMontoTotal() %></td>
									</tr>
								</tbody>
							</table>
							<h4 >Dirección de entrega</h4>
							<table class="table table-striped table-hover">
								<thead >
									<tr >
										<th >Pais</th>
										<th >Direcci&oacute;n</th>
									</tr>
								</thead>
								<tbody >
									<tr >
										<td >Argentina </td>
										<td ><%=orden.getDireccionOrden().getDireccionEnvio() %></td>
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
										<td ><%=orden.getPagoOrden().getMediosPagosId() %></td>
										<td ><%=orden.getPagoOrden().getMonto() %></td>
									</tr>
								</tbody>
							</table>
							<table class="table">
								<tbody >
									<tr >
										<td ><a class="view"
											href="${pageContext.request.contextPath}/secure/OrdenesControllers">
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
	<jsp:include page="../footer.jsp"></jsp:include>
	<jsp:include page="../scripts.jsp"></jsp:include>
</body>