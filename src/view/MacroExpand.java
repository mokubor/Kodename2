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
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import model.Code;
import model.CustomCode;
import model.LoopCode;

/**
 * A class which defines the component that allows a user to examine the contents of a previously
 * created custom action or conditional action. 
 * 
 * The action expanded cannot be edited within this dialog.
 */
public class MacroExpand extends JDialog{
	static JList list;
	static DefaultListModel model;
	JLabel name;
	static JButton done;
	JScrollPane scroll;
	ArrayList<String> x;
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton source = (JButton)e.getSource();
			
			if(source == done){
				dispose();
			}
			else{
				dispose();
			}
		}
	}
	
	public MacroExpand(String key, ArrayList<Code> Body){
		if (key == null) {
			throw new IllegalArgumentException("MacroExpand constructor: name is null");
		}
		JLabel label = new JLabel ("Macro Name: ");
		
		name = new JLabel("");
		
		if(Body == null){
			throw new IllegalArgumentException("MacroExpand constructor: body is null");
		}
		
		model = new DefaultListModel();
		name = new JLabel();
		
		name.setText(key);
		name.setVisible(true);
		
		/*
		 * add actions defined to display list
		 * 
		 * consider: removing the temp arraylist; x
		 */
		x = new ArrayList<String>(1);
		
		for(int i = 0; i < Body.size(); i++){
			String temp = Body.get(i).toString();
			x.add(temp);
		}
			
			
		for(int i = 0; i < x.size(); i ++){
			model.addElement(x.get(i));
		}
		
		/*add components to panel*/
		list = new JList(model);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setFixedCellWidth(200);
		list.setEnabled(true);
		list.setVisible(true);
		list.setSelectedIndex(-1);
		
		scroll = new JScrollPane(list);
			
		done = new JButton("Done");
		done.addActionListener(new ButtonListener());
		
		JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT,5, 5));
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(name);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		
		/*layout*/
		setLayout(new GridBagLayout());
		GridBagConstraints x = new GridBagConstraints();
		
		x.anchor = GridBagConstraints.CENTER;
		x.gridx = 0;
		x.gridy = 0;
		add(panel, x);
		
		x.gridy = 1;
		x.gridheight = 3;
		add(scroll, x);
		
		x.gridy = 4;
		x.gridheight = 1;
		add(done, x);
		
	}
	
	/**
	 * Method to activate/instantiate a MacroExpand dialog.
	 * @param String key
	 * @param Code code
	 */
	public static void ExpandMacro(String key, ArrayList<Code> code){
		JDialog c = new MacroExpand(key, code);
		c.pack();
		c.setLocationRelativeTo(null);
		c.setVisible(true);
		c.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		c.setModal(true);
	}
}
