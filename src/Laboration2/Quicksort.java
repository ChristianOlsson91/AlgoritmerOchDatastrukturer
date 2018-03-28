package Laboration2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Klass som använder algoritmen Quicksort för att sortera en lista av heltal.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170508 
 */
public class Quicksort {
	ArrayList<Integer> a = new ArrayList<Integer>();
	int[] array;
	int i;
	int j;
	int temp;
	int x;

	public Quicksort() {
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
		
		long before = System.currentTimeMillis();
		sort(array, 0, array.length-1);
		long after = System.currentTimeMillis();
		
		System.out.println("Tid i millisekunder: " + (after-before));
	}
	
	/**
	 * Metod för att sortera en array med heltalsvärden enligt algoritmen Quicksort
	 * 
	 * @param a - arrayen som ska sorteras
	 * @param l - elementet till höger
	 * @param r - elementet till vänster
	 */
	public void sort(int[] a, int l, int r) {
		i = l;
		j = r;
		x = a[(l+r)/2];

		do {
			while(a[i] < x) {
				i++;
			}

			while(x < a[j]) {
				j--;
			}

			if(i <= j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		while(i <= j);
		
		if(l < j)
			sort(a, l, j);

		if(i < r)
			sort(a, i, r);
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
		new Quicksort();
	}
}