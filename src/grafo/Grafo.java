package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;

public class Grafo   {
	
	private Map<String, Nodo>NodoMap = new HashMap<String,Nodo>();
	Scanner s = new Scanner(System.in);

	
	public Nodo getNodo(String NodoName) {
		Nodo n = NodoMap.get(NodoName);
		return n;
	}
	
	public void addNodo(String NodoName,String NodoName2, int cost) {
		Nodo n = NodoMap.get(NodoName);
		Nodo m = NodoMap.get(NodoName2);
		if(n == null) {
			n = new Nodo(NodoName);
			NodoMap.put(NodoName,n);
			System.out.println("Nodo: "+ NodoName +" no encontrado... nuevo nodo creado");
		}
		if(m == null) {
			n = new Nodo(NodoName2);
			NodoMap.put(NodoName2,n);
			System.out.println("Nodo: "+ NodoName2 +" no encontrado... nuevo nodo creado");
		}	
		agregarArista(NodoName, NodoName2, cost);
		
			
	}

	
	
	public void searchGraphs() {
		for (Nodo value1 : NodoMap.values()) {
			for (Nodo value2 : NodoMap.values()) {
			    printAllPaths(value1, value2);
			}
			clearAll();
		}
	}
	
	
	public void seeGraph() {
		if(NodoMap != null) {
			for(Map.Entry<String, Nodo> entry : NodoMap.entrySet()) {
				System.out.println("Nodo: " + entry.getKey());
				for (Arista e : entry.getValue().adjacente) {
					System.out.println("  -Apunta a: "+ e.destino.name + "(" + e.costo +")");
				}
			}
		} else {
			System.out.println("No existen vertices ni aristas en este grafo");
		}
	}
	
	
	public void dijkstra(String startName, String destino) {
		clearAll();
		Nodo start = NodoMap.get(startName);
		Nodo end = NodoMap.get(destino);

		start.dist = 0;
		
		Queue<Nodo> pq = new LinkedList<Nodo>();
		
		pq.add(start);
		while(!pq.isEmpty() ) {
			Nodo v = pq.remove();
			for(Arista e : v.adjacente) {
			Nodo w = e.destino;
			int cVW = e.costo;

		
			if( w.dist == -1) {

				w.dist = v.dist + cVW;
				w.prev = v;
				pq.add(w);}
			else if (w.dist > v.dist + cVW) {
				w.dist = v.dist + cVW;
				w.prev = v;
				pq.add(w);
				}
			
			
			}
		}
		if (end.dist != -1) {
			System.out.println("La suma de los pesos del camino mas corto entre " + startName+ " y " + end.name + " es: " + end.dist);
		}else System.out.println("No hay camino entre estos nodos");
	}
	
	public void BFS(String startName, String destino) {
		clearAll();
		Nodo start = NodoMap.get(startName);
		Nodo end = NodoMap.get(destino);

		
		Queue<Nodo> q = new LinkedList<Nodo>();
		q.add(start);
		start.dist = 0;
		
		while (!q.isEmpty()) {
			Nodo v = q.remove();
			
			for( Arista e : v.adjacente) {
				Nodo w = e.destino;
				if (w.dist == -1) {
					w.dist = v.dist + 1;
					w.prev = v;
					q.add(w);
				}
			}
		}
		if (end.dist != -1) {
			System.out.println("La distancia entre " + startName+ " y " + end.name + " es: " + end.dist);
		}else System.out.println("No hay camino entre estos nodos");
	}
	
	private void clearAll() {
		for (Entry<String, Nodo> e : NodoMap.entrySet()) {
			e.getValue().dist = -1;
			e.getValue().setVisited(false);
			}  
	}
	
	// Prints all paths from
    // 's' to 'd'
    public void printAllPaths(Nodo s, Nodo d)
    {
        ArrayList<String> pathList = new ArrayList<>();
 
        // add source to path[]
        pathList.add(s.name);
 
        // Call recursive utility
        printAllPathsUtil(s, d, pathList);
    }
 
    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private void printAllPathsUtil(Nodo u, Nodo d,
                                   
                                   List<String> localPathList)
    {
 
        if (u.equals(d)) {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            return;
        }
 
        // Mark the current node
        u.setVisited(true); 
 
        // Recur for all the vertices
        // adjacent to current vertex
        for (Arista i : u.adjacente) {
            if (!i.destino.isVisited()) {
                // store current node
                // in path[]
                localPathList.add(i.destino.name);
                printAllPathsUtil(i.destino, d, localPathList);
 
                // remove current node
                // in path[]
                localPathList.remove(i.destino.name);
            }
        }
 
        // Mark the current node
        u.setVisited(true);
    }
	
	
	public boolean hasCycle(Nodo sourceNodo) {
		
	    sourceNodo.setBeingVisited(true);
	    sourceNodo.filaNoC.add(sourceNodo.name);

	    for (Arista neighbor : sourceNodo.adjacente) {
	        if (neighbor.destino.isBeingVisited()) {
	        	
	        	sourceNodo.filaNoC.forEach(System.out::print);;
	        	System.out.print(" ");
	        	
	        	sourceNodo.filaNoC.clear();;
	        

	            return true;
	        } else if (!neighbor.destino.isVisited() && hasCycle(neighbor.destino)) {
	        
	        	sourceNodo.filaNoC.forEach(System.out::print);;
	        	System.out.print(" ");
	        	sourceNodo.filaNoC.clear();;
	        	return true;
	        }
	    }

	    sourceNodo.setBeingVisited(false);
	    sourceNodo.setVisited(true);
	    System.out.println();
	    return false;
	}
	
	public void agregarArista(String nomOri, String nomDest, int cost) {
		Nodo v = getNodo(nomOri);
		Nodo w = getNodo(nomDest);
		v.adjacente.add(new Arista(w,cost));
		
	
		
	}
}
