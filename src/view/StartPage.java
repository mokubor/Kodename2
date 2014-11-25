package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

// Class that has list of worlds to select from, welcome/title message, proceed/ok button, and world grid if include preview feature
public class StartPage extends JFrame {

	StartPageWorldList wl = new StartPageWorldList();
	StartPageTitle wt = new StartPageTitle();
	StartPageOK ok = new StartPageOK();
	StartPageGrid gd = new StartPageGrid();
	
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel northPanel = new JPanel();
	JPanel southPanel = new JPanel();
	
	JFrame mW;
	static JFrame frame;
	
	public StartPage() {
		
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
					
					frame.dispose();
					mW = new MainWindow(10, 10);
					mW.setVisible(true);
					mW.setSize(1000,600);
					mW.setLocationRelativeTo(null);
					
				}
		}
		});
	}
	
	public static void main(String[] args) {
		frame = new StartPage();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Start Page World Selection");
		frame.setSize(1100,600);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
