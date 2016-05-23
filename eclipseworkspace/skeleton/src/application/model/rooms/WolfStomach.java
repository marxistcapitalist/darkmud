package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Treasure;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class WolfStomach extends Room {
	
	public static String identifier = "WolfStomach";

	public WolfStomach (HashMap<String, Room> rooms) { 
		super(rooms, "Eww, it smells. You are standing in a giant wolf's stomach.\nThere are two other people here: a girl in a read cloak & an old, wizened woman.\nThe girl offers you her red cloak for saving them.", "You see the inside of the deceased wolf's stomach. Gross");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(CandyKitchen.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
	}
	
	@Override public void enter () {
		this.description = "Eww, it's still gross in here.\nLooking closer, you see some half-digested wolf-food. Disgusting";
		addItem(new Treasure("Cloak", "Red", "is of fine quality, and looks good despite smelling a bit off"));
	}
}
