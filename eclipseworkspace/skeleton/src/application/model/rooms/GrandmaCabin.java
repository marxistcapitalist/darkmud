package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Wolf;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class GrandmaCabin extends Room {
	
	public static String identifier = "GrandmaCabin";
	
	private Doorway doorN = null;
	private Doorway doorW = null;
	private Doorway doorE = null;

	public GrandmaCabin (HashMap<String, Room> rooms) { 
		super(rooms, "As you enter, all the enterances SLAM SHUT!\nYou are standing in an old, creaky cabin. The howling has stopped, and you see its source.\nThe wolf lunges toward you", "You see a small, country cabin. Very grandma-like");
		super.id = identifier;
	}
	@Override public void initialize () {
		// SPECIAL CASE - The doorways are inoperable until you have defeated the witch
		this.doorN = new Doorway(Direction.NORTH, this.rooms.get(FlowerTrailE.identifier), "NORTH", "impossiblekey");
		this.doorE = new Doorway(Direction.EAST, this.rooms.get(WolfStomach.identifier), "EAST", "impossiblekey");
		this.doorW = new Doorway(Direction.WEST, this.rooms.get(FlowerTrailD.identifier), "WEST", "impossiblekey");
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new Wolf("Wolf", "Huge", "is very fearsome-looking, and wields extremely sharp claws", 10));
	}
	
	public void openRoom() {
		removeDoorway(this.doorE);
		removeDoorway(this.doorN);
		removeDoorway(this.doorW);
		this.description = "You are standing in an old, creaky cabin.\nThe room is now vacant of wolves. Good";
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(FlowerTrailD.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(FlowerTrailE.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(WolfStomach.identifier)));
	}
}
