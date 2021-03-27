package ar.com.educacionit.clase4.enums;

public interface IFileParser {

	public String parse();
	
	public static String defaultParse( ) {
		return "";
	}
}
