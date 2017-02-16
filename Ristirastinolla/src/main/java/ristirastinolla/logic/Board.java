package ristirastinolla.logic;

/**
 * This class takes care of the basic logic of the game.
 */
public class Board {

    private char[][] board;

    /**
     *
     * @param row row size of the board
     * @param col col size of the board.
     */
    public Board(int row, int col) {

        this.board = new char[row][col];

    }

    /**
     * This method creates a new blank board
     */
    public void setBoard() {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                board[row][col] = '_';
            }
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

    /**
     *
     * @return size of the boards length
     */
    public int getRowSize() {
        return board.length;
    }

    /**
     *
     * @return size of the boards column
     */
    public int getColumnSize() {
        return board[0].length;
    }

    /**
     * This method checks if there is a winning line on any row line
     *
     * @return true if we have found the winner
     */
    public boolean checkIfRowWin() {
        for (int i = 0; i < 3; i++) {
            if ((finalCheck(board[i][0], board[i][1], board[i][2]) == true)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if there is a winning line on any col line
     *
     * @return true if we have found the winner
     */
    public boolean checkIfColWin() {
        for (int i = 0; i < 3; i++) {
            if (finalCheck(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method checks if there is a winning line on any diagonal line
     *
     * @return true if we have found the winner
     */
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

    /**
     * This method confirms that if we have found a possible winner we check
     * that subsequents are the same
     *
     * @param a certain mark on the first location
     * @param b certain mark on the second location
     * @param c certain mark on the third location
     * @return true if all three subsequents are the same
     */
    public boolean finalCheck(char a, char b, char c) { //Does the final check wheter the whole line has same values and the other player wins!
        return ((a != '_') && (a == b) && (b == c));
    }

    /**
     *
     * @param x location on x-axis
     * @param y location on y-axis
     * @return returns true if the given spot is already taken
     */
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

    /**
     *
     * @param a tells which players turn it is
     * @param x location on x-axis
     * @param y location on y-axis
     * @return true if asked location is selected for the player
     */
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
