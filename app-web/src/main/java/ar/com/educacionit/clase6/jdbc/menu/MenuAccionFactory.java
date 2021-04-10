package ar.com.educacionit.clase6.jdbc.menu;

import java.util.HashMap;
import java.util.Map;

public class MenuAccionFactory {

	static Map<MenuEnum, IAccion> mapMenuAccion;
	
	static {
		mapMenuAccion = new HashMap<>();
		
		mapMenuAccion.put(MenuEnum.CREAR, new Crear());
		mapMenuAccion.put(MenuEnum.BUSCAR_POR_ID, new BuscarPorID());
		mapMenuAccion.put(MenuEnum.BUSCAR_POR_CODIGO, new BuscarPorCodigo());
		mapMenuAccion.put(MenuEnum.ACTUALIZAR, new UpdateProducto());
		mapMenuAccion.put(MenuEnum.ELIMINAR_POR_ID, new DeletePorID());
		mapMenuAccion.put(MenuEnum.ELIMINAR_POR_CODIGO, new DeletePorCodigo());
		mapMenuAccion.put(MenuEnum.LISTAR_TODOS, new ListarTodos());
		mapMenuAccion.put(MenuEnum.BUSCAR_POR_TITULO, new ListarPorTitulo());
	}
	
	public static IAccion getIAccion(MenuEnum menuEnum) {
		IAccion accion = null;
		if(mapMenuAccion.containsKey(menuEnum)) {
			accion = mapMenuAccion.get(menuEnum);
		}
		return accion;
	}

}
