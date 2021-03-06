package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class BreadcrumbC extends Room {
	
	public static String identifier = "BreadcrumbC";

	public BreadcrumbC (HashMap<String, Room> rooms) { 
		super(rooms, "You are standing on a trail of breadcrumbs. The trail continues to the east and west.\nYou observe a candy house to the north", "You observe more of the breadcrumb trail");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(BreadcrumbA.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(BreadcrumbD.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(CandyHouse.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		
	}
}
