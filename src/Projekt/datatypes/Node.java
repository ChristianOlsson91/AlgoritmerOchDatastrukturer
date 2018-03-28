package Projekt.datatypes;

import se.hig.aod_git.types.geomtypes.Vertex2D;

/**
 * Klassen Node som representerar en nod. Klassen innehåller attribut och operationer för en nod.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 2017-06-01
 */
public class Node implements Comparable<Node> {
	private Vertex2D vertex;
	private String name;
	private Edge[] adjacentNodes;
	private double minDistance = Double.MAX_VALUE;
	private Node previous;
	
	public Node(String name) {
		this.name = name;
	}
	
	public Node(Vertex2D vertex, String name) {
		this.vertex = vertex;
		this.name = name;
	}
	
	@Override
	public int compareTo(Node arg0) {
		return Double.compare(this.minDistance, arg0.minDistance);
	}
	
	/**
	 * Sätter vilka noder som är grannar till noden
	 * 
	 * @param adjacentNodes - Noder som är grannar till noden
	 */
	public void setAdjacentNodes(Edge[] adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
	/**
	 * Sätter billigaste vägen
	 * 
	 * @param minDistance - Kostnad för billigaste vägen
	 */
	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}
	
	/**
	 * Sätter föregående nod
	 * 
	 * @param previous - Föregående nod
	 */
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	/**
	 * Sätter en vertex av typen Vertex2D för att bestämma en nods koordinater
	 * 
	 * @param vertex - Nodens koordinater
	 */
	public void setVertex(Vertex2D vertex) {
		this.vertex = vertex;
	}
	
	/**
	 * Hämtar närliggande noder till noden
	 * 
	 * @return Nodens grannar
	 */
	public Edge[] getAdjacentNodes() {
		return adjacentNodes;
	}
	
	/**
	 * Hämtar vertex som representerar noden
	 * 
	 * @return Vertex som representerar noden
	 */
	public Vertex2D getVertex() {
		return vertex;
	}
	
	/**
	 * Hämtar den billigaste vägen
	 * 
	 * @return Billigaste vägen
	 */
	public double getMinDistance() {
		return minDistance;
	}
	
	/**
	 * Returnerar namnet på noden
	 * 
	 * @return Namnet på noden
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Hämtar föregående nod
	 * 
	 * @return Föregående nod
	 */
	public Node getPrevious() {
		return previous;
	}
}