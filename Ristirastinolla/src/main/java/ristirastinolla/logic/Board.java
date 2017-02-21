package ristirastinolla.logic;

/**
 * This class takes care of the basic logic of the game.
 */
public class Board {

    private char[][] board;
    private int row;
    private int col;

    /**
     * Constructor.
     *
     * @param row row size of the board
     * @param col col size of the board.
     */
    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        this.board = new char[row][col];

    }

    /**
     * This method creates a new blank board.
     */
    public void setBoard() {
        for (int x = 0; x < this.board.length; x++) {
            for (int y = 0; y < this.board[x].length; y++) {
                board[x][y] = '_';
            }
        }
    }

    /**
     * This method updates the game table and adds players chosen position on
     * the table.
     *
     * @param player the player whose turn it is
     * @param x given x-position
     * @param y given y-position
     */
    public void updateTable(char player, int x, int y) {
        board[x][y] = player;
    }

    /**
     * Gives the size of the row.
     *
     * @return size of the boards length
     */
    public int getRowSize() {
        return board.length;
    }

    /**
     * Gives the size of the column.
     *
     * @return size of the boards column
     */
    public int getColumnSize() {
        return board[0].length;
    }
    
    /**
     * This method checks if the player has actually won. 
     * @param player who's currently playing.
     * @return true if the current player has won with his/her move.
     */
    
    public boolean checkIfWon(char player) {
        for (int x = 0; x < this.board.length; x++) {
            for (int y = 0; y < this.board[x].length; y++) {
                
                if(checkRow(x, y, 0, 1, 5, player)) {
                    return true;
                }
                if(checkRow(x, y, 1, 0, 5, player)) {
                    return true;
                }
                if(checkRow(x, y, 1, 1, 5, player)) {
                    return true;
                }
                if(checkRow(x, y, 1, -1, 5, player)) {
                    return true;
                }
                
            }
        }

        return false;
    }
    

    private boolean checkRow(int r0, int c0, int dr, int dc, int len, char player) {
        for (int i = 0; i != len; i++) {
            int r = r0 + i*dr;
            int c = c0 + i*dc;
            
            if( r < 0 ||c < 0 ||r >= board.length || c >= board[r].length || board[r][c] != player) {
                return false;
            }
        }
            
        return true;
    }

    /**
     * This method confirms that if we have found a possible winner we check
     * that subsequents are the same.
     *
     * @param a certain mark on the first location
     * @param b certain mark on the second location
     * @param c certain mark on the third location
     * @param d certain mark on the fourth
     * @return true if all three subsequents are the same
     */
    public boolean finalCheck(char a, char b, char c, char d) { //Does the final check wheter the whole line has same values and the other player wins!
        return ((a != '_') && (a == b) && (b == c) && (c == d));
    }

    /**
     * Checks if the the given spot is already taken.
     *
     * @param x location on x-axis
     * @param y location on y-axis
     * @return returns true if the given spot is already taken
     */
    public boolean checkIfSpotIsAlreadyTaken(int x, int y) {
        for (int rowSize = 0; rowSize < this.board.length; rowSize++) {
            for (int colSize = 0; colSize < this.board[rowSize].length; colSize++) {
                if (rowSize == x && colSize == y && (board[rowSize][colSize] == 'X' || board[rowSize][colSize] == 'O')) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if the spot is taken for either one of the players.
     *
     * @param a tells which players turn it is
     * @param x location on x-axis
     * @param y location on y-axis
     * @return true if asked location is selected for the player
     */
    public boolean returnPosition(char a, int x, int y) {
        for (int rowSize = 0; rowSize < this.board.length; rowSize++) {
            for (int colSize = 0; colSize < this.board[rowSize].length; colSize++) {
                if (rowSize == x && colSize == y && board[rowSize][colSize] == a) {
                    return true;
                }
            }
        }
        return false;
    }

}
