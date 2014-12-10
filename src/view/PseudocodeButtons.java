package view;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//Class for buttons allowing code to be deleted individually (or in bulk for conditionals) or cleared in its entirety
public class PseudocodeButtons extends JPanel {

	JPanel panel = new JPanel();
	
	public JButton deleteBut = new JButton("      Delete Code Fragment      ");
	public JButton clearBut = new JButton("      Clear Code      ");

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			if(source == clearBut){
				
				if(!PseudocodeList.getTheModel().isEmpty()) {
					
					int choice = JOptionPane.showOptionDialog(null, "Are you sure that you want to clear the entire code produced so far?",
							"Delete entire list of code?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					
					if(choice == 0) {				
						PseudocodeList.getTheModel().removeAllElements();
					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "There is no code to clear.", "No code to clear",
							JOptionPane.ERROR_MESSAGE);
				}
				Util.cntrl.getCodeList().clear();
				PseudocodeList.resetList();
				WorldConsole.reset();
				WorldButtons.disable_buttons();
				
			}else if(source == deleteBut){
			
				int selection = 666;
				
				if(PseudocodeList.getTheJList().getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "No code fragement was selected", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					String codeFrag = (String) PseudocodeList.getTheJList().getSelectedValue();
							
					Object[] options = {"Yes", "No"};
					selection = JOptionPane.showOptionDialog(null, "Are you sure you want to delete the code fragement?\n" + 
							codeFrag + "\n", "Delete Code Fragement from Macro",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				}
				try {
						
					if (selection == 0) {
						int index = PseudocodeList.getTheJList().getSelectedIndex();
						if(PseudocodeList.getTheModel().size() == 1){
							PseudocodeList.getTheModel().remove(PseudocodeList.getTheJList().getSelectedIndex());
							PseudocodeList.resetList();
							WorldConsole.reset();
							WorldButtons.disable_buttons();
							
						}
						else{
							PseudocodeList.getTheModel().remove(PseudocodeList.getTheJList().getSelectedIndex());
						}
						Util.cntrl.getCodeList().remove(index);
					}
				}
				catch(Exception exc) {}
			}			
			}

		}

	public PseudocodeButtons() {
		
		panel.add(deleteBut);
		panel.add(clearBut);
		
		deleteBut.addActionListener(new ButtonListener());
		clearBut.addActionListener(new ButtonListener());
		
		add(panel, BorderLayout.SOUTH);
	}

}
