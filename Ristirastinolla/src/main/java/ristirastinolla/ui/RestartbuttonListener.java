package ristirastinolla.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ristirastinolla.logic.Game;

/**
 * This is the ActionListener for the Restartbutton.
 * @author jtamland
 */
public class RestartbuttonListener implements ActionListener {

    private JButton restartButton;
    private Game game;
    private GUI gui;

    /**
     * Conctructor.
     * @param restartButton given JButton.
     * @param game game.
     * @param gui gui. 
     */
    public RestartbuttonListener(JButton restartButton, Game game, GUI gui) {

        this.restartButton = restartButton;
        this.game = game;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getGameStatus() || game.boardIsFull()) {

            if (e.getSource() == restartButton) {

                game.changeGameOverFalse();
                game.makeBoardEmpty();
                game.nextTurn();

                gui.repaint();
            }
        }
    }

}
