package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

public class CustomButtons extends JPanel {
	JButton create;
	static JButton delete;
	
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			if(source == create){
				/**open macro creation window*/	
				//t.dispose();
				//MacroCreation.createMacroWindow();
				delete.setEnabled(true);
				
			}
			else if (source == delete) {
				/**Delete macro*/
				int index = Customs.getIndex();
				String key = Customs.getKey();
				if(!Customs.cntrl.hasMacro(key)){
					JOptionPane.showMessageDialog(null, "Problem deleting Custom Action.", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					//remove key-action map from macros
					//Customs.cntrl.macros.remove(key);
					
					//remove from visible list
					Customs.delete();
					
					//disable button if there are no more macros
					//if(Customs.cntrl.macros.size() <= 0){
						source.setEnabled(false);
					//}
					
				}
				
			}
		}
	}
	
	public CustomButtons(){
		super();
		create = new JButton("Create"/*" Custom Actions"*/);
		delete = new JButton ("Delete"/*" Custom Actions"*/);
		
		create.setPreferredSize(new Dimension(20, 20));
		delete.setPreferredSize(new Dimension(20, 20));
		
		create.addActionListener(new ButtonListener());
		delete.addActionListener(new ButtonListener());
		
		/**if there are no macros, disable delete button*/
		//delete.setEnabled(false);
		
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		add(create);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(delete);
		add(Box.createRigidArea(new Dimension(0,10)));
		
	}
}
