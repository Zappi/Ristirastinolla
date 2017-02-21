package ristirastinolla;

import javax.swing.SwingUtilities;
import ristirastinolla.ui.GUI;

/**
 * This is the main class.
 * @author jtamland
 */
public class Main {

    /**
     * Main class.
     * @param args args
     */
    public static void main(String[] args) {

        //Game game = new Game(3, 3, new Board(3, 3)); //Put this into UI/GUI decide what to do!
        GUI gui = new GUI(9,9);
        SwingUtilities.invokeLater(gui);
    }
}
