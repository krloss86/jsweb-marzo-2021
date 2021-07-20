package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;
import ar.com.educacionit.web.parser.CSVFileParser;
import ar.com.educacionit.web.parser.IFileParser;
import ar.com.educacionit.web.parser.XLSFileParser;


@WebServlet("/controllers/UploadServlet")
@MultipartConfig
public class UploadServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part filePart = request.getPart("file");
		
		ViewEnums target = ViewEnums.UPLOAD_PREVIEW;
		
		if(filePart.getSize() > 0) {
			
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			
			//nombre.ext
			String ext = getExt(fileName);
			
			IFileParser fileParser;
			
			if("csv".equals(ext.toLowerCase())) {
				fileParser = new CSVFileParser(filePart);			
			}else {
				fileParser = new XLSFileParser(filePart);
			}
			
			Collection<Producto> productos = fileParser.parse();
			
			addAttribute(request.getSession(), ViewKeyEnums.UPLOAD_PREVIEW_KEY, productos);
		}else {
			super.addAttribute(request, ViewKeyEnums.ERROR_GENERAL,"Debe serleccionar un archivo");
			target = ViewEnums.UPLOAD;
		}
		
		redirect(target, request, response);		
	}
	
	/**
	 * OJO VALIDAR QUE FILE NAME SEA != NULL
	 * @param fileName
	 * @return
	 */
	private String getExt(String fileName) {
		
		int from = fileName.lastIndexOf(".") + 1;
		
		return fileName.substring(from, fileName.length());		
	}
}
