package arbol;

public class BinaryTree {
	private static Node root;

	private Node addRecursive(Node current, int value) {
		if (current == null) {
			System.out.println("Nuevo nodo creado con exito!");
			return new Node(value);
		}

		if (value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}
		
		return current;
	}

	public void add(int value) {
		root = addRecursive(root, value);
		
	}

	private Node deleteRecursive(Node current, int value) {
		if (current == null) {
			System.out.println("Nodo no encontrado");
			return null;
		

		}

		if (value == current.value) {
			System.out.println("Nodo eliminado");

			if (current.left == null && current.right == null) {
				return null;
			}

			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}

			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
		}
		if (value < current.value) {
			current.left = deleteRecursive(current.left, value);
			return current;
		}
		current.right = deleteRecursive(current.right, value);
		return current;
	}

	private static int findSmallestValue(Node root) {
		return root.left == null ? root.value : findSmallestValue(root.left);
	}

	public void delete(int value) {
		root = deleteRecursive(root, value);
	}

	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value + "\n");
			traverseInOrder(node.right);
		}
	}

	public void traversePostOrder(Node node) {
		if (node != null) {
			traversePostOrder(node.left);
			traversePostOrder(node.right);
			System.out.print(" " + node.value + "\n");
		}
	}

	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value + "\n");
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}

	public static Node getRoot() { 
		return root;
	}
}
