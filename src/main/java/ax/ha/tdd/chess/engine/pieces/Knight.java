package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class Knight extends ChessPieceBase implements ChessPiece{

    public Knight(Color player, Square location) {
        super(PieceType.KNIGHT, player, location);
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

        // Calculate the absolute difference in x and y coordinates
        int deltaX = Math.abs(destX - currentX);
        int deltaY = Math.abs(destY - currentY);

        // Knights move in an L-shape: 2 squares in one direction and 1 square in another
        if ((deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1)) {
            // Knight can move to the destination if it's empty or contains an opponent's piece
            return pieceAtDestination == null || pieceAtDestination.getColor() != getColor();
        } else {
            // Knight cannot move to the destination square
            return false;
        }
    }
}
