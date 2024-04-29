package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class King extends ChessPieceBase implements ChessPiece{

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

        // King can move one square diagonally
        if (Math.abs(destX - currentX) == 1 || Math.abs(destY - currentY) == 1 && pieceAtDestination != null) {
            return true;
            // King moves one square forward
        } else if (destX == currentX && destY == currentY + 1 && pieceAtDestination == null) {
                return true;
        } else {
            return false;
        }
    }
}
