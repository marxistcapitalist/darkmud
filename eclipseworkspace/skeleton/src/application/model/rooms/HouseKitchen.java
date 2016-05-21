package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Apple;
import application.model.items.Chest;
import application.model.items.Scenery;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class HouseKitchen extends Room {
	
	public static String identifier = "HouseKitchen";

	public HouseKitchen (HashMap<String, Room> rooms) { 
		super(rooms, "You are in a well-appointed kitchen, full of nice pots and pans and a humming refrigerator", "You see a fully-stocked kitchen");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(House.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(GrueStorage.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new Scenery("Table", "Dining", "is fully laid out for a meal, plates and all"));
		addItem(new Scenery("Stove", "Gas", "is still fully functional, although you probably shouldn't mess with it"));
		addItem(new Scenery("Pot", "Large", "shows signs of use, although is still in usable condition"));
		addItem(new Chest("Refrigerator", "Humming", new Apple("Milk", "Fresh", "is still fresh and tasty"))); // TODO Insert some food?
	}
}
