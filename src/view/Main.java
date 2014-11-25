package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*JPanel a = new BasicActions();
		JPanel b = new Conditions();
		JPanel c = new Customs();*/
		
		/*JFrame temp = new JFrame();
		
		temp.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));*/
		
		/*temp.add(a);
		temp.add(b);
		temp.add(c);*/
		
		/*JPanel ap = new ActionPanel();
		
		temp.add(ap);
		temp.setSize(140, 600);
		temp.setLocationRelativeTo(null);
		temp.setResizable(false);
		temp.setVisible(true);
		
		//temp.setDefaultCloseOperation(EXIT_ON_CLOSE);
		temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		temp.pack();*/
		int x = 10;
		int y = 10;
		MainWindow.createMainWindow(x, y);
	}

}
