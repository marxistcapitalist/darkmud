package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class ForestPath extends Room {
	
	public static String identifier = "ForestPath";

	public ForestPath (HashMap<String, Room> rooms) { 
		super(rooms, "You are standing on a dirt trail in the dark forest", "You observe a dirt path leading into the forest");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(Clearing.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(CrossRoads.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ForestA.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		
	}
}
