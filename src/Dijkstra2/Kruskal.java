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
	    F�r att hitta ett minimalt uppsp�nnande tr�d T i den sammanh�ngande grafen G
	    Upprepa tills T inneh�ller alla noder i G
	        L�t v vara den kortaste str�ckan i G som inte m�rkts som f�rbrukad
	        M�rk v som f�rbrukad
	        Om v inte bildar en cykel i T
	            L�gg v till T
	    T �r ett minimalt uppsp�nnande tr�d

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
