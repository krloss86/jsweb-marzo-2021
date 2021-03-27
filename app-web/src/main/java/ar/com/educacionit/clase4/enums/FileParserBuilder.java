package ar.com.educacionit.clase4.enums;

import java.util.HashMap;
import java.util.Map;

import ar.com.educacionit.clase4.exceptions.NoFileParserException;

public class FileParserBuilder {

	private static Map<Tipo, IFileParser> mapFileParsers;
	
	//bloque static
	static {
		mapFileParsers = new HashMap<>();
		
		mapFileParsers.put(Tipo.CSV, new CSVFileParser());
		mapFileParsers.put(Tipo.TXT, new TXTFileParser());
		mapFileParsers.put(Tipo.XLS, new XLSFileParser());
	}
	
	public static IFileParser builFileParser(Tipo tipo) throws NoFileParserException{
		
		IFileParser fileParser;
		
		if(mapFileParsers.containsKey(tipo)) {
			fileParser = mapFileParsers.get(tipo);
		}else {
			throw new NoFileParserException("No existe Parser asociado a " + tipo);
		}
			
		return fileParser;
	}
}
