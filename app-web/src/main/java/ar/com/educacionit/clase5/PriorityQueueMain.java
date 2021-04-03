package ar.com.educacionit.clase5;

import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueMain {

	public static void main(String[] args) {
		
		//wrapper!! 
		PriorityQueue<Cliente> clientes = new PriorityQueue<>();
		
		System.out.println("Ingrese la cantidad de clientes:");
		Scanner teclado = new Scanner(System.in);
		
		Integer cantidad = teclado.nextInt();
		
		System.out.println("Hay " + clientes.size() + " clientes");
		for(int i=0;i<cantidad;i++) {
			
			System.out.println("Ingrese nombre:");
			String nombre = teclado.next();
			
			System.out.println("Ingrese edad:");
			Integer edad = teclado.nextInt();
			
			Long id = Long.parseLong(""+i);
			
			Cliente cliente = new Cliente(id, nombre, edad, (i==2));
			clientes.offer(cliente);			
		}
		
		System.out.println(clientes);
		
		while(!clientes.isEmpty()) {
			Cliente cliente = clientes.poll();
			System.out.println(cliente);
		}
		
		teclado.close();
	}

}
