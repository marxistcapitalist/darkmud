package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Chest;
import application.model.items.Treasure;
 
public class GratingRoom extends Room {

	public static String identifier = "GratingRoom";

	public GratingRoom (HashMap<String, Room> rooms) { 
		super(rooms, "You climb down the ladder and find a small room with a significant amount of water pooling in it");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.UP, this.rooms.get(ClearingNorth.identifier), "Grating", "gratingkey"));
		
		addItem(new Chest("Water","Knee-Deep",
				new Treasure("Torch","Ivory","looks like it would be very helpful in a dark place, but after sitting in water for so long, it will most likely not be of very much help")
				));
	}
}
