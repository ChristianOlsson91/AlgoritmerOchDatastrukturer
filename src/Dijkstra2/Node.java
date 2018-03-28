package Dijkstra2;

import java.util.ArrayList;

public class Node {
	String name;
	Node neighbour;
	int cost;
	boolean visited;
	ArrayList<Node> neighbours;
	
	public Node(String name, Node neighbour, int cost) {
		this.name = name;
		this.neighbour = neighbour;
		this.cost = cost;
		neighbours.add(neighbour);
	}
	
	public void addDestination(Node neighbour, int cost) {
		this.neighbour = neighbour;
		this.cost = cost;
		neighbours.add(neighbour);
	}
	
	public void visited(boolean visited) {
		this.visited = visited;
	}
}