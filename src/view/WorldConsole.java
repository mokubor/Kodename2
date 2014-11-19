package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class WorldConsole extends JPanel{
	JTextArea console;
	
	public WorldConsole(){
		super();
		
		console = new JTextArea(8,20);
		
		console.setEditable(false);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5,15));
		add(console);
	}
	
	void edit(String t){
		console.setText(t);
	}
	
	/*public static void main(String[] args) {
		JFrame temp = new JFrame();
		
		temp.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
		
		WorldConsole ap = new WorldConsole();
		
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
