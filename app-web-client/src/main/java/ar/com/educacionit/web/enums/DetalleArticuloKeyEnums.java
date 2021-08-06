package ar.com.educacionit.web.enums;

public enum DetalleArticuloKeyEnums implements Enumerable{
	
	ARTICULO("articulo"),
	;
	
	private String viewKey;
	
	private DetalleArticuloKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}

	@Override
	public String getKey() {
		return this.viewKey;
	}

	
}
