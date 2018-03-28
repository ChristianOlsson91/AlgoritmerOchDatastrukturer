package Projekt.datatypes;

/**
 * Klassen Graph som representerar en graf. Klassen innehåller attribut och operationer för en graf.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 2017-06-02
 */
public class Graph {

	private Node[] vertices;

	/**
	 * Hämtar storleken på grafen
	 * 
	 * @return Storleken på grafen
	 */
	public int size() {
		return vertices.length;
	}
	
	/**
	 * Hämtar grafens noder
	 * 
	 * @return En array med noder
	 */
	public Node[] getVertices() {
		return vertices;
	}
}