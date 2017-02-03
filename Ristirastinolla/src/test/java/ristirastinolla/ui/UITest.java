/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristirastinolla.ui;

import ristirastinolla.ui.UI;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ristirastinolla.logic.Game;

/**
 *
 * @author jtamland
 */
public class UITest {

    private UI ui;

    public UITest() {
        
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.ui = new UI();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void givenPlayerIsCorrect(){
        ui.startUI();  
        
    }     

}
