package com.company;

import java.util.Random;

import static com.company.Printable.print;

public class Grid implements Printable{

    String rowString;

    public String getRowString() {
        String temp = "";

        for (int i = 1; i <= width; i++){
            temp += "\t" + Integer.toString(i);
        }

        return temp;
    }

    /**
     * Class variables:
     * @param width - the width of the board (x)
     * @param height - the height of the board (y)
     * @param Cell[][] board - A 2D array of cells
     */

    int height, width;

    // Create a 2D array of cells
    Cell[][] board;

    Grid(int height, int width){
        this.height = height;
        this.width = width;
        board = new Cell[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                board[i][j] = new Cell();
            }
        }
    }

    /**
     * Display game grid
     * as player should see it
     */
    void DisplayGrid(){
        String rString = getRowString();
        print(rString + "\n");

        // Iterate along rows
        for (int i = 0; i < height; i++){
            String columnTemp = "";
            // Iterate along columns
            for (int j = 0; j < width; j++){
                columnTemp += String.valueOf(board[i][j].DisplayValue) + "\t";
            }
            print("\n" + Integer.toString(i + 1) + "\t" + columnTemp);
        }
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

            /**
             * check if board[randRow][randCol] is mine
             * if not, SetMine,
             * else continue looping
             * Prevents multiple mines in one location
             */
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

    /**
     * This displays all hidden values
     * of the game grid
     */
    void DisplayGridData(){
        String rString = getRowString();
        print(rString);

        // Iterate along rows
        for (int i = 0; i <= height; i++){
            print(Integer.toString(i) + "\t");

            String columnTemp = "\t";

            // Iterate along columns
            for (int j = 0; j <= width; j++){
                columnTemp += String.valueOf(board[i][j].HiddenValue) + "\t";
            }

            print(columnTemp + "\n");
        }
    }
}
