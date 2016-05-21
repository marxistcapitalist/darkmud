package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class ForestSouth extends Room {
	
	public static String identifier = "ForestSouth";

	public ForestSouth (HashMap<String, Room> rooms) { 
		super(rooms, "This is a dimly lit forest, with large trees all around. To the east, there appears to be sunlight.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(ForestSouth.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ForestWest.identifier)));
		addDoorway(new Doorway(Direction.NORTHWEST, this.rooms.get(SouthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ClearingEast.identifier)));
	}
}
