package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;
import ar.com.educacionit.web.parser.CSVFileParser;
import ar.com.educacionit.web.parser.IFileParser;
import ar.com.educacionit.web.parser.XLSFileParser;


@WebServlet("/UploadServlet")
public class UploadServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		
		//nombre.ext
		String ext = getExt(fileName);
		
		IFileParser fileParser;
		
		if("csv".equals(ext.toLowerCase())) {
			fileParser = new CSVFileParser(fileName);			
		}else {
			fileParser = new XLSFileParser(fileName);
		}
		
		Collection<Producto> productos = fileParser.parse();
		
		addAttribute(request, ViewKeyEnums.UPLOAD_PREVIEW_KEY, productos);
		
		redirect(ViewEnums.UPLOAD_PREVIEW, request, response);		
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
