package ar.com.educacionit.web.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.services.ArticulosService;
import ar.com.educacionit.services.CategoriasService;
import ar.com.educacionit.services.MarcasService;
import ar.com.educacionit.services.impl.ArticuloServiceImpl;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.MarcasServiceImpl;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;

@WebServlet("/controllers/NuevoProductoServlet")
public class NuevoProductoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private CategoriasService cs = new CategoriaServiceImpl();
	
	private MarcasService ms = new MarcasServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//capturar los datos que envia la jsp
		String codigo = request.getParameter("codigo");
		String titulo = request.getParameter("titulo");
		String precio = request.getParameter("precio");
//		String tipoProducto = request.getParameter("tipoProducto");
		String categoriaId = request.getParameter("categoriasId");
		String marcasId = request.getParameter("marcasId");
		String stock = request.getParameter("stock");

		ViewEnums target = ViewEnums.LISTADO_GENERAL;
		
		try {
			
			Double precioF = Double.parseDouble(precio);
			Long categroiasIdL = Long.parseLong(categoriaId);
			Long marcasIdL = Long.parseLong(marcasId);
			Long stockL = Long.parseLong(stock);

			Articulos nuevoArticulo = new Articulos( titulo, codigo, precioF, stockL,marcasIdL,categroiasIdL);

			//Producto nuevoProducto = new Producto(titulo, precioF, codigo, tipoProductoL);
			
			ArticulosService ps = new ArticuloServiceImpl();
			
			ps.save(nuevoArticulo);
			request.setAttribute(ViewKeyEnums.EXITO.name(), "Se ha dado de alta exitosamente el producto id:" + nuevoArticulo.getId());
			
			//recargo la lista de productos
			Collection<Articulos> productos = ps.findAll();
			request.setAttribute(ViewKeyEnums.LISTADO.name(), productos);
			Double suma = productos.stream()
					.map(p -> p.getPrecio())
					.reduce(0D, (Double x, Double y) -> x+y);
				
			addAttribute(request, ViewKeyEnums.TOTAL, suma);

		} catch (ServiceException | RuntimeException e) {
			request.setAttribute(ViewKeyEnums.ERROR_GENERAL.name(), "Verifique los datos ingresados: " + e.getMessage());
			target = ViewEnums.NUEVO_PRODUCTO;
		}
		
		cargarCombos(request);
				
		//redireccion
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		cargarCombos(request);
		
		ViewEnums target = ViewEnums.NUEVO_PRODUCTO;
		
		getServletContext().getRequestDispatcher(target.getView()).forward(request, response);
	}

	private void cargarCombos(HttpServletRequest request) throws IOException {
		try {
			request.setAttribute("categorias",cs.findAll());
			request.setAttribute("marcas",ms.findAll());
		}catch (Exception e) {
			throw new IOException(e.getMessage(),e);
		}
	}

}
