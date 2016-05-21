package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Chest;
import application.model.items.Key;
import application.model.items.Rock;
import application.model.items.Scenery;
 
public class SouthOfHouse extends Room {
	
	public static String identifier = "SouthOfHouse";

	public SouthOfHouse (HashMap<String, Room> rooms) { 
		super(rooms, "You are facing the south side of a white house. There is no door here, and all the windows are barred.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.NORTHWEST, this.rooms.get(WestOfHouse.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(WestOfHouse.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(ForestSouth.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(BehindHouse.identifier)));
		addDoorway(new Doorway(Direction.NORTHEAST, this.rooms.get(BehindHouse.identifier)));
		
		addItem(new Chest("Pile", "Dirt", 
				new Rock("Rock", "Small", "is a rock"),
				new Rock("Rock", "Large", "is very rock"),
				new Rock("Rock", "Medium", "is such a rock"),
				new Rock("Rock", "Rough", "is really rockin'"),
				new Rock("Rock", "Tiny", "looks like a rock"),
				new Rock("Rock", "Smooth", "is probably a rock"),
				new Rock("Rock", "Huge", "rocks"),
				new Rock("Rock", "Regular", "had the physical characteristics of a rock"),
				new Rock("Rock", "Rocky", "isn't actually a rock"),
				new Key ("Key","Small","looks like it could be used on a window","housewindow")
		));
		
		
		addItem(new Scenery("House", "White", "is a beautiful colonial house which is painted white. It is clear that the owners must have been extremely wealthy." ));

	}
}

