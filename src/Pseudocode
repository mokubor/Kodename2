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

public class Pseudocode extends JFrame {

	JPanel panel = new JPanel();
	
	public JButton deleteBut = new JButton("      Delete Code Fragment      ");
	public JButton clearBut = new JButton("      Clear Code      ");
	
	GridBagConstraints c = new GridBagConstraints();
	
	DefaultListModel dlmModelPseudo = new DefaultListModel();
	JList jlistPseudo;
	JScrollPane scrollerPseudo;
	
	JPanel panelPseudo = new JPanel();
	
	public Pseudocode() {
		
		c.insets = new Insets(25,25,25,25);
		
		panel.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		
		panel.add(deleteBut);
		panel.add(clearBut);
		
		add(panel, BorderLayout.SOUTH);
				
		String[] displayListLoop = new String[2];
		
		displayListLoop[0] = "Code Fragement Number 1";
		displayListLoop[1] = "Code Fragement Number 2";
		
		jlistPseudo = new JList(displayListLoop);
		jlistPseudo.setModel(dlmModelPseudo);
				
		for (int i = 0; i < displayListLoop.length; i++) {
			dlmModelPseudo.addElement("     " + displayListLoop[i] + "     ");
		}
				
		scrollerPseudo = new JScrollPane(jlistPseudo);
		panelPseudo.add(scrollerPseudo);
		add(panelPseudo, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		JFrame frame = new Pseudocode();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pseudocode");
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
