package Laboration1;

/**
 * Sorteringsalgoritmen Bubblesort för sortering av en array bestående av sex heltal.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170426
 */
public class Problem3 {
	
	public static void main(String[] args) {
		int[] a = new int[6];
		int end = a.length-1;
		int pos;
		int temp;
		
		a[0] = 9;
		a[1] = 17;
		a[2] = 16;
		a[3] = 0;
		a[4] = 7;
		a[5] = 6;
		
		while (end > 0) {
			pos = 0;
			
			while (pos < end) {
				if(a[pos] > a[pos+1]) {
					temp = a[pos];
					a[pos] = a[pos+1];
					a[pos+1] = temp;
					System.out.print("|  Pos " + pos);
					System.out.print(" End " + end + "   ");
				}
				pos++;
				for(int index : a)
					System.out.print("|" + index);
			}
			end--;
		}
		System.out.println();
		for(int index : a)
			System.out.println(index);
	}
}