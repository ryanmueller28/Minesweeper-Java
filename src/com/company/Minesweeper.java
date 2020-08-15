package com.company;

public class Minesweeper implements Printable{

    public static void main(String[] args) {
        Game minesweeperGame = new Game();

        minesweeperGame.Start();

        minesweeperGame.GameLoop();
    }
}
