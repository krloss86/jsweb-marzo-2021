package ar.com.educacionit.web.enums;

public enum ProfileKeyEnums implements Enumerable{
	
	NOMBRE("nombre"),
	APELLIDO("apellido"),
	EMAIL("email"),
	DIRECCION("direccion"),
	PAIS("pais"),
	;
	
	private String viewKey;
	
	private ProfileKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}

	@Override
	public String getKey() {
		return this.viewKey;
	}

	
}
