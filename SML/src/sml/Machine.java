package sml;

import java.util.ArrayList;

import lombok.Data;

/*
 * The machine language interpreter
 */
@Data
public class Machine {
	// The labels in the SML program, in the order in which
	// they appear (are defined) in the program

	private Labels labels;

	// The SML program, consisting of prog.size() instructions, each
	// of class Instruction (or one of its subclasses)
	private ArrayList<Instruction> prog;

	// The registers of the SML machine
	private Registers registers;

	// The program counter; it contains the index (in prog) of
	// the next instruction to be executed.

	private int pc;

	{
		labels = new Labels();
		prog = new ArrayList<>();
		pc = 0;
	}

	public static void main(String[] args) {

		Machine m = new Machine();
		Translator t = new Translator(args[0]);
		t.readAndTranslate(m.getLabels(), m.getProg());

		System.out.println("Here is the program; it has " + m.getProg().size() + " instructions.");
		System.out.println(m);

		System.out.println("Beginning program execution.");
		m.execute();
		System.out.println("Ending program execution.");

		System.out.println("Values of registers at program termination:");
		System.out.println(m.getRegisters() + ".");
	}

	// Print the program

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i != getProg().size(); i++)
			s.append(getProg().get(i) + "\n");
		return s.toString();
	}

	// Execute the program in prog, beginning at instruction 0.
	// Precondition: the program and its labels have been store properly.

	public void execute() {
		setPc(0);
		setRegisters(new Registers());
		while (getPc() < getProg().size()) {
			Instruction ins = getProg().get(getPc());
			setPc(getPc() + 1);
			ins.execute(this);
		}
	}
}