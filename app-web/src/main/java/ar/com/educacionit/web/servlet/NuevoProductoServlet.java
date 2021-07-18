package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ProductoServices;
import ar.com.educacionit.services.impl.ProductoServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/NuevoProductoServlet")
public class NuevoProductoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//capturar los datos que envia la jsp
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String precio = request.getParameter("precio");
		String tipoProducto = request.getParameter("tipoProducto");
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		try {
			
			Float precioF = Float.parseFloat(precio);
			Long tipoProductoL = Long.parseLong(tipoProducto);
			
			Producto nuevoProducto = new Producto(titulo, precioF, codigo, tipoProductoL);
			
			ProductoServices ps = new ProductoServiceImpl();
			
			Producto producto = ps.nuevoProducto(nuevoProducto);
			request.setAttribute(ViewKeyEnums.EXITO.name(), "Se ha dado de alta exitosamente el producto id:" + producto.getId());
			
			//recargo la lista de productos
			Collection<Producto> productos = ps.findAll();
			request.setAttribute(ViewKeyEnums.LISTADO.name(), productos);
			Float suma = productos.stream()
					.map(p -> p.getPrecio())
					.reduce(0F, (Float x, Float y) -> x+y);
				
			addAttribute(request, ViewKeyEnums.TOTAL, suma);

		} catch (ServiceException | RuntimeException e) {
			request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), e.getMessage());
			target = ViewEnums.NUEVO_PRODUCTO;
		}
		
		//redireccion
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
