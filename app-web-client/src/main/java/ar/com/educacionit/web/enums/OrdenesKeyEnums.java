package ar.com.educacionit.web.enums;

public enum OrdenesKeyEnums implements Enumerable{
	
	ORDENES("ordenes"), 
	ORDEN("orden"),
	ID_ORDEN("orden_id") 
	
	;
	
	private String viewKey;
	
	private OrdenesKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}

	@Override
	public String getKey() {
		return this.viewKey;
	}

	
}
