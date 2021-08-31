import java.util.Random;
import java.util.ArrayList;
import java.util.*;
/**
* This class represents a bag of pieces.
*/
public class Bag{

    private ArrayList<Piece> pieces;

    /** 
        This constructor initializes the pieces array list
    */
    public Bag()
    {
        pieces = new ArrayList<Piece>();

        pieces.add(new MousePiece(0, 0, 0, null));
        pieces.add(new Piece("Cat", 0, 0, 0, 2, null));
        pieces.add(new Piece("Wolf", 0, 0, 0, 3, null));
        pieces.add(new Piece("Dog", 0, 0, 0, 4, null));
        pieces.add(new Piece("Leopard", 0, 0, 0, 5, null));
        pieces.add(new LionTigerPiece("Tiger", 0, 0, 0, 6, null));
        pieces.add(new LionTigerPiece("Lion", 0, 0, 0, 7, null));
        pieces.add(new ElephantPiece(0, 0, 0, null));

    }

    /** 
        This method shuffles the pieces
    */
    private void shufflePieces()
    {
        Collections.shuffle(pieces);
    }

    /** This method randomly chooses a piece from the pieces array list and      returns it

        @return randomly chosen piece
    */
    public Piece getPiece()
    {
        Random rand = new Random();
        shufflePieces();
        int i = rand.nextInt(pieces.size());
        
        return pieces.get(i);
    }

    /** This method removes a piece from the pieces array list

        @param piece the piece to be removed
    */
    public void removePiece(Piece piece)
    {
        pieces.remove(piece);   
    }
}
