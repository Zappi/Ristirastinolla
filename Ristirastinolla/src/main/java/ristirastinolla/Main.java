package ristirastinolla;

import javax.swing.SwingUtilities;
import ristirastinolla.UI.GUI;
import ristirastinolla.logic.Board;
import ristirastinolla.logic.Game;

public class Main {

    public static void main(String[] args) {
        
        Game game = new Game(3, 3);
        game.startGame();
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui);
        gui.run();
    }
}
