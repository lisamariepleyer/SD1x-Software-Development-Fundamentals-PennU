package playing;

public class Squarelotron {
    //instance variables
    int[][] squarelotron;
    int size;
    
    //constructor
    Squarelotron(int n) {

	squarelotron = new int[n][n];
	int counter = 1;
	for (int x = 0; x < n; x++) {
	    for (int y = 0; y < n; y++) {
		squarelotron[x][y] = counter;
		counter++;
	    }
	}
	
	size = n;
	
    }
    
    //methods
    Squarelotron upsideDownFlip(int ring) {
	
	Squarelotron newSq = new Squarelotron(size);
	for (int x = ring - 1; x <= size - ring; x++) {
	    if (x == ring - 1 | x == size - ring) {
		for (int y = ring - 1; y <= size - ring; y++) {
		    newSq.squarelotron[x][y] = squarelotron[size - x -1][y];
		}
	    } else {
		newSq.squarelotron[x][ring - 1] = squarelotron[size - x - 1][ring - 1];
		newSq.squarelotron[size - x - 1][size - ring] = squarelotron[x][size - ring];
	    }
	}
	
	return(newSq);
    }
    
    Squarelotron mainDiagonalFlip(int ring) {
	
	Squarelotron newSq = new Squarelotron(size);
	for (int x = ring - 1; x <= size - ring; x++) {
	    if (x == ring - 1 | x == size - ring) {
		for (int y = ring - 1; y <= size - ring; y++) {
		    newSq.squarelotron[y][x] = squarelotron[x][y];
		    newSq.squarelotron[x][y] = squarelotron[y][x];
		}
	    }
	}
	
	return(newSq);
    }
	
    
    void rotateRight(int numberOfTurns) {
	
	//method modifies the internal representation of the squarelotron; it does not create a new squarelotron.
	//does this mean I just need to print something? or should I edit the existing squarelotron?
	
	// how often do we have to rotate to the right?
	numberOfTurns = ((numberOfTurns % 4) + 4) % 4;
	
	// rotate
	for (int t = 0; t < numberOfTurns; t++) {
	    Squarelotron newSq = new Squarelotron(size);
	    for (int x = 0; x < size; x++) {
		    for (int y = 0; y < size; y++) {
			newSq.squarelotron[y][size - x - 1] = squarelotron[x][y];
		    }
	    }
	    this.squarelotron = newSq.squarelotron;
	}
    }
    
    void printSq() {
	for (int x = 0; x < size; x++) {
		for (int y = 0; y < size; y++) {
		    System.out.print(squarelotron[x][y]);
		}
		System.out.println();
	}
    }
    
    //main function
    public static void main(String[] args) {
	//Squarelotron sq = new Squarelotron(8);
	//System.out.println("size: " + sq.size);
	//System.out.println();
	//System.out.println("size: " + sq.squarelotron[1][1]);
	//sq.printSq();
	//System.out.println();
	//sq.rotateRight(5);
	//sq.printSq();
	//Squarelotron sqn = sq.upsideDownFlip(1);
	//sqn.printSq();
	//Squarelotron sqn = sq.mainDiagonalFlip(2);
	//sqn.printSq();
	
    }
}
