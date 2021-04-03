package ar.com.educacionit.clase5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueMain {

	public static void main(String[] args) {
		
		LinkedList<String> nombres = new LinkedList<>();
		
		nombres.add("carlos"); //collection
		
		//metodos propios de la Queue
		nombres.offer("Sergio");
		
		//boolean added = ((LinkedList<String>)nombres).offerFirst("Francisco");
		nombres.offerFirst("Francisco");
		
		System.out.println("La fila está compúesta por:" + nombres);
		while(!nombres.isEmpty()) {
			String siguienteNombre = nombres.peek();
			System.out.println("El siguiente es:" + siguienteNombre);
			
			siguienteNombre = nombres.poll();
			System.out.println(siguienteNombre + " atendido!");
		}
		
		System.out.println("Fila vacía!");
	}

}
