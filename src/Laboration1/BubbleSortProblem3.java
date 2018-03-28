package Laboration1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BubbleSortProblem3 {

	ArrayList<Integer> a = new ArrayList<Integer>();
	int end = a.size()-1;
	int pos;
	int temp;

	public BubbleSortProblem3() {
		try {
			a = loadList("H:\\workspace\\aod-git_lab1\\data_640000.txt", 100);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		int step = 0;
		int [] array = new int[a.size()];
		for (int v : a)
		{
			array[step] = v;
			step++;
		}

		BubbleSort.sort(array);
		
	}

	public static void main(String[] args) {
		new BubbleSortProblem3();
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
}