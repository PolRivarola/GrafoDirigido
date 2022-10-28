package grafo;

import java.util.List;
import java.util.LinkedList;

public class Nodo {
	public String name;
	public List<Arista> adjacente;
	public double dist;
	public Nodo prev;
	
	public Nodo(String nm) {
		name = nm;
		adjacente = new LinkedList<Arista>();
		reset();
		
	}
	
	public void reset() {
		dist = Grafo.INFINITY;
	}
}
