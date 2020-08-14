package com.company;

public class Cell {
    // is this cell a mine?
    boolean isMine;

    // What is the cell, actually? Empty, Mine, or Numbered
    char HiddenValue;

    // What is the cell, to the player?
    char DisplayValue;

    /**
     * Default constructor:
     * Set isMine to false
     * Set DisplayValue = '*'
     * Set HiddenValue = '.'
     */
    Cell(){
        this.isMine = false;
        this.DisplayValue = '*';
        this.HiddenValue = '.';
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public void setMine(){
        this.isMine = true;
        this.HiddenValue = '*';
    }
}
