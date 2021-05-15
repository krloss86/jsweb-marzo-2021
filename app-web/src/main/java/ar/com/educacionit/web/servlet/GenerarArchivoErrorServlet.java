package ar.com.educacionit.web.servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/GenerarArchivoErrorServlet")
public class GenerarArchivoErrorServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//el formato desde la jsp: select
		String formatoSalida = request.getParameter("formato");
		
		//defino que nombre tendra el archivo
		String fileName = "listado-productos-error";
				
		//armo el nombre final
		String fileOutputPath = File.separator + "desarrollo" + 
		File.separator + "educacionit" + File.separator + "files" + File.separator + fileName + "."+ formatoSalida;
		
		File outpFile = new File(fileOutputPath);
		
		if(!outpFile.exists()) {
			Files.createFile(outpFile.toPath());
		}
		
		//los productos con error que guardamos en el servlet CargarProductosServlet
		
		Collection<Producto> productosEnSesion = (Collection<Producto>)request.getSession().getAttribute(ViewKeyEnums.LISTADO_FAIL.name());
		//campo1;campo2;capon
		//valo1;valor2;valorn
		List<String> lineasLeidasDeSalida = convertir(productosEnSesion);
		
		FileWriter fr = new FileWriter(outpFile);
		for(String linea : lineasLeidasDeSalida) {
			fr.write(linea);
		}
		fr.close();
		
		descargar(fileName,formatoSalida, outpFile,  request, response);
	}

	private void descargar(String fileName, String formatoSalida, File outpFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/csv");
		
		String finalFilaName = fileName+"." +formatoSalida;
		response.setHeader("Content-Disposition", "attachment; filename=\""+finalFilaName +"\" ");
		
		try {
			OutputStream outputStream = response.getOutputStream();
			byte[] byteDelArchivoGenerado = Files.readAllBytes(outpFile.toPath());
			outputStream.write(byteDelArchivoGenerado);
			
			outputStream.flush();
			outputStream.close();
		}catch (Exception e) {
			response.getWriter().print("No se ha podido generar el archivo" + finalFilaName);
		}
	}

	private List<String> convertir(Collection<Producto> productosEnSesion) {
		List<String> lineas = new ArrayList<String>();
		lineas.add("codigo;titulo;precio;tipo\n");
		
		for(Producto aux : productosEnSesion) {
			StringBuffer linea = new StringBuffer();
			linea.append(aux.getCodigo()).append(";");
			linea.append(aux.getTitulo()).append(";");
			linea.append(aux.getPrecio()).append(";");
			linea.append(aux.getTipoProducto()).append("\n");
			lineas.add(linea.toString());
		}
		
		return lineas;
	}
}
