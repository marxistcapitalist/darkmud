package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.items.WaterBucket;
 
public class ForestA extends Room {
	
	public static String identifier = "ForestA";

	public ForestA (HashMap<String, Room> rooms) { 
		super(rooms, "You stand in a crowd of trees, blocking the light. A trial of breadcrumbs lead to the east", "You observe a crowd of trees, creating a shadowy area");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(ForestPath.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(WornRoadA.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(BreadcrumbA.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ToadstoolRing.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new WaterBucket("Bucket", "Water", "is full to the brim with murky water (it's not drinkable)", "witches"));
	}
}
