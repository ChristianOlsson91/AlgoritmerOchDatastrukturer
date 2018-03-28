package Djikstra;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.types.geomtypes.LineSegment2D;
import se.hig.aod_git.types.geomtypes.LineString2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

public class Graph {
	public static final double INFINITY = Double.MAX_VALUE;

	public void addEdge( String sourceName, String destName, double cost ){

		Vertex v = getVertex( sourceName );
		Vertex w = getVertex( destName );
		v.adj.add( new Edge( w, cost ) );
	}

	public void printPath( String destName )
	{
		Vertex w = vertexMap.get(destName);
		if(w == null)
			throw new NoSuchElementException();
		else if(w.dist == INFINITY)
			System.out.println(destName + " is unreachable");
		else
		{
			System.out.println("((Cost is: " + w.dist + ") " );
			printPath(w);
			System.out.println();
		}
	}
	public void unweighted( String startName )
	{
		clearALL();

		Vertex start = vertexMap.get(startName);
		if(start == null)
			throw new NoSuchElementException("Start vertex not found");
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(start);
		start.dist = 0;

		while(!q.isEmpty()){
			Vertex v = q.remove();

			for(Edge e : v.adj){
				Vertex w = e.dest;
				if(w.dist == INFINITY)
				{
					w.dist = v.dist + 1;
					w.prev = v;
					q.add(w);
				}
			}
		}
	}
	public void dijkstra( String startName ){
		PriorityQueue<Path> pq = new PriorityQueue();

		Vertex start = vertexMap.get( startName );
		if( start == null ){
			throw new NoSuchElementException("Start vertex not found");

			clearALL();
			pq.add( new Path( start, 0 ) ); start.dist = 0;

			int nodesSeen = 0;
			while(!pq.isEmpty( ) && nodesSeen < vertexMap.size( )){
				Path vrec = pq.remove( );
				Vertex v = vrec.dist;
				if(v.scratch != 0)
					continue;

				v.scratch = 1;
				nodesSeen++;

				for(Edge e : v.adj){
					Vertex w = e.dest;
					double cvw = e.cost;

					if(cvw < 0)					
						throw new GraphException("Graph has negative edges");

					if(w.dist > v.dist + cvw)
					{									
						w.dist = v.dist + cvw;
						w.prev = v;
						pq.add(new Path(w, w.dist));
					}
				}
			}
		}
	}
	
	public void negative( String startName ){

		clearALL( );

		Vertex start = vertexMap.get( startName );
		if( start == null )
			throw new NoSuchElementException( "Start vertex not found" );

		Queue<Vertex> q = new LinkedList<Vertex>( );
		q.add( start ); start.dist = 0; start.scratch++;

		while( !q.isEmpty( ) )
		{
			Vertex v = q.remove( );
			if( v.scratch++ > 2 * vertexMap.size( ) )
				throw new GraphException( "Negative cycle detected" );

			for( Edge e : v.adj )
			{
				Vertex w = e.dest;
				double cvw = e.cost;

				if( w.dist > v.dist + cvw )
				{
					w.dist = v.dist + cvw;
					w.prev = v;
					// Enqueue only if not already on the queue
					if( w.scratch++ % 2 == 0 )
						q.add( w );
					else
						w.scratch--; // undo the enqueue increment
				}
			}
		}

	}
	public void acyclic( String startName ){

		Vertex start = vertexMap.get( startName );
		if( start == null )
			throw new NoSuchElementException( "Start vertex not found" );

		clearALL( );
		Queue<Vertex> q = new LinkedList<Vertex>( );
		start.dist = 0;

		// Compute the indegrees
		Collection<Vertex> vertexSet = vertexMap.values( );
		for( Vertex v : vertexSet )
			for( Edge e : v.adj )
				e.dest.scratch++;

		// Enqueue vertices of indegree zero
		for( Vertex v : vertexSet )
			if( v.scratch == 0 )
				q.add( v );

		int iterations;
		for( iterations = 0; !q.isEmpty( ); iterations++ )
		{
			Vertex v = q.remove( );

			for( Edge e : v.adj )
			{
				Vertex w = e.dest;
				double cvw = e.cost;

				if( --w.scratch == 0 )
					q.add( w );

				if( v.dist == INFINITY )
					continue;

				if( w.dist > v.dist + cvw )
				{
					w.dist = v.dist + cvw;
					w.prev = v;
				}
			}
		}

		if( iterations != vertexMap.size( ) )
			throw new GraphException( "Graph has a cycle!" );

	}
	/**
	 * If vertexName is not present, add it to vertexMap.
	 * In either case, return the Vertex.
	 */

	private Vertex getVertex( String vertexName ){
		Vertex v = vertexMap.get(vertexName);
		if(v == null){
			v = new Vertex (vertexName);
			vertexMap.put(vertexName, v);
		}
		return v;
	}
	private void printPath(Vertex dest){
		if(dest.prev != null)
		{
			printPath(dest.prev);
			System.out.println(" to ");
		}
		System.out.println(dest.name);

	}
	public void clearALL(){
		for(Vertex v : vertexMap.values())
			v.reset();
	}

	private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

	class GraphException extends RuntimeException{
		public GraphException(String name){
			super(name);
		}
	}
}
