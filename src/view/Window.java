/**
 * @author Miracle Okubor
 */
package view;

import javax.swing.JFrame;

import control.Controller;

/**
 * This is the Window abstract class which extends a java swing JFrame.
 * <p>
 * The Window abstract class extends the javax.swing.JFrame. 
 * It has the static method "close()" to safely dispose of the window
 * <p>
 * @author liathano
 *
 */
public abstract class Window extends JFrame{
	
	//public static Controller cntrl;
	
	public Window(String title){
		super(title);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	
	/**
	 * This method allows the application to dispose of a window.
	 */
	public void close(){
		this.dispose();
	}
	
	

}
