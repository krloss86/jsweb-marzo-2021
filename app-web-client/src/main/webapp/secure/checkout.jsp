<!doctype html>
<%@page import="ar.com.educacionit.domain.MediosPagos"%>
<%@page import="ar.com.educacionit.domain.dto.ItemCarrito"%>
<%@page import="ar.com.educacionit.web.dto.Carrito"%>
<%@page import="ar.com.educacionit.web.enums.CarritoKeyEnums"%>
<%@page import="ar.com.educacionit.web.dto.Checkout"%>
<%@page import="ar.com.educacionit.domain.Paises"%>
<%@page import="java.util.List"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <title>Checkout example  Bootstrap v5.0</title>
    <!-- Bootstrap core CSS -->
	<jsp:include page="../styles.jsp"></jsp:include>
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
    <!-- Custom styles for this template -->
	<!--<link href="form-validation.css" rel="stylesheet"> -->
  </head>
  <body>
	<jsp:include page="../navbar.jsp"></jsp:include>
	<% 
		Carrito carrito = (Carrito)session.getAttribute(CarritoKeyEnums.CARRITO.name());
		Checkout checkout = (Checkout)session.getAttribute(CarritoKeyEnums.DATOS_CHECKOUT.name());
	%>
	<div class="container">
    <%
      	if(carrito != null && !carrito.getItems().isEmpty()) {
    %>
	  <main>
	  	<%--
		    <div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
		      <h2>Checkout form</h2>
		      <p class="lead">
		      	Below is an example form built entirely with Bootstrap's form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.
		      </p>
		    </div>
		--%>
		    <div class="row g-5 py-2">
		      <div class="col-md-5 col-lg-4 order-md-last">
		        <h4 class="d-flex justify-content-between align-items-center mb-3">
		          <span class="text-primary">Tu carrito</span>
		          <span class="badge bg-primary rounded-pill"><%=carrito.getItems().size() %></span>
		        </h4>
		        <ul class="list-group mb-3">
		        <%
	            	for(ItemCarrito item : carrito.getItems()) {
                %>
		          <li class="list-group-item d-flex justify-content-between lh-sm">
		            <div>
		              <h6 class="my-0"><%=item.getTitulo() %></h6>
<!-- 		              <small class="text-muted">Brief description</small> -->
		            </div>
		            <span class="text-muted">
		            	<%=item.getPrecio() %>
		            </span>
		          </li>
		       <%
	            	}
		       %>
		       <%--
		          <li class="list-group-item d-flex justify-content-between bg-light">
		            <div class="text-success">
		              <h6 class="my-0">Promo code</h6>
		              <small>EXAMPLECODE</small>
		            </div>
		            <span class="text-success">-$5</span>
		          </li>
		          --%>
		          <li class="list-group-item d-flex justify-content-between">
		            <span>Total ($)</span>
		            <strong><%=carrito.getTotal() %></strong>
		          </li>
		        </ul>
		        <form class="card p-2">
		          <div class="input-group">
		            <input type="text" class="form-control" placeholder="Promo code">
		            <button type="submit" class="btn btn-secondary">Aplicar &oacute;digo</button>
		          </div>
		        </form>
		      </div>
		      <div class="col-md-7 col-lg-8">
		      
		        <h4 class="mb-3">Direcci&oacute;n Facturaci&oacute;n</h4>
		        <form class="needs-validation" novalidate action="${pageContext.request.contextPath}/secure/CheckoutController" method="POST">
		          <div class="row g-3">
		            <div class="col-sm-6">
		              <label for="firstName" class="form-label">Nombre</label>
		              <input name="<%=CarritoKeyEnums.NOMBRE.name()%>" type="text" class="form-control" id="firstName" placeholder="" 
		              	value="<%=checkout.getNombre()%>" 
		              	required>
		              <div class="invalid-feedback">
		                requerido
		              </div>
		            </div>
		
		            <div class="col-sm-6">
		              <label for="lastName" class="form-label">Apellido</label>
		              <input name="<%=CarritoKeyEnums.APELLIDO.name()%>" type="text" class="form-control" id="lastName" placeholder="" 
		              	value="<%=checkout.getApellido()%>" 
		              	required>
		              <div class="invalid-feedback">
		                requerido
		              </div>
		            </div>
					<%--
		            <div class="col-12">
		              <label for="username" class="form-label">Username</label>
		              <div class="input-group has-validation">
		                <span class="input-group-text">@</span>
		                <input type="text" class="form-control" id="username" placeholder="Username" required>
		              <div class="invalid-feedback">
		                  Your username is required.
		                </div>
		              </div>
		            </div>
					--%>
		            <div class="col-12">
		              <label for="email" class="form-label">Email <span class="text-muted">(Optional)</span></label>
		              <input name="<%=CarritoKeyEnums.EMAIL.name()%>" type="email" class="form-control" id="email" placeholder="you@example.com"
		              	value="<%=checkout.getEmail()%>"
		              	required>
		              <div class="invalid-feedback">
		                Please enter a valid email address for shipping updates.
		              </div>
		            </div>
		
		            <div class="col-12">
		              <label for="address" class="form-label">Direcci&oacute;n</label>
		              <input name="<%=CarritoKeyEnums.DIRECCION.name()%>" type="text" class="form-control" id="address" placeholder="1234 Main St" 
		              	value="<%=checkout.getDireccion()%>"
		              	required>
		              <div class="invalid-feedback">
		                Ingrese direcci&oacute;n
		              </div>
		            </div>
					<%--
		            <div class="col-12">
		              <label for="address2" class="form-label">Address 2 <span class="text-muted">(Optional)</span></label>
		              <input type="text" class="form-control" id="address2" placeholder="Apartment or suite">
		            </div>
					--%>
		            <div class="col-md-5">
		              <label for="country" class="form-label">Pais</label>
		              <select name="<%=CarritoKeyEnums.PAIS.name()%>" class="form-select" id="country" required>
		                <option value="-1">Seleccione...</option>
		                <% 
		                	List<Paises> paises = (List<Paises>)request.getAttribute(CarritoKeyEnums.PAISES.name()); 
		                %>
		                <%
		                	for(Paises pais : paises) {
		                %>
			                <option value="<%=pais.getId()%>"><%=pais.getDescripcion() %></option>
						<%
		                	}
						%>
							                
		              </select>
		              <div class="invalid-feedback">
		                Seleccione pais v&aacute;lido
		              </div>
		            </div>
					<%--
		            <div class="col-md-4">
		              <label for="state" class="form-label">State</label>
		              <select class="form-select" id="state" required>
		                <option value="">Choose...</option>
		                <option>California</option>
		              </select>
		              <div class="invalid-feedback">
		                Please provide a valid state.
		              </div>
		            </div>
					
		            <div class="col-md-3">
		              <label for="zip" class="form-label">Zip</label>
		              <input type="text" class="form-control" id="zip" placeholder="" required>
		              <div class="invalid-feedback">
		                Zip code required.
		              </div>
		            </div>
		            --%>
		          </div>
		
					<%--
		          <hr class="my-4">
		          <div class="form-check">
		            <input type="checkbox" class="form-check-input" id="same-address">
		            <label class="form-check-label" for="same-address">Shipping address is the same as my billing address</label>
		          </div>
		
		          <div class="form-check">
		            <input type="checkbox" class="form-check-input" id="save-info">
		            <label class="form-check-label" for="save-info">Save this information for next time</label>
		          </div>
					--%>
		          <hr class="my-4">
		
		          <h4 class="mb-3">Pago</h4>
		
		          <div class="my-3">
		          <%
		          	List<MediosPagos> mediosPagos = (List<MediosPagos>)session.getAttribute(CarritoKeyEnums.MEDIOS_PAGOS.name());
		          %>
		          <%
		          	for(MediosPagos medio : mediosPagos) {
		          %>
		            <div class="form-check">
		              <input value="<%=medio.getId() %>" id="credit" name="paymentMethod" type="radio" class="form-check-input" required>
		              <label class="form-check-label" for="credit"><%=medio.getDescripcion() %></label>
		            </div>
		            <%-- 
		            <div class="form-check">
		              <input id="debit" name="paymentMethod" type="radio" class="form-check-input" required>
		              <label class="form-check-label" for="debit">Debit card</label>
		            </div>
		            <div class="form-check">
		              <input id="paypal" name="paymentMethod" type="radio" class="form-check-input" required>
		              <label class="form-check-label" for="paypal">PayPal</label>
		            </div>
		            --%>
		          <%
		          	}		          
		          %>
		          </div>
		
		          <div class="row gy-3">
		            <div class="col-md-6">
		              <label for="cc-name" class="form-label">Name on card</label>
		              <input type="text" class="form-control" id="cc-name" placeholder="" required>
		              <small class="text-muted">Full name as displayed on card</small>
		              <div class="invalid-feedback">
		                Name on card is required
		              </div>
		            </div>
		
		            <div class="col-md-6">
		              <label for="cc-number" class="form-label">Credit card number</label>
		              <input type="text" class="form-control" id="cc-number" placeholder="" required>
		              <div class="invalid-feedback">
		                Credit card number is required
		              </div>
		            </div>
		
		            <div class="col-md-3">
		              <label for="cc-expiration" class="form-label">Expiration</label>
		              <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
		              <div class="invalid-feedback">
		                Expiration date required
		              </div>
		            </div>
		
		            <div class="col-md-3">
		              <label for="cc-cvv" class="form-label">CVV</label>
		              <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
		              <div class="invalid-feedback">
		                Security code required
		              </div>
		            </div>
		          </div>
		
		          <hr class="my-4">
		
		          <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
		        </form>
		      </div>
		    </div>
	    <%
	      	}
	    %>
		  </main>
	
		  <footer class="my-5 pt-5 text-muted text-center text-small">
		    <p class="mb-1">&copy; 2017-2021 Company Name</p>
		    <ul class="list-inline">
		      <li class="list-inline-item"><a href="#">Privacy</a></li>
		      <li class="list-inline-item"><a href="#">Terms</a></li>
		      <li class="list-inline-item"><a href="#">Support</a></li>
		    </ul>
		  </footer>
	</div>
	<jsp:include page="../scripts.jsp"></jsp:include>
    <script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
  </body>
</html>
