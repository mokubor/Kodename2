/**
 * @author Miracle Okubor
 */
package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;

/**
 * Starting Class of the Kodename Project.
 */
public class Main {
	
	static Window currentWindow;
	
	public static void main(String[] args) {
		
		LoadSession.createLoadSessionPage();
	}
}
