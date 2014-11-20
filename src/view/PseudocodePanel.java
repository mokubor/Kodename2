package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class PseudocodePanel extends JPanel {
	JPanel panel = new JPanel();
	
	public JButton deleteBut = new JButton("      Delete Code Fragment      ");
	public JButton clearBut = new JButton("      Clear Code      ");
	
	GridBagConstraints c = new GridBagConstraints();
	
	DefaultListModel dlmModelPseudo = new DefaultListModel();
	JList jlistPseudo;
	JScrollPane scrollerPseudo;
	
	JPanel panelPseudo = new JPanel();
	
	public PseudocodePanel() {
		
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
	
	/*public static void main(String[] args) {
		JFrame temp = new JFrame();
	
		temp.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 20));
	
		PseudocodePanel ap = new PseudocodePanel();
	
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
