package view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.*;

public class MainWindow extends JFrame{
	
	JPanel action;
	JPanel pseudo;
	JPanel world;
	static Controller cntrl;
	
	MainWindow(int x, int y){
		super("Main Window");
		
		action = new ActionPanel(cntrl);
		pseudo = new PseudocodePanel();
		world = new WorldPanel(x, y);
		
		setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
		add(action);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(pseudo);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(world);
		add(Box.createRigidArea(new Dimension(0,10)));
		
	}
	
	public static void createMainWindow(int x, int y/*, Controller cntrl*/) {
		//initialize controller
		//cntrl = new Controller(x, y);
	
		JFrame frame = new MainWindow(x,y);
		frame.setSize(300, 300);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
