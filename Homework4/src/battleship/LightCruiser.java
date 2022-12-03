package battleship;

public class LightCruiser extends Ship {
    
    @Override
    public String getShipType() {
	return "light cruiser";
    }
    
    public LightCruiser() {
	int length = 5;
	setLength(length);
	setHit(new boolean[length]);
    }
    
}
