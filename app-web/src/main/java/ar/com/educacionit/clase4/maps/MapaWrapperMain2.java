package ar.com.educacionit.clase4.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapaWrapperMain2 {

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

		//System.out.println(diasSemana);
		
		//obtener las claves del mapa
		Set<Integer> claves = diasSemana.keySet();
		
		//ahora recorro el mapa sabiendo sus claves
		for(Integer clave : claves) {
			String valor = diasSemana.get(clave);
			
			System.out.println("clave:" + clave + " - valor: " +valor );
			
			diasSemana.put(clave, valor+" - Updated");
		}
		
		System.out.println(diasSemana);
	}

}
