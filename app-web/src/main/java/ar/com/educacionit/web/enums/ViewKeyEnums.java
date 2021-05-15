package ar.com.educacionit.web.enums;

public enum ViewKeyEnums {

	USUARIO("usuario"), 
	USUARIO_PASSWORD_INVALIDO("Usuario/Password Inválido"), 
	ERROR_GENERAL("error"), 
	EXITO("exito"), 
	LISTADO("listado"),
	
	//clave de busqueda
	CLAVE_BUSQUEDA("claveBusqueda"), 
	ID_PRODUCTO("id"),
	PRODUCTO_EDITAR("producto_editar"), 
	UPLOAD_PREVIEW_KEY("upload_preview_key"), 
	LISTADO_FAIL("listadoFail"),
	LISTADO_OK("listadoOk"), 
	TOTAL("total"),
	;
	
	private String viewKey;
	
	private ViewKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}

	public String getViewKey() {
		return viewKey;
	}
}
