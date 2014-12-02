package view;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;

import java.util.ArrayList;

import model.*;
import model.World.Contents;
import model.Code.*;
import control.Controller;

public class Util {
	
	static Controller cntrl;
	static JLabel[][] worldLabels;
	
	public static void updateCodeList(Code c){
		cntrl.getCodeList().add(c);
	}
	
	public static void setLabels(JLabel[][] labels) {
		worldLabels = labels;
	}
	
	public static JLabel getLabel(int x, int y) {
		return worldLabels[x][y];
	}
	
	public static void drawWorld() {
		World world = cntrl.getWorld();
		for(int i = 0; i < world.getYSize(); i++) {
			for(int j = 0; j < world.getXSize(); j++) {
				Contents contents = world.getContents(j, world.getYSize() - 1 - i);
				JLabel label = worldLabels[i][j];
				StringBuffer sb = new StringBuffer();
				sb.append(String.valueOf(j));
				sb.append(String.valueOf(world.getYSize() - 1 - i));
				switch(contents) {
				case BEEPER:
					sb.append("B");
					break;
				case NONE:
					sb.append("N");
					break;
				case OUT_OF_BOUNDS:
					sb.append("O");
					break;
				case WALL:
					sb.append("W");
					break;
				default:
					break;
				}
				label.setText(sb.toString());
				// worldLabels[i][j].setText(String.valueOf(j) + String.valueOf(world.getYSize() - 1 - i));
			}
		}
	}
	
	public static Code matchStringToCode(String s){

		switch(s){
		
			case "Move":			return new BasicCode(Action.MOVE);
			case "Turn Left":		return new BasicCode(Action.TURN_LEFT);
			case "Turn Right":		return new BasicCode(Action.TURN_RIGHT);
			case "Pick up beeper":	return new BasicCode(Action.PICK_UP);
			case "Put down beeper":	return new BasicCode(Action.PUT_DOWN);
			case "If":				
			case "End-If":
			case "Else":
			case "End-Else":
			case "For":
			case "End-For":			return null;
		
		}
		return null;
	}

	public static Proposition stringtoProposition(String s){
		
		switch(s){
		
		case "Facing East":			return Proposition.IS_FACING_EAST;
		case "Facing West":		return Proposition.IS_FACING_WEST;
		case "Facing North":		return Proposition.IS_FACING_NORTH;
		case "Facing South":	return Proposition.IS_FACING_SOUTH;
		case "Next to a Beeper":		return Proposition.NEXT_TO_BEEPER;		
		case "Front is Clear":			return Proposition.IS_FRONT_CLEAR;
		case "Right is Clear":			return Proposition.IS_RIGHT_CLEAR;
		case "Left is Clear":			return Proposition.IS_LEFT_CLEAR;
	
		}
		
		return null;
	}
	
	public static ArrayList<Code> getBody(JList list){
		ArrayList<Code> body = new ArrayList<Code>(1);
		
		DefaultListModel model = (DefaultListModel)list.getModel();
		
		if(model.getSize() == 1){
			if(((String)model.getElementAt(0)).equalsIgnoreCase("empty")){
				return null;
			}
		}
		for(int i = 0; i < model.getSize(); i++){
			String s = (String)model.getElementAt(i);
			Code c = matchStringToCode(s);
			body.add(c);
		}
		
		return body;
	}
}
