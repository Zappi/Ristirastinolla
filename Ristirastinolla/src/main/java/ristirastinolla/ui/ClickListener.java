/**
 *This class does the clicking functions for the game. When the board is clicked by mouse it does what it has to.
 */
package ristirastinolla.ui;

import ristirastinolla.graphics.DrawField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import ristirastinolla.logic.Board;
import ristirastinolla.logic.Game;

public class ClickListener implements MouseListener {

    private Game game;
    private GUI gui;
    private DrawField field;

    public ClickListener(Game game, DrawField field, GUI gui) {
        this.game = game;
        this.field = field;
        this.gui = gui;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int mouseX = mouseEvent.getX();
        int mouseY = mouseEvent.getY();

        int selectedCol = mouseX / 166;
        int selectedRow = mouseY / 166;

        if (!game.getGameStatus()) {
            if (selectedRow >= 0 && selectedRow < 3 && selectedCol >= 0 && selectedCol < 3) { // && game.valid(selectedRow, selectedCol) not working
                game.playerSelectMoves(game.returnPlayer(), selectedCol, selectedRow);
                game.nextTurn();
            }
        } else {
            System.out.println("TODo"); // this is just for the checkstyle
            System.out.println("Game over, player " + game.returnPlayer() + " has won");
            //Restart game, board is full or won
        }
        gui.repaint();
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
