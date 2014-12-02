package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

public class WorldGrid extends JPanel {
	int rows;
	int cols;
	
	public WorldGrid(int rows, int cols){
		super();
		final int borderWidth = 1;

		GridLayout layout = new GridLayout(rows, cols);
		
		JPanel panel = new JPanel(layout);
		
		//delete
		/*JLabel wall = new JLabel(" W ");
		wall.setVisible(true);
		wall.setSize(10, 10);
		JLabel beeper = new JLabel(" B ");
		beeper.setVisible(true);
		beeper.setSize(10, 10);
		JLabel Karel = new JLabel (" K ");
		Karel.setVisible(true);
		Karel.setSize(10, 10);*/
	
		JLabel[][] labels = new JLabel[rows][cols];
		Util.setLabels(labels);
		
		panel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		int i = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				JLabel label = new JLabel("   "+i+"  h ");
				labels[row][col] = label;
				label.setVisible(true);
				label.setSize(10, 10);
				if (row == 0) {
					if (col == 0) {
						// Top left corner, draw all sides
						label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					else {
						// Top edge, draw all sides except left edge
						label.setBorder(BorderFactory.createMatteBorder(borderWidth, 
	                                                                	0, 
	                                                                	borderWidth, 
	                                                                	borderWidth, 
	                                                                	Color.BLACK));
					}
				}
				else {
					if (col == 0) {
						// Left-hand edge, draw all sides except top
						label.setBorder(BorderFactory.createMatteBorder(0, 
	                                                             		borderWidth, 
	                                                             		borderWidth, 
	                                                             		borderWidth, 
	                                                             		Color.BLACK));
					}
					else {
						// Neither top edge nor left edge, skip both top and left lines
						label.setBorder(BorderFactory.createMatteBorder(0, 
	                                                                	0, 
	                                                                	borderWidth, 
	                                                                	borderWidth, 
	                                                                	Color.BLACK));
					}
				}
				
				
					panel.add(label);//take out of else
				
				i++;
				
			}
		}
	
		add(panel);
	}
	
	
	/*public static void main(String[] args) {
		JFrame temp = new JFrame();
		
		temp.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
		
		WorldGrid ap = new WorldGrid(6, 6);
		
		temp.add(ap);
		temp.setSize(140, 600);
		temp.setLocationRelativeTo(null);
		//temp.setResizable(false);
		temp.setVisible(true);
		
		//temp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temp.pack();
	}*/
	
}
