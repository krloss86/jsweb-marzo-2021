package ar.com.educacionit.web.parser;

import java.io.IOException;
import java.util.Collection;

import ar.com.educacionit.domain.Articulos;

public interface IFileParser {

	Collection<Articulos> parse() throws IOException;
}
