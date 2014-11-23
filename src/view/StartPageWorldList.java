package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

// Class to hold the 5 or so pre-made worlds to allow users to pick which one
public class StartPageWorldList extends JPanel {
	
	JPanel panelLst = new JPanel();
	DefaultListModel dlmModel = new DefaultListModel();
	JList jlist;
	JScrollPane scroller;
	
	Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
	Border title = BorderFactory.createTitledBorder(loweredetched, "Worlds");

	GridBagConstraints c = new GridBagConstraints();
	
	public StartPageWorldList() {
		
		c.insets = new Insets(25,25,25,25);
		panelLst.setLayout(new GridBagLayout());
		
		String[] displayList = {"World 1", "World 2", "World 3", "World 4", "World 5"};
				
		jlist = new JList(displayList);
		jlist.setModel(dlmModel);
				
		for (int i = 0; i < displayList.length; i++) {
			dlmModel.addElement("     " + displayList[i] + "     ");
		}
						
		jlist.setVisibleRowCount(10);
				
		scroller = new JScrollPane(jlist);
		c.gridx = 1;
		panelLst.add(scroller, c);
		add(panelLst, BorderLayout.CENTER);
		
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.setLayoutOrientation(JList.VERTICAL_WRAP);
		jlist.setFixedCellWidth(120);
		jlist.setEnabled(true);
		jlist.setVisible(true);
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		setBorder(title);
		
	}
}
