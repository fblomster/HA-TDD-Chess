package ax.ha.tdd.chess.engine;

import ax.ha.tdd.chess.console.ChessboardWriter;
import ax.ha.tdd.chess.engine.pieces.ChessPiece;
import ax.ha.tdd.chess.engine.pieces.Pawn;
import ax.ha.tdd.chess.engine.pieces.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PawnTests {

    @Test
    public void testMovePawnBackwardsShouldBeIllegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        //Assert
        assertFalse(pawn.canMove(chessboard, new Square("e1")));

        //For debugging, you can print the board to console, or if you want
        //to implement a command line interface for the game
        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMovePawnForwardOneSquare() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        //Assert
        assertTrue(pawn.canMove(chessboard, new Square("e3")));
        chessboard.removePieceAt(new Square("e2"));
        pawn = new Pawn(Color.WHITE, new Square("e3"));
        chessboard.addPiece(pawn);

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testMovePawnForwardTwoSquares() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn pawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(pawn);

        //Assert
        assertTrue(pawn.canMove(chessboard, new Square("e4")));
        chessboard.removePieceAt(new Square("e2"));
        pawn = new Pawn(Color.WHITE, new Square("e4"));
        chessboard.addPiece(pawn);

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testPawnCatchOpponentDiagonally() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn whitePawn = new Pawn(Color.WHITE, new Square("e2"));
        chessboard.addPiece(whitePawn);
        Pawn blackPawn = new Pawn(Color.BLACK, new Square("d3"));
        chessboard.addPiece(blackPawn);

        //Assert
        assertTrue(whitePawn.canMove(chessboard, new Square("d3")));

        //chessboard.removePieceAt(new Square("e2"));
        //chessboard.removePieceAt(new Square("d3"));
        //whitePawn = new Pawn(Color.WHITE, new Square("d3"));
        //chessboard.addPiece(whitePawn);

        System.out.println(new ChessboardWriter().print(chessboard));
    }

    @Test
    public void testPawnCatchOpponentDiagonallyBackwardsShouldBeIllegal() {
        //Arrange
        Chessboard chessboard = new ChessboardImpl();
        Pawn whitePawn = new Pawn(Color.WHITE, new Square("e5"));
        chessboard.addPiece(whitePawn);
        Pawn blackPawn = new Pawn(Color.BLACK, new Square("f4"));
        chessboard.addPiece(blackPawn);

        //Assert
        assertFalse(blackPawn.canMove(chessboard, new Square("e5")));

        System.out.println(new ChessboardWriter().print(chessboard));
    }
}
