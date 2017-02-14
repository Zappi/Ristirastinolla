/**
 *This class takes care of the basic logic of the game.
 */
package ristirastinolla.logic;

public class Board {

    private char[][] board;

    public Board(int row, int col) {

        this.board = new char[row][col];

    }

    public void setBoard() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                board[row][col] = '_';
            }
        }
    }

    //This metod will be deleted
    public void printBoard() {
        for (int row = 0; row < this.board.length; row++) {
            System.out.println("");
            for (int col = 0; col < this.board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col < this.board[row].length - 1) {
                    System.out.print("|");
                } else {
                    System.out.print("");
                }
            }
            System.out.println("");

        }
    }

    /**
     * This method updates the game table and adds players chosen position on
     * the table.
     *
     * @param player the player whose turn it is
     * @param row given x-position
     * @param col given y-position
     */
    public void updateTable(char player, int row, int col) {
        board[row][col] = player;
    }

    public int getRowSize() {
        return board.length;
    }

    public int getColumnSize() {
        return board[0].length;
    }

    public boolean checkIfRowWin() {
        for (int i = 0; i < 3; i++) {
            if ((finalCheck(board[i][0], board[i][1], board[i][2]) == true)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfColWin() {
        for (int i = 0; i < 3; i++) {
            if (finalCheck(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfDiagonalWin() {
        for (int i = 0; i < 3; i++) {
            if (finalCheck(board[0][0], board[1][1], board[2][2]) == true) {
                return true;
            }
            if (finalCheck(board[0][2], board[1][1], board[2][0]) == true) {
                return true;
            }
        }
        return false;
    }

    public boolean finalCheck(char a, char b, char c) { //Does the final check wheter the whole line has same values and the other player wins!
        return ((a != '_') && (a == b) && (b == c));
    }

    public boolean checkIfSpotIsAlreadyTaken(int x, int y) {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                if (row == x && col == y && (board[row][col] == 'X' || board[row][col] == 'O')) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean returnPosition(char a, int x, int y) {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                if (row == x && col == y && board[row][col] == a) {
                    return true;
                }
            }
        }
        return false;
    }
   
}
