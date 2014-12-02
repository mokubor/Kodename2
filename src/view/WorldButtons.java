package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import control.*;

public class WorldButtons extends JPanel{
	JButton play;
	static JButton step;
	static JButton step_through;
	//static Controller cntrl;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			if(source == play){
				/**begin program execution*/	
				Util.cntrl.compile();
				step.setEnabled(true);
				step_through.setEnabled(true);
				
			}else if(source == step){
				if(!Util.cntrl.execute()){
					disable_buttons();
					WorldConsole.edit(Util.cntrl.getExecutionMessage());
				}else{
					WorldConsole.edit(Util.cntrl.getExecutionMessage());
					//highlight pseudocode list
					//and update Karel
				}
			}else if(source == step_through){
				/*while(cntrl.execute()){
					WorldConsole.edit(cntrl.getExecutionMessage());
				}*/
			}else{
				
			}
			Util.drawWorld();

		}
	}
	
	public WorldButtons(/*Controller _cntrl*/){
		super();
		
		//cntrl = _cntrl;
		
		step = new JButton("Step");
		play = new JButton("Play"); //this should have a play icon
		step_through = new JButton("Step Through");
		
		play.addActionListener(new ButtonListener());
		step.addActionListener(new ButtonListener());
		step_through.addActionListener(new ButtonListener());
		
		disable_buttons();
		
		setLayout(new FlowLayout(FlowLayout.CENTER,15,20));
		
		add(step_through);
		add(play);
		add(step);
		
		
	}
	static void disable_buttons(){
		step.setEnabled(false);
		step_through.setEnabled(false);
	}
}
