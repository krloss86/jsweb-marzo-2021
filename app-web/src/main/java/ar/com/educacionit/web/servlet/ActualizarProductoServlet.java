package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/controllers/ActualizarProductoServlet")
public class ActualizarProductoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//capturar los datos que envia la jsp
		String id = request.getParameter("id");
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String precio = request.getParameter("precio");
		String tipoProducto = request.getParameter("tipoProducto");
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		Producto nuevoProducto = null;
		try {
			
			Long idLong = Long.parseLong(id);
			Double precioF = Double.parseDouble(precio);
			Long tipoProductoL = Long.parseLong(tipoProducto);
			
			nuevoProducto = new Producto(idLong, titulo, precioF, codigo, tipoProductoL);
			
			super.ps.actualizarProdcuto(nuevoProducto);
			request.setAttribute(ViewKeyEnums.EXITO.name(), "Se ha actualizao exitosamente el producto id:" + nuevoProducto.getId());
			
			//recargo la lista de productos
			Collection<Producto> productos = ps.findAll();
			request.setAttribute(ViewKeyEnums.LISTADO.name(), productos);

			Double suma = productos.stream()
					.map(p -> p.getPrecio())
					.reduce(0D, (Double x, Double y) -> x+y);
				
			addAttribute(request, ViewKeyEnums.TOTAL, suma);

		} catch (ServiceException | RuntimeException e) {
			request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), e.getMessage());
			target = ViewEnums.EDITAR_PRODUCTO;
			
			//recargar el producto
			addAttribute(request, ViewKeyEnums.PRODUCTO_EDITAR, nuevoProducto);
		}
		
		//redireccion
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
