/**
 * @author Miracle Okubor
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.*;
import model.*;

/**
 * A class which represents the Main Window of the Kodename application
 * <p>
 * The Main Window is a frame that contains the Action panel, Pseudocode panel and the World panel.
 * It is within this window that the user can create their program and most importantly, executed their program.
 * </p>
 *
 */
public class MainWindow extends Window{
	
	JPanel action;
	JPanel world;
	
	static PseudocodeList pL;
	static PseudocodeButtons pB;	
	
	public static JButton expand;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			
			 if(source == expand){
				 //Util.printcodeList();
				 WorldButtons.disable_buttons();
				 
				 int i = PseudocodeList.getTheJList().getSelectedIndex();
				 
				 if(i == -1){
					JOptionPane.showMessageDialog(null, "You must select an Action from the Pseudocode List to Expand", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
					return;
				 }
				 
				 String selected = Util.cntrl.getCodeList().get(i).getClass().toString();
				 
				 if( selected.equalsIgnoreCase("class model.IfElseCode")){//expand if-else code
					 Util.EditIndex = i;
					 IfElseCode code = (IfElseCode)Util.cntrl.getCodeList().get(i);
					 IfElseDialog.getIfDialog(code);
					 
					 PseudocodeList.getTheJList().setSelectedIndex(-1);
					 return;
					 
				 }
				 else if(selected.equalsIgnoreCase("class model.LoopCode")){//expand for-loop code
					 Util.EditIndex = i;
					 LoopCode code = (LoopCode)Util.cntrl.getCodeList().get(i);
					 LoopDialog.getForDialog(code);
					 
					 PseudocodeList.getTheJList().setSelectedIndex(-1);
					 return;
				 }
				 else if(selected.equalsIgnoreCase("class model.CustomCode")){//expand custom action
					 String key = ((String) PseudocodeList.getTheModel().getElementAt(PseudocodeList.getTheJList().getSelectedIndex())).trim();
					 CustomCode c = Util.cntrl.getMacroMap().get(key);
					 MacroExpand.ExpandMacro(c.getName(), c.getCodeBody());
					 
					 PseudocodeList.getTheJList().setSelectedIndex(-1);
					 return;
				 }
				 else{//expand basic action
					 JOptionPane.showMessageDialog(null, "You cannot expand a Basic action", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
					 
					 PseudocodeList.getTheJList().setSelectedIndex(-1);
					 return;
				 }
			 }
		}

	}

	
	MainWindow(int x, int y){
		super("Main Window");
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    
				if (JOptionPane.showConfirmDialog(null, 
			            "Closing a window will quit this application.\nAre you sure you want to close this window?\nProgress will be saved.", "Close Window", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
					if(Util.cntrl != null){
						if(Util.cntrl != null){
							//safely logout
							WindowSaveSession.createWindowSaveSession();

						}else{
							System.exit(0);
						}
					}
				}
		    }
		});
		
		Main.currentWindow = this;
		
		/*initialize panels*/
		expand = new JButton("Expand");
		expand.setEnabled(false);
		
		action = new ActionPanel();
		pL = new PseudocodeList(false);
		pB = new PseudocodeButtons();
		world = new WorldPanel(x, y);
		
		expand.addActionListener(new ButtonListener());
		
		pB.add(expand);
		
		
		add(action, BorderLayout.WEST);
		add(pL, BorderLayout.CENTER);
		add(pB, BorderLayout.SOUTH);
		add(world, BorderLayout.EAST);
	}
	
	
	/*public static void main(String[] args) {
		MainWindow frame = new MainWindow(10,10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Window");
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}*/
	
	/**
	 * Method to create the main window of the Kodename project. Input is the X by Y size of the world grid.
	 * @param int x 
	 * @param int y
	 */
	public static void createMainWindow(int x, int y) {
		
		JFrame frame = new MainWindow(x,y);
		frame.pack();
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	
	/**
	 * Safely closes the window
	 */
	public void close(){
		this.dispose();
	}
	
	/**
	 * Disables all buttons
	 */
	static void disableAll(){
		expand.setEnabled(false);
		pB.clearBut.setEnabled(false);
		pB.deleteBut.setEnabled(false);
	}
	
	/**
	 * Enables all buttons
	 */
	static void enableAll(){
		expand.setEnabled(true);
		pB.clearBut.setEnabled(true);
		pB.deleteBut.setEnabled(true);
	}
	
}