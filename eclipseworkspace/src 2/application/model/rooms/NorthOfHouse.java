package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.items.Scenery;
import application.model.Room;
 
public class NorthOfHouse extends Room {

	public static String identifier = "NorthOfHouse";

	public NorthOfHouse (HashMap<String, Room> rooms) { 
		super(rooms, "You are facing the north side of a white house. There is no door here, and all the windows are barred.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ForestPath.identifier)));
		addDoorway(new Doorway(Direction.SOUTHWEST, this.rooms.get(WestOfHouse.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(WestOfHouse.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(BehindHouse.identifier)));
		addDoorway(new Doorway(Direction.SOUTHEAST, this.rooms.get(BehindHouse.identifier)));
		
		addItem(new Scenery("House", "White", "is a beautiful colonial house which is painted white. It is clear that the owners must have been extremely wealthy." ));

	}
}
