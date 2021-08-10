package ar.com.educacionit.web.enums;

public enum ViewEnums {

	LOGIN("/login.jsp"),
	LOGIN_SUCCESS("/secure/profile.jsp"),
	LISTADO_GENERAL("/listadoGeneral.jsp"),  
	
	LISTADO_CATEGORIAS_INDEX("/categorias.jsp"),
	DETALLE_ARTICULO("/detalleArticulos.jsp"),
	CARRITO("/shoppingCart.jsp"),
	CHECKOUT("/secure/checkout.jsp"),
	CHECKOUT_SUCCESS("/secure/checkoutSuccess.jsp"),
	ORDER_DETAILS("/secure/orderDetails.jsp"), 
	ORDENES("/secure/orders.jsp")
	;
	
	private String view;
	
	//ctrl+spce
	private ViewEnums(String view) {
		this.view = view;
	}
	
	public String getView() {
		return this.view;
	}
}
