package ristirastinolla.logic;

import java.util.Scanner;
import ristirastinolla.UI.UI;

/**
 *
 * @author jtamland
 */
public class Game {

    private boolean gameOver;
    private char player = 'X';
    private Board board;
    private UI ui;
    private int x;
    private int y;

    public Game(int x, int y) {
        this.x = x;
        this.y = y;
        this.board = new Board(x, y);
        this.gameOver = false;
        this.ui = new UI();

    }

    public void startGame() {
        board.setBoard();
        

        board.printBoard();
        while (!gameOver) {

            checkSelectedMove(player);
            player = 'O';
            checkSelectedMove(player);
            player = 'X';

            gameOver = true; //this is just for the pit test for now
        }

        System.out.println("Game over");
    }

    private void checkSelectedMove(char player) {
        int row = ui.selectRow(player);
        int col = ui.selectCol(player);

        while (valid(row, col)) {
            checkSelectedMove(player);
        }
        board.updateTable(player, row, col);
        board.printBoard();
    }

    public boolean valid(int row, int col) {
        if (row > x - 1 || row < 0) {
            System.out.println("Unvalid row");
            return true;
        }
        if (col > y - 1 || col < 0) {
            System.out.println("Unvalid column");
            return true;
        }
        return false;
    }
}
