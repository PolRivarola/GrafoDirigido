package grafo;

import java.util.List;
import java.util.LinkedList;

public class Nodo implements Comparable<Nodo> {
	public String name;
	public List<Arista> adjacente;
	public int dist;
	public Nodo prev;
	
	public Nodo(String nm)   {
		name = nm;
		adjacente = new LinkedList<Arista>();
		reset();
		
	}
	
	public int compareTo(Nodo other) {
	    return Integer.compare(this.dist, other.dist);
	}
	
	public void reset() {
		dist = -1;
	}
}
