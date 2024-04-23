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
        //TODO here goes move logic for rooks
        return false;
    }
}
