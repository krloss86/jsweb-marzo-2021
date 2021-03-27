package ar.com.educacionit.clase4.enums;

public enum Tipo {

	//valores tiene este enum
	TXT("Texto"),//0
	XLS("Excel"),//1
	CSV("Texto CSV");	
	
	private String tipoTexto;
	
	//no puede ser public el contructor
	private Tipo(String tipoTexto) {
		this.tipoTexto = tipoTexto;
	}
	
	public String getTipoTexto() {
		return this.tipoTexto;
	}
	
	public static Tipo getEnumBy(String tipoString) {
		Tipo tipo;		
		try {
			tipo = Tipo.valueOf(tipoString);
		}catch (IllegalArgumentException e) {
			tipo = null;
		}
		return tipo;
	}
}
