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

        // Check if it's the pawn's first move
        boolean isFirstMove = (getColor() == Color.WHITE && currentY == 6) || (getColor() == Color.BLACK && currentY == 1);

        // Pawn moves one or two squares forward on its first move
        if (isFirstMove && destX == currentX && (destY == currentY + direction || destY == currentY + 2 * direction)) {
            // Check if there are no pieces blocking the way
            if (destY == currentY + 2 * direction && chessboard.getPieceAt(new Square(currentX, currentY + direction)) == null) {
                return pieceAtDestination == null;
            }
            return pieceAtDestination == null;
        }

        // Pawn moves one square forward
        if (destX == currentX && destY == currentY + direction && pieceAtDestination == null) {
            //System.out.println("Hej");
            return true;
        }

        if (Math.abs(destX - currentX) == 1 && destY == currentY + direction && pieceAtDestination != null) {
            return true;
        } else {
            return false;
        }
    }

}
