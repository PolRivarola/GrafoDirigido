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
			System.out.println("Oprima [1] si desea crear el grafo\r\n" + "");
			System.out.println("Oprima [2] si desea crear el arbol\r\n" + "");
			System.out.println("Oprima [0] si desea salir\r\n" + "");
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

				grafo.seeGraph();
				grafo.dijkstra("d9", "d5");
				grafo.BFS("d9", "d5");
				System.out.println();
				System.out.println("Esta es una lista de grafos aciclicos contenidos en este grafo");

				grafo.searchGraphs();
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
					System.out.println("Oprima [1] si desea recorrer el arbol en PreOrder");
					System.out.println("Oprima [2] si desea recorrer el arbol en InOrder");
					System.out.println("Oprima [3] si desea recorrer el arbol en PostOrder");
					System.out.println("Oprima [4] si desea eliminar un nodo");

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
						System.out.println("Que nodo desea eliminar?");
						int chc = sc.nextInt();
						btn.delete(chc);
						break;
					}
					
					
				} while (opcTree != 0);

			}
			break;

		} while (opc != 0);

	}
}
