package ar.com.educacionit.clase3;

public class BuscadorMain {

	public static void main(String[] args) {
		
		//instancio un buscador
		Buscador miBuscador = new Buscador();
		
		miBuscador.setClaveBusqueda("iron man");
		
		//ejecutar el metodo buscar
		miBuscador.buscar();
				
		System.out.println("Hemos Encontrado "+miBuscador.getCantidadResultados()+ " Resultados Para '"+miBuscador.getClaveBusqueda()+"'");
		
		if(miBuscador.hayResultados()) {
		
			Articulo[] articulos = miBuscador.getResultados();
		
			//recorrer los articulos y presentarlos en consola
			for(Articulo articulo : articulos) {
				//polimorfismo: 
				articulo.display();
				System.err.println("-------------");
			}
		}
	}

}
