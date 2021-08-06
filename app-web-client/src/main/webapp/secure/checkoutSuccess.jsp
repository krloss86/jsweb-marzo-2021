<%@page import="ar.com.educacionit.web.enums.CarritoKeyEnums"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="../styles.jsp"></jsp:include>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	<style>
      .container {
  		max-width: 700px;
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
	<jsp:include page="../navbar.jsp"></jsp:include>
	<div class="container">
<%-- 	<jsp:include page="mensajeria.jsp"/>	 --%>
		<div class="row mt-5">
			<div class="col align-self-center">
				<div class="tab-pane animated fadeIn active">
					<div class="" role="alert">
						<h3 class="head text-center">Se ha generado
							la orden N° <%=request.getAttribute(CarritoKeyEnums.ID_ORDEN_GENERADA.name()) %></h3>
						<p >Te hemos enviado un mail con los datos.</p>
						<p >Podes ver el estado haciendo click</p>
						<a class="btn btn-info w-100"
							title="View Details" href="${pageContext.request.contextPath}/secure/orderDetails.jsp"> Ver
							detalle de orden
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	<jsp:include page="../scripts.jsp"></jsp:include>
</body>