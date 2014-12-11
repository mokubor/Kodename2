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

public class MainWindow extends Window{
	
	JPanel action;
	JPanel world;
	//static Controller cntrl;
	
	static PseudocodeList pL;
	static PseudocodeButtons pB;	
	
	public static JButton expand;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			
			 if(source == expand){
				 Util.printcodeList();
				 WorldButtons.disable_buttons();
				 //String selected = ((String)pL.getTheModel().getElementAt(pL.getTheJList().getSelectedIndex())).trim();
				 int i = pL.getTheJList().getSelectedIndex();
				 if(i == -1){
					JOptionPane.showMessageDialog(null, "You must select an Action from the Pseudocode List to Expand", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
					return;
				 }
				 String selected = Util.cntrl.getCodeList().get(i).getClass().toString();
				 System.out.println("expand for index "+ pL.getTheJList().getSelectedIndex());
				 if( selected.equalsIgnoreCase("class model.IfElseCode")){
					 //int i = pL.getTheJList().getSelectedIndex();
					 System.out.println(Util.cntrl.getCodeList().get(i).getClass().toString());
					 Util.EditIndex = i;
					 IfElseCode code = (IfElseCode)Util.cntrl.getCodeList().get(i);
					 IfElseDialog.getIfDialog(code);
					 
					 pL.getTheJList().setSelectedIndex(-1);
					 return;
					 
				 }
				 else if(selected.equalsIgnoreCase("class model.LoopCode")){
					 //int i = pL.getTheJList().getSelectedIndex();
					 System.out.println(Util.cntrl.getCodeList().get(i).getClass().toString());
					 Util.EditIndex = i;
					 LoopCode code = (LoopCode)Util.cntrl.getCodeList().get(i);
					 LoopDialog.getForDialog(code);
					 
					 pL.getTheJList().setSelectedIndex(-1);
					 return;
				 }
				 else if(selected.equalsIgnoreCase("class model.CustomCode")){
					 
					 pL.getTheJList().setSelectedIndex(-1);
					 return;
				 }
				 else{
					 JOptionPane.showMessageDialog(null, "You cannot expand a Basic action", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
					 
					 pL.getTheJList().setSelectedIndex(-1);
					 return;
				 }
			 }
		}

	}

	
	MainWindow(int x, int y/*, Controller _cntrl*/){
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

					      System.out.println("trying to exit");
						}else{
							System.exit(0);
						}
					}
				}
		    }
		});
		
		//cntrl = _cntrl;
		Main.currentWindow = this;
		
		action = new ActionPanel(/*cntrl*/);
		pL = new PseudocodeList(false);
		pB = new PseudocodeButtons();
		world = new WorldPanel(x, y/*, cntrl*/);
		
		expand = new JButton("Expand");
		expand.setEnabled(false);
		expand.addActionListener(new ButtonListener());
		
		pB.add(expand);
		
		//setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));
		add(action, BorderLayout.WEST);
		//add(Box.createRigidArea(new Dimension(0,10)));
		//add(Box.createRigidArea(new Dimension(0,10)));
		add(pL, BorderLayout.CENTER);
		add(pB, BorderLayout.SOUTH);
		add(world, BorderLayout.EAST);
		//add(Box.createRigidArea(new Dimension(0,10)));
		
		/*addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
            	System.exit(0);
            }
        });*/
	}
	
	/*public static void main(String[] args) {
		MainWindow frame = new MainWindow(10,10);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Main Window");
		frame.setSize(1000,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}*/
	
	public static void createMainWindow(int x, int y/*, Controller _cntrl*/) {
		
		//cntrl = new Controller(x, y);
		
		JFrame frame = new MainWindow(x,y/*, _cntrl*/);
		frame.setSize(300, 300);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	

	public void close(){
		this.dispose();
	}
	
	static void disableAll(){
		expand.setEnabled(false);
		pB.clearBut.setEnabled(false);
		pB.deleteBut.setEnabled(false);
	}
	static void enableAll(){
		expand.setEnabled(true);
		pB.clearBut.setEnabled(true);
		pB.deleteBut.setEnabled(true);
	}
	
}