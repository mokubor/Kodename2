package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

// Class for buttons allowing code to be deleted individually (or in bulk for conditionals) or cleared in its entirety
public class PseudocodeButtons extends JPanel {

	JPanel panel = new JPanel();
	
	public JButton deleteBut = new JButton("      Delete Code Fragment      ");
	public JButton clearBut = new JButton("      Clear Code      ");
	
	public PseudocodeButtons() {
		
		panel.add(deleteBut);
		panel.add(clearBut);
		
		add(panel, BorderLayout.SOUTH);
	}
}
