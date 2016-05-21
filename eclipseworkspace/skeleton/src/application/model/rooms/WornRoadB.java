package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class WornRoadB extends Room {
	
	public static String identifier = "WornRoadB";

	public WornRoadB (HashMap<String, Room> rooms) { 
		super(rooms, "You are on an old, worn cobblestone path. You see weeds sprouting between the stones", "You see the rest of the worn cobblestone path");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(Grassland.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(WornRoadA.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
	}
}
