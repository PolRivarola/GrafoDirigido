package grafo;

public class Arista {
	public Nodo destiny;
	public int cost;
	
	public Arista( Nodo d, int c) {
		destiny = d;
		cost = c;
	}
}
