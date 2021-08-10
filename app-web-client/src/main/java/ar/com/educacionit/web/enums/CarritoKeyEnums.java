package ar.com.educacionit.web.enums;

public enum CarritoKeyEnums implements Enumerable{
	
	CANTIDAD("cantidad"),
	CARRITO("carrito"), 
	ID("id"),
	PAISES("paises"),
	DATOS_CHECKOUT("datos_checkout"), 
	MEDIOS_PAGOS("medios_pagos"),
	
	MEDIO_PAGO("medioPago"), 
	ID_ORDEN_GENERADA("ID_ORDEN_GENERADA")	
	;
	
	private String viewKey;
	
	private CarritoKeyEnums(String viewKey) {
		this.viewKey = viewKey;
	}

	@Override
	public String getKey() {
		return this.viewKey;
	}

	
}
