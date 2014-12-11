package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;

import model.BasicCode;
import model.Code;
import model.Code.Action;
import model.Code.Proposition;
import model.Karel;
import model.World;
import model.World.Contents;
import control.Controller;

public class Util {
	
	static Controller cntrl;
	static JLabel[][] worldLabels;
	static ArrayList<World> worlds;	
	
	static int EditIndex;
	
	public static void initializeWorlds(int worldCount){
		worlds = new ArrayList<World>();
		
		World w = new World(4,4);		
		w.setContents(1, 1, model.World.Contents.BEEPER);
		w.setContents(1,  0, model.World.Contents.BEEPER);
		w.setContents(2, 2, model.World.Contents.BEEPER);
		w.setContents(0,  1, model.World.Contents.WALL);
		w.setContents(1, 2, model.World.Contents.WALL);
		w.setContents(2, 1, model.World.Contents.WALL);
		
		worlds.add(w);
		
		w = new World(6,6);
		w.setContents(1, 1, model.World.Contents.WALL);
		w.setContents(2, 1, model.World.Contents.WALL);
		w.setContents(3, 1, model.World.Contents.WALL);
		w.setContents(4, 1, model.World.Contents.WALL);
		w.setContents(2, 2, model.World.Contents.BEEPER);
		w.setContents(0, 3, model.World.Contents.WALL);
		w.setContents(2, 3, model.World.Contents.WALL);
		w.setContents(3, 3, model.World.Contents.BEEPER);
		w.setContents(4, 3, model.World.Contents.BEEPER);
		w.setContents(5, 3, model.World.Contents.WALL);
		w.setContents(0, 4, model.World.Contents.WALL);
		w.setContents(2, 4, model.World.Contents.WALL);
		w.setContents(4, 4, model.World.Contents.WALL);
		w.setContents(1, 5, model.World.Contents.BEEPER);
		w.setContents(2, 5, model.World.Contents.BEEPER);
		w.setContents(4, 5, model.World.Contents.BEEPER);
		
		worlds.add(w);
		
		w = new World(6,6);
		w.setContents(1, 1, model.World.Contents.BEEPER);
		w.setContents(2, 1, model.World.Contents.WALL);
		w.setContents(3, 1, model.World.Contents.BEEPER);
		w.setContents(4, 1, model.World.Contents.WALL);
		w.setContents(1, 2, model.World.Contents.WALL);
		w.setContents(3, 2, model.World.Contents.WALL);
		w.setContents(1, 3, model.World.Contents.BEEPER);
		w.setContents(3, 3, model.World.Contents.WALL);
		w.setContents(5, 3, model.World.Contents.WALL);
		w.setContents(1, 4, model.World.Contents.WALL);
		w.setContents(3, 4, model.World.Contents.BEEPER);
		w.setContents(5, 4, model.World.Contents.WALL);
		w.setContents(2, 5, model.World.Contents.BEEPER);
		w.setContents(3, 5, model.World.Contents.WALL);
		w.setContents(5, 5, model.World.Contents.BEEPER);
		
		worlds.add(w);

		w = new World(6,6);
		w.setContents(1, 0, model.World.Contents.BEEPER);
		w.setContents(2, 0, model.World.Contents.BEEPER);
		w.setContents(3, 0, model.World.Contents.BEEPER);
		w.setContents(5, 0, model.World.Contents.BEEPER);
		w.setContents(4, 0, model.World.Contents.WALL);
		w.setContents(1, 1, model.World.Contents.WALL);
		w.setContents(2, 1, model.World.Contents.WALL);
		w.setContents(3, 1, model.World.Contents.BEEPER);
		w.setContents(0, 2, model.World.Contents.BEEPER);
		w.setContents(1, 2, model.World.Contents.WALL);
		w.setContents(3, 2, model.World.Contents.WALL);
		w.setContents(5, 2, model.World.Contents.WALL);
		w.setContents(0, 3, model.World.Contents.WALL);
		w.setContents(2, 3, model.World.Contents.WALL);
		w.setContents(4, 3, model.World.Contents.BEEPER);
		w.setContents(5, 3, model.World.Contents.WALL);
		w.setContents(1, 4, model.World.Contents.BEEPER);
		w.setContents(2, 4, model.World.Contents.WALL);
		w.setContents(4, 4, model.World.Contents.WALL);
		w.setContents(5, 5, model.World.Contents.BEEPER);
		w.setContents(3, 5, model.World.Contents.BEEPER);
		
		worlds.add(w);
		
		w = new World(8,8);				   
		w.setContents(3, 4, model.World.Contents.WALL);
		w.setContents(3, 5, model.World.Contents.WALL);
		w.setContents(4, 3, model.World.Contents.WALL);
		w.setContents(4, 7, model.World.Contents.WALL);
		w.setContents(5, 2, model.World.Contents.WALL);
		w.setContents(6, 2, model.World.Contents.WALL);
		w.setContents(7, 2, model.World.Contents.WALL);
		w.setContents(6, 6, model.World.Contents.BEEPER);
		
		worlds.add(w);
	}
	
