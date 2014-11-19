package control;

import model.BasicCode;
import model.Code.Action;

class Instruction extends Executable {

	final Action action;
	
	Instruction(int line, Action action) {
		super(line);
		this.action = action;
	}
	
	Instruction(int line, BasicCode code) {
		super(line);
		this.action = code.getInstruction();
	}
}
