package playing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SquarelotronTest { //extends Squarelotron {

    Squarelotron sq = new Squarelotron(7);
    
    //@BeforeEach
    //void setUp() throws Exception {
	//Squarelotron sq = new Squarelotron(4);
    //}

    @Test
    void testSquarelotron() {
	assertEquals(1, sq.squarelotron[0][0]);
    }

    @Test
    void testUpsideDownFlip() {
	assertEquals(1, sq.upsideDownFlip(1).squarelotron[6][0]);
	assertEquals(1, sq.upsideDownFlip(3).squarelotron[0][0]);
	assertEquals(17, sq.upsideDownFlip(3).squarelotron[4][2]);
	assertEquals(sq.squarelotron[3][3], sq.upsideDownFlip(4).squarelotron[3][3]);
    }

    @Test
    void testMainDiagonalFlip() {
	assertEquals(1, sq.mainDiagonalFlip(1).squarelotron[0][0]);
	assertEquals(7, sq.mainDiagonalFlip(1).squarelotron[6][0]);
	assertEquals(7, sq.mainDiagonalFlip(2).squarelotron[0][6]);
	assertEquals(17, sq.mainDiagonalFlip(3).squarelotron[2][2]);
	assertEquals(24, sq.mainDiagonalFlip(3).squarelotron[2][3]);
    }

    @Test
    void testRotateRight() {
	sq.rotateRight(1);
	assertEquals(1, sq.squarelotron[0][6]);
	sq.rotateRight(1);
	assertEquals(1, sq.squarelotron[6][6]);
	sq.rotateRight(-3);
	assertEquals(1, sq.squarelotron[6][0]);
    }

    //@Test
    //void testMain() {
	//fail("Not yet implemented");
    //}

}
