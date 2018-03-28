package main;

import java.awt.Color;
import java.util.ArrayList;

import Projekt.datatypes.Node;
import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.gui.ViewerWindow;
import se.hig.aod_git.types.geomtypes.LineString2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

public class Kruskal {

	private ArrayList<Node> minimumSpanningList = new ArrayList<>();
	
	public Kruskal(Graph g) {
		int i = 0;
		int distance = Integer.MAX_VALUE;
		ObjectRenderer renderer = new ObjectRenderer();
		ViewerWindow viewer = new ViewerWindow(renderer, "");
		LineString2D line = new LineString2D();
	}
		/*for(int j = 0; j < g.getNodes().size(); j++)
			line.appendVertex(g.getNodes().get(j));
		/*LineString2D line = new LineString2D();
		//LineString2D line2 = new LineString2D();
		/*line.appendVertex(g.getNodes().get(0).getVertex());
		line.appendVertex(g.getNodes().get(1).getVertex());
		
		line.appendVertex(g.getNodes().get(2).getVertex());
		line.appendVertex(g.getNodes().get(3).getVertex());
		line.appendVertex(g.getNodes().get(2).getVertex());
		line.appendVertex(g.getNodes().get(4).getVertex());
		//for(int j = 0; j < g.size(); j++) {
			System.out.println(j);
			line.appendVertex(g.getNodes().get(0).getVertex());
			line.appendVertex(g.getNodes().get(1).getVertex());
			
			line.appendVertex(g.getNodes().get(2).getVertex());
			line.appendVertex(g.getNodes().get(3).getVertex());
			line.appendVertex(g.getNodes().get(4).getVertex());
			line.appendVertex(g.getNodes().get(5).getVertex());
			//line.appendVertex(g.getNodes().get(3).getVertex());
			for(int k = 0; k < g.getNodes().get(k).getEdges().size(); k++) {
				line.appendVertex(g.getNodes().get(j).getVertex());
				
				line.appendVertex(g.getNodes().get(k).getEdges().get(k).getStartNode().getEdges().get(k).getEndNode().getVertex());
				System.out.println(k);
				//System.out.print("Start: " + g.getNodes().get(k).getEdges().get(k).getStartNode().getName() + " ");
				//System.out.println("End: " + g.getNodes().get(k).getEdges().get(k).getEndNode().getName());
			}
		//}
		//System.out.println(line.getVertices().toString());
		//renderer.addObject(line);
		//renderer.addObject(line2);
		//renderer.setScaleFactor(50, 50); 
		int totalEdges = 0;
		for (int j = 0; j < g.getNodes().size(); j++) {
			totalEdges += g.getNodes().get(j).getEdges().size();
		}
		ArrayList<Edge> kuken = new ArrayList<Edge>();
		System.out.println(totalEdges);
		Edge shortestEdge = null;
		while(kuken.size() != totalEdges/*minimumSpanningList.size() != g.size()){
			if(g.getNodes().size() == i+1){ 
				i = 0;
				shortestEdge.setConsumed(true);
				line.appendVertex(shortestEdge.getStartNode().getVertex());
				line.appendVertex(shortestEdge.getEndNode().getVertex());
				kuken.add(shortestEdge);
				distance = Integer.MAX_VALUE;
			}
			Node curNode = g.getNodes().get(i);
			
			if(minimumSpanningList.indexOf(curNode) != -1) {
				i++;
				continue;
			}
			boolean allEdgesConsumed = false;
			if(curNode.getConsumed() == false){
				for (int j = 0; j < curNode.getEdges().size(); j++) {
					Edge edge = curNode.getEdges().get(j);
					//if(edge.getConsumed() || )
					if(edge.getCost() < distance && !edge.getConsumed() && !checkForCycle()){
						distance = edge.getCost();
						shortestEdge = edge;
						allEdgesConsumed = false;
					}
				}
			}
				if(allEdgesConsumed) {
					minimumSpanningList.add(curNode);
				}
				
				for(int j = 0; j < g.size(); j++) {
					try {
					for(int k = 0; k < g.getNodes().get(j).getEdges().size(); k++) {
						if( g.getNodes().get(j).getEdges().get(j).getCost() < distance) {
							distance = g.getNodes().get(j).getEdges().get(j).getCost();
							g.getNodes().get(i).setConsumed(true);
						}
					}
				}
					catch(IndexOutOfBoundsException e) {
						e.printStackTrace();
					}
				g.getNodes().get(i).setConsumed(true);
				if(checkForCycle() == false) {
					minimumSpanningList.add(g.getNodes().get(i));
				}
				}
			
			LineString2D line2 = new LineString2D();
			for(int j = 0; j < minimumSpanningList.size(); j++) 
				line2.appendVertex(minimumSpanningList.get(j).getVertex());
		
		renderer.setColor(Color.RED);
		
		i++;
		}
		
		//ArrayList<Vertex2D>addedEdges = new ArrayList<Vertex2D>();
		
		for (Edge edge : kuken) {
			//Vertex2D start = edge.getStartNode().getVertex();
			//Vertex2D end = edge.getEndNode()().getVertex();
			//if(addedEdges.indexOf(start))
				
			//line.appendVertex();
			//line.appendVertex(edge.getEndNode().getVertex());
			//System.out.println(edge.getStartNode().getVertex().toString() + " " + edge.getEndNode().getVertex().toString());
			LineString2D kuklinje = new LineString2D();
			
			Vertex2D start = edge.getStartNode().getVertex();
			Vertex2D end = edge.getEndNode().getVertex();
			
			kuklinje.appendVertex(start);
			kuklinje.appendVertex(end);
			
			renderer.addObject(kuklinje);
		}
		line.appendVertex(kuken.get(0).getStartNode().getVertex());
		line.appendVertex(kuken.get(0).getEndNode().getVertex());
		
		line.appendVertex(kuken.get(2).getStartNode().getVertex());
		line.appendVertex(kuken.get(2).getEndNode().getVertex());
		
		line.appendVertex(kuken.get(4).getStartNode().getVertex());
		line.appendVertex(kuken.get(4).getEndNode().getVertex());
		
		line.appendVertex(kuken.get(6).getStartNode().getVertex());
		line.appendVertex(kuken.get(6).getEndNode().getVertex());
		
		System.out.println(line.getVertices().toString());
		renderer.addObject(line);
		renderer.setScaleFactor(50, 50);
	}
	
	public boolean checkForCycle() {
		
		
		System.out.println("Hittade ingen cykel");
		for(int j = 0; j < minimumSpanningList.size()-1; j++) {
			for(int i = j+1; i < minimumSpanningList.size()-1; i++) {
				//if(minimumSpanningList.get(i).getNext() != minimumSpanningList.get(j).getName()) {
					System.out.println("Hittade en cykel");				
					return true;
				}
			}
		//}
		return false;
		return true;
	}
}*/}