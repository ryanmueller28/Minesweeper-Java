package com.company;

public class Cell {
    /**
     * Class properties:
     * @param isMine - is this cell a mine?
     * @param HiddenValue - what is the cell actually?
     * @param DisplayValue - what is the cell to the player?
     */

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

    /**
     * Getter function for isMine
     * Getter is to call in classes above this one
     * Without messing with the variable itself
     * @return true if it's a mine
     */
    public boolean isMine() {
        return isMine;
    }

    public void setMine(){
        this.isMine = true;
        this.HiddenValue = '*';
    }
}
