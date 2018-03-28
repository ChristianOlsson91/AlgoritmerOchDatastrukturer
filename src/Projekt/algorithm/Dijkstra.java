package Projekt.algorithm;

import Projekt.datatypes.Edge;
import Projekt.datatypes.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Klass som inneh�ller metoder f�r att ber�kna kortaste v�gen i en graf enligt Dijkstras algoritm.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 2017-06-01
 */
public class Dijkstra {

	/**
	 * Metod f�r att ber�kna kortaste v�gen i en graf med Dijkstras algoritm
	 * 
	 * @param source - Startnoden i grafen
	 * @param target - Slutnoden i grafen
	 */
	public void shortestPath(Node source, Node target) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		source.setMinDistance(0);
		queue.add(source);
	
		while(!queue.isEmpty()) {
			Node u = queue.poll();
			if (u == target) 
				return;

			for(Edge e : u.getAdjacentNodes()) {
				Node v = e.getStartNode();
				double weight = e.getCost();
				double distanceThroughU = u.getMinDistance() + weight;
				if(distanceThroughU < v.getMinDistance()) {
					queue.remove(v);
					v.setMinDistance(distanceThroughU);
					v.setPrevious(u);
					queue.add(v);
				}
			}
		}
	}

	/**
	 * Metod som l�gger till kortaste v�gen i en graf
	 * 
	 * @param target - Noden som �r slutnod i Dijkstras algoritm
	 * @return Lista av noder som inneh�ller kortaste v�gen i en graf
	 */
	public List<Node> path(Node target) {
		List<Node> path = new LinkedList<>();
		for (Node current = target; current != null; current = current.getPrevious()) {
			path.add(current);
		}
		Collections.reverse(path);
		return path;
	}
}