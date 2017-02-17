package ristirastinolla.logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ristirastinolla.logic.Game;

/**
 *
 * @author jtamland
 */
public class GameTest {

    Game game;
    Board board;
    boolean gameOver = false;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        board = new Board(3, 3);
        game = new Game(3, 3, board);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createdGameExist() {
        assertTrue(game != null);
    }

    @Test
    public void whenGivingUnvalidRowLessThanZeroReturnFalse() {
        assertEquals(false, game.valid(-2, 0));
    }
    
    @Test
    public void giveValidRowValue() {
        assertEquals(true, game.valid(2, 0));
    }

    @Test
    public void whenGivingUnvalidRowBiggerThanMaxRowReturnFalse() {
        assertEquals(false, game.valid(1010, 0));
    }

    @Test
    public void whenGivingUnvalidColLessThanZeroReturnFalse() {
        assertFalse(game.valid(2, -4));
    }
 
    @Test
    public void giveValidColValue() {
        assertEquals(true, game.valid(2, 2));
    }
    
    @Test
    public void colAddition() {
        assertEquals(false, game.valid(3, 1));
    }

    @Test
    public void whenGivingUnvalidColBiggerThanMAxRowReturnFalse() {
        assertFalse(game.valid(2, 6));
    }

    @Test
    public void whenGivingUnvalidColAndROwReturnFalse() {
        assertFalse(game.valid(12412, -222));
    }

    @Test
    public void whenGivingValidValuesColAndRowReturnTrue() {
        assertTrue(game.valid(2, 2));
    }

    @Test
    public void playerHasNotWonInTheFirstRound() {
        assertEquals(false, game.hasWon('X'));
    }

    @Test
    public void rowHasWon() {
        board.updateTable('O', 1, 0);
        board.updateTable('O', 1, 1);
        board.updateTable('O', 1, 2);
        assertEquals(true, game.rowHasWon());
    }

    @Test
    public void colHasWon() {
        board.updateTable('X', 0, 0);
        board.updateTable('X', 1, 0);
        board.updateTable('X', 2, 0);
        assertEquals(true, game.colHasWon());
    }

    @Test
    public void diagonalHasWon() {
        board.updateTable('X', 0, 2);
        board.updateTable('X', 1, 1);
        board.updateTable('X', 2, 0);
        assertEquals(true, board.checkIfDiagonalWin());
    }
    
    @Test
    public void rowHasntWon() {
        assertEquals(false, board.checkIfRowWin());
    }    
    
    @Test
    public void colHasntWon() {
        assertEquals(false, board.checkIfColWin());
    }
    
    public void diagonalHasntWon() {
        assertEquals(false, board.checkIfDiagonalWin());
    }
    
    
    @Test 
    public void gameHasBeenWon() {
        board.updateTable('X', 0, 2);
        board.updateTable('X', 1, 1);
        board.updateTable('X', 2, 0);
        assertEquals(true, game.hasWon('X'));
    }
    
    @Test
    public void rightPlayer() {
        assertEquals('X', game.returnPlayer());
    }

    
    @Test
    public void gameHasntWon() {
        game.colHasWon();       
        board.updateTable('X', 1, 1);
        assertEquals(false, game.hasWon('O'));
    }
    @Test
    public void selectedPlaceIsAlreadyTaken() {
        board.updateTable('X', 0, 0);
        board.updateTable('X', 1, 1);
        assertEquals(false, game.valid(1, 1));
    }
    
    @Test
    public void nextPlayerFirstX() {
        game.nextTurn();
        assertEquals(game.returnPlayer(), 'O');
        game.nextTurn();
        assertEquals(game.returnPlayer(), 'X');
    }
    @Test
    public void boardIsFull() {
        game.playerSelectMoves('X', 0, 0);
        game.playerSelectMoves('O', 2, 0);
        game.playerSelectMoves('X', 1, 0);
        game.playerSelectMoves('O', 0, 1);
        game.playerSelectMoves('X', 1, 1);
        game.playerSelectMoves('O', 2, 1);
        game.playerSelectMoves('X', 2, 2);
        game.playerSelectMoves('O', 1, 2);
        game.playerSelectMoves('X', 0, 2);
        
        assertTrue(game.boardIsFull());
    }
    
    @Test 
    public void boardIsNotFull() {
        game.playerSelectMoves('X', 0, 0);
        assertFalse(game.boardIsFull());
    }
    
    @Test
    public void checkIfClickIsValid() {
        assertTrue(game.valid(0, 0));
    }
    
    @Test
    public void checkIfClickXIsNotValid() {
        assertFalse(game.valid(51, 0));
    }
    
    @Test
    public void checkIfClickYIsNotValid() {
        assertFalse(game.valid(3,151251));
    }
    

}
