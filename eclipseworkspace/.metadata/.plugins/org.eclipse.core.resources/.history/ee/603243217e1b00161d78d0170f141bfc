package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Apple;

public class ForestEast extends Room {
	
	public static String identifier = "ForestEast";

	public ForestEast (HashMap<String, Room> rooms) { 
		super(rooms, "You enter a thinned out area of forest and see mountains in the distance");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ForestNorth.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ForestNorth.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(ForestNorth.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(ForestEast.identifier)));
		
		addItem(new Apple("Apple", "Rotten", "looks suspicious"));
	}
}
