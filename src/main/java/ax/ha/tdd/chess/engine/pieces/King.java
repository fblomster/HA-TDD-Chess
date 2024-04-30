package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class King extends ChessPieceBase implements ChessPiece {

    public King(Color player, Square location) {
        super(PieceType.KING, player, location);
    }

    @Override
    public boolean canMove(Chessboard chessboard, Square destination) {
        Square currentSquare = getLocation();
        int currentX = currentSquare.getX();
        int currentY = currentSquare.getY();
        int destX = destination.getX();
        int destY = destination.getY();

        // Check if the destination square is occupied by another piece
        ChessPiece pieceAtDestination = chessboard.getPieceAt(destination);

        // Check if there's a piece at the destination square and if it belongs to the same color
        if (pieceAtDestination != null && pieceAtDestination.getColor() == getColor()) {
            return false; // Cannot move to a square occupied by a piece of the same color
        }

        // King can move one square diagonally or one square forward
        if ((Math.abs(destX - currentX) == 1 || Math.abs(destY - currentY) == 1) && (pieceAtDestination == null || pieceAtDestination.getColor() != getColor())) {
            return true;
        } else if (destX == currentX && destY == currentY + 1 && pieceAtDestination == null) {
            return true;
        } else {
            return false;
        }
    }
}