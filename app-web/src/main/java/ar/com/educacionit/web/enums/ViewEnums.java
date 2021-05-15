package ar.com.educacionit.web.enums;

public enum ViewEnums {

	LOGIN("/login.jsp"),
	LOGIN_SUCCESS("/loginSuccess.jsp"),
	UPLOAD("/upload.jsp"),
	LISTADO_GENERAL("/listadoGeneral.jsp"),
	NUEVO_PRODUCTO("/nuevo.jsp"), 
	EDITAR_PRODUCTO("/editar.jsp"), 
	UPLOAD_PREVIEW("/preview.jsp"), 
	RESULTADO_PREVIEW("/resultadoPreview.jsp");
	
	private String view;
	
	//ctrl+spce
	private ViewEnums(String view) {
		this.view = view;
	}
	
	public String getView() {
		return this.view;
	}
}
