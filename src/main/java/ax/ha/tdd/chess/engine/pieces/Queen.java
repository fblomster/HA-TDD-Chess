package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class Queen extends ChessPieceBase implements ChessPiece{

    public Queen(Color player, Square location) {
        super(PieceType.QUEEN, player, location);
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

        // Queen moves any number of squares vertically, horizontally or diagonally

        // Queen moves any number of squares forward along the Y-axis
        if (destX == currentX && destY != currentY) {
            int direction = Integer.compare(destY, currentY); // Calculate movement direction

            // Check if there are no pieces blocking the way
            for (int y = currentY + direction; y != destY; y += direction) {
                if (chessboard.getPieceAt(new Square(currentX, y)) != null) {
                    return false;
                }
            }
            return pieceAtDestination == null || pieceAtDestination.getColor() != getColor();
        } else if (destY == currentY && (destX != currentX)) { // Queen moves any number of squares forward along the X-axis
            int direction = Integer.compare(destX, currentX); // Calculate movement direction
            // Check if there are no pieces blocking the way
            for (int x = currentX + direction; x != destX; x += direction) {
                if (chessboard.getPieceAt(new Square(x, currentY)) != null) {
                    return false;
                }
            }
            return pieceAtDestination == null || pieceAtDestination.getColor() != getColor();
        } else if (deltaX == deltaY) { // Queen moves any number of squares diagonally
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
            // Queen can move to the destination if it's empty or contains an opponent's piece
            return pieceAtDestination == null || pieceAtDestination.getColor() != getColor();
        } else {
            // Queen cannot move to the destination square
            return false;
        }
    }
}
