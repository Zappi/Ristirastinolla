package ristirastinolla;

import javax.swing.SwingUtilities;
import ristirastinolla.ui.GUI;
import ristirastinolla.logic.Board;
import ristirastinolla.logic.Game;

public class Main {

    public static void main(String[] args) {

        //Game game = new Game(3, 3, new Board(3, 3)); //Put this into UI/GUI decide what to do!
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui);
    }
}
