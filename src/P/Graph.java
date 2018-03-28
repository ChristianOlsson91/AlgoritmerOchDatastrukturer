package P;

import java.util.ArrayList;
import java.util.Scanner;

import Projekt.gui.Window;
import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.types.geomtypes.LineSegment2D;
import se.hig.aod_git.types.geomtypes.LineString2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

public class Graph {
	ArrayList<Vertex2D> vertexList;
	ArrayList<LineSegment2D> lineSegmentList;
	public LineString2D lineString;
	Graph g;
	double minDistance = Double.MAX_VALUE;
	boolean consumed = false;

	public Graph() {
		vertexList = new ArrayList<Vertex2D>();
		Scanner scan = new Scanner(System.in);
		System.out.print("Välj hur många noder grafen ska ha: ");
		int numberOfNodes = scan.nextInt();
		
		for(int i = 0; i < numberOfNodes; i++) {
			vertexList.add(new Vertex2D(scan.nextDouble(), scan.nextDouble()));
		}
		scan.close();
		g = new Graph(vertexList);
		kruskal();
	}
	
	public Graph(ArrayList<Vertex2D> vertexList) {
		this.vertexList = vertexList;
		createLineString(vertexList);
	}
	
	public void createLineString(ArrayList<Vertex2D> vertexList) {
		lineString = new LineString2D();
		lineSegmentList = new ArrayList<>();
		
		for(int i = 0; i < vertexList.size(); i++) {
			lineSegmentList.add(new LineSegment2D(vertexList.get(i), vertexList.get(i)));
			lineString.appendVertex(vertexList.get(i));
			
			System.out.println(lineSegmentList.get(i));
		}
	}
	
	public LineString2D getLineString() {
		return lineString;
	}
	
	/*
	 * 
    För att hitta ett minimalt uppspännande träd T i den sammanhängande grafen G
    Upprepa tills T innehåller alla noder i G
        Låt v vara den kortaste sträckan i G som inte märkts som förbrukad
        Märk v som förbrukad
        Om v inte bildar en cykel i T
            Lägg v till T
    T är ett minimalt uppspännande träd

	 */
	public void kruskal() {
		ArrayList<Vertex2D> t = new ArrayList<>();
		int distance;
		int i = 0;
		double v;
		
		while(t.size() != vertexList.size()) {
			v = lineSegmentList.get(i).getV1().x() - lineSegmentList.get(i).getV0().x();
		}
	}
	
	public void consumed(boolean consumed) {
		this.consumed = consumed;
	}
	
	public void shortestPath() {
		int counter = 0;
		for(int i = 0; i < vertexList.size(); i++) {
			
		}
	}
}