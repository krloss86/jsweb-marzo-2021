package ar.com.educacionit.clase4.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapaWrapperMain3 {

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

		Set<Map.Entry<Integer,String>> entries = diasSemana.entrySet();
		
		//recorrer con un iterador
		Iterator<Map.Entry<Integer,String>> itEntries = entries.iterator();
		while(itEntries.hasNext()) {
			Map.Entry<Integer,String> unEntry = itEntries.next();
			Integer clave = unEntry.getKey();
			String valor = unEntry.getValue();
			System.out.println(clave + " - "+ valor);
			if(clave == 5) {
				itEntries.remove();
			}
		}
		
		System.out.println(diasSemana);
	}

}
