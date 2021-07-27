package ar.com.educacionit.web.enums;

public enum ViewKeyEnums {

	USUARIO("usuario"), 
	USUARIO_PASSWORD_INVALIDO("Usuario/Password Invalido"),
	USUARIO_SESSION_INVALIDA("Su sesion ha finalizado"),
	ERROR_GENERAL("error"), 
	WARNING_GENERAL("warning"),
	EXITO("exito"), 
	LISTADO("listado"),
	
	//clave de busqueda
	CLAVE_BUSQUEDA("claveBusqueda"), 
	ID_PRODUCTO("id"),
	LISTADO_FAIL("listadoFail"),
	LISTADO_OK("listadoOk"), 
	TOTAL("total"),
	
	//NUEVAS
	LIST_CATEGORIAS("categorias"),
	;
	
	private String viewKey;
	
	private ViewKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}

	public String getViewKey() {
		return viewKey;
	}
}
