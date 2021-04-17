package ar.com.educacionit.web.parser;

import java.io.IOException;
import java.util.Collection;

import ar.com.educacionit.domain.Producto;

public interface IFileParser {

	Collection<Producto> parse() throws IOException;
}
