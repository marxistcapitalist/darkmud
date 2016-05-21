package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class CanyonView extends Room {
	
	public static String identifier = "CanyonView";

	public CanyonView (HashMap<String, Room> rooms) { 
		super(rooms, "You are at the top of the Great Canyon on its south wall. From here there is a marvelous view of the Canyon and parts of the Frigid River upstream. Across the canyon, the walls of the White Cliffs still appear to loom far above. Following the Canyon upstream (north and northwest), The Halcyon Falls may be seen, complete with rainbow. Fortunately, my vision is better than average and I can discern the top of the Flood Control Dam #3 far to the distant north. To the west and south can be seen an immense forest, stretching for miles around. It is possible to climb down into the canyon from here.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.NORTHWEST, this.rooms.get(ClearingEast.identifier)));
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(ForestSouth.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(RockyLedge.identifier)));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(RockyLedge.identifier)));
	}
}
