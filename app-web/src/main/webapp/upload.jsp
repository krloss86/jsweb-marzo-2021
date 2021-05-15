<html>
	<head>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
		<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<div class="container">
			<div class="row">
				<div class="col-12 mt-2">
					<form enctype="multipart/form-data" action="<%=request.getContextPath()%>/UploadServlet" method="post">
					  <div class="form-group">
					    <label for="exampleFormControlFile1">Cargar Archivo de Productos (csv/xlsx)</label>
					    <input name="file" type="file" class="form-control-file" id="exampleFormControlFile1">
					  </div>
					  <button type="submit" class="btn btn-primary">Subir Archivo</button>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>