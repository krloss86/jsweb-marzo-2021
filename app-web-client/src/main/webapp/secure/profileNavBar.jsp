<div class="col-md-4 col-lg-3 col-xxl-2">
	<div class="bd-example">
		<ul class="nav flex-column">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" 
		    	href="${pageContext.request.contextPath}/secure/profile.jsp">
		    	Perfil
		    </a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" aria-current="page" 
		    	href="${pageContext.request.contextPath}/secure/orders.jsp">
		    	Ordenes
		    </a>
		  </li>		 
		</ul>
	</div>
	<div class="accordion accordion-flush" id="accordionFlushExample">
	  <div class="accordion-item">
	    <h2 class="accordion-header" id="flush-headingOne">
	      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
	        Seguridad
	      </button>
	    </h2>
	    <div id="flush-collapseOne" class="accordion-collapse collapse" aria-labelledby="flush-headingOne" data-bs-parent="#accordionFlushExample">
	      <div class="accordion-body">
			<form class="row g-1 p-1">
				<div class="col-md-12">
			    <label for="inputEmail4" class="form-label">Password</label>
			    <input type="password" class="form-control" id="inputEmail4">
			  </div>
			  <div class="col-md-12">
			    <label for="inputEmail4" class="form-label">Confirmar</label>
			    <input type="password"" class="form-control" id="inputEmail4">
			  </div>				  
			  <div class="col-12">
			    <button type="submit" class="btn btn-primary">Cambiar</button>
			  </div>
			</form>				  
	      </div>
	    </div>
	  </div>  
	</div>
</div>