package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class ForestNorth extends Room {

	public static String identifier = "ForestNorth";

	public ForestNorth (HashMap<String, Room> rooms) { 
		super(rooms, "Following the path, you enter a dimly lit section of forest");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ForestPath.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(ClearingEast.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(ForestEast.identifier)));
	}
}
