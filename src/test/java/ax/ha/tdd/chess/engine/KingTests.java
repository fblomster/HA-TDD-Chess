package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.*;
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

    @Test
    public void testCanKingCatchOpponentOneSquareHorizontal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d1"));
        chessboard.addPiece(king);
        Bishop bishop = new Bishop(Color.BLACK, new Square("c1"));
        chessboard.addPiece(bishop);

        assertTrue(king.canMove(chessboard, new Square("c1")));
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingCatchOpponentTwoSquaresHorizontalShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d1"));
        chessboard.addPiece(king);
        Bishop bishop = new Bishop(Color.BLACK, new Square("b1"));
        chessboard.addPiece(bishop);

        assertFalse(king.canMove(chessboard, new Square("b1")));
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingCatchOpponentOneSquareVertical() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.BLACK, new Square("d8"));
        chessboard.addPiece(king);
        Bishop bishop = new Bishop(Color.WHITE, new Square("d7"));
        chessboard.addPiece(bishop);

        assertTrue(king.canMove(chessboard, new Square("d7")));
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingCatchOpponentTwoSquaresVerticalShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.BLACK, new Square("d8"));
        chessboard.addPiece(king);
        Bishop bishop = new Bishop(Color.WHITE, new Square("d6"));
        chessboard.addPiece(bishop);

        assertFalse(king.canMove(chessboard, new Square("d6")));
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingCatchOpponentOneSquareDiagonal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d1"));
        chessboard.addPiece(king);
        Bishop bishop = new Bishop(Color.BLACK, new Square("e2"));
        chessboard.addPiece(bishop);

        assertTrue(king.canMove(chessboard, new Square("e2")));
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKingMoveTwoSquaresDiagonalWithObstacleShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d1"));
        chessboard.addPiece(king);
        Bishop bishop = new Bishop(Color.WHITE, new Square("c2"));
        chessboard.addPiece(bishop);

        assertFalse(king.canMove(chessboard, new Square("c2")));
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testIsKingThreatenedByRookShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d1"));
        chessboard.addPiece(king);
        Rook rook = new Rook(Color.BLACK, new Square("e4"));
        chessboard.addPiece(rook);

        assertFalse(king.canMove(chessboard, new Square("e1")));
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testIsKingThreatenedByPawnShouldBeIllegal() {
        Chessboard chessboard = new ChessboardImpl();
        King king = new King(Color.WHITE, new Square("d1"));
        chessboard.addPiece(king);
        Pawn pawn = new Pawn(Color.BLACK, new Square("f2"));
        chessboard.addPiece(pawn);

        assertFalse(king.canMove(chessboard, new Square("e1")));
        System.out.println(new ChessboardWriter().print(chessboard));
    }
}
