package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import control.Controller;
import model.*;

// Class that has list of worlds to select from, welcome/title message, proceed/ok button, and world grid if include preview feature
public class StartPage extends Window {

	StartPageWorldList wl = new StartPageWorldList();
	StartPageTitle wt = new StartPageTitle();
	StartPageOK ok = new StartPageOK();
	StartPageGrid gd = new StartPageGrid();
	
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel northPanel = new JPanel();
	JPanel southPanel = new JPanel();
	//static Controller cntrl;
	
	JFrame mW;
	static JFrame frame;
	
	public StartPage() {
		super("Start Page World Selection");
		
		Main.currentWindow = this;
		
		leftPanel.add(wl);
		northPanel.add(wt);
		southPanel.add(ok);
		rightPanel.add(gd);
		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.EAST);
		
		ok.okBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(wl.jlist.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, 
							"No world was selected. Please select a world and then press the OK button.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					World w = new World(4,4);
					
					w.setContents(1, 1, model.World.Contents.BEEPER);
					w.setContents(1,  0, model.World.Contents.BEEPER);
					w.setContents(2, 2, model.World.Contents.BEEPER);
					w.setContents(0,  1, model.World.Contents.WALL);
					w.setContents(1, 2, model.World.Contents.WALL);
					w.setContents(2, 1, model.World.Contents.WALL);
					
					for(int x = 0; x < 4; x++){
						for(int y = 0; y < 4; y++){
							System.out.println("("+x+","+y+")" + w.getContents(x,  y));
						}
					}
					//cntrl = new Controller( w);
					Util.cntrl = new Controller(w);
					Main.currentWindow.dispose();
					mW = new MainWindow(6, 6/*, cntrl*/);
					mW.setVisible(true);
					mW.setSize(1000,600);
					mW.setLocationRelativeTo(null);
					//MainWindow.createMainWindow(10,10, cntrl);
					
				}
		}
		});
	}
	
	public static void createStartPage() {
		
		JFrame frame = new StartPage();
		//frame = new StartPage();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setTitle("Start Page World Selection");
		frame.setSize(1100,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	/*public static void main(String[] args) {
		
		
		frame = new StartPage();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Start Page World Selection");
		frame.setSize(1100,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}*/
	
	
	public void close(){
		this.dispose();
	}
}
