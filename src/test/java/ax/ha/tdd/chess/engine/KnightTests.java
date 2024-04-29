package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.Knight;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTests {

    @Test
    public void testMoveKnightTwoVerticalOneHorizontal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("g1"));
        chessboard.addPiece(knight);

        //Assert
        assertTrue(knight.canMove(chessboard, new Square("f3")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMoveKnightOneVerticalTwoHorizontal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("f3"));
        chessboard.addPiece(knight);

        //Assert
        assertTrue(knight.canMove(chessboard, new Square("d4")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKnightCatchOpponent() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("g1"));
        chessboard.addPiece(knight);
        Rook rook = new Rook(Color.BLACK, new Square("f3"));
        chessboard.addPiece(rook);

        //Assert
        assertTrue(knight.canMove(chessboard, new Square("f3")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testCanKnightJumpObstacleShouldBeLegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Knight knight = new Knight(Color.WHITE, new Square("g1"));
        chessboard.addPiece(knight);
        Rook rook = new Rook(Color.BLACK, new Square("f3"));
        chessboard.addPiece(rook);
        Pawn pawn = new Pawn(Color.WHITE, new Square("g2"));
        chessboard.addPiece(pawn);

        //Assert
        assertTrue(knight.canMove(chessboard, new Square("f3")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }
}
