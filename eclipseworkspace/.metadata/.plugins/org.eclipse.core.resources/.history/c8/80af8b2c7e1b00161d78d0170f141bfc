package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class OnTheRainbow extends Room {
	
	public static String identifier = "OnTheRainbow";

	public OnTheRainbow (HashMap<String, Room> rooms) { 
		super(rooms, "You begin traveling along the rainbow... somehow");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(EndOfRainbow.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(HalcyonFalls.identifier), "The-Halcyon-Falls"));
	}
}
