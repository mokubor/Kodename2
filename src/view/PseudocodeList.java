package view;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

// Class to display what actions the user is adding to their program.
// For now it includes basic moves, but it means nothing, just meant to display strings.
public class PseudocodeList extends JPanel {

	static String[] mActions = {"Move", "Turn Left", "Turn Right", "Pick up beeper", "Put down beeper"};
	static JList list;
	static DefaultListModel model;
	
	JPanel panel = new JPanel();
	
	public PseudocodeList() {
		
		model = new DefaultListModel();
		
		for(int i = 0; i < mActions.length; i++){
			model.addElement(mActions[i]);
		}
		
		list = new JList (model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setFixedCellWidth(120);
		list.setEnabled(true);
		list.setVisible(true);
		//list.setSelectedIndex(0);
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border title = BorderFactory.createTitledBorder(loweredetched, "Pseudocode");
		
		setBorder(title);
		setVisible(true);
		panel.add(list);
		add(panel);
		
	}
}

