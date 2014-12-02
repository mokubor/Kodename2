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
import model.Code.Proposition;
import model.IfElseCode;


public class ConditionDialog extends JDialog{
	JPanel basic;
	String[] listofBooleans = {"NONE", "Facing East", "Facing West", "Facing North", "Facing South", "Next to a Beeper", "Front is Clear",
			"Right is Clear", "Left is Clear"};
	JComboBox booleans;
	JButton done;
	JButton cancel;
	JList if_list;
	JList else_list;
	JLabel if_label;
	JLabel else_label;
	DefaultListModel if_model;
	DefaultListModel else_model;
	JScrollPane scrollbar1;
	JScrollPane scrollbar2;
	String condition;
	Code if_code_piece;
	
	JButton to_if;
	JButton to_else;
	
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)e.getSource();
			
			if(source == done){
				if(booleans.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null, "if condition cannot be none", "Invalid Selection", JOptionPane.WARNING_MESSAGE);
					return;
				}
				else{
					condition = (String)booleans.getSelectedItem();
					System.out.println(condition);
					
					
					Proposition p = Util.stringtoProposition(condition);
					ArrayList<Code> body1 = Util.getBody(if_list);
					ArrayList<Code> body2 = Util.getBody(else_list);
					
					((IfElseCode) if_code_piece).setCondition(p);
					((IfElseCode) if_code_piece).setBody1(body1);
					((IfElseCode) if_code_piece).setBody2(body2);
					
					Util.updateCodeList(if_code_piece);
					
					
					dispose();
				}
				
				
			}
			else if(source == to_if){
				add(if_list, BasicActions.getElement());
				
			}
			else if(source == to_else){
				add(else_list, BasicActions.getElement());
			}
			else{
				dispose();
			}
			
			
		}
	}
	
	public ConditionDialog(JFrame owner){
		super(owner, "Create condition statement(s)", true);
		
		if_code_piece = new IfElseCode(null, null, null);
		
		basic = new BasicActions();
		
		booleans = new JComboBox(listofBooleans);
		booleans.setSelectedIndex(0);
		
		
		done = new JButton("Done");
		done.addActionListener(new ButtonListener());
		cancel = new JButton("Cancel");
		cancel.addActionListener(new ButtonListener());
		to_if = new JButton("Add to if");
		to_if.addActionListener(new ButtonListener());
		to_else = new JButton("Add to else");
		to_else.addActionListener(new ButtonListener());
		
		JLabel message = new JLabel("Pick a condition for your if statement:");
		if_label = new JLabel("If:");
		else_label = new JLabel("Else:");
		
		if_model = new DefaultListModel();
		else_model = new DefaultListModel();
		
		String[] empty = new String[1];
		empty[0] = "Empty";
		
		for(int i = 0; i < empty.length; i++){
			if_model.addElement(empty[i]);
			else_model.addElement(empty[i]);
		}
		
		if_list = new JList(if_model);
		if_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if_list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		if_list.setFixedCellWidth(200);
		if_list.setEnabled(true);
		if_list.setVisible(true);
		if_list.setSelectedIndex(-1);
		
		
		else_list = new JList(else_model);
		else_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		else_list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		else_list.setFixedCellWidth(200);
		else_list.setEnabled(true);
		else_list.setVisible(true);
		else_list.setSelectedIndex(-1);
	
		
		
		scrollbar1 = new JScrollPane(if_list);
		scrollbar2 = new JScrollPane(else_list);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(booleans);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(if_label);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(scrollbar1);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(else_label);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(scrollbar2);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		

		JPanel bpanel = new JPanel();
		bpanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		bpanel.add(cancel);
		bpanel.add(done);

		
		
		setLayout(new GridBagLayout());
		GridBagConstraints x = new GridBagConstraints();
		
		x.anchor = GridBagConstraints.EAST;
		x.gridx = 0;
		x.gridy = 4;
		add(basic, x);
		
		x.anchor = GridBagConstraints.CENTER;
		x.gridx = 1;
		x.gridy = 2;
		add(to_if, x);
		
		x.gridy = 4;
		add(to_else, x);
		
		x.gridx = 2;
		x.gridy = 0;
		add(message, x);
		
		x.anchor = GridBagConstraints.WEST;
		x.gridx = 2;
		x.gridy = 4;
		add(panel, x);
		
		x.gridx = 0;
		x.gridy = 5;
		x.anchor = GridBagConstraints.WEST;
		add(bpanel, x);
		
		
		
		
		
	}
	
	public static void getIfDialog(){
		JDialog c = new ConditionDialog(Main.currentWindow);
		c.pack();
		c.setLocationRelativeTo(null);
		c.setVisible(true);
		c.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public static void add(JList list, String data){
		System.out.println(data + " to some list");
		DefaultListModel model = (DefaultListModel)list.getModel();
		
		if(model.getSize() == 0 || model.getSize() == 1){
			if(((String)model.getElementAt(0)).equalsIgnoreCase("empty")){
				model.remove(0);
				model.addElement(data);
			}
			else{
				model.addElement(data);
			}
		}
		else{
			model.addElement(data);
		}
		
		list.setSelectedIndex(-1);
	}

}
