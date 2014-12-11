package view;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.Controller;



public abstract class Window extends JFrame{
	
	public static Controller cntrl;
	
	public Window(String title){
		super(title);
		
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
	}

	
	/**
	 * This method allows the application to dispose of a window.
	 */
	public void close(){
		this.dispose();
	}
	
	

}
