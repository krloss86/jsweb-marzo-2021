<%@page import="ar.com.educacionit.web.enums.ViewKeyEnums"%>
<%@page import="ar.com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>

<%
	if(request.getAttribute(ViewKeyEnums.ERROR_GENERAL.name()) != null) {
%>		
	<div class="row mt-1">
		<div class="col-12">
			<div class="alert alert-danger" role="alert">
				<%=request.getAttribute(ViewKeyEnums.ERROR_GENERAL.name()) %>
			</div>
		</div>
	</div>
<%
	}
%>	

<%
	if(request.getAttribute(ViewKeyEnums.WARNING_GENERAL.name()) != null) {
%>		
	<div class="row mt-1">
		<div class="col-12">
			<div class="alert alert-warning" role="alert">
				<%=request.getAttribute(ViewKeyEnums.WARNING_GENERAL.name()) %>
			</div>
		</div>
	</div>
<%
	}
%>

<%
	if(request.getAttribute(ViewKeyEnums.EXITO.name()) != null) {
%>		
	<div class="row mt-1">
		<div class="col-12">
			<div class="alert alert-success" role="alert">
				<%=request.getAttribute(ViewKeyEnums.EXITO.name()) %>
			</div>
		</div>
	</div>
<%
	}
%>	
