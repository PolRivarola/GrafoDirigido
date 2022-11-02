package main;

import java.util.Scanner;

import arbol.BinaryTree;
import grafo.*;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Grafo grafo = new Grafo();
		String[] nodos = { "d1", "d2", "d3", "d4", "d5", "d6", "d7", "d8", "d9", "d10", "d11", "d12", "d13" };
		int opc, opcTree = -1;

		do {
			System.out.println("1- Crear el grafo\r\n" + "");
			System.out.println("2- Crear el arbol\r\n" + "");
			System.out.println("0- Salir\r\n" + "");
			System.out.println("Ingrese opción:");
			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {

			case 1:
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

				int opcGraph = -1;

				do {
					System.out.println("1- Mostrar el grafo\r\n" + "");
					System.out.println("2- Calcular camino minimo sin pesos entre dos nodos\r\n" + "");
					System.out.println("3- Calcular camino minimo ponderado entre dos nodos\r\n" + "");
					System.out.println("4- Calcular los grafos acíclicos del grafo\r\n" + "");
					System.out.println("0- Salir\r\n" + "");
					System.out.println("Ingrese opción:");
					opcGraph = sc.nextInt();
					sc.nextLine();
					switch (opcGraph) {
					case 1:
						grafo.seeGraph();
						break;
					case 2:
						grafo.BFS();
						break;
					case 3:
						grafo.dijkstra();
						break;
					case 4:
						System.out.println();
						System.out.println("Esta es una lista de grafos aciclicos contenidos en este grafo");

						grafo.searchGraphs();
						break;
					case 0:
						
						System.out.println("Saliendo..");
						break;
					default:
						System.out.println("Ingrese una opcion válida");
						break;
					}
				} while (opcGraph != 0);
				break;

			case 2:

				BinaryTree btn = new BinaryTree();

				btn.add(6);
				btn.add(4);
				btn.add(8);
				btn.add(3);
				btn.add(5);
				btn.add(7);
				btn.add(9);

				do {
					System.out.println("1- Recorrer el arbol en PreOrder");
					System.out.println("2- Recorrer el arbol en InOrder");
					System.out.println("3- Recorrer el arbol en PostOrder");
					System.out.println("4- Agregar un nodo");
					System.out.println("5- Eliminar un nodo");
					System.out.println("0- Salir\r\n" + "");

					opcTree = sc.nextInt();
					sc.nextLine();
					switch (opcTree) {
					case 1:
						btn.traversePreOrder(BinaryTree.getRoot());
						break;
					case 2:
						btn.traverseInOrder(BinaryTree.getRoot());
						break;
					case 3:
						btn.traversePostOrder(BinaryTree.getRoot());
						break;
					case 4:
						System.out.println("En caso de ingresar nodos preexistentes no se generaran cambios...");
						System.out.println("Ingrese nodo a agregar:");
						int value = sc.nextInt();
						sc.nextLine();
						btn.add(value);
						break;
					case 5:
						System.out.println("Que nodo desea eliminar?");
						int chc = sc.nextInt();
						btn.delete(chc);
						break;
					case 0:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Ingrese una opcion válida");
						break;
					}

				} while (opcTree != 0);
				break;

			case 0:
			
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Ingrese una opcion válida");
				break;
			}

		} while (opc != 0);

	}
}
