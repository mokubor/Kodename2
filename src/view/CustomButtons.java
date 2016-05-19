/**
 * @author Miracle Okubor
 */
package view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 * A class which defines the buttons that appear in the Custom Actions section of the Action Panel.
 * <p>
 * The panel has two buttons:
 * 	 Create, which triggers a new dialog to create a custom action
 * 	 Delete, which deletes a previously create custom action.
 * </p>
 */
public class CustomButtons extends JPanel {
	static JButton create;
	static JButton delete;
	
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			
			if(source == create){
				/**
				 * Disable create button
				 * open MacroCreation dialog box
				 */
				create.setEnabled(false);
				JDialog dialog = new MacroCreation();
				
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setTitle("Macro Creation");
				dialog.setSize(1000,600);
				dialog.setVisible(true);
				dialog.setLocationRelativeTo(null);
				
				// Enable create macro button when window is explicitly X'd out/closed
				dialog.addWindowListener(new WindowAdapter() {
				    @Override
				    public void windowClosed(WindowEvent e) {
				        CustomButtons.create.setEnabled(true);
				        /**Switch from macro creation pseudocode list to main window pseudocodelist*/
				        PseudocodeList.isMacro = false;
				    }
				});
			
				
			}
			else if (source == delete) {
				/**Confirm delete action if an index was selected, display error message otherwise*/
				if (Customs.list.getSelectedIndex() != -1) {
					int choice = JOptionPane.showOptionDialog(null, "Are you sure that you want to delete the selected macro?",
							"Delete Macro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				
					if(choice == 0) {				
						/**
						 * remove the custom action from control map and delete string representation from UI list			
						 */
						
						//System.out.println(Util.cntrl.getMacroMap().size());
						String key = Customs.getKey();
						Util.cntrl.getMacroMap().remove(key);
						//System.out.println(Util.cntrl.getMacroMap().size());
						Customs.delete();
						
						if (Customs.model.isEmpty()) {
							Customs.resetCustomsList();
						}
						
						/**remove instance of custom action from current pseudocode */
						PseudocodeList.onCustomDelete(key);
					}
				}
				else {  
					JOptionPane.showMessageDialog(null, "There was no macro selected.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	public CustomButtons(){
		super();
		create = new JButton("Create");
		delete = new JButton ("Delete");
		
		create.setPreferredSize(new Dimension(20, 20));
		delete.setPreferredSize(new Dimension(20, 20));
		
		create.addActionListener(new ButtonListener());
		delete.addActionListener(new ButtonListener());
		
		/**if there are no macros, disable delete button*/
		delete.setEnabled(false);
		
		/*layout*/
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		add(create);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(delete);
		add(Box.createRigidArea(new Dimension(0,10)));
		
	}
	
}