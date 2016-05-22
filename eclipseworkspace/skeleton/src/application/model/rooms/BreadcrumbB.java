package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class BreadcrumbB extends Room {
	
	public static String identifier = "BreadcrumbB";

	public BreadcrumbB (HashMap<String, Room> rooms) { 
		super(rooms, "You are standing in a dark forest, following breadcrumbs.\nThe trail continues to the south, and you see candy to the north and east", "You observe more of a dark trail of breadcrumbs");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(BreadcrumbA.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ToadstoolRing.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(CandyHouse.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(CandyYard.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		
	}
}
