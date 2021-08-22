<%@page import="ar.com.educacionit.domain.dto.ItemCarrito"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="ar.com.educacionit.web.enums.CarritoKeyEnums"%>
<%@page import="ar.com.educacionit.web.dto.Carrito"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="styles.jsp"></jsp:include>
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/bootstrap/shopping-cart.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
  </head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="mensajeria.jsp"/>	
		<% 
	      	Carrito carrito = (Carrito)session.getAttribute(CarritoKeyEnums.CARRITO.name());
		%>
	    <%
	      	if(carrito != null && !carrito.getItems().isEmpty()) {
	    %>
		<div class="row">
	        <div class="col-12">
	        	<h3>Carrito de compras</h3>	
	            <div class="table-responsive">
	                <table class="table table-striped">
	                    <thead>
	                        <tr>
	                            <th scope="col"> </th>
	                            <th scope="col">T&iacute;tulo</th>
	                            <th scope="col" class="text-center">Cantidad</th>
	                            <th scope="col" class="text-right">Precio</th>
	                            <th> </th>
	                        </tr>
	                    </thead>
	                    <tbody>
						<%
	                    	for(ItemCarrito item : carrito.getItems()) {
	                    %>
	                        <tr>	                            		
	                            <td>
	                            	<img src="https://dummyimage.com/50x50/55595c/fff" /> 
	                            </td>
	                            <td>
	                            	<%=item.getTitulo() %>
	                            </td>
	                            <td>
	                            	<input id="<%=CarritoKeyEnums.CANTIDAD.name()%>_<%=item.getId() %>" class="form-control" type="text" value="<%=item.getCantidad() %>"/>
	                            </td>
	                            <td class="text-right">
	                            	<%=item.getPrecio() %>
	                            </td>
	                            <td class="text-right">
                            		<button id="<%=item.getId() %>" class="btn btn-sm btn-primary btnActualizar">
                            			<i class="bi bi-arrow-clockwise"></i> 
                            		</button>
                            		<button id="<%=item.getId() %>" class="btn btn-sm btn-danger btnEliminar">
                            			<i class="bi bi-trash"></i> 
                            		</button>
	                            </td>
	                        </tr>
	                    <%} %>                          
	                        <tr>
	                            <td></td>
	                            <td></td>
	                            <td></td>
	                            <td><strong>Total</strong></td>
	                            <td class="text-right">
	                            	<strong><%=carrito.getTotal() %></strong>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
	        </div>
	    </div>
		<form id="frmCarrito" action="${pageContext.request.contextPath}/CarritoController" method="POST">
			<input type="hidden" id="<%=CarritoKeyEnums.ID.name()%>" name="<%=CarritoKeyEnums.ID.name()%>"/>
			<input type="hidden" id="<%=CarritoKeyEnums.CANTIDAD.name()%>" name="<%=CarritoKeyEnums.CANTIDAD.name()%>"/>
		</form>
		<div class="row text-center">
			<div class="col-6">
				<a href="${pageContext.request.contextPath}/BuscarProductoServlet" class="btn btn-block btn-secondary text-uppercase" tabindex="0">
					Continue Shopping
				</a>
			</div>
			<div class="col-6">
				<a href="${pageContext.request.contextPath}/secure/CheckoutController" class="btn btn-block btn-success text-uppercase" tabindex="0">
					Checkout
				</a>
			</div>
		</div>
       	<%
            } else {
       	%>
			<div class="row mt-5">
				<div class="col-12">
					<div class="alert alert-warning" role="alert">
						<h4 class="alert-heading">Carrito Vac&iacute;o!</h4>
						<p>No hay productos en el carrito</p>
						<hr>
						<p class="mb-0">
							<a class="btn btn-info btn-md" href="${pageContext.request.contextPath}/BuscarProductoServlet">
							<i class="bi bi-cart"></i> 
							Continuar comprando </a>
						</p>
					</div>
				</div>
	    	</div>
       	<% 
            }
       	%>
	</div>
  	<jsp:include page="footer.jsp"></jsp:include>
   	<jsp:include page="scripts.jsp"></jsp:include>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="module" src="${pageContext.request.contextPath}/js/carrito.js"></script>  
</body>