package view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Class to allow users to make name for macro and save it.
public class MacroName extends JPanel {

	JLabel label = new JLabel("Macro Name:");
	JTextField tx = new JTextField(25);
	JButton but = new JButton("Save");
	
	JPanel topPanel = new JPanel();
	
	public MacroName() {
	
		topPanel.add(label);
		topPanel.add(tx);
		topPanel.add(but);
		
		add(topPanel, BorderLayout.NORTH);
	}
}
