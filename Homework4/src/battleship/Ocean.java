package battleship;

import java.util.Random;

public class Ocean {

    //INSTANCE VARIABLES

    public static final int OCEANSIZE = 20;
    public static final int SHIPSPLACED = 13;
    Ship[][] ships = new Ship[OCEANSIZE][OCEANSIZE];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    //METHODS

    //constructor
    public Ocean() {
	shotsFired = 0;
	hitCount = 0;
	shipsSunk = 0;
	for (int x = 0; x < OCEANSIZE; x++) {
	    for (int y = 0; y < OCEANSIZE; y++) {
		Ship emptySea = new EmptySea();
		ships[x][y] = emptySea;
	    }
	}
    }

    //getters and setters
    public int getShotsFired() {
	return shotsFired;
    }
    public int getHitCount() {
	return hitCount;
    }
    public int getShipsSunk() {
	return shipsSunk;
    }

    //other methods
    public void placeAllShipsRandomly() {

	Ship[] ships = new Ship[] { 
		new BattleShip (),
		new BattleCruiser (),
		new Cruiser (),
		new Cruiser (),
		new LightCruiser (),
		new LightCruiser (),
		new Destroyer (),
		new Destroyer (),
		new Destroyer (),
		new Submarine (),
		new Submarine (),
		new Submarine (),
		new Submarine () };

	Random random = new Random();
	for (Ship s : ships) {

	    boolean placed = false;
	    while (placed == false) {

		int row = random.nextInt(OCEANSIZE);
		int column = random.nextInt(OCEANSIZE);
		boolean horizontal = random.nextBoolean();

		if (s.okToPlaceShipAt(row, column, horizontal, this)) {
		    s.placeShipAt(row, column, horizontal, this);

		    placed = true;
		}
	    }

	}

	return;
    }

    public boolean isOccupied(int row, int column) {
	return !ships[column][row].getShipType().equals("empty");
    }

    public boolean shootAt(int row, int column) {
	shotsFired++;
	if (isOccupied(row, column) & !ships[column][row].isSunk()) {
	    hitCount++;
	    ships[column][row].shootAt(row, column);
	    System.out.println("hit");
	    if (ships[column][row].isSunk()) {
		shipsSunk++;
		System.out.println("You sunk a " + ships[column][row].getShipType() + "!");
	    }
	    return true;
	} else {
	    System.out.println("miss");
	    ships[column][row].shootAt(row, column);
	    return false;
	}
    }

    public boolean isGameOver() {
	return shipsSunk == SHIPSPLACED;
    }

    public Ship[][] getShipArray() {
	return ships;
    }

    public void print() {

	System.out.print("   ");
	for (int i = 0; i < OCEANSIZE; i++) {
	    if (String.valueOf(i).length() == 1) {
		System.out.print("0" + i + " ");
	    } else {
		System.out.print(i + " ");
	    }
	}
	System.out.println();
	for (int row = 0; row < OCEANSIZE; row++) {
	    if (String.valueOf(row).length() == 1) {
		System.out.print("0" + row + " ");
	    } else {
		System.out.print(row + " ");
	    }
	    for (int col = 0; col < OCEANSIZE; col++) {

		if (isOccupied(row, col)) {
		    if (ships[col][row].isHit(row, col)) {
			System.out.print(" " + ships[col][row].toString() + " ");
		    } else {
			System.out.print(" . ");
		    }
		} else {
		    System.out.print(" " + ships[col][row].toString() + " ");
		}		
	    }
	    System.out.println();
	}
    }


}
