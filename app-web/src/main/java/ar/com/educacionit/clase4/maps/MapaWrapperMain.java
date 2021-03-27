package ar.com.educacionit.clase4.maps;

import java.util.HashMap;
import java.util.Map;

public class MapaWrapperMain {

	public static void main(String[] args) {
		
		//crea
		Map<Integer, String> diasSemana = new HashMap<>();
		
		//carga
		diasSemana.put(1, "Lunes");
		diasSemana.put(2, "Martes");
		diasSemana.put(2, "Martes");//NO PUEDO AGREGAR DUPLICADOS POR CLAVE
		diasSemana.put(3, "Miercoles");
		diasSemana.put(4, "Jueves");
		diasSemana.put(5, "Viernes");
		diasSemana.put(6, "Sabado");
		diasSemana.put(7, "Domingo");

		System.out.println(diasSemana);
		
		//obtener dia de la semana
		//get()
		
		//contains -> boolean
		if(diasSemana.containsKey(5)) { 
			String dia = diasSemana.get(5);			
			System.out.println(dia);
		}
		
		//eliminar elementos de un mapa
		String diaEliminado = diasSemana.remove(7);
		
		//eliminar por clave y valor
		boolean diaEliminadoPorClaveYValor = diasSemana.remove(4, "Jueves");
		
		System.out.println(diasSemana);
	}

}
