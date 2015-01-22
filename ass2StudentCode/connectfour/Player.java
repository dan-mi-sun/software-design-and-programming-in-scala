package connectfour;

public enum Player {
	RED, YELLOW;

	/** Return the opponent of this player. */
	public Player opponent() {
		return this == RED ? YELLOW : RED;
	}

	/** Return the Player as a String */
	public String toString() {
		return this == RED ? "RED" : "YELLOW";
	}
}