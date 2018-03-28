package Laboration3;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.gui.ViewerWindow;
import se.hig.aod_git.types.geomtypes.Point2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;
import se.hig.aod_git.visualization.Visualizable;

public class Quadtree {
	ArrayList<Double> arraylist;
	ArrayList<Point2D> pList;
	
	public Quadtree() {
		/*try {
			arraylist = loadList("H:\\workspace\\aod-git_lab3\\aod-git_lab3-3_testdata.txt", 257);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		ObjectRenderer renderer = new ObjectRenderer();
		ViewerWindow viewer = new ViewerWindow(renderer, "Quadtree");
		pList = new ArrayList<>();
		
		//for(int i = 500; i < 520; i++) {
			//Vertex2D v = new Vertex2D(i, i+1);
			//pList.add(new Point2D(v));
		//}
		Point2D p = new Point2D(300, 300);
		System.out.println(p.toString());
		renderer.addObject(p);
		renderer.setColor(Color.RED);
		//renderer.addObject(pList.get(0));
		//for(Point2D p : pList)
			//renderer.addObject(p);
	}
	
	private ArrayList <Double> loadList (String path, int size)
			throws FileNotFoundException, IOException
	{
		int s = 0;
		ArrayList <Double> list = new ArrayList <Double> ();
		BufferedReader in = new BufferedReader (new FileReader (path));
		String l;
		while ((l = in.readLine ()) != null && s < size)
		{
			s++;
			list.add (Double.parseDouble (l));
		}
		in.close ();
		return list;
	}
	
	public static void main(String[] args) {
		new Quadtree();
	}
}
