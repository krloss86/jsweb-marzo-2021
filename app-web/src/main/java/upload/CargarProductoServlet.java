package upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.exceptions.ServiceException;
import ar.com.educacionit.web.enums.ViewEnums;
import ar.com.educacionit.web.enums.ViewKeyEnums;
import ar.com.educacionit.web.servlet.BaseServlet;
@WebServlet("/controllers/CargarProductosServlet")
public class CargarProductoServlet extends BaseServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Collection<Producto> productosEnSesion = (Collection<Producto>)request.getSession().getAttribute(ViewKeyEnums.UPLOAD_PREVIEW_KEY.name());
		
		//grabar en db
		
		// ok
		Collection<Producto> productosOk = new ArrayList<Producto>();
		// fail
		Collection<Producto> productosFail = new ArrayList<Producto>();
		
		if(productosEnSesion != null) {
			
			for(Producto aux : productosEnSesion) {
				try {
					Producto producto = ps.nuevoProducto(aux);
					productosOk.add(producto);
				} catch (ServiceException e) {
					productosFail.add(aux);
				}
			}
		}
		
		//lista de fallidos en sesion
		addAttribute(request.getSession(), ViewKeyEnums.LISTADO_FAIL, productosFail);
		
		//lista de ok en request
		addAttribute(request, ViewKeyEnums.LISTADO_OK, productosOk);
		
		redirect(ViewEnums.RESULTADO_PREVIEW, request, response);
	}
}
