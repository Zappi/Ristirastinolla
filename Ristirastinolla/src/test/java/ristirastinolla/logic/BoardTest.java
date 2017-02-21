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
import ristirastinolla.logic.Board;

/**
 *
 * @author jtamland
 */
public class BoardTest {

    Board board;

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        board = new Board(5, 5);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createdBoardExist() {
        assertTrue(board != null);
    }

    @Test
    public void boardRowSizeIsCorrect() {
        assertEquals(5, board.getRowSize());
    }

    @Test
    public void boardColSizeIsCorrect() {
        assertEquals(5, board.getColumnSize());
    }

    @Test
    public void updateTableMethodWorksWithPlayerX() {
        board.updateTable('X', 2, 1);
        assertTrue(board.returnPosition('X', 2, 1));
    }

    @Test
    public void updateTableMethodWorksWithPlayerY() {
        board.updateTable('Y', 0, 1);
        assertTrue(board.returnPosition('Y', 0, 1));
    }

    @Test
    public void setBoardIsOkay() {
        board.setBoard();
    }

    @Test
    public void spotIsAlreadyTaken() {
        board.updateTable('X', 0, 2);
        assertEquals(true, board.checkIfSpotIsAlreadyTaken(0, 2));
    }

    @Test
    public void spotHasntbeenAlreadyTaken() {
        board.updateTable('X', 0, 2);
        assertEquals(false, board.checkIfSpotIsAlreadyTaken(0, 1));
    }
    
    @Test
    public void falsePositionReturning() {
        assertEquals(false, board.returnPosition('X', 2, 2));
    }
}
