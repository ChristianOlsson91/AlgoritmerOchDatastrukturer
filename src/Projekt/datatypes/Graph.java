package Projekt.datatypes;

/**
 * Klassen Graph som representerar en graf. Klassen inneh�ller attribut och operationer f�r en graf.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 2017-06-02
 */
public class Graph {

	private Node[] vertices;

	/**
	 * H�mtar storleken p� grafen
	 * 
	 * @return Storleken p� grafen
	 */
	public int size() {
		return vertices.length;
	}
	
	/**
	 * H�mtar grafens noder
	 * 
	 * @return En array med noder
	 */
	public Node[] getVertices() {
		return vertices;
	}
}