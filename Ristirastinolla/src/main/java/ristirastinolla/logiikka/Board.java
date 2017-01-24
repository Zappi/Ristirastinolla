package ristirastinolla.logiikka;

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

    public void updateTable(char player, int row, int col) {

        board[row][col] = player;
    }

    public int getRowSize() {
        return board.length;
    }

    public int getColumnSize() {
        return board[0].length;
    }

    public boolean returnPosition(char a, int x, int y) {
        for (int row = 0; row < this.board.length; row++) {
            for (int col = 0; col < this.board[row].length; col++) {
                if(row == x && col == y && board[row][col] == a) {
                    return true;
                }
            }
        }
        return false;
    }
}
