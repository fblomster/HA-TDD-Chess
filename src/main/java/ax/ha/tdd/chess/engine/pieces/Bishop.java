package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class Bishop extends ChessPieceBase implements ChessPiece {

    public Bishop(Color player, Square location) {
        super(PieceType.BISHOP, player, location);
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

        int deltaX = Math.abs(destX - currentX);
        int deltaY = Math.abs(destY - currentY);

        // Bishop moves diagonally
        if (deltaX == deltaY) {
            // Check if there are no pieces blocking the way
            int xDirection = Integer.compare(destX, currentX);
            int yDirection = Integer.compare(destY, currentY);
            for (int i = 1; i < deltaX; i++) {
                int nextX = currentX + i * xDirection;
                int nextY = currentY + i * yDirection;
                if (chessboard.getPieceAt(new Square(nextX, nextY)) != null) {
                    return false; // There's a piece blocking the way
                }
            }
            // Bishop can move to the destination if it's empty or contains an opponent's piece
            return pieceAtDestination == null || pieceAtDestination.getColor() != getColor();
        } else {
            // Bishop cannot move to the destination square
            return false;
        }
    }
}
