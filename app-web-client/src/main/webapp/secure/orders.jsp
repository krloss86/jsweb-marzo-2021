<%@page import="ar.com.educacionit.web.enums.OrdenesKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Ordenes"%>
<%@page import="java.util.List"%>
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
				<div class="col-sm-12 col-lg-8 col-xxl-4">
					<div class="input-group mb-3">
					  <label class="input-group-text" for="inputGroupSelect01">Filtrar Estado Orden:</label>
					  <select class="form-select" id="inputGroupSelect01">
					    <option selected="">Choose...</option>
					    <option value="1">Pendientes</option>
					    <option value="2">Finalizadas</option>
					  </select>
					</div>
					<%--
					<div class="input-group mb-3">
					  <label class="input-group-text" for="inputGroupSelect01">Ordenasr por:</label>
					  <select class="form-select" id="inputGroupSelect01">
					    <option selected="">Choose...</option>
					    <option value="1">Mayor Precio</option>
					    <option value="2">Menor Precio</option>
					  </select>
					</div>
					--%>
				</div>
				<div class="col-12">
					<h3>Mis Ordenes</h3>
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>N�mero</th>
								<th>Status</th>
								<th>Total Price</th>
								<th>Order Date</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
						<%
							List<Ordenes> ordenes = (List<Ordenes>)session.getAttribute(OrdenesKeyEnums.ORDENES.name());
						%>
						<%
							for(Ordenes orden : ordenes) {
						%>
							<tr>
								<td><%=orden.getId() %></td>
								<td><%=orden.getEstadosOrdenesId() %></td>
								<td><%=orden.getMontoTotal() %></td>
								<td><%=orden.getFechaCreacion()%></td>
								<td><a data-toggle="tooltip"
									title="Ver Detalle" 
									href="${pageContext.request.contextPath}/controllers/DetalleOrdenController?<%=OrdenesKeyEnums.ID_ORDEN.name()%>=<%=orden.getId()%>">
									<i class="bi bi-eye-fill"></i>
								</a></td>
							</tr>
						<%
							}
						%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	<jsp:include page="../scripts.jsp"></jsp:include>
</body>