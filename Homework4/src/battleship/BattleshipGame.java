package battleship;

import java.util.Scanner;

public class BattleshipGame {

    public static void main(String[] args) {

	boolean playAgain = true;
	Scanner scanner = new Scanner (System.in);

	while(playAgain) {

	    System.out.println("Initializing new game ...");
	    System.out.println();
	    Ocean ocean = new Ocean();
	    ocean.placeAllShipsRandomly();

	    System.out.println("Here's your ocean!");
	    System.out.println();
	    ocean.print();
	    System.out.println();
	    System.out.println("Try to hit as many ships as possible.");
	    System.out.println("In every round you can shoot 5 times by inputing the coordinate pairs of (row, column) like so:");
	    System.out.println("e.g.: 0,0; 1,3; 4,5; 5,5; 19,19");
	    System.out.println();
	    System.out.print("Let's go! ");

	    while(!ocean.isGameOver()) {

		System.out.print("Enter coordinates: ");	    
		String coordinates = scanner.nextLine();
		String[] splitCoordinates = coordinates.split(";\\s*|\\n");
		for (String coo : splitCoordinates) {
		    String[] cooArray = coo.split(",\\s*");
		    ocean.shootAt(Integer.parseInt(cooArray[0]), Integer.parseInt(cooArray[1]));
		}

		System.out.println();
		System.out.println("Number of shots fired: " + ocean.getShotsFired());
		System.out.println("Number of times you hit a ship: " + ocean.getHitCount());
		System.out.println("Number of ships sunk: " + ocean.getShipsSunk());
		System.out.println();
		ocean.print();
		System.out.println();

	    }

	    if (ocean.isGameOver()) {
		System.out.println("All ships are sunk!");
		System.out.println("You needed " + ocean.getShotsFired() + " shots to win this game!");
		System.out.println("Do you want to play again? y/n");
		String answerPlayAgain = scanner.nextLine();
		if (answerPlayAgain == "n") playAgain = false;
	    }
	}
	scanner.close();
    }
}
