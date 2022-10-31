package grafo;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Nodo implements Comparable<Nodo> {
	public String name;
	public List<Arista> adjacente;
	public List<String> filaNoC;
	public int dist;
	public Nodo prev;
	private boolean beingVisited;
	private boolean visited;
	
	public Nodo(String nm)   {
		name = nm;
		adjacente = new LinkedList<Arista>();
		filaNoC = new LinkedList<String>();
		reset();
		
	}
	
	public int compareTo(Nodo other) {
	    return Integer.compare(this.dist, other.dist);
	}
	
	public void reset() {
		dist = -1;
	}

	public boolean isBeingVisited() {
		return beingVisited;
	}

	public void setBeingVisited(boolean beingVisited) {
		this.beingVisited = beingVisited;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
}
