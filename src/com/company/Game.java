package com.company;

import java.util.Scanner;

import static com.company.Printable.print;

public class Game implements Printable {

    Grid GameGrid;

    // Is the game over?
    boolean GameOver;

    int REVEALED_MINES = 0;

    public boolean isGameOver(){
        return GameOver;
    }

    // True if won
    // False if not
    boolean DidWin;

    public void setGameOver(boolean gameOver) {
        GameOver = gameOver;
    }

    public boolean getDidWin(){
        return DidWin;
    }

    void WinScreen(){
        GameOver = true;
        DidWin = true;

        GameGrid.DisplayGridData();
    }

    void LoseScreen(){
        GameOver = true;
        DidWin = false;

        GameGrid.DisplayGridData();
    }

    /**
     * The starting point of the game
     * Ask user for height and width of game
     * And initialize that size then call
     * GameLoop() method
     */
    public void Start() {
        Scanner sc = new Scanner(System.in);
        print("Enter the Height of the Grid: ");
        int h = sc.nextInt();
        print("Enter the Width of the Grid: ");
        int w = sc.nextInt();

        GameGrid = new Grid(h, w);
        GameGrid.RandomFillGrid();

    }

    /**
     * Main loop of the game
     * Ask user input for what cell (row and column)
     * and calls checkLocation(row, column)
     */
    void GameLoop() {
        // Create a scanner for user input
        Scanner sc = new Scanner(System.in);

        while (!isGameOver()) {
            GameGrid.DisplayGrid();

            print("Pick a spot to check a mine for\n" +
                    "First enter the row number then the column number: ");

            int rowNum = sc.nextInt();
            int colNum = sc.nextInt();

            // If a mine... do this
            if (CheckLocation(rowNum, colNum)) {
                LoseScreen();
            }else if(REVEALED_MINES == 10){
                WinScreen();
            }
            else{ // not a mine
                NumberOfMines(rowNum, colNum);
                ClearBlanks(rowNum, colNum);
            }
        }
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
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    // Edge Case Testing
                    // Tests if i or j would not be on the board
                    if (i > -1 && i < GameGrid.getWidth() && j > -1 && j < GameGrid.getHeight())
                        if (CheckLocation(i, j)) {
                            count++;
                        }
                }
            }

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
    void ClearBlanks(int row, int col) {
        int count = NumberOfMines(row, col);
        // If not a mine, change the hidden value of cell to
        // a character of the count
        // Parentheses = cast from int to character
        // Convert count from int to char to set HiddenValue to count
        if (count > 0) {
            GameGrid.board[row][col].HiddenValue = (char) count;
        }

        GameGrid.board[row][col].DisplayValue = GameGrid.board[row][col].HiddenValue;

        GameGrid.DisplayGrid();
    }
}
