package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.items.Scenery;
import application.model.Room;

 
public class BehindHouse extends Room {

	public static String identifier = "BehindHouse";

	public BehindHouse (HashMap<String, Room> rooms) { 
		super(rooms, "You are behind the white house. In one corner of the house is a window that is slightly ajar.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(HouseDining.identifier), "Window", "housewindow"));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(SouthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.SOUTHWEST, this.rooms.get(SouthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(NorthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.NORTHWEST, this.rooms.get(NorthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(ClearingEast.identifier)));
		
		
		addItem(new Scenery("House", "White", "is a beautiful colonial house which is painted white. It is clear that the owners must have been extremely wealthy." ));

	}
	
}
