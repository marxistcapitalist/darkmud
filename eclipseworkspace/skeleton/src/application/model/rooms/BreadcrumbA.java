package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Rock;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class BreadcrumbA extends Room {
	
	public static String identifier = "BreadcrumbA";

	public BreadcrumbA (HashMap<String, Room> rooms) { 
		super(rooms, "You are on a trail in a dark forest. There are breadcrumbs on the ground for some reason.\nThe trail continues to your east and north", "You observe a dark trail with a line of breadcrumbs");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(CrossRoads.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ForestA.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(BreadcrumbC.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(BreadcrumbB.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new Rock("Rock", "Hard", "is vary hard"));
		
	}
}
