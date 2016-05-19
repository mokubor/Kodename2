/**
 * @author Miracle Okubor
 */
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

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import control.*;

/**
 * A class for components to create and maintain custom actions
 * A list of created custom actions and buttons to modify the list.
 *
 */
public class Customs extends JPanel{
	static ArrayList<String> custom_code;
	static JList list;
	static DefaultListModel model;
	static JPanel buttons;
	JScrollPane scroller;
	//static Controller cntrl;
	
	public Customs(){
		super();
		
		/**
		 * initalize buttons
		 */
		buttons = new CustomButtons();
		
		custom_code = new ArrayList<String>(1);
		
		/**
		 * check if list of custom codes is empty, if it is, 
		 * initialize array to one
		 */
		if(Util.cntrl.getMacroMap() == null || Util.cntrl.getMacroMap().size() <= 0){
			custom_code = new ArrayList<String>(1);
			custom_code.add("No Custom Actions created");
			CustomButtons.delete.setEnabled(false);
		}
		else{
			/**retrieve key string values from hashmap and convert to array*/
			custom_code = new ArrayList<String>(1);
			int length = Util.cntrl.getMacroMap().size();
			
			for(int i = 0; i < length; i++){
				String key = (String)Util.cntrl.getMacroMap().keySet().toArray()[i].toString();
				custom_code.add(key);
			}
			CustomButtons.delete.setEnabled(true);
		}
		
		/**make default model for JList*/
		model = new DefaultListModel();
		
		//System.out.println(custom_code.size());
		
		for(int i = 0; i < custom_code.size(); i++){
			model.addElement(custom_code.get(i));
		}
		
		list = new JList(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setFixedCellWidth(140);
		list.setEnabled(true);
		list.setVisible(true);
		list.setDragEnabled(true);
		//list.setSelectedIndex(0);
		
		scroller = new JScrollPane(list);
		
		/*layout*/
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(scroller);
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
	
	/**
	 * Resets the list of custom actions and displays default message
	 */
	public static void resetCustomsList(){
		custom_code = new ArrayList<String>(1);
		custom_code.add("No Custom Actions created");
	
		for(int i = 0; i < custom_code.size(); i++){
			model.addElement(custom_code.get(i));
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
