package Projekt.gui;

import Projekt.algorithm.Dijkstra;
import Projekt.datatypes.Edge;
import Projekt.datatypes.Node;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import se.hig.aod_git.gui.ObjectRenderer;
import se.hig.aod_git.gui.ViewerWindow;
import se.hig.aod_git.types.geomtypes.LineString2D;
import se.hig.aod_git.types.geomtypes.Vertex2D;

/**
 * Klass som bygger upp och visar fönstret för programmet. 
 * 
 * @author tfk12coo, ofk15lkg
 * @version 2017-06-02
 */
public class Window {
	private List<Node> path = new ArrayList<>();
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem drawGraph;
	private JMenuItem shortestPath;
	private ObjectRenderer renderer;
	private ViewerWindow viewer;
	private Node[] vertices;
	private LineString2D shortestLine;
	private int start = 0, end = 0;
	private int nbrOfNodes = 0;
	private JComboBox<Integer> combo;
	private Dijkstra dijkstra = new Dijkstra();
	private LineString2D line1 = new LineString2D();
	private LineString2D line2 = new LineString2D();
	private LineString2D line3 = new LineString2D();
	private LineString2D line4 = new LineString2D();
	private LineString2D line5 = new LineString2D();
	private LineString2D line6 = new LineString2D();
	private LineString2D line7 = new LineString2D();
	private LineString2D line8 = new LineString2D();
	private LineString2D line9 = new LineString2D();
	private LineString2D line10 = new LineString2D();
	private LineString2D line11 = new LineString2D();
	private LineString2D line12 = new LineString2D();
	private LineString2D line13 = new LineString2D();
	private LineString2D line14 = new LineString2D();
	private LineString2D line15 = new LineString2D();
	private LineString2D line16 = new LineString2D();
	private LineString2D line17 = new LineString2D();
	private LineString2D line18 = new LineString2D();
	private LineString2D line19 = new LineString2D();
	private LineString2D line20 = new LineString2D();
	private LineString2D line21 = new LineString2D();
	private LineString2D line22 = new LineString2D();
	private LineString2D line23 = new LineString2D();
	
	public Window() {
		renderer = new ObjectRenderer();
		viewer = new ViewerWindow(renderer, "Graph");
		
		bar = new JMenuBar();
		menu = new JMenu("Meny");
		drawGraph = new JMenuItem("Rita ut en graf");
		shortestPath = new JMenuItem("Beräkna kortaste avstånd");
		
		bar.add(menu);
		menu.add(drawGraph);
		menu.add(shortestPath);
		viewer.setJMenuBar(bar);
		
		drawGraph.addActionListener(new DrawGraph());
		shortestPath.addActionListener(new ShortestPath());
		viewer.revalidate();
	}
	
	public class DrawGraph implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new JFrame();
			JButton button = new JButton("Ok");
			combo = new JComboBox<>();
			JPanel panel = new JPanel();
			
			combo.addItem(3);
			combo.addItem(6);
			combo.addItem(12);
			
			panel.add(combo);
			panel.add(button);
			frame.add(BorderLayout.NORTH, new JLabel("Välj hur många noder grafen ska ha"));
			frame.add(BorderLayout.SOUTH, panel);
			frame.setResizable(false);
			frame.setLocationRelativeTo(viewer);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		
			char c = 'A';
			
