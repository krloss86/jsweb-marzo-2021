<%@page isErrorPage="true" %>
<!doctype html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<jsp:include page="styles.jsp"/>
	</head>
	<body>
		<div class="container">
		    <div class="row">
		        <div class="col-12">
		            <div class="error-template">
		                <h1>
		                    Oops!</h1>
		                <h2>
		                    404 Not Found</h2>
		                <div class="error-details">
		                    <%
			                    if(exception != null) {
			                    	out.print(exception.toString());
			                    }
		                    %>
		                </div>
		                <div class="error-actions">
							<a href="<%=request.getContextPath()%>"
								class="btn btn-primary btn-lg">
								<span class="glyphicon glyphicon-home"></span> Take Me Home 
							</a>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</body>
</html>