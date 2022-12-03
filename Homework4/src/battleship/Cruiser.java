package battleship;

public class Cruiser extends Ship {
    
    @Override
    public String getShipType() {
	return "cruiser";
    }
    
    public Cruiser() {
	int length = 6;
	setLength(length);
	setHit(new boolean[length]);
    }
    
}
