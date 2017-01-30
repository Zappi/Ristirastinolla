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
        game = new Game(3, 3);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createdGameExist() {
        assertTrue(game != null);
    }
    
    @Test
    public void whenGivingUnvalidRowLessThanZeroReturnTrue() {
        assertTrue(game.valid(-1, 0));
    }
    
    @Test
    public void whenGivingUnvalidRowBiggerThanMaxRowReturnTrue() {
        assertTrue(game.valid(6, 0));
    }
    
    @Test
    public void whenGivingUnvalidColLessThanZeroReturnTrue() {
        assertTrue(game.valid(2, -4));
    }
    
    @Test
    public void whenGivingUnvalidColBiggerThanMAxRowReturnTrue() {
        assertTrue(game.valid(2, 6));
    }
    
    @Test
    public void whenGivingUnvalidColAndROwReturnTrue() {
        assertTrue(game.valid(12412, -222));
    }
    
    @Test
    public void whenGivingValidValuesColAndRowReturnFalse() {
        assertFalse(game.valid(2, 2));
    }
    

}
