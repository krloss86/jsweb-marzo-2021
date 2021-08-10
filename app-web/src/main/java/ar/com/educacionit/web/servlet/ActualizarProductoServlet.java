package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
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
		String categoriaId = request.getParameter("categoriasId");
		String marcasId = request.getParameter("marcasId");
		String stock = request.getParameter("stock");
		
		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		Articulos nuevoArticulo = null;
		try {
			
			Long idLong = Long.parseLong(id);
			Double precioF = Double.parseDouble(precio);
			Long categroiasIdL = Long.parseLong(categoriaId);
			Long marcasIdL = Long.parseLong(marcasId);
			Long stockL = Long.parseLong(stock);
			
			nuevoArticulo = new Articulos(idLong, titulo, codigo, precioF, stockL,marcasIdL,categroiasIdL);
			
			super.ps.update(nuevoArticulo);
			request.setAttribute(ViewKeyEnums.EXITO.name(), "Se ha actualizao exitosamente el producto id:" + nuevoArticulo.getId());
			
			//recargo la lista de productos
			Collection<Articulos> productos = ps.findAll();
			request.setAttribute(ViewKeyEnums.LISTADO.name(), productos);

			Double suma = productos.stream()
					.map(p -> p.getPrecio())
					.reduce(0D, (Double x, Double y) -> x+y);
				
			addAttribute(request, ViewKeyEnums.TOTAL, suma);

		} catch (ServiceException | RuntimeException e) {
			request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), e.getMessage());
			target = ViewEnums.EDITAR_PRODUCTO;
			
			//recargar el producto
			addAttribute(request, ViewKeyEnums.PRODUCTO_EDITAR, nuevoArticulo);
		}
		
		//redireccion
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
