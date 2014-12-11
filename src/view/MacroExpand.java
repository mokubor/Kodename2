package view;

import java.awt.Dimension;
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

public class MacroExpand extends JDialog{
	static JList list;
	static DefaultListModel model;
	static JLabel name;
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
		JLabel label = new JLabel ("Macro Name: ");
		if(Body == null){
			//break
		}
		model = new DefaultListModel();
		name.setText(key);
		name.setVisible(true);
		
			x = new ArrayList<String>(1);
			for(int i = 0; i < Body.size(); i++){
				String temp = Util.codetoString(Body.get(i));
				x.add(temp);
			}
			
			
			
			for(int i = 0; i < x.size(); i ++){
				model.addElement(x.get(i));
			}
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
		panel.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		panel.add(name);
		panel.add(Box.createRigidArea(new Dimension(0,10)));
		
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
	public static void ExpandMacro(String key, ArrayList<Code> code){
		JDialog c = new MacroExpand(key, code);
		c.pack();
		c.setLocationRelativeTo(null);
		c.setVisible(true);
		c.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		c.setModal(true);
	}
}
