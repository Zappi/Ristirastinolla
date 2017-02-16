package ristirastinolla.logic;

/**
 * This is the game's engine which takes care all of the important functions of
 * the game.
 */
public class Game {

    private boolean gameOver;
    private char player = 'X';
    private Board board;
    private int x;
    private int y;

    /**
     *
     * @param x size of the boards row
     * @param y size of the boards col
     * @param board game board
     */
    public Game(int x, int y, Board board) {
        this.x = x;
        this.y = y;
        this.board = board;
        board.setBoard();
        this.gameOver = false;
    }

    /**
     * This metods does the actual move for the player and also checks if either
     * one of the player has won or if the board is full
     *
     * @param player tell's which players turn,
     * @param x tell's the selected x-position
     * @param y tell's the selected y-position
     *
     */
    public void playerSelectMoves(char player, int x, int y) { //This method will check the final selection wheter the mark can be placed on the exact place.
        int row = x;
        int col = y;

        board.updateTable(player, row, col);

        if (hasWon(player)) {
            gameOver = true;
        }
    }

    /**
     *
     * @param row checks if the given row-value is correct on the gametable
     * @param col checks if the given co-value is correct on the gametable
     * @return true if selected positions are unvalid, false if selected
     * positions are valid
     */
    public boolean valid(int row, int col) {  //This method checks if the selected coordinates are appropriate and returns true if they are not. 
        if (row > x - 1 || row < 0) {
            return false;
        }
        if (col > y - 1 || col < 0) {
            return false;
        }
        if (board.checkIfSpotIsAlreadyTaken(row, col)) { //Checks if there is already either X or O on that place.
            return false;
        }

        return true;
    }

    /**
     * Checks if either one of the players has won
     *
     * @param player checks if either one of the players has won the game by
     * calling certain other methods
     * @return true if the given param player has won, in any other cases it
     * will return false
     */
    public boolean hasWon(char player) {
        return (rowHasWon() || colHasWon() || diagonalHasWon());
    }

    /**
     * This method checks if any row line has won
     *
     * @return true if game has won and false if not
     */
    public boolean rowHasWon() {
        if (board.checkIfRowWin()) {
            gameOver = true;
            return true;
        }

        return false;
    }

    /**
     * This method retruns if the game has been on or not
     *
     * @return true if either of player has won and false if not
     */
    public boolean getGameStatus() {
        return gameOver;
    }

    /**
     * This method checks if any col line has won
     *
     * @return true if game has won and false if not
     */
    public boolean colHasWon() {
        if (board.checkIfColWin()) {
            gameOver = true;
            return true;
        }
        return false;
    }

    /**
     * This method checks if any diagonal line has won
     *
     * @return true if game has won and false if not
     */
    public boolean diagonalHasWon() {
        if (board.checkIfDiagonalWin()) {
            gameOver = true;
            return true;
        }
        return false;
    }

    /**
     * This method only returns the player whose turn it is at the moment
     *
     * @return return either X or O
     */
    public char returnPlayer() {
        return player;
    }

    /**
     * This method will control turns during the game.
     */
    public void nextTurn() {
        if (player == 'X') {
            player = 'O';
        } else if (player == 'O') {
            player = 'X';
        }
    }

    /**
     * This method will clear the board for the next round.
     */
    public void makeBoardEmpty() {
        board.setBoard();
    }

    /**
     * This method does the check for the game if the whole board is full,
     * because we have to know it in the situation when the board is full and
     * it's draw.
     *
     * @return true if the board is full and false if there is still free spots.
     */
    public boolean boardIsFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!board.checkIfSpotIsAlreadyTaken(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * When one round is over and it is time to start a new round this method
     * will change the game playable again
     */
    public void changeGameOverFalse() {
        gameOver = false;
    }

}
