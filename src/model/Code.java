package model;

import java.io.Serializable;
/**
 * This is a Code object type that will allow for proper hierarchy of the code
 * types. It also ensures that Loop, IfElse, Basic, and Custom code objects are
 * all equal to each other to prevent ambiguity.
 * @author Kodename team
 * @see java.util.ArrayList
 *
 */
public abstract class Code implements Serializable {
	
	public enum Action { MOVE, TURN_LEFT, TURN_RIGHT, PICK_UP, PUT_DOWN }
	public enum Proposition { IS_WALL_IN_FRONT }
	
}
