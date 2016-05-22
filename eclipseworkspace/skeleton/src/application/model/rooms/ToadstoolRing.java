package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.MapManager;
import application.MapManager.Health;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class ToadstoolRing extends Room {
	
	public static String identifier = "ToadstoolRing";

	public ToadstoolRing (HashMap<String, Room> rooms) { 
		super(rooms, "Oh no! You stepped into a toadstool ring!\nLittle faries dance around you, and you lose track of time..", "You observe a ring of mushrooms. They seem to glow slightly");
		super.id = identifier;
	}
	
	@Override public void initialize() {
		//addDoorway(new Doorway(Direction.WEST, this.rooms.get(ClearingE.identifier), "", "impossiblekey"));
	}
	
	@Override public void enter() {
		MapManager.setHealth(Health.DEAD);
	}
}
