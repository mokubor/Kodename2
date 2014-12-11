package view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import control.*;
//import control.Controller;

public class Customs extends JPanel{
	static String[] custom_code;
	static JList list;
	static DefaultListModel model;
	static JPanel buttons;
	//static Controller cntrl;
	
	public Customs(){
		super();
		
		//retrieve any cusom code elements that may have already been created
		
		//cntrl = Util.cntrl;
		
		/*initalize buttons*/
		buttons = new CustomButtons();
		
		
		/**check if list of custom codes is empty, if it is, 
		 * initialize array to one*/
		if(Util.cntrl.getMacroMap() == null || Util.cntrl.getMacroMap().size() <= 0){
			custom_code = new String[1];
			custom_code[0] = "No Custom Actions created";
			CustomButtons.delete.setEnabled(false);
		}
		else{
			//custom_code = new String[cntrl.getMacroMap().size()];
			//retrieving key string values from hashmap and converting to array
			custom_code = (String[]) Util.cntrl.getMacroMap().keySet().toArray();
			CustomButtons.delete.setEnabled(true);
		}
		
		/**make default model*/
		model = new DefaultListModel();
		
		//retrieve any cusom code elements that may have already been created
		for(int i = 0; i < custom_code.length; i++){
			model.addElement(custom_code[i]);
		}
		
		list = new JList (model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setFixedCellWidth(140);
		list.setEnabled(true);
		list.setVisible(true);
		list.setDragEnabled(true);
		//list.setSelectedIndex(0);
		

		
		/*layout*/
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(list);
		add(Box.createRigidArea(new Dimension(0,10)));
		add(buttons);
		add(Box.createRigidArea(new Dimension(0,10)));
		
		
		//make border
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border title = BorderFactory.createTitledBorder(loweredetched, "Custom Actions");

		setBorder(title);
		setVisible(true);
		//setPreferredSize(new Dimension(100,100));
		
	}
	
	public static void resetCustomsList(){
		custom_code = new String[1];
		custom_code[0] = "No Custom Actions created";
	
		for(int i = 0; i < custom_code.length; i++){
			model.addElement(custom_code[i]);
		}
	
		list.setModel(model);
		CustomButtons.delete.setEnabled(false);
	}
	
	static int getIndex(){
		return list.getSelectedIndex();
	}
	
	static String getKey(){
		return (String)list.getSelectedValue();
	}
	
	static void delete(){
		model.remove(getIndex());
		list.setSelectedIndex(-1);
	}
}
