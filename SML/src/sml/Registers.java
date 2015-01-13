package sml;

import lombok.Data;

/**
 * This class ....
 * 
 * An instance contains 32 registers and methods to access and change them
 * 
 * @author someone
 */

@Data
public class Registers {

	private final static int NUMBEROFREGISTERS = 32;
	private int registers[];

	// Constructor: an instance whose registers are set to 0

	{
		registers = new int[NUMBEROFREGISTERS];
	}

	public Registers() {
		for (int i = 0; i != registers.length; i++) {
			registers[i] = 0;
		}
	}

	// Set register i to v.
	// Precondition: 0 <= i <= NUMBEROFREGISTERS

	public void setRegister(int i, int v) {
		registers[i] = v;
	}

	public int getRegister(int i) {
		return registers[i];
	}
}