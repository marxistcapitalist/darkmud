package application.model.rooms;

import java.util.HashMap;

import application.MapManager;
import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.items.Apple;
import application.model.items.Bag;
import application.model.items.Treasure;
import application.model.Room;
import application.view.Logger;
import application.view.LogEntry.LogType;
 
public class UpATree extends Room {
	
	public static String identifier = "UpATree";

	public UpATree (HashMap<String, Room> rooms) { 
		super(rooms, "You are about ten feet above the ground nestled among some large branches. The nearest branch above you is beyond your reach." );
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get("ForestPath")));
		
		addItem(new Bag("Nest", "Bird's", 
				new Apple ("Egg", "Blue", "is fairly small; you could probably eat it"),
				new Treasure ("Egg", "Jewel-Encrusted", "is fairly small") {
					@Override
					public void executeUse() {
						Logger.log(LogType.RESPONSE, "You try to eat the egg, but it get's stuck in your throat");
						MapManager.decrementHealth();
						MapManager.decrementHealth();
					}
				},
				
				new Apple ("Egg", "Speckled", "is a generic, speckled egg")));
	}
}
