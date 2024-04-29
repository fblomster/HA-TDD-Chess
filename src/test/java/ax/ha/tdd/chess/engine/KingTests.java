package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.King;
import ax.ha.tdd.chess.engine.pieces.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KingTests {

    @Test
    public void testCanKingMoveOneSquareDiagonally() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.BLACK, new Square("d8"));
        chessboard.addPiece(king);

        assertTrue(king.canMove(chessboard, new Square("c7")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingMoveMultipleSquaresDiagonallyShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.BLACK, new Square("d8"));
        chessboard.addPiece(king);

        assertFalse(king.canMove(chessboard, new Square("g5")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingMoveOneSquareHorizontally() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d1"));
        chessboard.addPiece(king);

        assertTrue(king.canMove(chessboard, new Square("c1")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingMoveMultipleSquaresHorizontallyShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d1"));
        chessboard.addPiece(king);

        assertFalse(king.canMove(chessboard, new Square("g1")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingMoveOneSquareVertically() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.BLACK, new Square("d8"));
        chessboard.addPiece(king);

        assertTrue(king.canMove(chessboard, new Square("d7")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingMoveMultipleSquaresVerticallyShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.BLACK, new Square("d8"));
        chessboard.addPiece(king);

        assertFalse(king.canMove(chessboard, new Square("d4")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }
}
