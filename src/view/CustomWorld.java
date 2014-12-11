package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import control.Controller;

import model.World;
import model.World.Contents;

public class CustomWorld extends JDialog{
	
	JFrame mW;
	
	JTextField xCoorTF = new JTextField(3);
	JTextField yCoorTF = new JTextField(3);
	
	String[] elementArr = {"Beeper", "Wall"};
	JComboBox elementBox = new JComboBox(elementArr);
	
	JButton addBut = new JButton("Add element");
	JButton doneBut = new JButton("Take Me To My World");
	JButton cancelBut = new JButton("Cancel");		
	JLabel xCoorL = new JLabel("X Coordinate: ");
	JLabel yCoorL = new JLabel("Y Coordinate: ");
	
	World w;
	
	CustomWorldGridPanel gp = new CustomWorldGridPanel();
	
	public CustomWorld(final World w) {
		
		super();
		
		this.w = w;
		gp.renderWorld(w);
		
		setLayout(new FlowLayout());
		
		add(xCoorL);
		add(xCoorTF);
		add(yCoorL);
		add(yCoorTF);
		add(doneBut);
		add(cancelBut);
		add(elementBox);
		add(addBut);
		add(gp);
		
		addBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(xCoorTF.getText());
				int y = Integer.parseInt(yCoorTF.getText());
				
				String el = (String)elementBox.getItemAt(elementBox.getSelectedIndex());
				
				if(el.equals("Beeper")){
					w.setContents(x, y, Contents.BEEPER);
				}else{
					w.setContents(x, y, Contents.WALL);
				}
				
				Util.cntrl = new Controller(w);
				gp.renderWorld(w);
				
			}
		});
		
		doneBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Main.currentWindow.dispose();
					mW = new MainWindow(w.getXSize(), w.getYSize()/*, cntrl*/);
					mW.setVisible(true);
					mW.setSize(1000,600);
					mW.setLocationRelativeTo(null);
					Util.drawWorld(null, null);
				}

		});
		
		cancelBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				}

		});
	}
}