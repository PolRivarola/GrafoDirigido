package main;
import grafo.*;


public class Main {

	public static void main(String[] args) {
		
		
		Grafo grafo = new Grafo();
		String[] nodos = {"d1","d2","d3","d4","d5","d6","d7","d8","d9","d10","d11","d12","d13"};
		
		
		
		System.out.println("Creador de grafo");
		
		grafo.addNodo(nodos[0], nodos[1], 200);
		grafo.addNodo(nodos[0], nodos[12], 250);
		grafo.addNodo(nodos[0], nodos[8], 290);
		grafo.addNodo(nodos[1], nodos[5], 360);
		grafo.addNodo(nodos[1], nodos[2], 190);
		grafo.addNodo(nodos[2], nodos[5], 250);
		grafo.addNodo(nodos[2], nodos[4], 190);
		grafo.addNodo(nodos[2], nodos[0], 300);
		grafo.addNodo(nodos[3], nodos[2], 180);
		grafo.addNodo(nodos[4], nodos[5], 300);
		grafo.addNodo(nodos[4], nodos[9], 400);
		grafo.addNodo(nodos[5], nodos[10], 350);
		grafo.addNodo(nodos[5], nodos[11], 300);
		grafo.addNodo(nodos[6], nodos[3], 300);
		grafo.addNodo(nodos[6], nodos[2], 250);
		grafo.addNodo(nodos[6], nodos[0], 150);
		grafo.addNodo(nodos[7], nodos[6], 200);
		grafo.addNodo(nodos[7], nodos[0], 220);
		grafo.addNodo(nodos[8], nodos[7], 180);
		grafo.addNodo(nodos[8], nodos[12], 180);
		grafo.addNodo(nodos[9], nodos[3], 200);
		grafo.addNodo(nodos[10], nodos[9], 700);
		grafo.addNodo(nodos[10], nodos[4], 200);
		grafo.addNodo(nodos[11], nodos[1], 150);
		grafo.addNodo(nodos[12], nodos[11], 100);
		grafo.addNodo(nodos[12], nodos[1], 200);

		grafo.seeGraph();
		grafo.dijkstra("d12", "d5");

		grafo.BFS("d12","d5");
	
		
		
	}
}
