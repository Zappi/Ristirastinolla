/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristirastinolla.ui;

import java.util.Scanner;
import ristirastinolla.logic.Game;

public class UI {

    private Scanner reader;

    public UI() {

        this.reader = new Scanner(System.in);
    }

    public void startUI() {
        System.out.println("Welcome to play TicTacToe");
        System.out.println("");

    }

    public int selectRow(char player) {
        System.out.print("Player " + player + " select your row: ");
        int toReturn = Integer.parseInt(reader.nextLine());
        return toReturn;
    }

    public int selectCol(char player) {
        System.out.print("Player " + player + " select your column: ");
        int toReturn = Integer.parseInt(reader.nextLine());
        return toReturn;
    }

}
