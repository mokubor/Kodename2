package model;

import java.io.Serializable;
import java.util.ArrayList;

import model.Code.Proposition;;

/**
 * This is a IfElse code object type for if statement blocks that include the condition,
 * a list of code to execute if the condition evaluates to true, and a list of code to
 * execute if the condition evaluates to false.
 * @author Kodename team
 * @see java.util.ArrayList
 *
 */
public class IfElseCode extends Code implements Serializable {

	Proposition prop;
	ArrayList<Code> body1;
	ArrayList<Code> body2;

	/**
	 * Constructor for an object representing an if else in Karel.
	 * @param prop the if condition
	 * @param body1 the if body
	 * @param body2 the else body
	 */
	public IfElseCode(Proposition prop, ArrayList<Code> body1, ArrayList<Code> body2) {
		this.prop = prop;
		this.body1 = body1;
		this.body2 = body2;
	}
	/**
	 * Get the if condition.
	 * @return the if condition if it exists, else null
	 */
	public Proposition getCondition() {
		return prop;
	}
	
	/**
	 * Get the if body.
	 * @return the if body
	 */
	public ArrayList<Code> getBody1() {
		return body1;
	}
	
	/**
	 * Get the else body.
	 * @return the else body
	 */
	public ArrayList<Code> getBody2() {
		return body2;
	}
	
	/**
	 * Set the if condition.
	 * @param c if condition
	 */
	public void setCondition(Proposition c) {
		prop = c;
	}
	
	/**
	 * Set the if body.
	 * @param b if body
	 */
	public void setBody1(ArrayList<Code> b) {
		body1 = b;
	}
	
	/**
	 * Set the else body.
	 * @param b else body
	 */
	public void setBody2(ArrayList<Code> b) {
		body2 = b;
	}
}

