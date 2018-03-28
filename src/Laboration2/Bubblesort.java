package Laboration2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Sorteringsalgoritmen Bubblesort för sortering av en array givet ett antal värden som hämtas från fil.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170504
 */
public class Bubblesort {
	ArrayList<Integer> a = new ArrayList<Integer>();
	
	public Bubblesort() {
		try {
			a = loadList("H:\\workspace\\aod-git_lab1\\data_640000.txt", 640000);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		Collections.sort(a, Collections.reverseOrder());
		int step = 0;
		int [] array = new int[a.size()];
		for (int v : a)
		{
			array[step] = v;
			step++;
		}
		
		sort(array);
	}
	
	/**
	 * Metod för att sortera array med Bubblesort
	 * 
	 * @param array - Arrayen som ska sorteras
	 */
	public static void sort(int [] array) {
		boolean changed = true;
		int end = array.length-1;
		int pos;
		int temp;
		
		long before = System.currentTimeMillis();
		while(changed == true) {
			changed = false;
			pos = 0;

			while(pos < end){
				if (array[pos] > array[pos + 1]){
					temp = array[pos];
					array[pos] = array[pos + 1];
					array[pos + 1] = temp;	
					changed = true;
				}		
				pos++;
			}
			end--;
		}
		long after = System.currentTimeMillis();
		System.out.println("Tid i millisekunder: " + (after-before));
	}

	private ArrayList <Integer> loadList (String path, int size)
			throws FileNotFoundException, IOException
	{
		int s = 0;
		ArrayList <Integer> list = new ArrayList <Integer> ();
		BufferedReader in = new BufferedReader (new FileReader (path));
		String l;
		while ((l = in.readLine ()) != null && s < size)
		{
			s++;
			list.add (Integer.parseInt (l));
		}
		in.close ();
		return list;
	}
	
	public static void main(String[] args) {
		new Bubblesort();
	}

}
