/**
 * @author Miracle Okubor
 */
package view;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

/**
 * A class which holds a representation of condition statements the user can use.
 * <p>
 * The class defines, as strings, the two condition statements that can be created in the application
 * If statements and For loops
 * </p>
 * @author liathano
 *
 */
public class Conditions extends JPanel{
	static String[] cond = {"If-Else", "For-End For"};
	static JList list;
	static DefaultListModel model;
	
	public Conditions(){
		super();
		model = new DefaultListModel();
		
		for(int i = 0; i < cond.length; i++){
			model.addElement(cond[i]);
		}
		
		/*layout*/
		list = new JList (model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setFixedCellWidth(120);
		list.setEnabled(true);
		list.setVisible(true);
		list.setDragEnabled(true);
		//list.setSelectedIndex(0);
		
		/*border*/
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border title = BorderFactory.createTitledBorder(loweredetched, "Conditions");
		
		setBorder(title);
		setVisible(true);
		//setSize(600,100);
		add(list);
		
	}
}
