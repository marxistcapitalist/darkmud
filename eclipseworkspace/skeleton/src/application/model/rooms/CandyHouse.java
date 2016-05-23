package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class CandyHouse extends Room {
	
	public static String identifier = "CandyHouse";

	public CandyHouse (HashMap<String, Room> rooms) { 
		super(rooms, "You enter a house made of candy...\nHow? You don't know... looks good though.\nSomeone is cooking in the kitchen to the north", "You see a candy house, and wonder if you're dreaming");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(CandyKitchen.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(CandyStorage.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(BreadcrumbC.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(BreadcrumbB.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		
	}
}
