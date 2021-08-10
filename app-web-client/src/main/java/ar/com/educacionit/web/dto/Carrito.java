package ar.com.educacionit.web.dto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.com.educacionit.domain.dto.ItemCarrito;

public class Carrito {

	Map<Long, ItemCarrito> items;
	
	public Carrito() {
		this.items = new HashMap<Long, ItemCarrito>();
	}
	
	public void add(ItemCarrito item) {
		ItemCarrito itemActual = null;
		if(this.items.containsKey(item.getId())) {
			itemActual = this.items.get(item.getId());
			
			if(item.getCantidad() < 0) {
				itemActual.setCantidad(0);
			}else if(itemActual.getCantidad()+item.getCantidad() > 999) {
				itemActual.setCantidad(999);;
			}else {
				itemActual.actualizarCantidad(item.getCantidad());
			}
		}else {
			itemActual = item;
		}
		this.items.put(itemActual.getId(), itemActual);
	}
	
	public void update(Long id, Integer cantidad) {
		ItemCarrito itemActual = null;
		if(this.items.containsKey(id)) {
			itemActual = this.items.get(id);
			
			if(cantidad < 0) {
				itemActual.setCantidad(0);
			}else if(itemActual.getCantidad()+cantidad > 999) {
				itemActual.setCantidad(999);;
			}else {
				itemActual.setCantidad(cantidad);
			}
			this.items.put(itemActual.getId(), itemActual);
		}
	}
	
	public void remove(Long id) {
		this.items.remove(id);
	}
	
	public void clear() {
		this.items.clear();
	}
	
	public Collection<ItemCarrito> getItems(){
		return this.items.values();
	}
	
	public Double getTotal() {
		return this.items.values().stream()
		.map(item -> item.getPrecio())
		.reduce(0D, (x,y) -> x+y);		
	}
}