			vertices = new Node[nbrOfNodes];
			for(int i=0; i<vertices.length; i++) {
				vertices[i] = new Node("" + c);
				c++;
			}
		
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					nbrOfNodes = (int) combo.getSelectedItem();
					frame.dispose();
				}
			});
			
			switch(nbrOfNodes) {
			case 3:
				vertices[0].setVertex(new Vertex2D(1,1));
				vertices[1].setVertex(new Vertex2D(1,7));
				vertices[2].setVertex(new Vertex2D(7,1));
				
				vertices[0].setAdjacentNodes(new Edge[]{ new Edge(vertices[1],3), new Edge(vertices[2],1)});
				vertices[1].setAdjacentNodes(new Edge[]{ new Edge(vertices[0],3), new Edge(vertices[2],1)});
				vertices[2].setAdjacentNodes(new Edge[]{ new Edge(vertices[0],1), new Edge(vertices[1],1)});
				
				line1.appendVertex(vertices[0].getVertex()); 
				line1.appendVertex(vertices[1].getVertex());
				line2.appendVertex(vertices[1].getVertex());
				line2.appendVertex(vertices[2].getVertex());
				line3.appendVertex(vertices[2].getVertex());
				line3.appendVertex(vertices[0].getVertex());
				
				renderer.addObject(line1);
				renderer.addObject(line2);
				renderer.addObject(line3);
				viewer.repaint();
				viewer.validate();
				break;
			case 6:
				vertices[0].setVertex(new Vertex2D(1,1));
				vertices[1].setVertex(new Vertex2D(1,4));
				vertices[2].setVertex(new Vertex2D(4,1));
				vertices[3].setVertex(new Vertex2D(4,4));
				vertices[4].setVertex(new Vertex2D(6,6));
				vertices[5].setVertex(new Vertex2D(7,4));
				
				vertices[0].setAdjacentNodes(new Edge[]{ new Edge(vertices[1],3), new Edge(vertices[2],1)});
				vertices[1].setAdjacentNodes(new Edge[]{ new Edge(vertices[0],3), new Edge(vertices[2],1),
						new Edge(vertices[3],2)});
				vertices[2].setAdjacentNodes(new Edge[]{ new Edge(vertices[0],1), new Edge(vertices[1],1),
						new Edge(vertices[3],1), new Edge(vertices[5],7)});
				vertices[3].setAdjacentNodes(new Edge[]{ new Edge(vertices[1],2), new Edge(vertices[2],1),
						new Edge(vertices[4],10)});
				vertices[4].setAdjacentNodes(new Edge[]{ new Edge(vertices[3],10), new Edge(vertices[5],1)});
				vertices[5].setAdjacentNodes(new Edge[]{ new Edge(vertices[2],7), new Edge(vertices[4],1)});
				
				line1.appendVertex(vertices[0].getVertex()); 
				line1.appendVertex(vertices[1].getVertex());
				line2.appendVertex(vertices[1].getVertex());
				line2.appendVertex(vertices[2].getVertex());
				line3.appendVertex(vertices[1].getVertex());
				line3.appendVertex(vertices[3].getVertex());
				line4.appendVertex(vertices[2].getVertex()); 
				line4.appendVertex(vertices[3].getVertex());
				line5.appendVertex(vertices[3].getVertex());
				line5.appendVertex(vertices[4].getVertex());
				line6.appendVertex(vertices[4].getVertex());
				line6.appendVertex(vertices[5].getVertex());
				line7.appendVertex(vertices[5].getVertex());
				line7.appendVertex(vertices[2].getVertex());
				line8.appendVertex(vertices[2].getVertex());
				line8.appendVertex(vertices[0].getVertex());
				
				renderer.addObject(line1);
				renderer.addObject(line2);
				renderer.addObject(line3);
				renderer.addObject(line4);
				renderer.addObject(line5);
				renderer.addObject(line6);
				renderer.addObject(line7);
				renderer.addObject(line8);
				break;
			case 12:
				vertices[0].setVertex(new Vertex2D(1,1));
				vertices[1].setVertex(new Vertex2D(1,4));
				vertices[2].setVertex(new Vertex2D(4,1));
				vertices[3].setVertex(new Vertex2D(4,4));
				vertices[4].setVertex(new Vertex2D(6,6));
				vertices[5].setVertex(new Vertex2D(8,1));
				vertices[6].setVertex(new Vertex2D(8,4));
				vertices[7].setVertex(new Vertex2D(11,3));
				vertices[8].setVertex(new Vertex2D(11,5));
				vertices[9].setVertex(new Vertex2D(13,7));
				vertices[10].setVertex(new Vertex2D(11,8));
				vertices[11].setVertex(new Vertex2D(9,7));
				
				vertices[0].setAdjacentNodes(new Edge[]{ new Edge(vertices[1],1), new Edge(vertices[2],2)});
				vertices[1].setAdjacentNodes(new Edge[]{ new Edge(vertices[0],1), new Edge(vertices[2],2),
						new Edge(vertices[3],3)});
				vertices[2].setAdjacentNodes(new Edge[]{ new Edge(vertices[0],2), new Edge(vertices[1],2),
						new Edge(vertices[3],3), new Edge(vertices[5],7)});
				vertices[3].setAdjacentNodes(new Edge[]{ new Edge(vertices[1],2), new Edge(vertices[2],1),
						new Edge(vertices[4],10)});
				vertices[4].setAdjacentNodes(new Edge[]{ new Edge(vertices[3],10), new Edge(vertices[5],1)});
				vertices[5].setAdjacentNodes(new Edge[]{ new Edge(vertices[2],7), new Edge(vertices[4],1)});
				vertices[6].setAdjacentNodes(new Edge[]{ new Edge(vertices[2],6), new Edge(vertices[3],5),
						new Edge(vertices[4],1), new Edge(vertices[5],1), new Edge(vertices[7],2), new Edge(vertices[8],4)});
				vertices[7].setAdjacentNodes(new Edge[]{ new Edge(vertices[5],8), new Edge(vertices[6],2),
						new Edge(vertices[8],3)});
				vertices[8].setAdjacentNodes(new Edge[]{ new Edge(vertices[4],1), new Edge(vertices[6],4),
						new Edge(vertices[7],3)});
				vertices[9].setAdjacentNodes(new Edge[]{ new Edge(vertices[8], 2), new Edge(vertices[10], 1)});
				vertices[10].setAdjacentNodes(new Edge[]{ new Edge(vertices[9],1), new Edge(vertices[11],4)});
				vertices[11].setAdjacentNodes(new Edge[]{ new Edge(vertices[4],2), new Edge(vertices[10],4)});
				
				line1.appendVertex(vertices[0].getVertex()); 
				line1.appendVertex(vertices[1].getVertex());
				line2.appendVertex(vertices[1].getVertex());
				line2.appendVertex(vertices[2].getVertex());
				line3.appendVertex(vertices[1].getVertex());
				line3.appendVertex(vertices[3].getVertex());
				line4.appendVertex(vertices[2].getVertex()); 
				line4.appendVertex(vertices[3].getVertex());
				line5.appendVertex(vertices[3].getVertex());
				line5.appendVertex(vertices[4].getVertex());
				line6.appendVertex(vertices[4].getVertex());
				line6.appendVertex(vertices[1].getVertex());
				line7.appendVertex(vertices[0].getVertex());
				line7.appendVertex(vertices[2].getVertex());
				line8.appendVertex(vertices[2].getVertex());
				line8.appendVertex(vertices[5].getVertex());
				line9.appendVertex(vertices[2].getVertex());
				line9.appendVertex(vertices[5].getVertex());
				line10.appendVertex(vertices[3].getVertex());
				line10.appendVertex(vertices[6].getVertex());
				line11.appendVertex(vertices[5].getVertex());
				line11.appendVertex(vertices[6].getVertex());
				line12.appendVertex(vertices[5].getVertex());
				line12.appendVertex(vertices[7].getVertex());
				line13.appendVertex(vertices[4].getVertex());
				line13.appendVertex(vertices[11].getVertex());
				line14.appendVertex(vertices[4].getVertex());
				line14.appendVertex(vertices[6].getVertex());
				line15.appendVertex(vertices[4].getVertex());
				line15.appendVertex(vertices[8].getVertex());
				line17.appendVertex(vertices[6].getVertex());
				line17.appendVertex(vertices[7].getVertex());
				line18.appendVertex(vertices[6].getVertex());
				line18.appendVertex(vertices[8].getVertex());
				line19.appendVertex(vertices[7].getVertex());
				line19.appendVertex(vertices[8].getVertex());
				line20.appendVertex(vertices[8].getVertex());
				line20.appendVertex(vertices[9].getVertex());
				line21.appendVertex(vertices[9].getVertex());
				line21.appendVertex(vertices[10].getVertex());
				line22.appendVertex(vertices[10].getVertex());
				line22.appendVertex(vertices[11].getVertex());
				line23.appendVertex(vertices[2].getVertex());
				line23.appendVertex(vertices[6].getVertex());
				
				renderer.addObject(line1);
				renderer.addObject(line2);
				renderer.addObject(line3);
				renderer.addObject(line4);
				renderer.addObject(line5);
				renderer.addObject(line6);
				renderer.addObject(line7);
				renderer.addObject(line8);
				renderer.addObject(line9);
				renderer.addObject(line10);
				renderer.addObject(line11);
				renderer.addObject(line12);
				renderer.addObject(line13);
				renderer.addObject(line14);
				renderer.addObject(line15);
				renderer.addObject(line16);
				renderer.addObject(line17);
				renderer.addObject(line18);
				renderer.addObject(line19);
				renderer.addObject(line20);
				renderer.addObject(line21);
				renderer.addObject(line22);
				renderer.addObject(line23);
				break;
			}
		
			for(int i = 0; i < vertices.length-1; i++) {
				System.out.print(vertices[i].getName() + " ");
				for(Edge edge : vertices[i].getAdjacentNodes()) {
					Node v = edge.getStartNode();
					System.out.print(v.getName() + "," + edge.getCost() + " ");
				}
				System.out.println();
			}
		}
	}
	
	/**
	 * 
	 * 
	 */
	public class ShortestPath implements ActionListener {
		JComboBox<String> startCombo = new JComboBox<>();
		JComboBox<String> endCombo = new JComboBox<>();
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame2 = new JFrame();
			JButton button = new JButton("OK");
			
			if(vertices.length == 0) {
				JOptionPane.showMessageDialog(null, "Du måste rita ut en graf först!");
				return;
			}
			
			for (Node n : vertices) {
				  startCombo.addItem(n.getName());
				  endCombo.addItem(n.getName());
			}
			
			frame2.add(BorderLayout.NORTH, new JLabel("Välj start och slutnod"));
			JPanel panel = new JPanel();
			panel.add(new JLabel("Startnod:"));
			panel.add(startCombo);
			panel.add(new JLabel("Slutnod:"));
			panel.add(endCombo);
			panel.add(button);
			
			frame2.add(panel);
			frame2.setResizable(false);
			frame2.setLocationRelativeTo(viewer);
			frame2.pack();
			frame2.setVisible(true);
			
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					start = (int) startCombo.getSelectedIndex();
					end = (int) endCombo.getSelectedIndex();
					frame2.dispose();
				}
			});
			
			System.out.println("start: " + start);
			System.out.println("slut: " + end);
			
			long before = 0, after = 0;
			
			before = System.nanoTime();
			dijkstra.shortestPath(vertices[start], vertices[end]);
			after = System.nanoTime();
			path = dijkstra.path(vertices[end]);
	
			System.out.println("Tid i nanosekunder: " + (after-before));
		
			shortestLine = new LineString2D();
			
			System.out.println("Shortest path");
			for (Node v : path) {
				System.out.println(v.getName() + " "  + v.getMinDistance());
				shortestLine.appendVertex(v.getVertex());
			}
			renderer.setColor(Color.RED);
			renderer.addObject(shortestLine);
			viewer.revalidate();
			viewer.repaint();
		}
	}
}