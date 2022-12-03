package battleship;

import java.util.ArrayList;

public abstract class Ship {

    //INSTANCE VARIABLES

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    //METHODS

    //getters and setters
    public int getBowRow() {
	return bowRow;
    }
    public void setBowRow(int bowRow) {
	this.bowRow = bowRow;
    }
    public int getBowColumn() {
	return bowColumn;
    }
    public void setBowColumn(int bowColumn) {
	this.bowColumn = bowColumn;
    }
    public int getLength() {
	return length;
    }
    public void setLength(int length) {
	this.length = length;
    }
    public boolean isHorizontal() {
	return horizontal;
    }
    public void setHorizontal(boolean horizontal) {
	this.horizontal = horizontal;
    }
    public boolean[] getHit() {
	return hit;
    }
    public void setHit(boolean[] hit) {
	this.hit = hit;
    }

    // other methods
    abstract String getShipType();

    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	ArrayList<Boolean> anyOccupied = new ArrayList<Boolean>();
	if (horizontal) {
	    boolean tooLong = (column + this.getLength()) > ocean.getShipArray().length;
	    anyOccupied.add(tooLong);
	    if (!tooLong) {
		for (int i = column - 1; i <= column + this.getLength() + 1; i++) {
		    for (int j = row - 1; j <= row + 1; j++) {
			if (i < 0 | j < 0 | i >= ocean.getShipArray().length | j >= ocean.getShipArray().length) continue;
			//System.out.println("row: " + j + ", columns: " + i);
			anyOccupied.add(ocean.isOccupied(j, i));
		    }
		}
	    }
	} else {
	    boolean tooLong = (row + this.getLength()) > ocean.getShipArray().length;
	    anyOccupied.add(tooLong);
	    if (!tooLong) {
		for (int i = row - 1; i <= row + this.getLength() + 1; i++) {
		    for (int j = column - 1; j <= column + 1; j++) {
			if (i < 0 | j < 0 | i >= ocean.getShipArray().length | j >= ocean.getShipArray().length) continue;
			//System.out.println("row: " + i + ", columns: " + j);
			anyOccupied.add(ocean.isOccupied(i, j));
		    }
		}
	    }
	}
	if(anyOccupied.contains(true)) return false;
	return true;
    }

    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
	bowRow = row;
	bowColumn = column;
	this.horizontal = horizontal;

	if (horizontal) {
	    for (int i = column; i < column + this.getLength(); i++) {
		ocean.getShipArray()[i][row] = this;
	    }
	} else {
	    for (int i = row; i < row + this.getLength(); i++) {
		ocean.getShipArray()[column][i] = this;
	    }
	}
	return;
    }

    public boolean shootAt(int row, int column) {
	if (isSunk()) {
	    return false;
	} else {
	    if (horizontal & row == bowRow) {
		for (int i = bowColumn; i < bowColumn + this.getLength(); i++) {
		    if (i == column) {
			hit[column - bowColumn] = true;
			return true;
		    }
		}
	    } else if (!horizontal & column == bowColumn) {
		for (int i = bowRow; i < bowRow + this.getLength(); i++) {
		    if (i == row) {
			hit[row - bowRow] = true;
			return true;
		    }
		}
	    } return false;
	}

    }

    public boolean isSunk() {
	for (boolean b : hit) if (!b) return false;
	return true;
    }
    
    public boolean isHit(int row, int column) {
	if (horizontal) {
	    return getHit()[column - bowColumn];
	} else {
	    return getHit()[row - bowRow];
	}
    }

    public String toString() {
	return isSunk() ? "x" : "S";
    }

}
