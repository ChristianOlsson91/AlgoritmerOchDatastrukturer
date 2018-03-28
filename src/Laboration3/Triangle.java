package Laboration3;

import se.hig.aod_git.types.geomtypes.LineString2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

public class Triangle {
	private Vertex2D vertexNode1;
	private Vertex2D vertexNode2;
	private Vertex2D vertexNode3;
	private LineString2D ls;
	
	public Triangle() {
		vertexNode1 = new Vertex2D(0, 0);
		vertexNode2 = new Vertex2D(0, 0);
		vertexNode3 = new Vertex2D(0, 0);
	}
	
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		vertexNode1 = new Vertex2D(x1, y1);
		vertexNode2 = new Vertex2D(x2, y2);
		vertexNode3 = new Vertex2D(x3, y3);
		
		ls = new LineString2D();
		ls.appendVertex(vertexNode1);
		ls.appendVertex(vertexNode2);
		ls.appendVertex(vertexNode3);
		ls.appendVertex(vertexNode1);
	}
	
	public Vertex2D getNode1() {
		return vertexNode1;
	}
	
	public Vertex2D getNode2() {
		return vertexNode2;
	}
	
	public Vertex2D getNode3() {
		return vertexNode3;
	}
	
	public double calculateArea() {
		double area = (vertexNode1.x()*((vertexNode2.y()*1)-(vertexNode3.y()*1))-vertexNode1.y()*((vertexNode2.x()*1)-(vertexNode3.x()*1))+1*
				((vertexNode2.x()*vertexNode3.y())-(vertexNode2.y()*vertexNode3.x())))*0.5;
		
		return area;
	}
	
	public LineString2D visualize() {
		return ls;
	}
}