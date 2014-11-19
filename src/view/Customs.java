package view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

public class Customs extends JPanel{
	static Object[] custom_code;
	static JList list;
	static DefaultListModel model;
	JPanel buttons;
	
	public Customs(){
		super();
		
		//retrieve any cusom code elements that may have already been created
		/**check if list of custom codes is empty, if it is, 
		 * initialize array to one*/
		custom_code = new Object[1];
		
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
		//list.setSelectedIndex(0);
		
		/*initalize buttons*/
		buttons = new CustomButtons();
		
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
}
