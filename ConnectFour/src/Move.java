import lombok.Data;

/**
 * An instance represents a player and a column number, so that when this move
 * is applied to a Board object, this Move's player will place a piece in
 * this Move's column in the Board.
 */
@Data
public class Move {
    private Player player;  // player is playing
    private int column;           // in this column

    /**
     * Constructor: an instance with player p playing in column c.
     * Precondition p != null and c in 0..Board.NUM_COLS-1.
     */
    public Move(Player p, int c) {
        if (p == null) {
            throw new IllegalArgumentException("Cannot create a Move with a null player");
        }
        if (c < 0 || Board.NUM_COLS <= c) {
            throw new IllegalArgumentException("Cannot create a Move with column that " +
                    "is not in 0..Board.NUM_COLS-1");
        }
        column = c;
        player = p;
    }

    /**
     * Return a representation of this Move.
     */
    @Override
    public String toString() {
        return player + " put a piece in column " + column;
    }
}