	public static void updateCodeList(int index, Code c){
		System.out.println("back end codeList size: " + cntrl.getCodeList().size());
		System.out.println("inserting in index: " + index);
		if(index == -1){
			cntrl.getCodeList().add(c);
		}
		else{
			cntrl.getCodeList().add(index, c);
		}
		
		System.out.println("Size after insert: " + cntrl.getCodeList().size());
	}
	
	public static void setLabels(JLabel[][] labels) {
		worldLabels = labels;
	}
	
	public static JLabel getLabel(int x, int y) {
		return worldLabels[x][y];
	}
	
	public static void drawWorld(Karel karel, World world) {
		if (karel == null) {
			karel = cntrl.getKarel();
		}
		if (world == null) {
			world = cntrl.getWorld();
		}
		for(int i = 0; i < world.getYSize(); i++) {
			for(int j = 0; j < world.getXSize(); j++) {
				Contents contents = world.getContents(j, world.getYSize() - 1 - i);
				JLabel label = worldLabels[i][j];
				  worldLabels[i][j].setOpaque(true);
				worldLabels[i][j].setBackground(Color.white);
				
				StringBuffer sb = new StringBuffer();
				//sb.append(String.valueOf(j));
				//sb.append(String.valueOf(world.getYSize() - 1 - i));
				
				boolean karelBeeper = false;
				
				switch(contents) {
				case BEEPER:
				     System.out.println("beeper at xy: " + j + " and " + i);
				     if(karel.getX() == j && karel.getY() == world.getYSize() - 1 - i){
				    	 worldLabels[i][j].setIcon(new ImageIcon("images/beeperRight.png"));
				    	 karelBeeper = true;
				     }
				     else{
				    	 worldLabels[i][j].setIcon(new ImageIcon("images/beeper.png"));
				     }
				     break;
				case NONE:
					  worldLabels[i][j].setOpaque(true);
					  worldLabels[i][j].setIcon(null);
						worldLabels[i][j].setBackground(Color.white);

					break;
				case OUT_OF_BOUNDS:
					//sb.append("O ");
					break;
				case WALL:
					//sb.append("Wall ");
			
					worldLabels[i][j].setIcon(new ImageIcon("images/wall.png"));
					            
					break;
				default:
					break;
				}
				if(!karelBeeper && karel.getX() == j && karel.getY() == world.getYSize() - 1 - i) {
					ImageIcon image = new ImageIcon("images/right.png");
					worldLabels[i][j].setIcon(image);
					//sb.append("Karel ");
					switch(karel.getFacing()) {
					case EAST:
						worldLabels[i][j].setIcon(new ImageIcon("images/right.png"));

						break;
					case NORTH:
						worldLabels[i][j].setIcon(new ImageIcon("images/north.png"));

						break;
					case SOUTH:
						worldLabels[i][j].setIcon(new ImageIcon("images/south.png"));

						break;
					case WEST:
						worldLabels[i][j].setIcon(new ImageIcon("images/left.png"));

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
	
	public static ArrayList<Code> getBodyMacro(){
		ArrayList<Code> body = new ArrayList<Code>(1);
		
		System.out.println("isMacro " + PseudocodeList.isMacro);
		if(PseudocodeList.getTheModel().getSize() == 1){
			if(((String)PseudocodeList.getTheModel().getElementAt(0)).equalsIgnoreCase("Begin by Draging an Action")){// add check for empty for if/for
				System.out.println("NULL");
				return null;
			}
		}
		
		for(int i = 0; i < PseudocodeList.getTheModel().getSize(); i++){
			String s = (String)PseudocodeList.getTheModel().getElementAt(i);
			Code c = matchStringToCode(s);
			body.add(c);
		}
		
		return body;
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
	
	public static void printcodeList(){
		for(int i = 0; i < cntrl.getCodeList().size(); i ++){
			 System.out.println(i + " " + cntrl.getCodeList().get(i).getClass().toString());
		 }
	}
}
