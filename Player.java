/**
 * Represents a player in the game.
 */
class Player {
	Player(int number, String color) {
		this.number = number;
		this.color = color;
		//TODO: init pieces
	}


	/**
	 * Initializes the player's pieces.
	 * @param side which side the player is on (0 for left, 1 for right)
	 */
	public void initializePieces(int side) {
		if (side == 0) {
			//this should only add the REFERENCES to pieces that are initialized in the Board class
			//walang new new dito
			//TODO after finishing Board class
		}
	}

	public Piece[] getPieces() {
		return pieces;
	}

	public Tile[] getTiles() {
		return tiles;
	}

	public String getColor() {
		return color;
	}

	public int getNumber() {
		return number;
	}
	
	/** This method makes the player draw a piece from the class Bag

    	@param b the bag where the player draws a piece from
    	@return a random piece from the bag
	*/
	public Piece drawPiece(Bag b)
	{
		return b.getPiece();
	}

	private Piece[] pieces;
	private Tile[] denTiles;
	private int number;
	private String color;
}
