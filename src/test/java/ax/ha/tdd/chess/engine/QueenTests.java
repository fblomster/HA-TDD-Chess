package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.Bishop;
import ax.ha.tdd.chess.engine.pieces.Queen;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTests {

    @Test
    public void testCanQueenMoveDiagonally() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.BLACK, new Square("e8"));
        chessboard.addPiece(queen);

        assertTrue(queen.canMove(chessboard, new Square("g6")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanQueenMoveVertically() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.BLACK, new Square("e8"));
        chessboard.addPiece(queen);

        assertTrue(queen.canMove(chessboard, new Square("e4")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanQueenMoveHorizontally() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("e1"));
        chessboard.addPiece(queen);

        assertTrue(queen.canMove(chessboard, new Square("h1")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanQueenCatchOpponent() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("e1"));
        chessboard.addPiece(queen);
        Rook rook = new Rook(Color.BLACK, new Square("h4"));
        chessboard.addPiece(rook);

        assertTrue(queen.canMove(chessboard, new Square("h4")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanQueenJumpObstacleShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        Queen queen = new Queen(Color.WHITE, new Square("e1"));
        chessboard.addPiece(queen);
        Bishop bishop = new Bishop(Color.WHITE, new Square("f1"));
        chessboard.addPiece(bishop);

        assertFalse(queen.canMove(chessboard, new Square("f1")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }
}
