package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import model.BasicCode;
import model.Code;
import model.CustomCode;
import model.KRuntimeException;
import model.Karel;
import model.World;

/**
 * Controller acts as a communication medium between the code that the user has created for Karel and any
 * user interfaces (textual or graphical). The primary function of Controller is to maintain all state
 * information necessary to run a session (keep track of Karel and World objects and the user's code). It
 * will parse the user's code and issue commands to Karel.
 * 
 * @author Kodename team
 */
public class Controller implements Serializable {
	
	final Karel karel;
	final World world;
	Map<String, CustomCode> macros;
	ArrayList<Code> codeList;
	Deque<BasicCode> deque;
	
	/**
	 * Instantiate a controller, representing a new game / new session.
	 * 
	 * @param x number of columns in the world
	 * @param y number of rows in the world
	 * @return a new controller
	 */
	public Controller(int x, int y) {
		world = new World(x, y);
		karel = new Karel(world, 0, 0);
		macros = new HashMap<String, CustomCode>();
		codeList = new ArrayList<Code>();
		deque = null;
	}
	
	/**
	 * Change the macro associated with a macro name.
	 * 
	 * @param name the name of the macro
	 * @param cc the macro body
	 * @return null if no macro of the given name existed, else the previous macro body
	 * (that has just been replaced)
	 */
	public CustomCode addMacro(String name, CustomCode cc) {
		if (name == null || cc == null) {
			throw new IllegalArgumentException("Neither macro name nor body can be null.");
		}
		return macros.put(name, cc);
	}
	
	/**
	 * Determine whether a macro of a given name exists.
	 * 
	 * @param name string name of the macro
	 * @return true iff the macro exists
	 */
	public boolean hasMacro(String name) {
		return macros.containsKey(name);
	}
	
	/**
	 * Find a macro by name. Since no UI should ask for a nonexistent macro, this throws
	 * an exception if that case does occur.
	 * 
	 * @param name the name of the macro
	 * @return the CustomCode object representing the macro
	 * @throws IllegalArgumentException if no macro of the given name exists
	 */
	public CustomCode getMacro(String name) {
		if (!macros.containsKey(name)) {
			throw new IllegalArgumentException("No macro named " + name + " exists.");
		}
		return macros.get(name);
	}

	/**
	 * Return the user's Karel program.
	 * 
	 * @return the list containing all blocks of code in the Karel program
	 */
	public ArrayList<Code> getCodeList() {
		return codeList;
	}
	
	/**
	 * Parses the codeList, populates the queue of BasicCode instructions.
	 */
	public void parseCode() {
		deque = new LinkedList<BasicCode>();
		// TODO implement
		throw new UnsupportedOperationException("Not implemented.");
	}
	
	/**
	 * Execute the entire Karel program.
	 * 
	 * @assumes the Karel program has not been modified since the last call to
	 * parseCode
	 * @return a message indicating execution successful, or else a message
	 * indicating where execution failed
	 * @throws IllegalStateException if the code has not bee parsed
	 */
	public String execute(){
		if (deque == null) {
			throw new IllegalStateException("You must parse the code before executing.");
		}
		// TODO calls executePrivate, catches any exceptions
		return null;
	}
	
	/**
	 * Calls Karel to act on the given instruction
	 * @param s the executable instruction
	 */
	private void callKarel(Code.Action action){
		switch(action) {
		case MOVE:
			karel.move();
			break;
		case PICK_UP:
			karel.pickUp();
			break;
		case PUT_DOWN:
			karel.putDown();
			break;
		case TURN_LEFT:
			karel.turnLeft();
			break;
		case TURN_RIGHT:
			karel.turnRight();
			break;
		default:
			throw new RuntimeException("Controller cannot execute this unknown action: " + action);
		}
	}

}

