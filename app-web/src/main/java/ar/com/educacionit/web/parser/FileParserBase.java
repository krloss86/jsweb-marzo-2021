package ar.com.educacionit.web.parser;

public abstract class FileParserBase {

	protected String name;
	
	//protected Part filePart;
	
	public FileParserBase(String name) {
		this.name = name;
	}
}
