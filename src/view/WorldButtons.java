/**
 * @author Miracle Okubor
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JButton;

import control.*;

/**
 *A class which defines a JPanel for the execution buttons on the Kodename world panel
 *and their functionality.
 */
public class WorldButtons extends JPanel{
	JButton play;
	static JButton step;
	static JButton step_through;
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			if(source == play){//begin program execution without syntax highlighting
				WorldConsole.reset();
				Util.cntrl.compile();
				Util.drawWorld(Util.cntrl.getKarel(), Util.cntrl.getWorld());
				PseudocodeList.getTheJList().setSelectedIndex(-1);
				step.setEnabled(true);
				step_through.setEnabled(true);
				
			}else if(source == step){//execute single step
				if(!Util.cntrl.execute()){
					disable_buttons();
					WorldConsole.edit(Util.cntrl.getExecutionMessage());
					PseudocodeList.getTheJList().setSelectedIndex(-1);
				}else{
					WorldConsole.edit(Util.cntrl.getExecutionMessage());
					PseudocodeList.getTheJList().setSelectedIndex(Util.cntrl.getExecutionLine());
					Util.drawWorld(Util.cntrl.getKarel(), Util.cntrl.getWorld());
				}
			}else if(source == step_through){//execute code with syntax highlighting
				MainWindow.disableAll();
				while(Util.cntrl.execute()){
					WorldConsole.edit(Util.cntrl.getExecutionMessage());
					Util.drawWorld(Util.cntrl.getKarel(), Util.cntrl.getWorld());
				}
				WorldConsole.edit(Util.cntrl.getExecutionMessage());
				disable_buttons();
				MainWindow.enableAll();
			}else{
				
			}


		}
	}
	
	public WorldButtons(){
		super();
		
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
	
	/**
	 * Disables all execution buttons on the World panel
	 */
	static void disable_buttons(){
		step.setEnabled(false);
		step_through.setEnabled(false);
	}
}
