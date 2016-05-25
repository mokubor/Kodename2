/**
 * @author Miracle Okubor
 */
package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.Code;
import model.LoopCode;

/**
 * A class representing a JDialog used to create For-loop statements
 * <p>
 * This dialog contains a combobox representing the number of iterations. max = 4
 * A list that displays the users chosen actions.
 * </p> 
 *
 */
public class LoopDialog extends JDialog{
	
	static int value;//-1 if the user exits the dialog using the "cancel" button. No update to code list 
	JPanel basic;
	String[] no_of_iterations = {"0", "1", "2", "3", "4"};
	JComboBox iterations;
	JButton done;
	JButton cancel;
	JButton add;
	static JList for_list;
	JLabel for_label;
	JLabel end_label;
	static DefaultListModel for_model;
	JScrollPane scrollbar;
	int count;
	LoopCode loop_code_piece;
	
	boolean isempty = true;//defines if the loop object is a modification or a new object.
	JButton remove;
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton source = (JButton)e.getSource();
			
			if(source == done){
				/* create for-loop code object */
				if(iterations.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "repeat count cannot be 0", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					int count = iterations.getSelectedIndex();
					
					if(isListEmpty()){
						JOptionPane.showMessageDialog(null, "Add an action to the list or select the Cancel button", "Empty List", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					ArrayList<Code> body = Util.getBody(for_list);
					
					((LoopCode) loop_code_piece).setCounter(count);
					((LoopCode) loop_code_piece).setBody(body);
					
					/*
					 * check if a pre-existing objects is being modified or a new object is being added to code list
					 */
					if(isempty == true){
						Util.updateCodeList(Util.EditIndex, loop_code_piece);
						
					}else{
						Util.cntrl.getCodeList().remove(Util.EditIndex);
						Util.updateCodeList(Util.EditIndex, loop_code_piece);
					}
					
					value = 1;
					dispose();
				}
			
			}
			else if(source == add){
				add(BasicActions.getElement());
			}
			else if(source == remove){
				remove(for_list.getSelectedIndex());
			}
			else{//cancel button
				value = -1;
				dispose();
			}
		}
	}
	
	public LoopDialog(JFrame owner, Code c){
		super(owner, "Create Loop statement", true);
		
		if(c == null){
			loop_code_piece = new LoopCode(0, null);
		}
		else{
			loop_code_piece = (LoopCode)c;
			isempty = false;
		}
		
		basic = new BasicActions();
		
		iterations = new JComboBox(no_of_iterations);
		iterations.setSelectedIndex(0);
		
		/*buttons*/
		done = new JButton("Done");
		done.addActionListener(new ButtonListener());
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ButtonListener());
		add = new JButton("Add");
		add.addActionListener(new ButtonListener());
		remove = new JButton("Remove");
		remove.addActionListener(new ButtonListener());
		
		/*labels*/
		JLabel message = new JLabel("How many times do you want to repeat the loop:");
		for_label = new JLabel("For:");
		end_label = new JLabel("End For");
		
		for_model = new DefaultListModel();
		
		if(isempty){
			String[] empty = new String[1];
			empty[0] = "Empty";
		
			for(int i = 0; i < empty.length; i++){
				for_model.addElement(empty[i]);
			}
		}
		else{
			count = loop_code_piece.getCounter();
			iterations.setSelectedIndex(count);
			
			ArrayList<Code> Body = loop_code_piece.getBody();
			for(int i = 0; i < Body.size(); i++){
				String t = Util.codetoString(Body.get(i));
				for_model.addElement(t);
			}
		}
		
		for_list = new JList(for_model);
		for_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		for_list.setLayoutOrientation(JList.VERTICAL_WRAP);
		for_list.setFixedCellWidth(200);
		for_list.setEnabled(true);
		for_list.setVisible(true);
		for_list.setSelectedIndex(-1);
		
		scrollbar = new JScrollPane(for_list);
		
		/*exit buttons panel*/
		JPanel bpanel = new JPanel();
		bpanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		bpanel.add(cancel);
		bpanel.add(done);
		
		/*layout*/
		setLayout(new GridBagLayout());
		GridBagConstraints x = new GridBagConstraints();
		
		x.anchor = GridBagConstraints.WEST;
		x.gridx = 0;
		x.gridy = 1;
		x.gridheight = 5;
		add(basic, x);
		
		x.gridx = 1;
		x.gridy = 3;
		x.anchor = GridBagConstraints.CENTER;
		x.gridheight = 1;
		add(add, x);
		
		x.gridy = 4;
		add(remove, x);
		
		x.anchor = GridBagConstraints.WEST;
		x.gridx = 2;
		x.gridy = 0;
		add(message, x);
		
		x.gridy = 1;
		add(iterations, x);
		
		x.gridy = 2;
		add(for_label, x);
		
		x.gridy = 3;
		x.gridheight = 2;
		x.anchor = GridBagConstraints.NORTHWEST;
		add(for_list, x);
		
		x.gridy = 5;
		x.gridheight = 1;
		add(end_label, x);
		
		x.gridx = 2;
		x.gridy = 6;
		x.anchor = GridBagConstraints.EAST;
		add(bpanel, x);
		
		
	}
	
	/**
	 * Creates and displays a For-Loop Dialog
	 * @param code
	 */
	public static void getForDialog(Code code){
		JDialog c = new LoopDialog(null, code);
		c.pack();
		c.setLocationRelativeTo(null);
		c.setVisible(true);
		c.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		c.setModal(true);
		
	}
	
	/**
	 * Adds a new element to the list
	 * @param String data
	 */
	public static void add(String data){
		if(data == null){
			JOptionPane.showMessageDialog(null, "You must select a basic action", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		
		if(for_model.getSize() == 0 || for_model.getSize() == 1){
			if(((String)for_model.getElementAt(0)).equalsIgnoreCase("empty")){//remove default value
				for_model.remove(0);
				for_model.addElement(data);
			}
			else{
				for_model.addElement(data);
			}
		}
		else{
			for_model.addElement(data);
		}
		
		for_list.setSelectedIndex(-1);
	}
	
	/**
	 * Removes the selected element from the list
	 * <p>
	 * Displays an error dialog on invalid selections. 
	 * If there is only one element in the and this is removed, a default "empty" message is displayed in list
	 * </p>
	 * @param int index
	 */
	public void remove(int index){
		
		if(index == -1){
			JOptionPane.showMessageDialog(null, "You must select from For to remove", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(for_model.size() == 1){//display default value
			for_model.remove(0);
			for_model.addElement("Empty");
			
		}
		else{
			for_model.remove(index);
		}
		for_list.setSelectedIndex(-1);
		
		return;
	}
	
	/**
	 * Returns the integer exit code for this dialog.
	 * <p>
	 * 1 if a the dialog resulted in an update to the code list
	 * -1 if the dialog was terminated and all changes discarded.
	 * </p>
	 * @return int
	 */
	public static int getValue(){
		return value;
	}
	
	public static boolean isListEmpty(){
		if(for_model.getSize() == 1){
			if(((String)for_model.getElementAt(0)).equalsIgnoreCase("empty")){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
}
