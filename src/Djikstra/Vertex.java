package Djikstra;

import java.awt.List;
import java.util.LinkedList;

public class Vertex {

	public String name;
	public double dist;
	public Vertex prev;
	public Vertex pos;
	public int scratch;
	public LinkedList<Edge> adj;
	
	public Vertex(String nm){
		name = nm; 
		adj = new LinkedList<Edge>(); 
		reset();	
	}
	public void reset(){
		
		dist = Graph.INFINITY;
		prev = null;
		pos = null;
		scratch = 0;	
	}
	
}
