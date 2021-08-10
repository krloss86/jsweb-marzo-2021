package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;
import ar.com.educacionit.web.servlet.ordenadores.OrdenAsc;
import ar.com.educacionit.web.servlet.ordenadores.OrdenDesc;

/**
 * Servlet implementation class BuscarProductoServlet
 */
@WebServlet("/controllers/BuscarProductoServlet")
public class BuscarProductoServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String claveBusqueda = request.getParameter(ViewKeyEnums.CLAVE_BUSQUEDA.getViewKey());
		
		if(claveBusqueda == null || claveBusqueda.trim().equals("")) {
			claveBusqueda ="";
		}
		
		Collection<Articulos> articulos = new ArrayList<>();
		
		try {
			if(!claveBusqueda.equals("")) {
				articulos = ps.findAllBy(claveBusqueda);
			}else {
				articulos = ps.findAll();
			}
			//productos = ps.findAll(claveBusqueda);			
			//suma total de valores
			
			Stream<Articulos> stream = articulos.stream();
			
			//obtener los parametros de los filtros
			String titulo = request.getParameter("titulo");
			if(titulo != null && !"".equals(titulo.trim())) {
				stream = stream.filter(p -> p.getTitulo().toLowerCase().contains(titulo.toLowerCase()));
			}
			
			//precio mayores o iguales
			String precio = request.getParameter("precio");
			if(precio !=null && !"".equals(precio.trim())) {
				Double precioF = Double.parseDouble(precio);
				stream = stream.filter(p -> p.getPrecio() >= precioF);
			}
			
			String tipo = request.getParameter("tipo");
			if(tipo != null && !"".equals(tipo.trim())) {
				Long tipoL = Long.parseLong(tipo);
				stream = stream.filter(p-> p.getCategoriasId().equals(tipoL));
			}
			
			//aplico todos los filtros (si hay)
			articulos = stream.collect(Collectors.toList());
			
			if(articulos.isEmpty()) {	
				addAttribute(request, ViewKeyEnums.WARNING_GENERAL, "No hay datos");
			}
			//otengo orden
			
			String orden = request.getParameter("orden");
			if("asc".equals(orden)) {
				Collections.sort((List)articulos, new OrdenDesc());
			}else {
				Collections.sort((List)articulos, new OrdenAsc());
			}
			
			Double suma = articulos.stream()
				.map(p -> p.getPrecio())
				.reduce(0D, (Double x, Double y) -> x+y);
			
			addAttribute(request, ViewKeyEnums.TOTAL, suma);
		} catch (ServiceException e) {
			addAttribute(request, ViewKeyEnums.ERROR_GENERAL, e.getMessage());
		} finally {
			addAttribute(request, ViewKeyEnums.LISTADO, articulos);
		}
		
		
		//redireccion
		getServletContext().getRequestDispatcher(ViewEnums.LISTADO_GENERAL.getView()).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
