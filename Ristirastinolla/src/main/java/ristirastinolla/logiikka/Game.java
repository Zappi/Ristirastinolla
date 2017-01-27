package ristirastinolla.logiikka;

import java.util.Scanner;

/**
 *
 * @author jtamland
 */
public class Game {

    private boolean gameOver;
    private char player = 'X';
    private Scanner reader;
    private Board board;
    private int x;
    private int y;

    public Game(int x, int y) {
        this.x = x;
        this.y = y;
        this.board = new Board(x, y);
        this.reader = new Scanner(System.in);
        this.gameOver = false;

    }

    public void startGame() {
        board.setBoard();
        System.out.println("Welcome to play TicTacToe");
        System.out.println("");

        board.printBoard();
        while (!gameOver) {

            selectMove(player);
            player = 'O';
            selectMove(player);
            player = 'X';

            gameOver = true; //this is just for the pit test for now
        }

        System.out.println("Game over");
    }

    private void selectMove(char player) {
        System.out.print("Player " + player + " select your row: ");
        int row = Integer.parseInt(reader.nextLine());
        System.out.print("Player " + player + " select your column: ");
        int col = Integer.parseInt(reader.nextLine());

        while (valid(row, col)) {
            selectMove(player);
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
