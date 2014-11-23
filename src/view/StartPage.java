package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;

// Class that has list of worlds to select from, welcome/title message, proceed/ok button, and world grid if include preview feature
public class StartPage extends JFrame {

	JPanel wl;
	JPanel wt;
	JPanel ok;
	JPanel gd;
	
	public StartPage() {
		
		wl = new StartPageWorldList();
		wt = new StartPageTitle();
		ok = new StartPageOK();
		gd = new StartPageGrid();
		
		add(wl, BorderLayout.WEST);
		add(wt, BorderLayout.NORTH);
		add(ok, BorderLayout.SOUTH);
		add(gd, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		JFrame frame = new StartPage();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Start Page World Selection");
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
