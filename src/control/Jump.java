package control;

class Jump extends Executable {

	/**
	 * If this jump instruction is instruction n, the next instruction
	 * to execute is instruction n + offset.
	 */
	final int offset;
	
	Jump(int line, int offset) {
		super(line);
		this.offset = offset;
	}

}
