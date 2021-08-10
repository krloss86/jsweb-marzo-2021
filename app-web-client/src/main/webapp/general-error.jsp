<%@page isErrorPage="true" %>
<!doctype html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<jsp:include page="styles.jsp"/>
	</head>
	<body>
		<div class="container-fluid">
		    <div class="row">
		        <div class="col-12">
		            <div>
		                <h1>
		                    Oops!</h1>
		                <h2>
		                    404 Not Found</h2>
		                <div class="alert alert-danger">
		                    <%
			                    if(exception != null) {
			                    	if(exception.getCause() !=null)
			                    		out.println(exception.getCause().getMessage());
			                    	else
			                    		out.println(exception.getMessage());
			                    }
		                    %>
		                </div>
		                <div>
							<a href="<%=request.getContextPath()%>"
								class="btn btn-primary btn-lg">
								Ir a Home 
							</a>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</body>
</html>