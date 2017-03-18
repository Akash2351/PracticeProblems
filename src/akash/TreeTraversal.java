/**
 * Akash Anjanappa -Tree traversals
 * 16 March 2017
 */
package akash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	public static void main(String[] args) {
		Graph g = new Graph();

		Node nA = new Node('A');
		Node nB = new Node('B');
		Node nC = new Node('C');
		Node nD = new Node('D');
		Node nE = new Node('E');
		Node nF = new Node('F');

		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.setRootNode(nA);

		g.connectNodes(nA, nB);
		g.connectNodes(nA, nC);
		g.connectNodes(nA, nD);

		g.connectNodes(nB, nE);
		g.connectNodes(nB, nF);
		g.connectNodes(nC, nF);

		System.out.println(" Running traversals on graph:");
		System.out.println("DFS");
		g.dfs();
		System.out.println("");
		System.out.println("BFS");
		g.bfs();

	}

}

//class that stores nodes and utility functions for traversals.
// uses adj matrix to store the edges.
class Graph {

	int size;
	// this holds the nodes
	ArrayList nodes = new ArrayList();
	// used to indicate the edges btw nodes
	int[][] adjMatrix;
	Node rootNode;

	void addNode(Node node) {
		nodes.add(node);
	}

	void setRootNode(Node root) {
		this.rootNode = root;
	}

	// function to add edges between nodes. this adds an entry in the adj matrix
	void connectNodes(Node start, Node end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
	}

	// returns a unvisited node for the given node. It used the adj matrix to
	// find this.
	// keep calling this to return all adjacent nodes which are not visited
	// untill null is returned.
	Node getUnvisitedNode(Node n) {
		int index = nodes.indexOf(n);
		int j = 0;

		while (j < size) {
			if (adjMatrix[index][j] == 1 && ((Node) nodes.get(j)).visited == false) {
				return (Node) nodes.get(j);
			}
			j++;
		}
		return null;
	}

	// performs DFS traversal - depth first using stack.
	void dfs() {
		Stack s = new Stack();
		s.add(rootNode);
		rootNode.visited = true;
		printNode(rootNode);

		while (!s.isEmpty()) {
			// dont remove node until all its children are visited.
			Node node = (Node) s.peek();
			Node child = getUnvisitedNode(node);

			// add the child to the stack. in the next loop, this node will be
			// explored.
			// one child is added at once. Whereas in BFS, all the nodes are
			// added at once.
			if (child != null) {
				s.add(child);
				printNode(child);
				child.visited = true;
			} else {
				// remove the node once all its children are visited.
				s.pop();
			}
		}

		// clear the visited flag for all the nodes.
		clearNodes();
	}

	void bfs() {
		Queue q = new LinkedList();
		q.add(rootNode);
		rootNode.visited = true;
		printNode(rootNode);

		while (!q.isEmpty()) {
			// remove the front node from the queue.
			Node node = (Node) q.remove();
			Node child = null;

			// add all its children to the queue at once!!
			while ((child = getUnvisitedNode(node)) != null) {
				q.add(child);
				child.visited = true;
				printNode(child);
			}
		}
		clearNodes();
	}

	void clearNodes() {
		for (Object node : nodes) {
			((Node) node).visited = false;
		}

	}

	void printNode(Node node) {
		System.out.print(node.label + " ");
	}

}

class Node {
	char label;
	boolean visited;

	Node(char c) {
		this.label = c;
	}
}
