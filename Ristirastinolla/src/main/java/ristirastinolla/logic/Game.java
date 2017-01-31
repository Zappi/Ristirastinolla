package ristirastinolla.logic;

import ristirastinolla.UI.UI;

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
        ui.startUI();

    }

    public void startGame() {
        board.setBoard();
        

        board.printBoard();
        while (!gameOver) {
            
            player = 'X';
            playerSelectMoves(player); //These two method calls asks from UI where the player wants to put his mark. 
            
            if(gameOver == true) {
                break;
            }
            
            player = 'O';
            playerSelectMoves(player);
        }
        
        System.out.println("");
        System.out.println("Player " + player + " wins!");
        
        System.out.println("");
        System.out.println("Game over");
    }

    private void playerSelectMoves(char player) { //This method will check the final selection wheter the mark can be placed on the exact place.
        int row = ui.selectRow(player);
        int col = ui.selectCol(player);
        while (valid(row, col)) {
            //playerSelectMoves(player);
            row = ui.selectRow(player);
            col = ui.selectCol(player);
        }
        board.updateTable(player, row, col);
         if(hasWon(player)) {
                gameOver = true;
                return;
            }
        board.printBoard();
    }

    public boolean valid(int row, int col) {  //This method checks if the selected coordinates are appropriate and returns true if they are not. 
        if (row > x - 1 || row < 0) {
            System.out.println("Unvalid row");
            return true;
        }
        if (col > y - 1 || col < 0) {
            System.out.println("Unvalid column");
            return true;
        }
        if(board.checkIfSpotIsAlreadyTaken(row, col)) { //Checks if there is already either X or O on that place.
            System.out.println("This place has already been taken.");
            return true;
        }
        
        return false;
    }
    
    public boolean hasWon(char player) {
        return (rowHasWon() ||colHasWon() ||diagonalHasWon());
    }
    
    public boolean rowHasWon() {
        if (board.checkIfRowWin()) {
            gameOver = true;
            return true;
        }
        return false;
    }
    
    public boolean colHasWon() {
       if (board.checkIfColWin()) {
            gameOver = true;
            return true;
        }
        return false;
    }
    
    public boolean diagonalHasWon() {
         if (board.checkIfDiagonalWin()) {
            gameOver = true;
            return true;
        }
        return false;
    }
}

