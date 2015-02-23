object GameGUI extends App {
  /* -------------------------- Change these to play game differently. -------------------------- */

  /* p1 is the first player, p2 is the second player. A Solver
         * can be a Human, AI, or Dummy. Human and Dummy constructors have
         * a player parameter; the AI constructor has a player and depth
         * as parameters, with the a depth used to recurse when searching the
         * game space. */
  // val p1 = new AI(RED, 6);
  // val p2 = new Human(YELLOW);
  val p1 = new Dummy(RED);
  val p2 = new Dummy(YELLOW);
  // val p1 = new Human(RED);
  // val p2 = new Dummy(YELLOW);

  /* --------------------------------- Do not change below here. --------------------------------- */

  val game = new Game(p1, p2);
  game.setGUI(new GUI(game, Board.NUM_COLS, Board.NUM_ROWS));
  game.runGame();
}
