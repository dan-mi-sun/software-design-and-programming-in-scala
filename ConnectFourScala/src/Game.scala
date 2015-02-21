
class Game(private var activePlayer: Solver, private var player2: Solver) {

  private var board: Board = Board()

  private var gui: GUI = _

  private var winner: Option[Player] = _

  def this(p1: Solver,
           p2: Solver,
           b: Board,
           p: Boolean) {
    this(p1, p2)
    board = b
    activePlayer = (if (p) p1 else p2)
  }

  def setGUI(gui: GUI) {
    this.gui = gui
  }

  def columnClicked(col: Int) {
    if (activePlayer.isInstanceOf[Human]) {
      activePlayer.asInstanceOf[Human].columnClicked(col)
    }
  }

  def runGame() {
    while (!isGameOver) {
      var moveIsSafe = false
      var nextMove: Move = null
      while (!moveIsSafe) {
        val bestMoves = activePlayer.getMoves(board)
        if (bestMoves.length == 0) {
          gui.setMsg("Game cannot continue until a Move is produced.")
          //continue
        } else {
          nextMove = bestMoves(0)
        }
        if (board.getTile(0, nextMove.column) == null) {
          moveIsSafe = true
        } else {
          gui.setMsg("Illegal Move: Cannot place disc in full column. Try again.")
        }
      }
      board.makeMove(nextMove)
      if (gui == null) {
        println(nextMove)
        println(board)
      } else {
        gui.updateGUI(board, nextMove)
      }
      val temp = activePlayer
      activePlayer = player2
      player2 = temp
      try {
        Thread.sleep(Game.SLEEP_INTERVAL)
      } catch {
        case e: InterruptedException => e.printStackTrace()
      }
    }
    if (gui == null) {
      if (winner.isDefined) {
        println(winner + " won the game!!!")
      } else {
        println("Tie game!")
      }
    } else {
      gui.notifyGameOver(winner.get)
    }
  }

  def isGameOver(): Boolean = {
    winner = board.hasConnectFour()

    if (winner.isDefined) return true
    var r = 0
    while (r < Board.NUM_ROWS) {
      var c = 0
      while (c < Board.NUM_COLS) {
        if (board.getTile(r, c) == null) return false
        c = c + 1
      }
      r = r + 1
    }
    true
  }
}

object Game extends App {

  val p1 = Dummy(RED)
  val p2 = Dummy(YELLOW)
  val game = Game(p1, p2)
  private val SLEEP_INTERVAL = 10
  game.runGame()

  def apply(p1: Solver, p2: Solver) =
    new Game(p1, p2)
}

