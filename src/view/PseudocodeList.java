/**
 * @author Miracle Okubor
 */

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

/**
 * A panel which display the actions the user is adding to their program.
 */

public class PseudocodeList extends JPanel {

	public static String[] mActions;
	
	public static JList list; // List and model for regular pseudocode
	public static DefaultListModel model = new DefaultListModel();
	
	public static JList listMacro; // List and model for macro creation pseudocode
	public static DefaultListModel modelMacro = new DefaultListModel();
	
	static boolean wasNull = false;
	public static JScrollPane scroller;
	
	// Boolean to determine whether or not this class is currently used on regular pseudocode or macro creation
	public static boolean isMacro;
	
	JPanel panel = new JPanel();
	
	// No argument constructor represents regular pseudocode
	public PseudocodeList(boolean setVal) {
		
		// set boolean to passed value: true if macro or false if regular list
		isMacro = setVal;
		
		// couldn't do getTheJList() = new JList(mActions) because left side must be variable 
		if (isMacro) {
			listMacro = new JList(modelMacro);
		}
		else {
			list = new JList(model);
		}
		
		getTheJList().setModel(getTheModel());
		getTheModel().clear();
		
		
		mActions = new String[1];
		mActions[0] = "Begin by Draging an Action";
		wasNull = true;
	
		if(!isMacro){
			if(Util.cntrl.getCodeList().size() != 0){
				for(int i = 0; i < Util.cntrl.getCodeList().size(); i++){
					getTheModel().addElement(Util.cntrl.getCodeList().get(i).toString());
				}
				getTheModel().addElement("...");
				MainWindow.expand.setEnabled(true);
			}else{
				for(int i = 0; i < mActions.length; i++){
					getTheModel().addElement(mActions[i]);
				}
			}
		}else{
			for(int i = 0; i < mActions.length; i++){
				getTheModel().addElement(mActions[i]);
			}
		}
		scroller = new JScrollPane(getTheJList());
		
		getTheJList().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTheJList().setLayoutOrientation(JList.VERTICAL);
		getTheJList().setFixedCellWidth(200);
		getTheJList().setEnabled(true);
		getTheJList().setVisible(true);
		
		/*
		 * Set the handler for the drag and drop functionality 
		 * between the action panel and pseudocode panels.
		 * 
		 */
		getTheJList().setTransferHandler(new TransferHandler() {
			 
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
 
           
			@SuppressWarnings("deprecation")
			public boolean importData(TransferHandler.TransferSupport info) {
                if (!info.isDrop()) {
                    return false;
                }
                 
                // Check for String flavor
                if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    return false;
                }
 
                JList.DropLocation dl = (JList.DropLocation)info.getDropLocation();
                int index = dl.getIndex();
                boolean insert = dl.isInsert();
                // Get the current string under the drop.
                String value = (String)getTheModel().getElementAt(index);
 
                // Get the string that is being dropped.
                Transferable t = info.getTransferable();
                String data;
                try {
                    data = (String)t.getTransferData(DataFlavor.stringFlavor);
                } 
                catch (Exception e) { return false; }
                 
                // Display a dialog with the drop information.
                if (dl.isInsert()) {
                    if (dl.getIndex() >= 0|| dl.getIndex()>= getTheJList().getModel().getSize()) {
                    	System.out.println(dl.getIndex() + " -> " +data);
                    	int line = dl.getIndex();
                    	
                    	data = data.trim();
                    	Util.EditIndex = line;
                    	
                    	/*
                    	 * find code type and open a dialog for if-else, or for-loop code
                    	 * add basic code to controller codelist
                    	 * get macro from controller macro map and add to codelist
                    	 */
                    	if(data.equalsIgnoreCase("if-else")){
                    		if(!isMacro){
                    			IfElseDialog.getIfDialog(null);
                    		
                    			if(IfElseDialog.getValue() > 0){
                    				add(data, line);
                    			}
                    		}
                    		else{
                    			MacroIfElseDialog.getMacroIfDialog(null);
                    			
                    			if(MacroIfElseDialog.getValue()>0){
                    				add(data, line);
                    			}
                    		}
                    	}
                    	else if(data.equalsIgnoreCase("For-End For")){
                    		if(!isMacro){
                    			LoopDialog.getForDialog(null);
                    		
                    			if(LoopDialog.getValue() >0){
                    				add(data, line);
                    			}
                    		}
                    		else{
                    			MacroLoopDialog.getMacroForDialog(null);
                    			
                    			if(MacroLoopDialog.getValue() >0){
                        				add(data, line);
                        			}
                    		}
                    	}
                    	
                    	else if(data.equalsIgnoreCase("move") || 
                    			data.equalsIgnoreCase("turn left") || 
                    			data.equalsIgnoreCase("turn right")||
                    			data.equalsIgnoreCase("put down beeper") || 
                    			data.equalsIgnoreCase("pick up beeper")){
                    		
                    		Code temp = Util.matchStringToCode(data);
                    		if(!isMacro) {//updating the main pseudocode list
                    			Util.updateCodeList(line,temp);
                    		}
                    		else{
                    			MacroCreation.updateCustomActions(temp, line);
                    		}
                    		add(data, line);
                    	}
                    	else{
                    		Code temp = (Code)Util.cntrl.getMacroMap().get(data);
                    		Util.updateCodeList(line,  temp);
                    		add(data, line);
                    	}
                    	
                    	
                    	WorldButtons.disable_buttons();
                    	
                    }
                } else {
                    
                }
                 
 
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
		getTheJList().setDropMode(DropMode.INSERT);
		
		Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		Border title = BorderFactory.createTitledBorder(loweredetched, "Pseudocode");
		
		setBorder(title);
		setVisible(true);
		panel.add(scroller);
		
		add(panel);
		
	}
	
	 @SuppressWarnings("unchecked")
	/**
	 * Add a code piece to the list at the specified index 
	 * @param code
	 * @param index
	 */
	public static void add(String code, int index){
		
		if(getTheModel().get(0).equals("Begin by Draging an Action")){
			
			getTheModel().remove(0);
			getTheModel().addElement("...");
			wasNull = false;
		}
				
		if(index == -1){
			getTheModel().addElement(code);
		}
		else{
			getTheModel().add(index,  code);
		}
	
		
		MainWindow.expand.setEnabled(true);
		getTheJList().setSelectedIndex(-1);
		
	}
	 
	 /**
	  * Reset the Pseudocode List with default messages
	  * @author Miracle Okubor
	  */
	 public static void resetList(){
		 
		 getTheModel().clear();
			mActions = new String[1];
			mActions[0] = "Begin by Draging an Action";
			wasNull = true;
		
		
		for(int i = 0; i < mActions.length; i++){
			getTheModel().addElement(mActions[i]);
		}
		
		getTheJList().setModel(getTheModel());
	 }

	 
	 /**
	  * Return the appropriate model
	  * @return DefaultListModel
	  * @author Miracle Okubor
	  */
	 public static DefaultListModel getTheModel() {
		 
		 if(isMacro) {
			 return modelMacro;
		 }
		 return model;
		 
	 }
	 
	 /**
	  * Return the appropriate jlist
	  * @return JList
	  * @author Miracle Okubor
	  */
	 public static JList getTheJList() {
		 
		 if(isMacro) {
			 return listMacro;
		 }
		 return list;
		 
	 }
	/**
	 * Delete a custom action from the pseudocode list 
	 * @param String key
	 * @author Miracle Okubor
	 */
	public static void onCustomDelete(String key){
		DefaultListModel model =PseudocodeList.getTheModel();
		
		for(int i = 0; i < model.getSize(); i++){
			if(((String)model.getElementAt(i)).equalsIgnoreCase(key)){
				model.remove(i);
				Util.cntrl.getCodeList().remove(i);
				WorldButtons.disable_buttons();
			}
		}
	}

}