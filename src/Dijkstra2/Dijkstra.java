package Dijkstra2;
import java.util.ArrayList;

/*     DIJKSTRA (Graf G, startnod s)
//Vi initierar alla noder i grafen.
// Billigaste vägen (avståndet) är oändligt
//  och föregående nod är odefinierad
för i ∈ Noder(G) gör
   avstånd[i] = OÄNDLIGT
   föregångare[i] = NULL
// Avståndet till startnoden är 0
avstånd[s] = 0
//markera startnoden som avsökt
Avsökt( s )
medan inte alla noder avsökta gör
   // Finn den ej avsökta nod som har lägst nodpris
   //  tills alla är avsökta
   i = Minimum( ej avsökta noder )
   för j ∈ närliggande(i) gör
       // Undersök om det finns en billigare väg
       //  via nod i till närliggande noder
       om avstånd[j] > avstånd[i] + kostnad(i, j) gör
           avstånd[j] = avstånd[i] + kostnad(i, j)
           föregångare[j] = i
   Avsökt( i )*/
public class Dijkstra {
	Node a;
	Node b;
	Node c;
	int distance;
	int[] distances = new int[10];
	int[] precursors = new int[10];
	public static final int INFINITY = 1000000;
	ArrayList<Node> nodeList;
	Graph g = new Graph(nodeList);
	static Node s;
	
	public Dijkstra() {
		int j = 0;
		
		for(int i = 0; i < g.size() ; i++) {
			distances[i] = INFINITY;
			precursors[i] = (Integer) null;
			distances[s.cost] = 0;
			s.visited(true);
			
			while(c.visited != true) {
				i = g.unvisited();
			
				for(Node n : s.neighbours) {
					if(distances[j] > distances[i] + s.cost) {
						distances[j] = distances[i] + s.cost;
						precursors[j] = i;
					}
				}
			}
			nodeList.get(i).visited(true);
		}
	}
	
	public static void main(String[] args) {
		new Dijkstra();
	}
}