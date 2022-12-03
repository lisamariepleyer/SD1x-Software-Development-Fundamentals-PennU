package battleship;

public class Submarine extends Ship {
    
    @Override
    public String getShipType() {
	return "submarine";
    }
    
    public Submarine() {
	int length = 3;
	setLength(length);
	setHit(new boolean[length]);
    }
    
}
