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
<%-- 	<jsp:include page="mensajeria.jsp"/>	 --%>
		<div class="row mt-2">
			<jsp:include page="profileNavBar.jsp"></jsp:include>
			<div class="col">
				<h3>Datos de perfil</h3>
				<form class="row g-3">
					<div class="col-md-6 col-lg-4">
				    <label for="inputEmail4" class="form-label">Nombre</label>
				    <input type="email" class="form-control" id="inputEmail4">
				  </div>
				  <div class="col-md-6 col-lg-4">
				    <label for="inputEmail4" class="form-label">Apellido</label>
				    <input type="email" class="form-control" id="inputEmail4">
				  </div>
				  <div class="col-md-12 col-lg-4">
				    <label for="inputEmail4" class="form-label">Email</label>
				    <input type="email" class="form-control" id="inputEmail4">
				  </div>
				  <div class="col-12">
				    <label for="inputAddress" class="form-label">Direcci&oacute;n</label>
				    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
				  </div>
				  <div class="col-md-6">
				    <label for="inputCity" class="form-label">Pa&iacute;s</label>
				    <input type="text" class="form-control" id="inputCity">
				  </div>
				  <div class="col-md-4">
				    <label for="inputState" class="form-label">Provincia</label>
				    <select id="inputState" class="form-select">
				      <option selected>Choose...</option>
				      <option>...</option>
				    </select>
				  </div>
				  <div class="col-md-2">
				    <label for="inputZip" class="form-label">C&oacute;digo Postal</label>
				    <input type="text" class="form-control" id="inputZip">
				  </div>
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