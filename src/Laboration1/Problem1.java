package Laboration1;

import se.hig.aod_git.lab1.lists.ArrayList;
import se.hig.aod_git.lab1.lists.LinkedList;

/**
 * Klass för att testa hur långt det tar att mäta hur lång tid det tar att lägga in ett antal element till en ArrayList respektive LinkedList.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170426
 */
public class Problem1 {

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		int[] array = new int[6400];
		int listSize = 640000;
		
		for(int i = 0; i < listSize; i++) {
			linkedList.insertLast(i);
		}
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		long before = System.currentTimeMillis();
		
		for(int i = 0; i < array.length; i++) {
			linkedList.insertLast(array[i]);
		}
		
		long after = System.currentTimeMillis();
		
		System.out.println(after-before);
	}
}