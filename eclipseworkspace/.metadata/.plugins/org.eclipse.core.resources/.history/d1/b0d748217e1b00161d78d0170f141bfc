package application.model.rooms;

import java.util.HashMap;

import application.MapManager;
import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.interfaces.Keyedable;
import application.model.Item;
import application.model.Room;
import application.view.LogEntry.LogType;
import application.view.Logger;
 
public class ForestPath extends Room {
	
	public static String identifier = "ForestPath";

	public ForestPath (HashMap<String, Room> rooms) { 
		super(rooms, "This is a dimly lit forest, with large trees all around. One particularly large tree with some low branches stands here.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(NorthOfHouse.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ClearingNorth.identifier)));
		addDoorway(new Doorway(Direction.UP, this.rooms.get(UpATree.identifier), "Tree", "treeclimber") {
			@Override
			public void executeInspect() {
				Logger.log(LogType.RESPONSE, "It looks like you could climb this with some climbing gear");
			}
			
			@Override
			public void unlock(Item item) {
				if (item instanceof Keyedable && this.islocked == true) {
					if (item.key.equals(this.key)) {
						this.islocked = false;
						Logger.log(LogType.RESPONSE, "You are now able to climb the tree!");
						return;
					}
					for (Room room : MapManager.getAllRoomsUnnamed()) {
						for (Doorway doorway : room.getDoorways()) {
							if (item.key.equals(doorway.key)) {
								doorway.islocked = false;
							}
						}
					}
					Logger.log(LogType.RESPONSE, "Why are you using this on the tree?");	
					return;
				}
			}
		});
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(ForestNorth.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ForestWest.identifier)));
	}
}