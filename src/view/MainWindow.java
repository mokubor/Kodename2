package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.*;

public class MainWindow extends JFrame{
	
	JPanel action;
	JPanel world;
	static Controller cntrl;
	
	PseudocodeList pL = new PseudocodeList();
	PseudocodeButtons pB = new PseudocodeButtons();	
	
	MainWindow(int x, int y){
		super("Main Window");
		
		action = new ActionPanel(cntrl);
		world = new WorldPanel(x, y);
		
		//setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
		add(action, BorderLayout.WEST);
		//add(Box.createRigidArea(new Dimension(0,10)));
		//add(Box.createRigidArea(new Dimension(0,10)));
		add(pL, BorderLayout.CENTER);
		add(pB, BorderLayout.SOUTH);
		add(world, BorderLayout.EAST);
		//add(Box.createRigidArea(new Dimension(0,10)));
		
		addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	System.exit(0);
            }
        });
	}
	
	/*public static void main(String[] args) {
		MainWindow frame = new MainWindow(10,10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Window");
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}*/
	
	public static void createMainWindow(int x, int y) {
		
		cntrl = new Controller(x, y);
		
		JFrame frame = new MainWindow(x,y);
		frame.setSize(300, 300);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}