package Laboration2;

/**
 * Klass f�r att hitta SGD givet tv� heltal, SGD ber�knas med b�de en iterativ och en rekursiv metod och antalet steg m�ts.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170508
 */
public class Problem1 {
	int a, b, c;
	int counter = 0;
	
	public Problem1() {
		System.out.println(euclideanIterativeAlgorithm(1071, 1029));
		System.out.println("Steg f�r iterativ algoritm: " + counter);
		counter = 0;
		System.out.println(euclideanRecursiveAlgorithm(1071, 1029));
		System.out.println("Steg f�r rekursiv algoritm: " + counter);
	}
	
	public static void main(String[] args) {
		new Problem1();
	}
	
	/**
	 * Iterativ metod f�r att hitta SGD av tv� heltalsv�rden, a och b
	 * 
	 * @param a - Heltalsv�
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
	 * Rekursiv metod f�r att hitta SGD av tv� heltalsv�rden, a och b.
	 * 
	 * @param a - Heltalsv�rde
	 * @param b - Heltalsv�rde
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