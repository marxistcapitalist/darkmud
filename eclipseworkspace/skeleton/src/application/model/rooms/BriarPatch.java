package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.MapManager;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class BriarPatch extends Room {
	
	public static String identifier = "BriarPatch";

	public BriarPatch (HashMap<String, Room> rooms) { 
		super(rooms, "Ouch, the thorns of the hedge dig into your skin! You better get out of here", "You see a large, thorny hedge");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(ClearingE.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ClearingN.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		
	}
	
	@Override public void enter () {
		MapManager.decrementHealth();
	}
}
