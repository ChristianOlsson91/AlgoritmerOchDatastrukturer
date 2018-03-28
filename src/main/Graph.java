package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Projekt.datatypes.Edge;
import Projekt.datatypes.Node;
import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.gui.ViewerWindow;
import se.hig.aod_git.types.geomtypes.LineString2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

public class Graph {

	private ArrayList<Edge> edgesA;
	private ArrayList<Edge> edgesB;
	private ArrayList<Edge> edgesC;
	private ArrayList<Edge> edgesD;
	private ArrayList<Edge> edgesE;
	private ArrayList<Edge> edgesF;
	private ArrayList<Edge> edgesG;

	ObjectRenderer renderer = new ObjectRenderer();
	ViewerWindow viewer = new ViewerWindow(renderer, "");
	LineString2D line = new LineString2D();
	private ArrayList<Node> nodeList;

	public Graph() {
		nodeList = new ArrayList<>();
		edgesA = new ArrayList<>();
		edgesB = new ArrayList<>();
		edgesC = new ArrayList<>();
		edgesD = new ArrayList<>();
		edgesE = new ArrayList<>();
		edgesF = new ArrayList<>();
		edgesG = new ArrayList<>();

		Node a = new Node(new Vertex2D(1, 1), "A", false, false);
		Node b = new Node(new Vertex2D(1, 4), "B", false, false);
		Node c = new Node(new Vertex2D(5, 4), "C", false, false);
		Node d = new Node(new Vertex2D(5, 1), "D", false, false);
		Node e = new Node(new Vertex2D(8, 4), "E", false, false);
		Node f = new Node(new Vertex2D(4, 1), "F", false, false);
		Node g = new Node(new Vertex2D(9, 1), "G", false, false);

		edgesA.add(0, new Edge(a, b, 3));
		edgesA.add(1, new Edge(a, d, 3));
		a.setEdges(edgesA);

		edgesB.add(0, new Edge(b, a, 2));
		edgesB.add(1, new Edge(b, c, 1));
		b.setEdges(edgesB);

		edgesC.add(0, new Edge(c, b, 1));
		edgesC.add(1, new Edge(c, d, 3));
		edgesC.add(2, new Edge(c, a, 1));
		c.setEdges(edgesC);

		d.setEdges(edgesD);

		edgesA.add(0, new Edge(a, b, 3));
		edgesA.add(1, new Edge(a, d, 4));
		a.setEdges(edgesA);

		edgesB.add(0, new Edge(b, a, 3));
		edgesB.add(1, new Edge(b, c, 1));
		edgesB.add(2, new Edge(b, d, 2));
		b.setEdges(edgesB);

		edgesC.add(0, new Edge(c, b, 1));
		edgesC.add(1, new Edge(c, d, 2));
		edgesC.add(2, new Edge(c, e, 1));
		c.setEdges(edgesC);

		edgesD.add(0, new Edge(d, a, 4));
		edgesD.add(1, new Edge(d, b, 2));
		edgesD.add(2, new Edge(d, c, 2));
		edgesD.add(3, new Edge(d, e, 15));
		edgesD.add(4, new Edge(d, f, 6));
		d.setEdges(edgesD);

		edgesE.add(0, new Edge(e, c, 1));
		edgesE.add(1, new Edge(e, d, 15));
		edgesE.add(2, new Edge(e, f, 8));
		edgesE.add(3, new Edge(e, g, 9));
		e.setEdges(edgesE);

		edgesF.add(0, new Edge(f, d, 6));
		edgesF.add(1, new Edge(f, e, 8));
		edgesF.add(2, new Edge(f, g, 11));
		f.setEdges(edgesF);

		edgesG.add(0, new Edge(g, e, 9));
		edgesG.add(1, new Edge(g, f, 11));
		g.setEdges(edgesG);

		nodeList.add(a);
		nodeList.add(b);
		nodeList.add(c);
		nodeList.add(d);
		nodeList.add(e);
		nodeList.add(f);
		nodeList.add(g);

		kruskal();
	}

	public void kruskal() {
		ArrayList<Edge> edges = new ArrayList<>();
		ArrayList<Integer> weights = new ArrayList<>();
		
		for (int i = 0; i < nodeList.size(); i++) {
			edges = nodeList.get(i).getEdges();
			for (int j = 0; j < edges.size(); j++) {
				if(edges.get(j).getStartNode() == edges.get(j).getEndNode())
					weights.add(edges.get(j).getCost());
			}
		}
	
		for(Integer i : weights) 
			System.out.print(i + " ");	
		
		//Ritar ut alla linjer grafiskt
		for (int i = 0; i < nodeList.size(); i++) {
			edges = nodeList.get(i).getEdges();
			for (int j = 0; j < edges.size(); j++) {
				line.appendVertex(edges.get(j).getStartNode().getVertex());
				line.appendVertex(edges.get(j).getEndNode().getVertex());
			}
		}
		int temp = 0;
		char c = 'A';
		for (int i = 0; i < nodeList.size(); i++) {
			if(nodeList.get(i).getVisited() == false) {
				edges = nodeList.get(i).getEdges();
				int distance = Integer.MAX_VALUE;
				System.out.println("Index: " + c);
				c++;
			for (int j = 0; j < edges.size(); j++) {
				if (edges.get(j).getCost() < distance) {
					distance = edges.get(j).getCost();
					temp = j;
				}
			}
			System.out.println("Temp: " + temp);
			if (checkForCycle() == false && edges.get(temp).getConsumed() == false) {
				edges.get(temp).setConsumed(true);
				line.appendVertex(edges.get(temp).getStartNode().getVertex());
				line.appendVertex(edges.get(temp).getEndNode().getVertex());
				System.out.println(distance);
				renderer.addObject(line);
			}
			}
		}

		renderer.addObject(line);
		renderer.setScaleFactor(50, 50);
	}

	public boolean checkForCycle() {
		ArrayList<Edge> edges = new ArrayList<>();
		for (int j = 0; j < nodeList.size(); j++) {
			edges = nodeList.get(j).getEdges();
			for (int i = j + 1; i < edges.size(); i++) {
				if (edges.get(i).getStartNode().getNext() != edges.get(j).getEndNode().getNext()) {
					System.out.println("Hittade en cykel");
					return true;
				}
			}
		}
		return false;
	}

	public int size() {
		return nodeList.size();
	}

	public boolean isCycle() {
		for (int i = 0; i < nodeList.size(); i++) {

		}
		return false;
	}

	public ArrayList<Node> getNodes() {
		return nodeList;
	}
}