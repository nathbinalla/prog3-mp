/**
 * This class represents a match to be played by two players.
 *
 */

class Game {
	private Board board;
	private Player player1;
	private Player player2;
	private int turn;

	Game() {
		board = new Board();
		turn = 0;
		//TODO: player init
	}

	/**
	 * Sets up a new game (piece selection, color, etc).
	 */
	public void newGame() {
		//is this where i put the players drawing pieces to know who goes first?
	}

	/**
	 * Executes a turn by moving a piece in a given direction.
	 */
	public boolean doTurn(Piece piece, char direction) {
		return piece.movePiece(direction);
	}

	public void EndGame() {
		//zzz
	}
}
