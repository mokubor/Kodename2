package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	
	World w;
	
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

		wl.jlist.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {
				switch(wl.jlist.getSelectedIndex()){
				
					case 0:	w = Util.worlds[0];
							break;
					case 1:	w = Util.worlds[1];							
							break;
					case 2:	w = Util.worlds[2];
							break;
					case 3:	w = Util.worlds[3];
							break;
					case 4:	w = Util.worlds[4];
							break;
				}
				Util.cntrl = new Controller(w);
				gd.renderWorld(w);
		    }
		});
		
		ok.okBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					if(w == null){
						w = Util.worlds[0];
						Util.cntrl = new Controller(Util.worlds[0]);
					}
					
					Main.currentWindow.dispose();
					mW = new MainWindow(w.getXSize(), w.getYSize()/*, cntrl*/);
					mW.setVisible(true);
					mW.setSize(1000,600);
					mW.setLocationRelativeTo(null);
					Util.drawWorld(null, null);
					//MainWindow.createMainWindow(10,10, cntrl);
					
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
