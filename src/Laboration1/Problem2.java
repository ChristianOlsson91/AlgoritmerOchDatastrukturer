package Laboration1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Algoritm för att hitta det minsta avståndet givet ett antal punkter som hämtas från fil.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170426
 */
public class Problem2 {
	int[][] returnedList;
	int dx;
	int dy;
	double distance;
	double minDistance = Double.MAX_VALUE;
	
	public Problem2() {
		try {
			returnedList = loadList("C:\\Users\\Christian\\workspace\\aod-git_lab1\\points_640000.txt", 320000);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long before = System.currentTimeMillis();
		for(int j = 0; j < returnedList.length-1; j++) {
			for(int i = j+1; i < returnedList.length-1; i++) {
				dx = returnedList[j][0] - returnedList[i][0];
				dy = returnedList[j][1] - returnedList[i][1];
				distance = Math.sqrt(dx*dx + dy*dy);
				
				if(distance < minDistance){
					minDistance = distance;
				}
			}
		}
		long after = System.currentTimeMillis();
		System.out.println(after-before);
		System.out.println(minDistance);
	}
	
	public static void main(String[] args) {
		new Problem2();
	}
	
	/**
	* Method for reading ’size’ points from a file with
	* path ’path’. The result is stored in a twodimensional
	* array of integers where each element consists of an
	* array with two elements; x is stored in element 0,
	* y in element 1.
	*/
	private int[][] loadList (String path, int size) throws FileNotFoundException, IOException {
		int s = 0;
		ArrayList <Integer[]> list = new ArrayList <Integer[]> ();
		BufferedReader in = new BufferedReader (new FileReader (path));
		String l;
		String[] elementBuffer;
		Integer[] valueBuffer;
		
		while ((l = in.readLine ()) != null && s < size) {
			s++;
			elementBuffer = l.trim().split(" ");
			valueBuffer = new Integer[2];
			valueBuffer[0] = Integer.parseInt (elementBuffer[0]);
			valueBuffer[1] = Integer.parseInt (elementBuffer[1]);
			list.add (valueBuffer);
		}
		in.close ();
		int[][] returnList = new int[list.size()][2];
		Integer[] data;
		for (int i = 0; i < list.size(); i++)
		{
			data = list.get (i);
			returnList[i][0] = data[0];
			returnList[i][1] = data[1];
		}
		return returnList;
	}
}