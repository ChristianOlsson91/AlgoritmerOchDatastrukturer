package Projekt.datatypes;

import se.hig.aod_git.types.geomtypes.Vertex2D;

/**
 * Klassen Node som representerar en nod. Klassen inneh�ller attribut och operationer f�r en nod.
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
	 * S�tter vilka noder som �r grannar till noden
	 * 
	 * @param adjacentNodes - Noder som �r grannar till noden
	 */
	public void setAdjacentNodes(Edge[] adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}
	
	/**
	 * S�tter billigaste v�gen
	 * 
	 * @param minDistance - Kostnad f�r billigaste v�gen
	 */
	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}
	
	/**
	 * S�tter f�reg�ende nod
	 * 
	 * @param previous - F�reg�ende nod
	 */
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	
	/**
	 * S�tter en vertex av typen Vertex2D f�r att best�mma en nods koordinater
	 * 
	 * @param vertex - Nodens koordinater
	 */
	public void setVertex(Vertex2D vertex) {
		this.vertex = vertex;
	}
	
	/**
	 * H�mtar n�rliggande noder till noden
	 * 
	 * @return Nodens grannar
	 */
	public Edge[] getAdjacentNodes() {
		return adjacentNodes;
	}
	
	/**
	 * H�mtar vertex som representerar noden
	 * 
	 * @return Vertex som representerar noden
	 */
	public Vertex2D getVertex() {
		return vertex;
	}
	
	/**
	 * H�mtar den billigaste v�gen
	 * 
	 * @return Billigaste v�gen
	 */
	public double getMinDistance() {
		return minDistance;
	}
	
	/**
	 * Returnerar namnet p� noden
	 * 
	 * @return Namnet p� noden
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * H�mtar f�reg�ende nod
	 * 
	 * @return F�reg�ende nod
	 */
	public Node getPrevious() {
		return previous;
	}
}