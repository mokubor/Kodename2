package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

public class CustomButtons extends JPanel {
	JButton create;
	static JButton delete;
	
	JFrame mC;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			
			if(source == create){
			mC = new MacroCreation();
			mC.setVisible(true);
			mC.setSize(1000,600);
			mC.setLocationRelativeTo(null);
			
				
			}
			else if (source == delete) {
				/**Delete macro*/
				
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
		
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		add(create);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(delete);
		add(Box.createRigidArea(new Dimension(0,10)));
		
	}
}