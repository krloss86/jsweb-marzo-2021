package ar.com.educacionit.clase4.enums;

public class TipoEnumMain {

	public static void main(String[] args) {
		
		Tipo unEnum = Tipo.XLS;	
		
		//nombre de enum
		System.out.println("Nombre del enum:" + unEnum.name());
		System.out.println("Orden dentro del enum: " + unEnum.ordinal());
		System.out.println("Valor asociado al enum: "+ unEnum.getTipoTexto());
		
		String resultado = exportar(unEnum);		
		
		System.out.println(resultado);
	}

	public static String exportar(Tipo tipo) {
		
		String resultado;
		//los valores que tiene un enum
		if(Tipo.CSV.equals(tipo)) {
			resultado = "generando un csv"; 
		}else if(Tipo.TXT.equals(tipo)) {
			resultado = "generando un txt";
		}else {
			resultado = "generando un xls";
		}
		return resultado;
	}
}
