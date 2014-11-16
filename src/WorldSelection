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

public class WorldSelection extends JFrame {

	JPanel panel = new JPanel();
	JPanel titlePanel = new JPanel();
	
	public JButton okBut = new JButton("      OK      ");
	JLabel label = new JLabel("Welcome to Kodename!");
	JLabel label2 = new JLabel("Please select one of the premade worlds and then press the OK button to proceed.");
		
	GridBagConstraints c = new GridBagConstraints();
	
	JPanel panelLst = new JPanel();
	DefaultListModel dlmModel = new DefaultListModel();
	JList jlist;
	JScrollPane scroller;
	
	public WorldSelection() {
		
		c.insets = new Insets(25,25,25,25);
		
		titlePanel.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		titlePanel.add(label, c);
		c.gridy = 1;
		titlePanel.add(label2, c);
		
		add(titlePanel, BorderLayout.NORTH);
		
		label.setFont(new Font("Dialog", Font.BOLD, 50));
		label.setForeground(Color.BLUE);
		
		panel.add(okBut);
		add(panel, BorderLayout.EAST);
		
		panelLst.setLayout(new GridBagLayout());
		
		String[] displayList = new String[5];
		
		displayList[0] = "Some text";
		displayList[1] = "Joe";
		displayList[2] = "I don't want to do this";
		displayList[3] = "Shut up, you volunteered to do this";
		displayList[4] = "Snow blind";
				
		jlist = new JList(displayList);
		jlist.setModel(dlmModel);
				
		for (int i = 0; i < displayList.length; i++) {
			dlmModel.addElement("     " + displayList[i] + "     ");
		}
						
		jlist.setVisibleRowCount(10);
				
		scroller = new JScrollPane(jlist);
		panelLst.add(scroller, c);
		add(panelLst, BorderLayout.WEST);
	}
	
	public static void main(String[] args) {
		JFrame frame = new WorldSelection();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("World Selection");
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
