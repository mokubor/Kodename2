package model;

import java.util.ArrayList;

/**
 * This is a IfElse code object type for if statement blocks that include the condition,
 * a list of code to execute if the condition evaluates to true, and a list of code to
 * execute if the condition evaluates to false.
 * @author Kodename team
 * @see java.util.ArrayList
 *
 */
public class IfElseCode extends Code {

	String condition;
	ArrayList<Code> body1;
	ArrayList<Code> body2;
	
	
	/* No setter for this field. It is managed internally. */
	boolean evalCondition;
	
	/**
	 * Constructor for an object representing an if else in Karel.
	 * @param condition the if condition
	 * @param body1 the if body
	 * @param body2 the else body
	 */
	public IfElseCode(String condition, ArrayList<Code> body1, ArrayList<Code> body2) {
		this.evalCondition=true;
		this.condition = condition;
		this.body1 = body1;
		this.body2 = body2;
	}
	/**
	 * Get the if condition.
	 * @return the if condition if it exists, else null
	 */
	public String getCondition() {
		return condition;
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
	public void setCondition(String c) {
		evalCondition = true;
		condition = c;
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

