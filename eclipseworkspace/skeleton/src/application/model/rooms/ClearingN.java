package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Apple;
import application.model.items.Rock;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class ClearingN extends Room {
	
	public static String identifier = "ClearingN";

	public ClearingN (HashMap<String, Room> rooms) { 
		super(rooms, "You are standing in an unnaturally dark clearing. You spot a tasty-looking glowing red potion at the center", "You observe a very dark clearing");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(BrushTower.identifier)));
		//addDoorway(new Doorway(Direction.EAST, this.rooms.get(BriarPatch.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new Apple("Potion", "Red", "looks like a healing potion, considering the glowing", 3));
		addItem(new Rock("Rock", "Odd", "is very odd"));
	}
}
