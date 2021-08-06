package ar.com.educacionit.web.enums;

public enum CategoriaKeyEnum implements Enumerable{

	LIST_CATEGORIAS("categorias"), 
	CATEGORIAS_ID("categoriasId"), 
	TIPO_BUSQUEDA("tipoBusqueda");
	
	private String viewKey;
	
	private CategoriaKeyEnum(String viewKey) {
		this.viewKey = viewKey;
	}

	public String getViewKey() {
		return viewKey;
	}

	@Override
	public String getKey() {
		return this.name();
	}
}
