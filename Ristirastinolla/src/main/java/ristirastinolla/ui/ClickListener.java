/**
 *This class does the clicking functions for the game. When the board is clicked by mouse it does what it has to.
 */
package ristirastinolla.ui;

import ristirastinolla.graphics.DrawField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import ristirastinolla.logic.Board;
import ristirastinolla.logic.Game;

public class ClickListener implements MouseListener {

    private Game game;
    private GUI gui;
    private DrawField field;
    private JButton restartButton;
    private JLabel gameBar;
    private boolean boardIsFull;

    public ClickListener(Game game, DrawField field, GUI gui, JButton restartButton, JLabel gameBar) {
        this.game = game;
        this.field = field;
        this.gui = gui;
        this.restartButton = restartButton;
        this.gameBar = gameBar;
        this.boardIsFull = false;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if(game.boardIsFull()) {
            boardIsFull = true;
        }
        
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();

        int selectedRow = mouseX / 166;
        int selectedCol = mouseY / 166;

        if (!game.getGameStatus()) {
            if (validClick(selectedRow, selectedCol)) { // && game.valid(selectedRow, selectedCol) not working
                game.playerSelectMoves(game.returnPlayer(), selectedRow, selectedCol);
                game.nextTurn();
                gameBar.setText(game.returnPlayer() + "'s turn");
            } else {
                gameBar.setText("Unvalid slot");
                return;
            }
        } else {
            System.out.println("TODo"); // this is just for the checkstyle
            System.out.println("Game over, player " + game.returnPlayer() + " has won");
            //if(restartButton.getModel().isSelected()) {
            game.makeBoardEmpty();
            boardIsFull = false;
            //}
            game.changeGameOverFalse();
        }
        gui.repaint();
    }

    private boolean validClick(int row, int col) {
        if (game.valid(row, col)) {
            return false;
        }
        return true;
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
