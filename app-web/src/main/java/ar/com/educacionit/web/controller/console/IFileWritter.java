package ar.com.educacionit.web.controller.console;

import java.io.IOException;
import java.util.Map;

import ar.com.educacionit.domain.Articulos;

public interface IFileWritter {

	void write(String name, Map<String, Articulos> productos) throws IOException;

	public default String toCSV(Articulos articulo) {
		return articulo.getTitulo() + ";" + articulo.getPrecio() + ";" + articulo.getCodigo() + ";" + articulo.getMarcasId();
	}
}
