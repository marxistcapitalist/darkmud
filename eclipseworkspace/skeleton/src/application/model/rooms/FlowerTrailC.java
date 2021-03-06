package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Rock;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class FlowerTrailC extends Room {
	
	public static String identifier = "FlowerTrailC";

	public FlowerTrailC (HashMap<String, Room> rooms) { 
		super(rooms, "You are on a trail surrounded by flowers. The trail continues to the east, north and south", "You observe additional lengths of the flower trail");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(FlowerTrailB.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(FlowerTrailE.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(FlowerTrailD.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new Rock("Rock", "Square", "is very square (how odd)"));
	}
}
