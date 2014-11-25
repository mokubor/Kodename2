package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// Pop up dialog for when conditional loop or if statement is selected, a boolean is selected to determine test condition
public class Booleans  {
	
	public String chosenBoolean = "";
	
	public Booleans() {
		
		Object[] listofBooleans = {"Facing East", "Facing West", "Facing North", "Facing South", "Next to a Beeper", "Front is Clear",
				"Right is Clear", "Left is Clear"};
		
		chosenBoolean = (String)JOptionPane.showInputDialog(null,
				"Please select one of the following conditions \nthat determine whether ensuing statements execute", 
				"Test Condition for If statement or Loop",
		                    JOptionPane.PLAIN_MESSAGE, null, listofBooleans, listofBooleans[0]);

		// Print statement to show how value would be used
		System.out.println("You selected: " + chosenBoolean);
		
		// If s is null, then user either X'd out dialog or pressed Cancel
	}
	
	public static void main(String[] args) {
		Booleans frame = new Booleans();
	}
}
