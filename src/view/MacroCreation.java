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

public class MacroCreation extends JFrame {

	JPanel panel = new JPanel();
	JPanel pseudoPanel = new JPanel();
	
	public JButton deleteBut = new JButton("      Delete Code Fragment      ");
	public JButton clearBut = new JButton("      Clear Code      ");
		
	GridBagConstraints c = new GridBagConstraints();
	
	DefaultListModel dlmModelBasic = new DefaultListModel();
	JList jlistBasic;
	JScrollPane scrollerBasic;
	
	JPanel panelLoop = new JPanel();
	DefaultListModel dlmModelLoop = new DefaultListModel();
	JList jlistLoop;
	JScrollPane scrollerLoop;
	
	public MacroCreation() {
		
		c.insets = new Insets(25,25,25,25);
		
		panel.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		
		panel.add(deleteBut);
		panel.add(clearBut);
		
		add(panel, BorderLayout.SOUTH);
		
		String[] displayList = new String[6];
		
		displayList[0] = "Turn Left";
		displayList[1] = "Turn Right";
		displayList[2] = "Move Forward";
		displayList[3] = "Pick Up Beeper";
		displayList[4] = "If Else Statement";
		displayList[5] = "For Loop";
				
		jlistBasic = new JList(displayList);
		jlistBasic.setModel(dlmModelBasic);
				
		for (int i = 0; i < displayList.length; i++) {
			dlmModelBasic.addElement("     " + displayList[i] + "     ");
		}
				
		scrollerBasic = new JScrollPane(jlistBasic);
		
		pseudoPanel.add(scrollerBasic);
		add(pseudoPanel, BorderLayout.WEST);
		
		String[] displayListLoop = new String[2];
		displayListLoop[0] = "Code Fragment 1";
		displayListLoop[1] = "Code Fragment 2";
		
		jlistLoop = new JList(displayListLoop);
		jlistLoop.setModel(dlmModelLoop);
				
		for (int i = 0; i < displayListLoop.length; i++) {
			dlmModelLoop.addElement("     " + displayListLoop[i] + "     ");
		}
				
		scrollerLoop = new JScrollPane(jlistLoop);
		panelLoop.add(scrollerLoop);
		add(panelLoop, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		JFrame frame = new MacroCreation();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pseudocode");
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
