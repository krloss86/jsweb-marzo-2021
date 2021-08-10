package ar.com.educacionit.web.enums;

public enum ViewKeyEnums implements Enumerable{

	USUARIO("usuario"), 
	USUARIO_PASSWORD_INVALIDO("Usuario/Password Invalido"),
	USUARIO_SESSION_INVALIDA("Su sesion ha finalizado"),
	ERROR_GENERAL("error"), 
	WARNING_GENERAL("warning"),
	EXITO("exito"), 
	LISTADO("listado"),
	
	//clave de busqueda
	CLAVE_BUSQUEDA("claveBusqueda"), 
	TOTAL("total"),
	;
	
	private String viewKey;
	
	private ViewKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}

	public String getViewKey() {
		return viewKey;
	}

	@Override
	public String getKey() {
		return this.name();
	}
}
