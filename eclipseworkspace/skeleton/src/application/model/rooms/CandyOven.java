package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Hatchet;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class CandyOven extends Room {
	
	public static String identifier = "CandyOven";

	public CandyOven (HashMap<String, Room> rooms) { 
		super(rooms, "Boy, is it hot! In the oven are two children. They offer you a hatchet in return for freeing them, and run off", "You see the iron oven, which emits very hot air");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(CandyKitchen.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
	}
	
	@Override public void enter () {
		this.description = "Boy, the inside of this oven is STILL hot!\nLooking closer, you see some human remains the bottom of the oven. Gross";
		addItem(new Hatchet("Hatchet", "Shiny", "is in surprisingly good condition"));
	}
}
