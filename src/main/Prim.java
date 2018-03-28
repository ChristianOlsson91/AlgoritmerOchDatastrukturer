package main;

import java.util.ArrayList;

import Projekt.datatypes.Edge;
import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.gui.ViewerWindow;
import se.hig.aod_git.types.geomtypes.LineString2D;

public class Prim {

	public Prim(Graph g) {
		ObjectRenderer renderer = new ObjectRenderer();
		ViewerWindow viewer = new ViewerWindow(renderer, "");
		
		LineString2D line = new LineString2D();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		Edge edge;
		
		int j = 0;
		
		while(j < g.getNodes().get(j).getEdges().size()) {
			edges = g.getNodes().get(j).getEdges();
			for(int i = 0; i < edges.size(); i++) {
				line.appendVertex(edges.get(i).getStartNode().getVertex());
				line.appendVertex(edges.get(i).getEndNode().getVertex());
			}
			j++;
		}
		
		renderer.addObject(line);
		renderer.setScaleFactor(50, 50);
		
	}
}