package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class EndOfRainbow extends Room {
	
	public static String identifier = "EndOfRainbow";

	public EndOfRainbow (HashMap<String, Room> rooms) { 
		super(rooms, "You are on a small, rocky beach on the continuation of the Frigid River past the Falls. The beach is narrow due to the presence of the White Cliffs. The river canyon opens here and sunlight shines in from above. A rainbow crosses over the falls to the west and a narrow path continues to the southeast." );
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.SOUTHWEST, this.rooms.get(CanyonBottom.identifier)));
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(OnTheRainbow.identifier)));
	}
}
