package Djikstra;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

// Represents an entry in the priority queue for Dijkstra's algorithm.
public class Path implements Comparable<Path> {
	public Vertex dest;
	public double cost;
	
	public Path(Vertex d, double c) {
		dest = d;
		cost = c;
	}
	
	public int compareTo(Path rhs) {
		double otherCost = rhs.cost;
		
		return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
	}
	
	/**
	 * Single-source weighted shortest-path algorithm.
	 */
	public void dijkstra(String startName) {
		PriorityQueue<Path> pq = new PriorityQueue<Path>();
		
		Vertex start = vertexMap.get(startName);
		if(start == null)
			throw new NoSuchElementException("Start vertex not found");
		
		clearALL();
		pq.add(new Path(start, 0));
		start.dist = 0;
		int nodesSeen = 0;
		while(!pq.isEmpty() && nodesSeen < vertexMap.size()) {
			Path vrec = pq.remove();
			Vertex v = vrec.dest;
			if(v.scratch != 0) // already processed v
				continue;
			
			v.scratch = 1;
			nodesSeen++;
			
			for(Edge e : v.adj) {
				Vertex w = e.dest;
				double cvw = e.cost;
				
				if(cvw < 0)
					throw new GraphException("Graph has negative edges");
				
				if(w.dist > v.dist + cvw) {
					w.dist = v.dist + cvw;
					w.prev = v;
					pq.add(new Path(w, w.dist));
				}
			}
		}
	}
}