package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class ForestWest extends Room {
	
	public static String identifier = "ForestWest";

	public ForestWest (HashMap<String, Room> rooms) { 
		super(rooms, "This is a large forest, with trees obstructing all views except to the east, where a small clearing may be seen through the trees.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ClearingNorth.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ForestWest.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(ForestSouth.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(ForestPath.identifier)));
	}

}
