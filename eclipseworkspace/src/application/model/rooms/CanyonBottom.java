package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class CanyonBottom extends Room {
	
	public static String identifier = "CanyonBottom";

	public CanyonBottom (HashMap<String, Room> rooms) { 
		super(rooms, "You are beneath the walls of the river canyon which may be climbable here. There is a small stream here, which is the lesser part of the runoff of Halcyon Falls. To the north is a narrow path." );
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.UP, this.rooms.get(RockyLedge.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(EndOfRainbow.identifier)));
	}

}
