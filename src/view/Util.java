package view;

import model.*;
import model.Code.*;

public class Util {
	
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
}
