package battleship;

public class Destroyer extends Ship {
    
    @Override
    public String getShipType() {
	return "destroyer";
    }
    
    public Destroyer() {
	int length = 4;
	setLength(length);
	setHit(new boolean[length]);
    }
    
}
