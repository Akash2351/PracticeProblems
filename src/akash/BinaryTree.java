/**
 * Akash Anjanappa - BST implementation 
 * 16 March 2017
 */
package akash;

public class BinaryTree {
	
	Node root;
	BinaryTree(){
		root = null;
	}
	
	//adds a node to the tree to the BST
	boolean addNode(int data) {
		Node current = root;
		Node parent = current;

		Node newNode = new Node(data);

		if (current == null) {
			root = newNode;
			return true;
		}
		while (true) {
			if (data < current.data) {
				parent = current;
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return true;
				}
			} else {
				parent = current;
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return true;
				}
			}
		}
	}
	
	void preOrder(Node node){
		if(node!=null){
			preOrder(node.left);
			System.out.println(node.data+" ");
			preOrder(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(15);
		tree.addNode(8);
		tree.addNode(3);
		tree.addNode(18);
		
		tree.preOrder(tree.root);

	}

}

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}