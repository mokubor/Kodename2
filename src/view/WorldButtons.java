package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

public class WorldButtons extends JPanel{
	JButton play;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			if(source == play){
				/**begin program execution*/	
				
			}

		}
	}
	
	public WorldButtons(){
		super();
		play = new JButton("Play"); //this should have a play icon
		
		play.addActionListener(new ButtonListener());
		
		setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
		
		add(play);
		
		
		
	}
}
