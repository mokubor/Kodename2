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
	
	public Booleans() {
		
		String[] listofBooleans = {"Facing East", "Facing West", "Facing North", "Facing South", "Beeper Here", "Facing Wall"};
		
		int selectedBoolean = -1;					

		// Currently it loops until an option is selected. So it won't accept closing of dialog. Maybe we should allow
		// users to X out of it and then we would not print if/loop statement in pseudocode.
		while (selectedBoolean == -1) {
			selectedBoolean = JOptionPane.showOptionDialog(null,
				    "Please select one of the following conditions that determine whether ensuing statements execute",
				    "Test Condition for If statement or Loop", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				    null, listofBooleans, listofBooleans[5]);
			
		}
		
		// Print statement to show how value would be used
		System.out.println("You selected: " + listofBooleans[selectedBoolean]);
	}
	
	public static void main(String[] args) {
		Booleans frame = new Booleans();
	}
}
