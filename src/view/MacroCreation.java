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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// Class that holds the individual parts of Macro Creation screen and puts it together.
// It includes panel for buttons to remove code, list of selected code, list of available
// code to add, and panel for creating name and saving.
public class MacroCreation extends JFrame {

	JPanel mN;
	JPanel mBL;
	JPanel pL;
	JPanel pB;
	
	public MacroCreation() {
		
		pB = new PseudocodeButtons();
		add(pB, BorderLayout.SOUTH);
		
		pL = new PseudocodeList();
		add(pL, BorderLayout.CENTER);
		
		mBL = new MacroBasicLoop();
		add(mBL, BorderLayout.WEST);
		
		mN = new MacroName();
		add(mN, BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new MacroCreation();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Macro Creation");
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
