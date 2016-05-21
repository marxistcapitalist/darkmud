package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Grue;
 
public class HalcyonFalls extends Room {
	
	public static String identifier = "HalcyonFalls";

	public HalcyonFalls (HashMap<String, Room> rooms) { 
		super(rooms, "You plunge into the frigid water, and emerge into a room on the other side.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(OnTheRainbow.identifier)));
		
		addItem(new Grue("Grue", "Massive", "seems to have something shiny on it" , 10));
	}
}
