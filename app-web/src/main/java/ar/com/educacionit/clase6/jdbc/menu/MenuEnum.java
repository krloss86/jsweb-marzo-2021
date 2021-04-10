package ar.com.educacionit.clase6.jdbc.menu;

public enum MenuEnum {

	CREAR(1),
	BUSCAR_POR_ID(2),
	BUSCAR_POR_CODIGO(3),
	ACTUALIZAR(4),
	ELIMINAR_POR_ID(5),
	ELIMINAR_POR_CODIGO(6),
	LISTAR_TODOS(7),
	BUSCAR_POR_TITULO(8);
	
	private Integer opcion;
	
	private MenuEnum(Integer opcion) {
		this.opcion = opcion;
	}

	public Integer getOpcion() {
		return opcion;
	}
	
	public static MenuEnum getByCodigo(Integer opcion ) {
		//int  -> existe el enum?
		MenuEnum menu = null;
		MenuEnum[] enums = MenuEnum.values();
		for(MenuEnum unEnum : enums ) {
			if(unEnum.getOpcion().equals(opcion)) {
				menu = unEnum;
				break;
			}
		}		
		return menu;
	}
}
