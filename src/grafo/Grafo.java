package grafo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Grafo {

	private Map<String, Nodo> NodoMap = new HashMap<String, Nodo>();
	Scanner sc = new Scanner(System.in);
	
	public Nodo getNodo(String NodoName) {
		Nodo n = NodoMap.get(NodoName);
		return n;
	}

	public void addNodo(String NodoName, String NodoName2, int cost) {
		Nodo n = NodoMap.get(NodoName);
		Nodo m = NodoMap.get(NodoName2);
		if (n == null) {
			n = new Nodo(NodoName);
			NodoMap.put(NodoName, n);
			System.out.println("Nodo: " + NodoName + " no encontrado... nuevo nodo creado");
		}
		if (m == null) {
			n = new Nodo(NodoName2);
			NodoMap.put(NodoName2, n);
			System.out.println("Nodo: " + NodoName2 + " no encontrado... nuevo nodo creado");
		}
		addArista(NodoName, NodoName2, cost);

	}

	public void searchGraphs() {
		for (Nodo value1 : NodoMap.values()) {
			for (Nodo value2 : NodoMap.values()) {
				clearAll();
				if (value2 != value1) {
					AllPaths(value1, value2);
				}

			}
		}
	}

	public void seeGraph() {
		if (NodoMap != null) {
			for (Map.Entry<String, Nodo> entry : NodoMap.entrySet()) {
				System.out.println("Nodo: " + entry.getKey());
				for (Arista e : entry.getValue().adjacente) {
					System.out.println("  -Apunta a: " + e.destiny.name + "(" + e.cost + ")");
				}
			}
		} else {
			System.out.println("No existen nodos ni arcos en este grafo");
		}
	}

	public void dijkstra() {
		Nodo start = null;
		Nodo end = null;
		String startName = "";
		String destino = "";
		
		clearAll();
		
		while(start == null || end == null) {
			System.out.println("Ingrese primer nodo");
			startName = sc.nextLine();
			System.out.println("Ingrese segundo nodo");
			destino = sc.nextLine();
			start = NodoMap.get(startName);
			end = NodoMap.get(destino);
			if(start == null || end == null) {
				 System.out.println("Ingrese nodos existentes porfavor!");
				 
			}
		}
		start.dist = 0;

		Queue<Nodo> pq = new LinkedList<Nodo>();

		pq.add(start);
		while (!pq.isEmpty()) {
			Nodo v = pq.remove();
			for (Arista e : v.adjacente) {
				Nodo w = e.destiny;
				int cVW = e.cost;

				if (w.dist == -1) {

					w.dist = v.dist + cVW;
					w.prev = v;
					pq.add(w);
				} else if (w.dist > v.dist + cVW) {
					w.dist = v.dist + cVW;
					w.prev = v;
					pq.add(w);
				}

			}
		}
		if (end.dist != -1) {
			System.out.println("La suma de los pesos del camino mas corto entre " + startName + " y " + end.name
					+ " es: " + end.dist);
		} else
			System.out.println("No hay camino entre estos nodos");
	}

	 private Stack<String> path  = new Stack<String>();  
	    private Set<String> onPath  = new HashSet<String>();    
	    public void AllPaths(Nodo G, Nodo T) {
	        enumerate(G,T);
	    }

	    // use DFS
	    public void enumerate(Nodo G, Nodo T) {

	        path.push(G.name);
	        onPath.add(G.name);

	        if (G.name.equals(T.name))
	            System.out.println(path);

	        else {
	            for (Arista w : G.adjacente) {
	                if (!onPath.contains(w.destiny.name)) enumerate(w.destiny,T);
	            }
	        }

	        path.pop();
	        onPath.remove(G.name);
	    }
	
	
	public void BFS() {
		Nodo start = null;
		Nodo end = null;
		String startName = "";
		String destino = "";
		
		clearAll();
		
		while(start == null || end == null) {
			System.out.println("Ingrese primer nodo");
			startName = sc.nextLine();
			System.out.println("Ingrese segundo nodo");
			destino = sc.nextLine();
			start = NodoMap.get(startName);
			end = NodoMap.get(destino);
			if(start == null || end == null) {
				 System.out.println("Ingrese nodos existentes porfavor!");
				 
			}
		}
		

		
		Queue<Nodo> q = new LinkedList<Nodo>();
		q.add(start);
		start.dist = 0;

		while (!q.isEmpty()) {
			Nodo v = q.remove();

			for (Arista e : v.adjacente) {
				Nodo w = e.destiny;
				if (w.dist == -1) {
					w.dist = v.dist + 1;
					w.prev = v;
					q.add(w);
				}
			}
		}
		if (end.dist != -1) {
			System.out.println("La distancia entre " + startName + " y " + end.name + " es: " + end.dist);
		} else
			System.out.println("No hay camino entre estos nodos");
	}

	private void clearAll() {
		for (Entry<String, Nodo> e : NodoMap.entrySet()) {
			e.getValue().dist = -1;
		}
	}


	public void addArista(String nomOri, String nomDest, int cost) {
		Nodo v = getNodo(nomOri);
		Nodo w = getNodo(nomDest);
		v.adjacente.add(new Arista(w, cost));

	}
}
