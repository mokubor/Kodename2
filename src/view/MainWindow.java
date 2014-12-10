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
	
	PseudocodeList pL;
	PseudocodeButtons pB;	
	
	public static JButton expand;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			
			 if(source == expand){
				 String selected = ((String)pL.getTheModel().getElementAt(pL.getTheJList().getSelectedIndex())).trim();
				 if( selected.equalsIgnoreCase("if-else")){
					 int i = pL.getTheJList().getSelectedIndex();
					 System.out.println(Util.cntrl.getCodeList().get(i).getClass().toString());
					 Util.EditIndex = i;
					 IfElseCode code = (IfElseCode)Util.cntrl.getCodeList().get(i);
					 IfElseDialog.getIfDialog(code);
					 
				 }
				 else if(selected.equalsIgnoreCase("For-End For")){
					 int i = pL.getTheJList().getSelectedIndex();
					 System.out.println(Util.cntrl.getCodeList().get(i).getClass().toString());
					 Util.EditIndex = i;
					 LoopCode code = (LoopCode)Util.cntrl.getCodeList().get(i);
					 LoopDialog.getForDialog(code);
				 }
				 else{
					 JOptionPane.showMessageDialog(null, "You cannot expand a "+selected+" action", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
					 return;
				 }
			 }
		}

	}

	
	MainWindow(int x, int y/*, Controller _cntrl*/){
		super("Main Window");
		
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
	
}