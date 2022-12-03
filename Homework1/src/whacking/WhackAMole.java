package whacking;

import java.util.Random;
import java.util.Scanner;

public class WhackAMole {
    //instance variables
    int score;
    int molesLeft;
    int attemptsLeft;
    char [][] moleGrid;
    
    //constructors
    WhackAMole(int numAttempts, int gridDimension) {
	this.attemptsLeft = numAttempts;
	
	moleGrid = new char[gridDimension][gridDimension];
	for (int x = 0; x < gridDimension; x++) {
		for (int y = 0; y < gridDimension; y++) {
		    moleGrid[x][y] = '*';
		}
	}
    }
    
    //methods
    boolean place(int x, int y) {
	// there is a mole already
	if (moleGrid[x][y] == 'M') {
	    return false;
	}
	else {
	    moleGrid[x][y] = 'M';
	    return true;
	}
    }
    
    void whack(int x, int y) {
	if (moleGrid[x][y] == 'M') {
	    molesLeft--;
	    score++;
	    attemptsLeft--;
	    moleGrid[x][y] = 'W'; // is this correct?
	}
	else if (moleGrid[x][y] == 'W') {
	    attemptsLeft--;
	}
	else {
	    attemptsLeft--;
	}
    }
    
    void printGridToUser() {
	for (int x = 0; x < moleGrid.length; x++) {
		for (int y = 0; y < moleGrid[0].length; y++) {
		    if (moleGrid[x][y] == 'W') {
			System.out.print('W');
		    }
		    else {
			System.out.print('*');
		    }
		}
		System.out.println();
	}
    }
    
    void printGrid() {
	for (int x = 0; x < moleGrid.length; x++) {
		for (int y = 0; y < moleGrid[0].length; y++) {
		    System.out.print(moleGrid[x][y]);
		}
		System.out.println();
	}
    }
    
    //main method
    public static void main(String[] args) {
	
	// INITIATE GAME
	// set number of attempts and create empty grid of size gridDimension x gridDimension 
	int gridDimension = 10;
	WhackAMole wamGrid = new WhackAMole(50, gridDimension);
	wamGrid.molesLeft = 10;
	wamGrid.score = 0;
	
	//randomly place moles
	int placedMoles = wamGrid.molesLeft;
	Random rand = new Random();
	while (placedMoles > 0) {
	    //only if no mole was there already a new mole could be placed and thus return true
	    if(wamGrid.place(rand.nextInt(gridDimension), rand.nextInt(gridDimension))) {
		placedMoles--;
	    }
	}
	
	System.out.println("Attempts: " + wamGrid.attemptsLeft);
	System.out.println("Moles hidden: " + wamGrid.molesLeft);
	
	wamGrid.printGridToUser();
	
	// LET USER FIND MOLES
	// ask user for coordinates and whack moles
	Scanner scanner = new Scanner (System.in);
	while (wamGrid.attemptsLeft > 0) {
	    
	    System.out.println();
	    System.out.print("Enter coordinates: ");
	    scanner.useDelimiter(",\\s*|\\n"); //\\D+
	    int x,y;
	    x = scanner.nextInt();
	    y = scanner.nextInt();
	    
	    if (x == -1 & y == -1) break;
	    
	    // changes grid position to 'W' if there is an undiscovered mole
	    // changes scores, attempts left and moles left
	    wamGrid.whack(x, y);
	    if (wamGrid.molesLeft == 0) break;
	    wamGrid.printGridToUser();
	    
	    System.out.println();
	    System.out.println("Attempts left: " + wamGrid.attemptsLeft);
	    System.out.println("Score : " + wamGrid.score);
	    System.out.println("Moles still hidden: " + wamGrid.molesLeft);
	    System.out.println();
	    
	}
	scanner.close();
	
	// PRINT RESULTS
	if (wamGrid.molesLeft == 0) {
	    System.out.println(" --------- ");
	    System.out.println("| YOU WON |");
	    System.out.println(" --------- ");
	} else {
	    System.out.println(" ----------- ");
	    System.out.println("| GAME OVER |");
	    System.out.println(" ----------- ");
	}
	
	// print score + grid once user is out of attempts
	System.out.println("You scored " + wamGrid.score + " and missed " + wamGrid.molesLeft + " moles!");
	wamGrid.printGrid();
	
    }
}