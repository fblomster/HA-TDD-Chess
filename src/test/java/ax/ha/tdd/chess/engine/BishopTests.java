package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.Bishop;
import ax.ha.tdd.chess.engine.pieces.Knight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BishopTests {

    @Test
    public void testCanBishopMoveDiagonally() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.BLACK, new Square("c8"));
        chessboard.addPiece(bishop);

        assertTrue(bishop.canMove(chessboard, new Square("h3")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanBishopMoveVerticallyShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.BLACK, new Square("c8"));
        chessboard.addPiece(bishop);

        assertFalse(bishop.canMove(chessboard, new Square("c3")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanBishopCatchOpponent() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("f1"));
        chessboard.addPiece(bishop);
        Knight knight = new Knight(Color.BLACK, new Square("c4"));
        chessboard.addPiece(knight);

        assertTrue(bishop.canMove(chessboard, new Square("c4")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanBishopCatchOpponentVerticallyShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("c5"));
        chessboard.addPiece(bishop);
        Knight knight = new Knight(Color.BLACK, new Square("c4"));
        chessboard.addPiece(knight);

        assertFalse(bishop.canMove(chessboard, new Square("c4")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanBishopJumpObstacleShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        Bishop bishop = new Bishop(Color.WHITE, new Square("f1"));
        chessboard.addPiece(bishop);
        Knight knight = new Knight(Color.WHITE, new Square("c4"));
        chessboard.addPiece(knight);

        assertFalse(bishop.canMove(chessboard, new Square("b5")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }
}
