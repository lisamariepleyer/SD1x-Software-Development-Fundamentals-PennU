package battleship;

public class EmptySea extends Ship {
    
    @Override
    public String getShipType() {
	return "empty";
    }

    public EmptySea() {
	int length = 1;
	setLength(length);
	setHit(new boolean[length]);
    }
    
    @Override
    public boolean isSunk() {
	return false;
    }
    
    @Override
    public String toString() {
	return getHit()[0] ? "-" : ".";
    }
    
    @Override
    public boolean shootAt(int row, int column) {
	this.getHit()[0] = true;
	return false;
    }
    
}
