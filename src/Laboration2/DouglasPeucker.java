package Laboration2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;

import se.hig.aod_git.algorithms.geomalg.GeomAlgs2D;
import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.gui.ViewerWindow;
import se.hig.aod_git.types.geomtypes.LineString2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

/**
 * Klass som använder sig av Douglas-Peucker algoritmen för att reducera en linje givet ett antal punkter som
 * hämtas från fil eller som användaren matar in från tangentbordet. Resultatet visas både grafiskt och i konsolen.
 * 
 * @author tfk12coo, ofk15lkg
 * @version 170508
 */
public class DouglasPeucker {
	ArrayList<Vertex2D> original = new ArrayList<>();
	LineString2D originalline = new LineString2D();
	LineString2D resultline = new LineString2D();
	Vertex2D vMax;
	double[][] list;
	int i = 0;
	int j;
	double dist;
	double eps;
	
	public DouglasPeucker() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Välj '1' om du vill hämta punkter från fil, '2' om du vill mata in manuellt: ");
		String choice = scan.nextLine();
		System.out.print("Välj ett värde på epsilon: ");
		eps = scan.nextDouble();
		
		if(choice.equals("1")) {
			try {
				list = loadList("H:\\workspace\\aod-git_lab2\\aod-git_lab2\\dp_testpoints.txt", 20);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			for(int k = 0; k < list.length; k++)
				original.add(new Vertex2D(list[k][0], list[k][1]));
			
			for(Vertex2D v : original)
				originalline.appendVertex(v);
		}
		
		else if(choice.equals("2")) {
			System.out.print("Välj hur många punkter du vill mata in: ");
			int nbrOfPoints = scan.nextInt();
			int counter = 1;
	
			while(counter < nbrOfPoints+1) {
				System.out.print("Punkt " + counter + ": ");
				double x = scan.nextDouble();
				double y = scan.nextDouble();
				Vertex2D v = new Vertex2D(x, y);
				original.add(v);
				counter++;
			
				for(Vertex2D vertex : original)
					originalline.appendVertex(vertex);
			}
		}
		scan.close();
		
		j = original.size()-1;
		simplify(original, i, j);
		System.out.println("Original linjen: " + originalline);
		System.out.println("Reducerade linjen: " + resultline);
		System.out.println(original);
	
		ObjectRenderer renderer = new ObjectRenderer();
		ViewerWindow viewer = new ViewerWindow(renderer, "Douglas-Peucker");
		viewer.add(BorderLayout.NORTH, new JLabel("Röd linje = originalet     Blå linje = reducerad"));
		viewer.show();
		renderer.setScaleFactor(40, 40);
		renderer.setColor(Color.RED);
		renderer.addObject(originalline);
		renderer.setColor(Color.BLUE);
		renderer.addObject(resultline);
	}
	
	/**
	 * Metod för att givet ett antal noder i listan 'original' generalisera linjen med hjälp av algoritmen
	 * Douglas-Peucker
	 * 
	 * @param original - ArrayList som innehåller noder av typen Vertex2D
	 * @param i - Första positionen i listan
	 * @param j - Sista positionen i listan
	 */
	public void simplify(ArrayList<Vertex2D> original, int i, int j) {
		int index = 0;
		resultline.appendVertex(original.get(i));
			for(int l = index; l < original.size()-1; l++) {
				dist = GeomAlgs2D.distanceToLine(original.get(i), original.get(j), original.get(l));
				if(dist > eps) {
					index = l;
				}
			vMax = new Vertex2D(original.get(index).x(), original.get(index).y());
			resultline.appendVertex(vMax);
		}
		resultline.appendVertex(original.get(j));
	}
	
	/**
	* Method for reading ’size’ points from a file with
	* path ’path’. The result is stored in a twodimensional
	* array of integers where each element consists of an
	* array with two elements; x is stored in element 0,
	* y in element 1.
	*/
	private double[][] loadList (String path, int size) throws FileNotFoundException, IOException {
		int s = 0;
		ArrayList <double[]> list = new ArrayList <double[]> ();
		BufferedReader in = new BufferedReader (new FileReader (path));
		String l;
		String[] elementBuffer;
		double[] valueBuffer;
		
		while ((l = in.readLine ()) != null && s < size) {
			s++;
			elementBuffer = l.trim().split(" ");
			valueBuffer = new double[2];
			valueBuffer[0] = Double.parseDouble (elementBuffer[0]);
			valueBuffer[1] = Double.parseDouble (elementBuffer[1]);
			list.add (valueBuffer);
		}
		in.close ();
		double[][] returnList = new double[list.size()][2];
		double[] data;
		for (int i = 0; i < list.size(); i++)
		{
			data = list.get (i);
			returnList[i][0] = data[0];
			returnList[i][1] = data[1];
		}
		return returnList;
	}

	public static void main(String[] args) {
		new DouglasPeucker();
	}
}