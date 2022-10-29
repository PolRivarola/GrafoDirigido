package grafo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Grafo {
	
	private Map<String, Nodo>NodoMap = new HashMap<String,Nodo>();
	Scanner s = new Scanner(System.in);

	
	public Nodo getNodo(String NodoName) {
		Nodo n = NodoMap.get(NodoName);
		if(n == null) {
			n = new Nodo(NodoName);
			NodoMap.put(NodoName,n);
			System.out.println("Nodo no encontrado... nuevo nodo creado");
			if(NodoMap.size() != 1) {
			System.out.println("Hacia que nodo apunta este nuevo nodo?");
			String nodoDest = s.nextLine();
			while(nodoExist(nodoDest) != true) {
				System.out.println("Cual es el costo de esta arista?");
				double cost = s.nextInt();
				agregarArista(NodoName, nodoDest, cost);
			}}
		}
		return n;
	}
	
	public boolean nodoExist(String name) {
		Nodo nodo = NodoMap.get(name);
		if(nodo == null) {
			System.out.println("Este nodo no existe, intentelo de nuevo");
			return false;
		}
		return true;
		
	}
	
	public void seeGraph() {
		if(NodoMap != null) {
			for(Map.Entry<String, Nodo> entry : NodoMap.entrySet()) {
				System.out.println("Vertice: " + entry.getKey());
			}
		} else {
			System.out.println("No existen vertices ni aristas en este nodo");
		}
	}
	
	public void agregarArista(String nomOri, String nomDest, double cost) {
		Nodo v = getNodo(nomOri);
		Nodo w = getNodo(nomDest);
		v.adjacente.add(new Arista(w,cost));
		
	
		
	}
}
