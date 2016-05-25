/**
 * @author Miracle Okubor
 */
package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

/**
 * A panel which contains an un-editable text console which displays status messages, 
 * such as which code statement was just executed or error messages, for the Kodename user to 
 * see during program execution.
 */
public class WorldConsole extends JPanel{
	static JTextArea console;
	static String console_text = "";
	
	public WorldConsole(){
		super();
		
		console = new JTextArea(8,20);
		
		console.setEditable(false);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5,15));
		
		console.setText(console_text);
		
		JScrollPane scroll = new JScrollPane(console);
		add(scroll);
	}
	
	/**
	 * Adds a new message to the world panel text console
	 * @param String t
	 */
	static void edit(String t){
		console_text = console_text.concat("\n");
		console_text = console_text.concat(t);
		console.setText(console_text);
	}
	
	/**
	 * Deletes all content of the world panel text console
	 */
	static void reset(){
		console_text = "";
		console.setText(console_text);
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
