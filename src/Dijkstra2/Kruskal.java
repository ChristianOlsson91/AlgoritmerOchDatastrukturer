package Dijkstra2;

import java.util.ArrayList;

import se.hig.aod_git.types.geomtypes.Vertex2D;

public class Kruskal {

	public static void main(String[] args) {

		new Kruskal();

	}
	public Kruskal(){

		ArrayList<Node> tree = new ArrayList<>();

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
		for(int i = 0; i < tree.size(); i++) {
			while(tree.get(i).visited != true){
				tree.get(i).visited(true);
			}
			if(tree.get(i).cost < tree.get(i + 1).cost){

			}



		}
	}
}
