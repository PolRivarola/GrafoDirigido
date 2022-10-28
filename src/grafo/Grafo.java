package grafo;

import java.util.HashMap;
import java.util.Map;

public class Grafo {
	
	private Map<String, Nodo>NodoMap = new HashMap<String,Nodo>();
	
	
	public Nodo getNodo(String NodoName) {
		Nodo n = NodoMap.get(NodoName);
		if(n == null) {
			n = new Nodo(NodoName);
			NodoMap.put(NodoName,n);
		}
		return n;
	}
	
	
	
	public void agregarArista(String nomOri, String nomDest, double cost) {
		Nodo v = getNodo(nomOri);
		Nodo w = getNodo(nomDest);
		v.adjacente.add(new Arista(w,cost));
		
	
		
	}
}
