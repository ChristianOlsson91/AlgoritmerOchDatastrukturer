package Laboration2;

/**
 * Klass för att hitta SGD givet två heltal, SGD beräknas med både en iterativ och en rekursiv metod och antalet steg mäts.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170508
 */
public class Problem1 {
	int a, b, c;
	int counter = 0;
	
	public Problem1() {
		System.out.println(euclideanIterativeAlgorithm(1071, 1029));
		System.out.println("Steg för iterativ algoritm: " + counter);
		counter = 0;
		System.out.println(euclideanRecursiveAlgorithm(1071, 1029));
		System.out.println("Steg för rekursiv algoritm: " + counter);
	}
	
	public static void main(String[] args) {
		new Problem1();
	}
	
	/**
	 * Iterativ metod för att hitta SGD av två heltalsvärden, a och b
	 * 
	 * @param a - Heltalsvä
	 * @param b
	 * @return 
	 */
	public int euclideanIterativeAlgorithm(int a, int b) {
		
		if(b == 0)
			return a;
		
		while (b != 0) {
			c = a % b;
			a = b;
			b = c;
			counter++;
		}
		
		return a;
	}
	
	/**
	 * Rekursiv metod för att hitta SGD av två heltalsvärden, a och b.
	 * 
	 * @param a - Heltalsvärde
	 * @param b - Heltalsvärde
	 * @return Returnerar metodanrop med variablerna a och b
	 */
	public int euclideanRecursiveAlgorithm(int a, int b) {
		
		if(b == 0)
			return a;
		
		c = a % b;
		a = b;
		b = c;
		counter++;
			
		return euclideanRecursiveAlgorithm(a, b);
	}
}