package ar.com.educacionit.web.parser;

import javax.servlet.http.Part;

public abstract class FileParserBase {

	protected String name;
	
	protected Part filePart;
	
	public FileParserBase(String name) {
		this.name = name;
	}
	
	public FileParserBase(Part filePart) {
		this.filePart = filePart;
	}
}
