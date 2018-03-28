package Dijkstra2;

import java.util.ArrayList;

class Graph {
	int numberOfNodes;
	ArrayList<Node> nodeList;
	Node a;
	Node b;
	Node c;
	Node d;
	Node e;
	
	Graph g;
	
	public Graph() {
		a = new Node("A", b, 7);
		a.addDestination(e, 1);
		b = new Node("B", c, 6);
		b.addDestination(e, 5);
		c = new Node("C", d, 2 );
		c.addDestination(b, 6);
		c.addDestination(e, 3);
		d = new Node("D", c, 2);
		d.addDestination(e, 4);
		
		nodeList = new ArrayList<>();
		nodeList.add(a);
		nodeList.add(b);
		nodeList.add(c);
		nodeList.add(d);
		nodeList.add(e);
		
		g = new Graph(nodeList);
	}
	
	public Graph(ArrayList<Node> nodeList) {
		this.nodeList = nodeList;
	}
	
	public int size() {
		return numberOfNodes;
	}
	
	public int unvisited() {
		int counter = 0;
		while(counter < nodeList.size() && nodeList.get(counter).visited != false)
			counter++;
		
		return counter;
	}
}