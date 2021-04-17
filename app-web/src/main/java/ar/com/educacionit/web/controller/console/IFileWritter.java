package ar.com.educacionit.web.controller.console;

import java.io.IOException;
import java.util.Map;

import ar.com.educacionit.domain.Producto;

public interface IFileWritter {

	void write(String name, Map<String, Producto> productos) throws IOException;

}
