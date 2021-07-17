<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>BootCamp</title>
    <jsp:include page="styles.jsp"></jsp:include>
  </head>
	</head>
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
			<jsp:include page="mensajeria.jsp"/>
			<div class="row">
				<h1>Cargar Archivo</h1>
				<div class="col-12 mt-2">
					<form enctype="multipart/form-data" action="<%=request.getContextPath()%>/UploadServlet" method="post">
					  <div class="form-group">
					    <label for="exampleFormControlFile1">Cargar Archivo de Productos (csv/xlsx)</label>
					    <input name="file" type="file" class="form-control-file" id="exampleFormControlFile1">
					  </div>
					  <button type="submit" class="btn btn-primary mt-1">
					  	Subir Archivo
					  </button>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
</html>