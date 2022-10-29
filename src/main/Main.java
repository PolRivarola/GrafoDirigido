package main;
import java.util.*;

import grafo.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		Grafo grafo = new Grafo();
		
		
		
		System.out.println("Creador de grafo");
		System.out.println("Que desea hacer");
		int opc = -1;
		do {
			System.out.println("1- Buscar nodo(de no ser encontrado se creara un nodo nuevo)");
			System.out.println("0- Salir");
			opc = s.nextInt();
			s.nextLine();
			if(opc==1) {
				System.out.println("Nombre del nodo a buscar/crear");
				String n = s.nextLine();
				grafo.getNodo(n);
			}
			
			grafo.seeGraph();
			
		}while(opc != 0);
		System.out.println("Adios!");
		s.close();
		
		
	}
}
