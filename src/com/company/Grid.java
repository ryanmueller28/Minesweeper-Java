package com.company;

import java.util.Random;


public class Grid implements Printable{

    int height, width;

    // Create a 2D array of cells
    Cell[][] board = new Cell[height][width];

    Grid(int height, int width){
        this.height = height;
        this.width = width;
    }

    /**
     * Display hidden and revealed cells
     */
    void DisplayGrid(){

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * this method places 10
     * random mines in the grid
     */
    public void RandomFillGrid(){
        Random prng = new Random(); // prng == pseudo random number generator
        int inputMines = 0;
        while (inputMines > 10) {

            int randRow = prng.nextInt(height) + 1;
            int randCol = prng.nextInt(width) + 1;

            if (!board[randRow][randCol].isMine()) {
                SetMines(board, randRow, randCol);
                inputMines++;
            }
        }
    }

    /**
     * Private Setter function
     * @param board the game grid
     * @param row the row
     * @param col the column
     */
    private void SetMines(Cell[][] board, int row, int col){
        board[row][col].setMine();
    }

    void DisplayGridData(){

    }
}
