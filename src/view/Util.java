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
	static World[] worlds;	
	
	static int EditIndex;
	
	public static void initializeWorlds(int worldCount){
		worlds = new World[worldCount];
		
		worlds[0] = new World(4,4);		
		worlds[0].setContents(1, 1, model.World.Contents.BEEPER);
		worlds[0].setContents(1,  0, model.World.Contents.BEEPER);
		worlds[0].setContents(2, 2, model.World.Contents.BEEPER);
		worlds[0].setContents(0,  1, model.World.Contents.WALL);
		worlds[0].setContents(1, 2, model.World.Contents.WALL);
		worlds[0].setContents(2, 1, model.World.Contents.WALL);
		
		worlds[1] = new World(6,6);
		worlds[1].setContents(1, 1, model.World.Contents.WALL);
		worlds[1].setContents(2, 1, model.World.Contents.WALL);
		worlds[1].setContents(3, 1, model.World.Contents.WALL);
		worlds[1].setContents(4, 1, model.World.Contents.WALL);
		worlds[1].setContents(2, 2, model.World.Contents.BEEPER);
		worlds[1].setContents(0, 3, model.World.Contents.WALL);
		worlds[1].setContents(2, 3, model.World.Contents.WALL);
		worlds[1].setContents(3, 3, model.World.Contents.BEEPER);
		worlds[1].setContents(4, 3, model.World.Contents.BEEPER);
		worlds[1].setContents(5, 3, model.World.Contents.WALL);
		worlds[1].setContents(0, 4, model.World.Contents.WALL);
		worlds[1].setContents(2, 4, model.World.Contents.WALL);
		worlds[1].setContents(4, 4, model.World.Contents.WALL);
		worlds[1].setContents(1, 5, model.World.Contents.BEEPER);
		worlds[1].setContents(2, 5, model.World.Contents.BEEPER);
		worlds[1].setContents(4, 5, model.World.Contents.BEEPER);
		
		worlds[2] = new World(6,6);
		worlds[2].setContents(1, 1, model.World.Contents.BEEPER);
		worlds[2].setContents(2, 1, model.World.Contents.WALL);
		worlds[2].setContents(3, 1, model.World.Contents.BEEPER);
		worlds[2].setContents(4, 1, model.World.Contents.WALL);
		worlds[2].setContents(1, 2, model.World.Contents.WALL);
		worlds[2].setContents(3, 2, model.World.Contents.WALL);
		worlds[2].setContents(1, 3, model.World.Contents.BEEPER);
		worlds[2].setContents(3, 3, model.World.Contents.WALL);
		worlds[2].setContents(5, 3, model.World.Contents.WALL);
		worlds[2].setContents(1, 4, model.World.Contents.WALL);
		worlds[2].setContents(3, 4, model.World.Contents.BEEPER);
		worlds[2].setContents(5, 4, model.World.Contents.WALL);
		worlds[2].setContents(2, 5, model.World.Contents.BEEPER);
		worlds[2].setContents(3, 5, model.World.Contents.WALL);
		worlds[2].setContents(5, 5, model.World.Contents.BEEPER);

		worlds[3] = new World(6,6);
		worlds[3].setContents(1, 0, model.World.Contents.BEEPER);
		worlds[3].setContents(2, 0, model.World.Contents.BEEPER);
		worlds[3].setContents(3, 0, model.World.Contents.BEEPER);
		worlds[3].setContents(5, 0, model.World.Contents.BEEPER);
		worlds[3].setContents(4, 0, model.World.Contents.WALL);
		worlds[3].setContents(1, 1, model.World.Contents.WALL);
		worlds[3].setContents(2, 1, model.World.Contents.WALL);
		worlds[3].setContents(3, 1, model.World.Contents.BEEPER);
		worlds[3].setContents(0, 2, model.World.Contents.BEEPER);
		worlds[3].setContents(1, 2, model.World.Contents.WALL);
		worlds[3].setContents(3, 2, model.World.Contents.WALL);
		worlds[3].setContents(5, 2, model.World.Contents.WALL);
		worlds[3].setContents(0, 3, model.World.Contents.WALL);
		worlds[3].setContents(2, 3, model.World.Contents.WALL);
		worlds[3].setContents(4, 3, model.World.Contents.BEEPER);
		worlds[3].setContents(5, 3, model.World.Contents.WALL);
		worlds[3].setContents(1, 4, model.World.Contents.BEEPER);
		worlds[3].setContents(2, 4, model.World.Contents.WALL);
		worlds[3].setContents(4, 4, model.World.Contents.WALL);
		worlds[3].setContents(5, 5, model.World.Contents.BEEPER);
		worlds[3].setContents(3, 5, model.World.Contents.BEEPER);
		
		worlds[4] = new World(15,15);				   
		worlds[4].setContents(3, 4, model.World.Contents.WALL);
		worlds[4].setContents(3, 5, model.World.Contents.WALL);
		worlds[4].setContents(4, 3, model.World.Contents.WALL);
		worlds[4].setContents(4, 7, model.World.Contents.WALL);
		worlds[4].setContents(4, 8, model.World.Contents.WALL);
		worlds[4].setContents(4, 9, model.World.Contents.BEEPER);
		worlds[4].setContents(4, 10, model.World.Contents.BEEPER);
		worlds[4].setContents(4, 11, model.World.Contents.BEEPER);
		worlds[4].setContents(4, 12, model.World.Contents.WALL);
		worlds[4].setContents(4, 13, model.World.Contents.WALL);
		worlds[4].setContents(4, 14, model.World.Contents.WALL);
		worlds[4].setContents(5, 2, model.World.Contents.WALL);
		worlds[4].setContents(6, 2, model.World.Contents.WALL);
		worlds[4].setContents(7, 2, model.World.Contents.WALL);
		worlds[4].setContents(8, 3, model.World.Contents.WALL);					     
		worlds[4].setContents(8, 7, model.World.Contents.WALL);
		worlds[4].setContents(8, 8, model.World.Contents.WALL);
		worlds[4].setContents(8, 9, model.World.Contents.BEEPER);
		worlds[4].setContents(8, 10, model.World.Contents.BEEPER);
		worlds[4].setContents(8, 11, model.World.Contents.BEEPER);
		worlds[4].setContents(8, 12, model.World.Contents.WALL);
		worlds[4].setContents(8, 13, model.World.Contents.WALL);
		worlds[4].setContents(8, 14, model.World.Contents.WALL);
		worlds[4].setContents(9, 4, model.World.Contents.WALL);
		worlds[4].setContents(9, 5, model.World.Contents.WALL);		
	}
	
	public static void updateCodeList(int index, Code c){
		if(index == -1){
			cntrl.getCodeList().add(c);
		}
		else{
			cntrl.getCodeList().add(index, c);
		}
	}
	
	public static void setLabels(JLabel[][] labels) {
		worldLabels = labels;
	}
	
	public static JLabel getLabel(int x, int y) {
		return worldLabels[x][y];
	}
	
	public static void drawWorld() {
		Karel karel = cntrl.getKarel();
		World world = cntrl.getWorld();
		for(int i = 0; i < world.getYSize(); i++) {
			for(int j = 0; j < world.getXSize(); j++) {
				Contents contents = world.getContents(j, world.getYSize() - 1 - i);
				JLabel label = worldLabels[i][j];
				StringBuffer sb = new StringBuffer();
				//sb.append(String.valueOf(j));
				//sb.append(String.valueOf(world.getYSize() - 1 - i));
				switch(contents) {
				case BEEPER:
					sb.append("Beeper ");
					break;
				case NONE:
					//sb.append("N");
					break;
				case OUT_OF_BOUNDS:
					sb.append("O ");
					break;
				case WALL:
					sb.append("Wall ");
					break;
				default:
					break;
				}
				if(karel.getX() == j && karel.getY() == world.getYSize() - 1 - i) {
					sb.append("Karel ");
					switch(karel.getFacing()) {
					case EAST:
						sb.append("/East");
						break;
					case NORTH:
						sb.append("/North");
						break;
					case SOUTH:
						sb.append("/South");
						break;
					case WEST:
						sb.append("/West");
						break;
					default:
						break;
					
					}
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
	
	public static String codetoString(Code c){
		Action t = ((BasicCode)c).getInstruction();
		switch(t){
		
			case MOVE: return "Move";
			case TURN_LEFT: return "Turn Left";
			case TURN_RIGHT: return "Turn Right";
			case PICK_UP: return "Pick up Beeper";
			case PUT_DOWN: return "Put down Beeper";
		
		}
		
		return null;
	}
	
	public static String propositiontoString(Proposition p){
		
		switch(p){
		
			case IS_FRONT_CLEAR: return "Front is Clear";
			case IS_LEFT_CLEAR: return "Left is Clear";
			case IS_RIGHT_CLEAR: return "Right is Clear";
			case IS_FACING_NORTH: return "Facing North";
			case IS_FACING_SOUTH: return "Facing South";
			case IS_FACING_EAST: return "Facing East";
			case IS_FACING_WEST: return "Facing West";
			case NEXT_TO_BEEPER: return "Next to a Beeper";
		
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
