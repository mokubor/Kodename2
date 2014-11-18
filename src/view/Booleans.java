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

public class Booleans  {
	
	public Booleans() {
		
		String[] listofBooleans = new String[6];
		
		listofBooleans[0] = "   Facing East   ";
		listofBooleans[1] = "   Facing West   ";
		listofBooleans[2] = "   Facing North   ";
		listofBooleans[3] = "   Facing South   ";
		listofBooleans[4] = "   Facing Beeper   ";
		listofBooleans[5] = "   Facing Wall   ";
				
		JList list = new JList(listofBooleans);
        JPanel panel = new JPanel();
        panel.add(list);
        JOptionPane.showMessageDialog(null, panel, "Please select one of the booleans", JOptionPane.OK_CANCEL_OPTION);
		
	}
	
	public static void main(String[] args) {
		Booleans frame = new Booleans();
	}
}
