package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Apple;
import application.model.items.Chest;
import application.model.items.Key;
import application.model.items.Knife;
import application.model.items.Rock;
 
public class HouseAttic extends Room {

	public static String identifier = "HouseAttic";

	public HouseAttic (HashMap<String, Room> rooms) { 
		super(rooms, "This is the Attic. The only exit is stairs that lead down." );
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(HouseDining.identifier), "Stairs"));
		
		addItem(new Key("Rope", "Climbing", "looks sturdy", "treeclimber"));
		
		addItem(new Chest("Table","Low", 
				new Rock("Brick", "Clay","would be fun to throw"),
				new Knife("Knife","Nasty-Looking", "looks to have blood dried on it", "houseknife"),
				new Apple("Jerky", "Dusty", "looks old but edible")
				));
	
	}
}
