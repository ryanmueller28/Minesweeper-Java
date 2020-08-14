package com.company;

import java.util.Scanner;

import static com.company.Printable.print;

public class Game implements Printable {

    Grid GameGrid;

    /**
     * The starting point of the game
     * Ask user for height and width of game
     * And initialize that size then call
     * GameLoop() method
     */
    public void Start() {
        Scanner sc = new Scanner(System.in);
        print("Enter the Height of the com.company.Grid: ");
        int h = sc.nextInt();
        print("Enter the Width of the com.company.Grid: ");
        int w = sc.nextInt();

        GameGrid = new Grid(h, w);
    }

    /**
     * Main loop of the game
     * Ask user input for what cell (row and column)
     * and calls checkLocation(row, column)
     */
    void GameLoop() {
        
    }

    /**
     * Count number of mines adjacent to cell at [row][col]
     *
     * @param row the row number
     * @param col the column number
     * @return count - the number of mines next to cell
     */
    int NumberOfMines(int row, int col) {
        int count = 0;

        // If not a mine, do this
        if (!CheckLocation(row, col)) {
            for (int i = row - 1; i <= col + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (i > -1 && i < GameGrid.getWidth() && j > -1 && j < GameGrid.getHeight())
                        if (CheckLocation(i, j)) {
                            count++;
                        }
                }
            }
            // If not a mine, change the hidden value of cell to
            // a character of the count
            GameGrid.board[row][col].HiddenValue = (char)count;
        }
        return count;
    }

    /**
     * Checks if grid at row, col is a mine
     * @param row
     * @param col
     * @return true if mine by looking at the cell's value of isMine
     */
    boolean CheckLocation(int row, int col){
        return GameGrid.board[row][col].isMine();
    }

    /**
     * Method reveal all cells adjacent to cell
     * at [row][col]. If one of the adjacent cells has a mine
     * then a number is put in that location
     * if one adjacent cell does not have any mines, then the cell is blanked
     * @param row
     * @param col
     */
    void ClearBlanks(int row, int col){

    }
}
