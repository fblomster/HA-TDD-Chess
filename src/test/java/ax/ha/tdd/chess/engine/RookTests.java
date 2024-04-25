package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTests {

    @Test
    public void testMoveRookStraightForwardYAxis() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("h1"));
        chessboard.addPiece(rook);

        //Assert
        assertTrue(rook.canMove(chessboard, new Square("h5")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMoveRookStraightBackwardsYAxisWithObstacleShouldBeIllegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("h5"));
        chessboard.addPiece(rook);
        Pawn pawn = new Pawn(Color.WHITE, new Square("h3"));
        chessboard.addPiece(pawn);

        //Assert
        assertFalse(rook.canMove(chessboard, new Square("h3")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMoveRookRightXAxis() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.BLACK, new Square("a5"));
        chessboard.addPiece(rook);

        //Assert
        assertTrue(rook.canMove(chessboard, new Square("f5")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMoveRookLeftXAxis() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("f5"));
        chessboard.addPiece(rook);

        //Assert
        assertTrue(rook.canMove(chessboard, new Square("a5")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testRookCannotMoveDiagonallyShouldBeIllegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("f5"));
        chessboard.addPiece(rook);

        //Assert
        assertFalse(rook.canMove(chessboard, new Square("e6")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testRookCannotJumpObstacleShouldBeIllegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("f5"));
        chessboard.addPiece(rook);
        Pawn pawn = new Pawn(Color.WHITE, new Square("d5"));
        chessboard.addPiece(pawn);

        //Assert
        assertFalse(rook.canMove(chessboard, new Square("d5")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testRookCatchOpponent() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Rook rook = new Rook(Color.WHITE, new Square("f5"));
        chessboard.addPiece(rook);
        Pawn pawn = new Pawn(Color.BLACK, new Square("d5"));
        chessboard.addPiece(pawn);

        //Assert
        assertTrue(rook.canMove(chessboard, new Square("d5")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }
}
