package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Chest;
import application.model.items.Treasure;
 
public class StoneBarrow extends Room {
	
	public static String identifier = "StoneBarrow";

	public StoneBarrow (HashMap<String, Room> rooms) { 
		super(rooms, "You come upon what looks like an ancient burial site");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.NORTHEAST, this.rooms.get(WestOfHouse.identifier)));
		
		addItem(new Chest("Plinth","Sandstone",
				new Treasure("Scarab", "Jeweled", "looks very shiny")
				));
	}
}
