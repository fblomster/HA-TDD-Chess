package ax.ha.tdd.chess.engine.pieces;

import ax.ha.tdd.chess.engine.Chessboard;
import ax.ha.tdd.chess.engine.Color;
import ax.ha.tdd.chess.engine.Square;

public class Rook extends ChessPieceBase implements ChessPiece{

    public Rook(Color player, Square location) {
        super(PieceType.ROOK, player, location);
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

        // Rook moves one or multiple squares forward or backward along the y-axis
        if (destX == currentX && destY != currentY) {
            int direction = Integer.compare(destY, currentY); // Calculate movement direction

            // Check if there are no pieces blocking the way
            for (int y = currentY + direction; y != destY; y += direction) {
                if (chessboard.getPieceAt(new Square(currentX, y)) != null) {
                    return false;
                }
            }
            return pieceAtDestination == null || pieceAtDestination.getColor() != getColor();
        }
        // Rook moves one or multiple squares forward along the X-axis
        else if (destY == currentY && (destX != currentX)) {
            int direction = Integer.compare(destX, currentX); // Calculate movement direction
            // Check if there are no pieces blocking the way
            for (int x = currentX + direction; x != destX; x += direction) {
                if (chessboard.getPieceAt(new Square(x, currentY)) != null) {
                    return false;
                }
            }
            return pieceAtDestination == null || pieceAtDestination.getColor() != getColor();
        } else {
            return false;
        }
    }
}
