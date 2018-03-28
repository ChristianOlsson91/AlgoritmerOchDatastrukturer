package Laboration3;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;

import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.gui.ViewerWindow;
import se.hig.aod_git.types.geomtypes.LineSegment2D;
import se.hig.aod_git.types.geomtypes.Polygon2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

public class Problem1 {
	ArrayList<Vertex2D> vertexList;
	ArrayList<Vertex2D> vList;
	int counter;
	long after, before;
	
	public Problem1() {
		Triangle triangle = new Triangle(1, 1, 1, 6, 7, 1);
		System.out.println("Arean av triangeln: " + Math.abs(triangle.calculateArea()));
		
		Trapezium trapezium = new Trapezium(3, 0, 3, 6, 7, 4, 7, 0);
		LineSegment2D lineSegment = new LineSegment2D(new Vertex2D(trapezium.getNode1().x(), trapezium.getNode1().y()), new Vertex2D(trapezium.getNode4().x(), trapezium.getNode4().y()));
		System.out.println("Arean av trapetsen: " + trapezium.calculateArea(lineSegment));
		
		vertexList = new ArrayList<>();
		vertexList.add(new Vertex2D(3, 6));
		vertexList.add(new Vertex2D(7, 3));
		vertexList.add(new Vertex2D(10, 5));
		vertexList.add(new Vertex2D(14, 4));
		vertexList.add(new Vertex2D(18, 6));
		vertexList.add(new Vertex2D(15, 9));
		vertexList.add(new Vertex2D(13, 12));
		vertexList.add(new Vertex2D(8, 11));
 		Polygon2D polygon = new Polygon2D(vertexList);
 		System.out.println("Arean av polygonen beräknat med trianglar: " + calculateAreaWithTriangles(polygon));
 		
 		ObjectRenderer polygonrenderer = new ObjectRenderer();
 		ObjectRenderer trianglerenderer = new ObjectRenderer();
 		ObjectRenderer trapeziumrenderer = new ObjectRenderer();
 		ObjectRenderer polyrenderer = new ObjectRenderer();
 		
 		polygonrenderer.addObject(polygon);
 		polygonrenderer.setScaleFactor(20, 20);
 		trianglerenderer.addObject(triangle.visualize());
 		trianglerenderer.setScaleFactor(20, 20);
 		trapeziumrenderer.addObject(trapezium.visualize());
 		trapeziumrenderer.setScaleFactor(20, 20);
 		polyrenderer.addObject(polygon);
 		polyrenderer.setScaleFactor(20, 20);
 		
 		ViewerWindow polygonViewer = new ViewerWindow(polygonrenderer, "Polygon");
 		ViewerWindow triangleViewer = new ViewerWindow(trianglerenderer, "Triangle");
 		ViewerWindow trapeziumViewer = new ViewerWindow(trapeziumrenderer, "Trapezium");
 		ViewerWindow view = new ViewerWindow(polyrenderer, "Polygon"); 
 
 		polygonViewer.add(BorderLayout.NORTH, new JLabel("Polygonens area: " + calculateAreaWithTriangles(polygon)));
 		triangleViewer.add(BorderLayout.NORTH, new JLabel("Triangelns area: " + Math.abs(triangle.calculateArea())));
 		trapeziumViewer.add(BorderLayout.NORTH, new JLabel("Trapetsens area: " + trapezium.calculateArea(lineSegment)));
 		view.add(BorderLayout.NORTH, new JLabel("Polygonens area: " + calculateAreaWithTrapeziums(polygon)));
 		
 		polygonViewer.setLocation(500, 500);
 		triangleViewer.setLocation(1500, 500);
 		trapeziumViewer.setLocation(500, 500);
 		view.setLocation(500, 800);
 		System.out.println("Arean av polygonen beräknad med trapetser: " + calculateAreaWithTrapeziums(polygon));
	}
	
	public double calculateAreaWithTriangles(Polygon2D polygon) {
		double area = 0;
		counter = 0;
		int totalTime = 0;
		
		Vertex2D p = new Vertex2D(polygon.getVertex(0).x(), polygon.getVertex(0).y());
		for(int i = 0; i<polygon.size()-1; i++) {
			before = System.nanoTime();
			Triangle t1 = new Triangle(p.x(), p.y(), polygon.getVertex(i).x(), polygon.getVertex(i).y(), polygon.getVertex(i+1).x(), polygon.getVertex(i+1).y());
			
			area += t1.calculateArea();
			after = System.nanoTime();
			totalTime += after-before;
			System.out.println(after-before);
			counter++;
		}
		System.out.println("Totaltid med trianglar: " + totalTime);
		System.out.println("Beräkningssteg för areaberäkning med hjälp av trianglar: " + counter);
		
		return Math.abs(area);
	}
	
	public double calculateAreaWithTrapeziums(Polygon2D polygon) {
		double area = 0;
		counter = 0;
		int totalTime = 0;
		
		for(int i = 0; i < polygon.size()-1; i++) {
			before = System.nanoTime();
			area += ((polygon.getVertex(i).y()+polygon.getVertex(i+1).y())/2)*(polygon.getVertex(i).x()-polygon.getVertex(i+1).x());
			after = System.nanoTime();
			totalTime += after-before;
			System.out.println(after-before);
			counter++;
		}
		
		before = System.nanoTime();
		area += ((polygon.getVertex(polygon.size()-1).y() + polygon.getVertex(0).y())/2)*(polygon.getVertex(polygon.size()-1).x()-polygon.getVertex(0).x());
		after = System.nanoTime();
		totalTime += after-before;
		counter++;
		
		System.out.println("Totaltid med trapetser: " + totalTime);
		System.out.println("Beräkningssteg för areaberäkning med hjälp av trapetser: " + counter);
	
		return area;	
	}
	
	public static void main(String[] args) {
		new Problem1();
	}
}