package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class ForestA extends Room {
	
	public static String identifier = "ForestA";

	public ForestA (HashMap<String, Room> rooms) { 
		super(rooms, "You stand in a crowd of trees, blocking the light. ", "You observe an empty clearing");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(WornRoadA.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(BrushTower.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(ToadstoolRing.identifier)));
		//addDoorway(new Doorway(Direction.NORTH, this.rooms.get(BriarPatch.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		// TODO Add potion
	}
}
