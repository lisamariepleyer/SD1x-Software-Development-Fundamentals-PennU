package battleship;

public class BattleCruiser extends Ship {
    
    @Override
    public String getShipType() {
	return "battlecruiser";
    }
    
    public BattleCruiser() {
	int length = 7;
	setLength(length);
	setHit(new boolean[length]);
    }
}
