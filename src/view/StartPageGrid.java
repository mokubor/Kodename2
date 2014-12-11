package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import control.Controller;

import model.World;

// Class to call world grid if we include preview feature
public class StartPageGrid extends JPanel {

	JPanel wg;
	
	public StartPageGrid() {
		
		Util.initializeWorlds(5);
		Util.cntrl = new Controller(Util.worlds[0]);
		int x = Util.worlds[0].getXSize();
		int y = Util.worlds[0].getYSize();
		wg = new WorldGrid(x, y);
		
		add(wg, BorderLayout.EAST);
	}
}
