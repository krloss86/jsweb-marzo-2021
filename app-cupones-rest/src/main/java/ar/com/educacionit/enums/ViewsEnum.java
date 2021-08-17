package ar.com.educacionit.enums;

public enum ViewsEnum {
	LISTADO("cupones/list"),
	LISTADO_REDIRECT("redirect:/cupon/list"),
	EDITAR("cupones/edit"),
	NEW("cupones/new"),
	INDEX("index"), 
	;

	private String view;

	private ViewsEnum(String view) {
		this.view = view;
	}

	public String toString() {
		return this.view;
	}
}
