package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import control.Controller;

public class WindowSaveSession extends JDialog{
	
	JLabel nameL = new JLabel("Filename: ");
	JTextField nameTF = new JTextField(10);
	
	JButton saveBut = new JButton("Save");
	JButton cancelBut = new JButton("Cancel");
	
	public WindowSaveSession(){
		super();
	
		setLayout(new FlowLayout());
		
		add(nameL);
		add(nameTF);
		add(saveBut);
		add(cancelBut);
		
		saveBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String s = nameTF.getText();
				if(s.contains(":")){
					System.out.println("s is bad");
					return;
				}
				
				Date d = new Date();
			    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			    File f = new File("data" + File.separator + nameTF.getText());
			    System.out.println("FILE: " + f);
			    Util.cntrl.save(f);
			    System.exit(0);
			}
		});
		
		
	
	}
	
	public static void createWindowSaveSession() {
		
		JDialog frame = new WindowSaveSession();
		//frame = new StartPage();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setTitle("Start Page World Selection");
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
