package view;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.BorderFactory;

import model.*;

// Class to display what actions the user is adding to their program.
// For now it includes basic moves, but it means nothing, just meant to display strings.
public class PseudocodeList extends JPanel {

	public static String[] mActions = {"Move", "Turn Left", "Turn Right", "Pick up beeper", "Put down beeper"};
	public static JList list;
	public static DefaultListModel model = new DefaultListModel();
	public static JScrollPane scroller;
	
	JPanel panel = new JPanel();
	
	public PseudocodeList() {
		
		list = new JList(mActions);
		list.setModel(model);
		
		for(int i = 0; i < mActions.length; i++){
			model.addElement(mActions[i]);
		}
		
		scroller = new JScrollPane(list);
		//list = new JList (model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		list.setFixedCellWidth(120);
		list.setEnabled(true);
		list.setVisible(true);
		
		list.setTransferHandler(new TransferHandler() {
			 
            public boolean canImport(TransferHandler.TransferSupport info) {
                // we only import Strings
                if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    return false;
                }
 
                JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
                if (dl.getIndex() == -1) {
                    return false;
                }
                return true;
            }
 
            public boolean importData(TransferHandler.TransferSupport info) {
                if (!info.isDrop()) {
                    return false;
                }
                 
                // Check for String flavor
                if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    //displayDropLocation("List doesn't accept a drop of this type.");
                    return false;
                }
 
                JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
                //DefaultListModel listModel = (DefaultListModel)list.getModel();
                int index = dl.getIndex();
                boolean insert = dl.isInsert();
                // Get the current string under the drop.
                String value = (String)model.getElementAt(index);
 
                // Get the string that is being dropped.
                Transferable t = info.getTransferable();
                String data;
                try {
                    data = (String)t.getTransferData(DataFlavor.stringFlavor);
                } 
                catch (Exception e) { return false; }
                 
                // Display a dialog with the drop information.
                //String dropValue = "\"" + data + "\" dropped ";
                if (dl.isInsert()) {
                    if (dl.getIndex() >= 0|| dl.getIndex()>= list.getModel().getSize()) {
                    	System.out.println(dl.getIndex() + " -> " +data);
                    	
                    	Code temp = Util.matchStringToCode(data.trim());
                    	MainWindow.updateCodeList(temp);
                    	
                    	((DefaultListModel)list.getModel()).addElement(data);
                    	
                    	System.out.println("size after insert "+ list.getModel().getSize());
                    	
                    }
                        //displayDropLocation(dropValue + "at beginning of list");
                    	
                } else {
                    //displayDropLocation(dropValue + "on top of " + "\"" + value + "\"");
                }
                 
        /**  This is commented out for the basicdemo.html tutorial page.
                 **  If you add this code snippet back and delete the
                 **  "return false;" line, the list will accept drops
                 **  of type string.
                // Perform the actual import.  
                if (insert) {
                    listModel.add(index, data);
                } else {
                    listModel.set(index, data);
                }
                return true;
        */
        return false;
            }
             
            public int getSourceActions(JComponent c) {
                return COPY;
            }
             
            protected Transferable createTransferable(JComponent c) {
                JList list = (JList)c;
                Object[] values = list.getSelectedValues();
         
                StringBuffer buff = new StringBuffer();
 
                for (int i = 0; i < values.length; i++) {
                    Object val = values[i];
                    buff.append(val == null ? "" : val.toString());
                    if (i != values.length - 1) {
                        buff.append("\n");
                    }
                }
                return new StringSelection(buff.toString());
            }
        });		
		list.setDropMode(DropMode.INSERT);
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border title = BorderFactory.createTitledBorder(loweredetched, "Pseudocode");
		
		setBorder(title);
		setVisible(true);
		panel.add(scroller);
		//panel.add(list);
		add(panel);
		
	}
}

