package battleship;

public class BattleShip extends Ship {
    
    @Override
    public String getShipType() {
	return "battleship";
    }
    
    public BattleShip() {
	int length = 8;
	setLength(length);
	setHit(new boolean[length]);
    }
    
}
