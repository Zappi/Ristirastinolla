package ristirastinolla.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import ristirastinolla.logic.Game;

public class RestartbuttonListener implements ActionListener {

    private JButton restartButton;
    private Game game;
    private GUI gui;

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
