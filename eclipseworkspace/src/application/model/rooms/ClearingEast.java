package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class ClearingEast extends Room {
	
	public static String identifier = "ClearingEast";

	public ClearingEast (HashMap<String, Room> rooms) { 
		super(rooms, "You stroll into the eastern clearing");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ForestNorth.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(ForestSouth.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(BehindHouse.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(CanyonView.identifier)));
	}
}
