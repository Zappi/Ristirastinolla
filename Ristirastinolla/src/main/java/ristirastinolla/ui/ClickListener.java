/**
 *This class does the clicking functions for the game. When the board is clicked by mouse it does what it has to.
 */
package ristirastinolla.ui;

import ristirastinolla.graphics.DrawBoard;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import ristirastinolla.logic.Game;

/**
 * This class handles the clicks on the board.
 *
 * @author jtamland
 */
public class ClickListener implements MouseListener {

    private Game game;
    private GUI gui;
    private DrawBoard field;
    private JLabel gameBar;
    private Sound sound;

    /**
     * Constructor.
     *
     * @param game given game logic.
     * @param field given field.
     * @param gui given gui.
     * @param gameBar given textbar.
     * @param sound given sound object
     */
    public ClickListener(Game game, DrawBoard field, GUI gui, JLabel gameBar, Sound sound) {
        this.game = game;
        this.field = field;
        this.gui = gui;
        this.gameBar = gameBar;
        this.sound = sound;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();

        int selectedRow = mouseX / 65;
        int selectedCol = mouseY / 65;

        if (!game.getGameStatus()) {

            if (!game.boardIsFull()) {
                if (game.valid(selectedRow, selectedCol)) {
                    game.playerSelectMoves(game.returnPlayer(), selectedRow, selectedCol);
                    playSound(game.returnPlayer());
                    game.nextTurn();
                    gameBar.setText(game.returnPlayer() + "'s turn");
                } else {
                    gameBar.setText("Unvalid slot");
                    return;
                }

            }
            if (game.boardIsFull() || game.hasWon('X') || game.hasWon('O')) {
                if (game.boardIsFull() && !game.hasWon('X') && !game.hasWon('O')) {
                    gameBar.setText("Game over, Draw! Press restart to play again.");
                } else {
                    sound.playWinnerSound();
                    game.nextTurn();
                    gameBar.setText("Game over, player " + game.returnPlayer() + " has won. Press restart to play again.");
                }
            }
        }

        gui.repaint();
    }

    private void playSound(char player) {
        if (player == 'X') {
            sound.playSoundX();
        } else {
            sound.playSoundO();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
