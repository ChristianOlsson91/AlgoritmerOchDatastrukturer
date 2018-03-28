package Projekt.datatypes;

/**
 * Klassen Edge som representerar en kant. Klassen innehåller attribut och operationer för en kant.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 2017-06-01
 */
public class Edge {
	private Node start;
	private Node end;
	private int cost;
	
	public Edge(Node start, Node end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
	}
	
	public Edge(Node start, int cost) {
		this.start = start;
		this.cost = cost;
	}
	
	/**
	 * Returnerar en kants startnod
	 * 
	 * @return Kantents startnod
	 */
	public Node getStartNode() {
		return start;
	}
	
	/**
	 * Returnerar en kants slutnod
	 * 
	 * @return Kantens slutnod
	 */
	public Node getEndNode() {
		return end;
	}
	
	/**
	 * Returnerar en kants kostnad
	 * 
	 * @return Kantents kostnad
	 */
	public int getCost() {
		return cost;
	}
}