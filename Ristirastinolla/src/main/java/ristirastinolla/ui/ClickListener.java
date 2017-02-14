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
        System.out.println(game.getGameStatus());
        System.out.println(game.boardIsFull());

        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();

        int selectedRow = mouseX / 166;
        int selectedCol = mouseY / 166;

        if (!game.getGameStatus() && !game.boardIsFull()) {
            if (validClick(selectedRow, selectedCol)) {
                game.playerSelectMoves(game.returnPlayer(), selectedRow, selectedCol);
                game.nextTurn();
                gameBar.setText(game.returnPlayer() + "'s turn");
            } else {
                gameBar.setText("Unvalid slot");
                return;
            }

        }
        if(game.boardIsFull() ||game.hasWon('X') ||game.hasWon('O')) {
            if (game.boardIsFull() &&!game.hasWon('X') ||!game.hasWon('O')) {
                gameBar.setText("Game over, Draw!");
                boardIsFull = false;
            } else {
                game.nextTurn();
                gameBar.setText("Game over, player " + game.returnPlayer() + " has won");
            } //if(restartButton.getModel().isSelected()) {

            game.changeGameOverFalse();
            game.makeBoardEmpty();
            game.nextTurn();
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
