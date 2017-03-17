/**
 * Akash Anjanappa - BST implementation 
 * 16 March 2017
 */
package akash;

import java.util.LinkedList;
import java.util.Queue;

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
	
	//pre order traversal of the BST - increasing order of display
	void preOrder(Node node){
		if(node!=null){
			preOrder(node.left);
			System.out.print(node.data+" ");
			preOrder(node.right);
		}
	}
	
	boolean find(int key){
		Node current = root;
		if(current.data == key)
			return true;
		
		while(true){
			
			if(key<current.data)
				current = current.left;
			else
				current = current.right;
			
			if(current == null)
				return false;
			
			if(current.data == key)
				return true;
			
		}
	}
	
	boolean checkIfBst(Node node,int min, int max){
		if(node == null)
			return true;
		
		if(node.data < min || node.data > max)
			return false;
		
		return (checkIfBst(node.left,min,node.data-1) && checkIfBst(node.right,node.data+1,max));
	}
	
	//return the mirror of the tree. Pass the root node to mirror the whole tree.	
	Node mirror(Node node){
		if(node == null)
			return node;
		
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		
		node.left = right;
		node.right = left;
		
		return node;
	}
	
	//find the height of the tree
	//find the root node to get the tree height  O(n)
	int height(Node root){
		if(root==null) return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	// print the path to the dest node
	// returns true if the dest node is found...
	boolean printPath(Node root, int destNode) {
		if (root == null)
			return false;

		if (root.data == destNode || printPath(root.left, destNode) || printPath(root.right, destNode)) {
			System.out.print(root.data + " ");
			
			// add to list , and reverse to print the path if needed
			return true;
		}
		return false;
	}
	
	// Find The Distance From Root To Given Node of a Binary Tree.
	// similar to finding the path to a given node, except return the count
	// value;  O(n)
	public int Pathlength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.data == n1) || (x = Pathlength(root.left, n1)) > 0 || (x = Pathlength(root.right, n1)) > 0) {
				return x + 1;

			}
			return 0;
		}
		return 0;
	}
	
	// Print All Paths From Root In a Binary Tree Whose Sum is Equal to a Given
	// Number
	// Given a binary tree and X, Print all the paths starting from root so that
	// sum of all the nodes in path equals to a given num­ber.  O(n)
	void hasPath(Node node, int sum, String path) {

		if (node != null) {
			// check if data > sum,then it exceeded, just skip the node. (sum=0,
			// means exact value, print path)
			if (node.data > sum)
				return;
			else {
				path += node.data + " ";
				sum -= node.data; // keep decrementing the sum until 0.
				if (sum == 0) {
					System.out.println(path);
				}
				hasPath(node.left, sum, path); // do recursively for left and
												// right childs...keep
												// decrementing sum till 0.
				hasPath(node.right, sum, path);
			}
		}
	}
	
	//level order traversal using BFS -  O(n)
	void levelTraversal(Node root){
		Queue q = new LinkedList();
		if(root==null) return;
		q.add(root);
		
		while(!q.isEmpty()){
			int levelSize = q.size();
			while(levelSize>0){
				Node n = (Node) q.remove();
				System.out.print(n.data+" ");
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
				levelSize--;
			}
			System.out.println(" ");
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
		
		System.out.println(" Pre order traversal of tree:");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println("Height of the tree:"+tree.height(tree.root));
		System.out.println(" Finding for key: 18:"+ tree.find(18));
		System.out.println(" Finding for key: 19:"+ tree.find(19));
		System.out.println(" Checking if BST:"+ tree.checkIfBst(tree.root,Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(" Mirroring the tree:");
		tree.root = tree.mirror(tree.root);
		System.out.println(" Pre order traversal of tree:");
		tree.preOrder(tree.root);
		System.out.println();
		System.out.println(" Printing the path to dest: 18->");
		tree.printPath(tree.root,18); System.out.println();
		System.out.print(" length:"+tree.Pathlength(tree.root,18)); System.out.println();
		System.out.println(" Printing the path to dest: 8->");
		tree.printPath(tree.root,8); System.out.println();
		System.out.print(" length:"+tree.Pathlength(tree.root,18));; System.out.println();
		System.out.println(" Printing the path whose sum is 18:");
		tree.hasPath(tree.root,18, "");
		System.out.println("Level order traversal of the tree - BFS");
		tree.levelTraversal(tree.root);
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