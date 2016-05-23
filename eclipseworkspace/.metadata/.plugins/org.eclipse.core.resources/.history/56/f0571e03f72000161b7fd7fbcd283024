package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Apple;
import application.model.items.Bag;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class FlowerTrailE extends Room {
	
	public static String identifier = "FlowerTrailE";

	public FlowerTrailE (HashMap<String, Room> rooms) { 
		super(rooms, "You are standing on a flowery trail. A basket of pastries sits discarded.\nYou spot an old cabin to the south, and a beautiful field of flowers to the north", "You observe a smaller path of the trail, and a basket");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.NORTH, this.rooms.get(FloweryField.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(FlowerTrailC.identifier)));
		addDoorway(new Doorway(Direction.SOUTH, this.rooms.get(GrandmaCabin.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new Bag("Basket", "Pastry", 
				new Apple("Donut", "Sugar", "looks so tasty, your mouth waters just viewing it"),
				new Apple("Bun", "Cinnamon", "makes you think of a Cinnabon, but 20x better", 3),
				new Apple("Sandwich", "Normal", "... it's a sandwich")
		));
	}
}
