/**
* Represents a moveable piece.
*/
public class Piece extends Tile { 

  /**
  * This constructor creates a Piece object with a type, owner, and position.
  * @param t Tile type
  * @param x x-position
  * @param y y-position
  * @param o Piece owner (0 = none, 1 = player 1, 2 = player 2)
  * @param r Piece rank
  * @param board The board this piece is on
  */
  Piece(String t, int x, int y, int o, int r, Board board) {
    super(t, x, y, o, board);
    rank = r;
  }
  /**
  * Returns the piece's rank.
  */
  public int getRank() {
    return rank;
  }

  /**
  * Moves the piece in one direction.
  * @param  direction The desired direction to move in (N/S/E/W).
  * @param  pieces  The array of all game pieces in play.
  * @param  terrain The array of all terrain.
  * @return false if movement fails, true otherwise.
  */
  public boolean movePiece(char direction) {
    Piece[] pieces = this.getBoard().getPieces();
    Tile[] terrain = this.getBoard().getTerrain();
    int checkX = 0;
    int checkY = 0;

    switch (direction) {
      case 'N':
        checkY = 1;
        break;
      case 'S':
        checkY = -1;
        break;
      case 'E':
        checkX = 1;
        break;
      case 'W':
        checkX = -1;
        break;
      default:
        return false;
    }


    int collisionIndex = 0;
    boolean collision = false;


    //iterate through entire piece array for piece collision checking
    for (int i = 0; i < pieces.length; i++) {
      if (pieces[i].getX() == (this.getX() + checkX) && pieces[i].getY() == (this.getY() + checkY)) {
        collision = true;
        collisionIndex = i;
      }
    }

    //terrain collision checking
    //water is the only terrain feature that has collision,
    //but we also need to check if we're moving into a den
    for (int i = 0; i < terrain.length; i++) {
      if (terrain[i].getX() == (this.getX() + checkX) && terrain[i].getY() == (this.getY() + checkY)) {

        if (terrain[i].getType().matches("Water")) {
          //TODO: return na lang
          //if it walks into water it should be invalid anyway
          return false;
        }

        if (terrain[i].getType().matches("Den") && this.getOwner() != terrain[i].getOwner()) {
          terrain[i].setType("DenCaptured");
        }

        //TODO: same as above
        if (terrain[i].getType().matches("Den") && terrain[i].getOwner() == this.getOwner()) {
          return false;
        }

      }
    }

    //capture checking
    if (collision && capturePiece(pieces[collisionIndex])) {
      this.x += checkX;
      this.y += checkY;
      pieces[collisionIndex].getCaptured();
      System.out.println("Captured an enemy " + pieces[collisionIndex].getType());
      return true;
    }

    if (collision) {
      return false;
    }

   //check if movement is inbounds after water check
    if (this.getX() + checkX == 0 || this.getX() + checkX == 10 || this.getY() + checkY == 0 || this.getY() + checkY == 8) {
      return false;
    }

    //make the move if the desired space is clear of any pieces
    this.x += checkX;
    this.y += checkY;

    return true;
  }

  /**
  * Checks if this piece can capture the piece it is moving onto.
  * @param target the piece to compare ranks against 
  * @return true if capturing fails, false otherwise.
  */
  public boolean capturePiece(Piece target) {
    //TODO: traps 
    if (target.getOwner() == this.getOwner())
      return false;
    return this.rank >= target.rank;
  }

  /**
  * Captures the piece, placing it in -1, -1 and updating its captured status.
  */
  public void getCaptured() {
    //TODO: replace this with something saner
    x = -1;
    y = -1;
    isCaptured = true;
    return;
  }

  /**
  * Returns whether the piece has been captured or not.
  * @return true if piece has been captured, false otherwise
  */
  public boolean getCaptureStatus() {
    return isCaptured;
  }

  /**
  * Gets the tile that the piece is currently standing on.
  * @param tiles the tiles array
  * @return the tile the piece is standing on, null if the tile is blank.
  */
  public Tile getTileUnder() {
    Tile[] tiles = this.getBoard().getTerrain();
    for (int i=0;i < tiles.length;i++) {
      if (tiles[i].getX() == this.x && tiles[i].getY() == this.y) {
        return tiles[i];
      }
    }
    return null;
  }

  public String toString() {
	return this.getType() + " at " + this.getX() + ", " + this.getY();
  }

  private int rank;
  boolean isCaptured = false;
}
