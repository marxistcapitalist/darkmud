package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Scenery;
import application.model.items.Knife;
import application.model.items.RapWitch;
import application.model.items.Rock;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class BrushTower extends Room {
	
	public static String identifier = "BrushTower";
	
	private Doorway doorW = null;
	private Doorway doorN = null;
	private Doorway doorE = null;
	private Scenery maiden = null;

	public BrushTower (HashMap<String, Room> rooms) { 
		super(rooms, "As you enter, all the enterances SLAM SHUT!\nYou are standing in the top room of the tall tower.\nA witch and a beautiful young woman are here as well", "You see a tall, stone-brick tower. It seems to be climbable");
		super.id = identifier;
	}
	// TODO Allow CLIMB as keyword for getting into this room
	@Override public void initialize () {
		// SPECIAL CASE - The doorways are inoperable until you have defeated the witch
		this.doorW = new Doorway(Direction.WEST, this.rooms.get(ClearingW.identifier), "WEST", "impossiblekey");
		this.doorN = new Doorway(Direction.NORTH, this.rooms.get(ClearingN.identifier), "NORTH", "impossiblekey");
		this.doorE = new Doorway(Direction.EAST, this.rooms.get(ClearingE.identifier), "EAST", "impossiblekey");
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new RapWitch("Witch", "Old", "is very nasty-looking, and wields a scraggly wand", 10));
		addItem(new Scenery("Woman", "Young", "is stunningly beautiful, and has extremely long, blond hair"));
		addItem(new Rock("Rock", "Odd", "is very odd"));
		addItem(new Rock("Rock", "Sharp", "is very sharp"));
		addItem(new Rock("Rock", "Hard", "is vary hard"));
		addItem(new Rock("Rock", "Square", "is very square (how odd)"));
		addItem(new Rock("Rock", "Dickish", "looks phallic"));
		addItem(new Rock("Rock", "Kid", "insists his name is Robert Ritchie"));
		addItem(new Knife("Knife", "Rusty", "could give you a nasty case of Tetanus", ""));
		
	}
	
	public void openRoom() {
		removeDoorway(this.doorW);
		removeDoorway(this.doorE);
		removeDoorway(this.doorN);
		removeItem(maiden);
		this.description = "You are standing in the top room of a tall tower.\nThe room is now vacant of both witches and beautiful maidens";
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ClearingW.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(ClearingE.identifier)));
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(ClearingN.identifier)));
	}
}
