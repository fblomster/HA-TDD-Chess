package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Game;
import ax.ha.tdd.chess.engine.Square;
import ax.ha.tdd.chess.engine.Color;

public class Pawn extends ChessPieceBase implements ChessPiece{

    public Pawn(Color player, Square location) {
        super(PieceType.PAWN, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        Square currentSquare = getLocation();
        int currentX = currentSquare.getX();
        int currentY = currentSquare.getY();
        int destX = destination.getX();
        int destY = destination.getY();

        // Determine the direction in which the pawn should move based on its color
        int direction = (getColor() == Color.BLACK) ? 1 : -1;

        // Check if the destination square is occupied by another piece
        ChessPiece pieceAtDestination = chessboard.getPieceAt(destination);

        // Pawn moves one square forward
        if (destX == currentX && destY == currentY + direction && pieceAtDestination == null) {
            System.out.println("Hej");
            return true;
        } else {
            return false;
        }
    }

}
