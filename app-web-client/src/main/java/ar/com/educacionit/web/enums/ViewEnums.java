package ar.com.educacionit.web.enums;

public enum ViewEnums {

	LOGIN("/login.jsp"),
	LOGIN_SUCCESS("/loginSuccess.jsp"),
	LISTADO_GENERAL("/listadoGeneral.jsp"),  
	RESULTADO_PREVIEW("/resultadoPreview.jsp"), 
	
	LISTADO_CATEGORIAS_INDEX("/categorias.jsp");
	
	private String view;
	
	//ctrl+spce
	private ViewEnums(String view) {
		this.view = view;
	}
	
	public String getView() {
		return this.view;
	}
}
