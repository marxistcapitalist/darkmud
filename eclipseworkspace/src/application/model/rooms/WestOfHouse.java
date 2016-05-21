package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Chest;
import application.model.items.Paper;
import application.model.items.Scenery;
 
public class WestOfHouse extends Room {
	
	public static String identifier = "WestOfHouse";

	public WestOfHouse (HashMap<String, Room> rooms) { 
		super(rooms, "You are in an open field on the west side of a white house with a boarded front door.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(NorthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.NORTHEAST, this.rooms.get(NorthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ForestWest.identifier)));
		addDoorway(new Doorway(Direction.SOUTHWEST, this.rooms.get(StoneBarrow.identifier), "Stone-Door"));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(SouthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.SOUTHEAST, this.rooms.get(SouthOfHouse.identifier)));;
		
		addItem(new Chest("Mailbox", "White", 
				new Paper ("Leaflet", "Folded", "says: Welcome to the Maze! \n The Maze is a game of adventure, danger, and low cunning. In it you will explore some of the most amazing territory ever seen by mortals. Hardened adventurers have run screaming from the terrors contained within. \n Your goal is to collect the FOUR treasures. \n The Maze was inspired by Zork which was created at the MIT Laboratory for Computer Science by Tim Anderson, Marc Blank, Bruce Daniels, and Dave Lebling.")
				));
		addItem(new Scenery("Mat", "Rubber", "has the text \"Maze Sweet Maze\" written on it"));
		
		addItem(new Scenery("House", "White", "is a beautiful colonial house which is painted white. It is clear that the owners must have been extremely wealthy." ));
		addItem(new Scenery("Door","Front","is locked, and there is evidently no key"));
	}
}
