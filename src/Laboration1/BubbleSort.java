package Laboration1;

public class BubbleSort {

	public static void sort(int [] array) {

		int end = array.length-1;
		int pos;
		int temp;

		long before = System.currentTimeMillis();

		while(end > 0){
			pos = 0;

			while(pos < end){
				if (array[pos] > array[pos + 1]){
					temp = array[pos];
					array[pos] = array[pos + 1];
					array[pos + 1] = temp;	
					System.out.println("| Pos" + pos);
					System.out.println("End " + end);
				}		
				pos++;
			}
			end--;
		}
		
		long after = System.currentTimeMillis();
		System.out.println("Exekveringstid: " + (after - before) + " Millisekunder");
	}
}