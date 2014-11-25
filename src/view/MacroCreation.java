package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// Class that holds the individual parts of Macro Creation screen and puts it together.
// It includes panel for buttons to remove code, list of selected code, list of available
// code to add, and panel for creating name and saving.
public class MacroCreation extends JFrame {

	MacroName mN = new MacroName();
	MacroBasicLoop mBL = new MacroBasicLoop();
	PseudocodeList pL = new PseudocodeList();
	PseudocodeButtons pB = new PseudocodeButtons();
	
	public MacroCreation() {
		
		add(pB, BorderLayout.SOUTH);
		add(pL, BorderLayout.CENTER);
		add(mBL, BorderLayout.WEST);
		add(mN, BorderLayout.NORTH);
		
		mN.but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Saved name: " + mN.tx.getText().trim());
				System.exit(0);
				// Capture and store list of code in pseudocode list panel
		}
		});
		
		pB.deleteBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selection = 666;
				
				if(pL.list.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "No code fragement was selected", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					String codeFrag = (String) pL.list.getSelectedValue();
							
					Object[] options = {"Yes", "No"};
					selection = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the code fragement?\n" + 
							codeFrag + "\n", "Delete Code Fragement from Macro",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				}
				try {
						
					if (selection == 0) {
						pL.model.remove(pL.list.getSelectedIndex());
					}
				}
				catch(Exception exc) {}
			}
			});
		
		pB.clearBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!pL.model.isEmpty()) {
					
					int choice = JOptionPane.showOptionDialog(null, "Are you sure that you want to clear the entire code for this macro?",
							"Delete entire list of code for macro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					
					if(choice == 0) {				
					pL.model.removeAllElements();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "There is no code to clear in this macro creation.", "No code to clear",
							JOptionPane.ERROR_MESSAGE);
				}								
				
			}
				
		});
		
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
