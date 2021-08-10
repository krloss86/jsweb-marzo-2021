<%@page import="ar.com.educacionit.domain.User"%>
<%@page import="ar.com.educacionit.web.enums.ProfileKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Paises"%>
<%@page import="java.util.List"%>
<%@page import="ar.com.educacionit.web.enums.CarritoKeyEnums"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="../styles.jsp"></jsp:include>
  </head>
<body>
	<jsp:include page="../navbar.jsp"></jsp:include>
	<div class="container-fluid">
	<jsp:include page="../mensajeria.jsp"/>	
		<div class="row mt-2">
			<jsp:include page="profileNavBar.jsp"></jsp:include>
			<div class="col">
				<h3>Datos de perfil</h3>
			  <%
			  	User user = (User)session.getAttribute(ViewKeyEnums.USUARIO.name());
			  %>
				<form class="row g-3" 
					action="${pageContext.request.contextPath}/secure/ProfileController"
					method="POST">
					<div class="col-md-6 col-lg-4">
				    <label for="inputEmail4" class="form-label">Nombre</label>
				    <input name="<%=ProfileKeyEnums.NOMBRE%>" value="<%=user.getSocios().getNombre()%>" type="text" class="form-control" id="inputEmail4">
				  </div>
				  <div class="col-md-6 col-lg-4">
				    <label for="inputEmail4" class="form-label">Apellido</label>
				    <input name="<%=ProfileKeyEnums.APELLIDO%>" value="<%=user.getSocios().getApellido()%>" type="text" class="form-control" id="inputEmail4">
				  </div>
				  <div class="col-md-12 col-lg-4">
				    <label for="inputEmail4" class="form-label">Email</label>
				    <input name="<%=ProfileKeyEnums.EMAIL%>" value="<%=user.getSocios().getEmail()%>" type="text" class="form-control" id="inputEmail4">
				  </div>
				  <div class="col-12">
				    <label for="inputAddress" class="form-label">Direcci&oacute;n</label>
				    <input name="<%=ProfileKeyEnums.DIRECCION%>" value="<%=user.getSocios().getDireccion()%>" type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
				  </div>
				  <div class="col-xs-12 col-md-6 col-lg-3">
		              <label for="country" class="form-label">Pais</label>
		              <select name="<%=ProfileKeyEnums.PAIS.name()%>" class="form-select" id="country" required>
		                <option value="">Seleccione...</option>
		                <% 
		                	List<Paises> paises = (List<Paises>)session.getAttribute(CarritoKeyEnums.PAISES.name()); 
		               
		                	for(Paises pais : paises) {
		                		String selcted = pais.getId().equals(user.getSocios().getPaisesId()) ? "selected" : "";
		                %>
			                <option <%=selcted%> value="<%=pais.getId()%>"><%=pais.getDescripcion() %></option>
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
				    <label for="inputState" class="form-label">Provincia</label>
				    <select id="inputState" class="form-select">
				      <option selected>Choose...</option>
				      <option>...</option>
				    </select>
				  </div>
				  --%>
				  <%--
				  <div class="col-md-2">
				    <label for="inputZip" class="form-label">C&oacute;digo Postal</label>
				    <input type="text" class="form-control" id="inputZip">
				  </div>
				  --%>
				  <div class="col-12">
				    <button type="submit" class="btn btn-primary">Actualizar</button>
				  </div>
				</form>				  
			</div>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	<jsp:include page="../scripts.jsp"></jsp:include>
</body>