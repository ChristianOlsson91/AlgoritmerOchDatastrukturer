package Laboration3;

import se.hig.aod_git.types.geomtypes.LineSegment2D;
import se.hig.aod_git.types.geomtypes.LineString2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

/**
 * Metod för att skapa samt utföra operationer på trapetser.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170519
 */
public class Trapezium {
	private Vertex2D vertexNode1;
	private Vertex2D vertexNode2;
	private Vertex2D vertexNode3;
	private Vertex2D vertexNode4;
	private LineString2D ls;
	
	/**
	 * Konstruktor som skapar en trapets med alla punkter i origo.
	 */
	public Trapezium() {
		vertexNode1 = new Vertex2D(0, 0);
		vertexNode2 = new Vertex2D(0, 0);
		vertexNode3 = new Vertex2D(0, 0);
		vertexNode4 = new Vertex2D(0, 0);
	}
	
	 /**
	  * Konstruktor som skapar en trapets med noder i dem inskickade värdena. Den drar även en linje mellan alla noder i trapetsen.
	  * 
	  * @param x1 - Första nodens x-värde
	  * @param y1 - Första nodens y-värde
	  * @param x2 - Andra nodens x-värde
	  * @param y2 - Andra nodens y-värde
	  * @param x3 - Tredje nodens x-värde
	  * @param y3 - Tredje nodens y-värde
	  * @param x4 - Fjärde nodens x-värde
	  * @param y4 - Fjärde nodens y-värde
	  */
	public Trapezium(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		vertexNode1 = new Vertex2D(x1, y1);
		vertexNode2 = new Vertex2D(x2, y2);
		vertexNode3 = new Vertex2D(x3, y3);
		vertexNode4 = new Vertex2D(x4, y4);
		
		ls = new LineString2D();
		ls.appendVertex(vertexNode1);
		ls.appendVertex(vertexNode2);
		ls.appendVertex(vertexNode3);
		ls.appendVertex(vertexNode4);
		ls.appendVertex(vertexNode1);
	}
	
	/**
	 * Hämtar första noden.
	 * 
	 * @return vertexNode1 - Första noden
	 */
	public Vertex2D getNode1() {
		return vertexNode1;
	}
	
	/**
	 * Hämtar andra noden.
	 * 
	 * @return vertexNode2 - Andra noden
	 */
	public Vertex2D getNode2() {
		return vertexNode2;
	}
	
	/**
	 * Hämtar tredje noden.
	 * 
	 * @return - Tredje noden
	 */
	public Vertex2D getNode3() {
		return vertexNode3;
	}
	
	/**
	 * Hämtar fjärde noden.
	 * 
	 * @return vertexNode4 - Fjärde noden
	 */
	public Vertex2D getNode4() {
		return vertexNode4;
	}
	
	/**
	 * Metod som beräknar arean av en trapets enligt formeln: ((vertexNode2.y+vertexNode3.y)/2))*lineSegment.length
	 * 
	 * @param lineSegment - Linje för att beräkna värdet d, längden mellan första nodens x-värde och sista nodens x-värde
	 * @return area - Arean av trapetsen
	 */
	public double calculateArea(LineSegment2D lineSegment) {
		double area = ((vertexNode2.y()+vertexNode3.y())/2)*lineSegment.length();
		
		return area;
	}
	
	/**
	 * Metod för att visualisera en linje.
	 *  
	 * @return ls - Linjen som ska visualiseras
	 */
	public LineString2D visualize() {
		return ls;
	}
}