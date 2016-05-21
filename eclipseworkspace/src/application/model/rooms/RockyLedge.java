package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
 
public class RockyLedge extends Room {
	
	public static String identifier = "RockyLedge";

	public RockyLedge (HashMap<String, Room> rooms) { 
		super(rooms, "You are on a ledge about halfway up the wall of the river canyon. You can see from here that the main flow from the Halcyon Falls twists along a passage which it is impossible to enter. Below you is the canyon bottom. Above you is more cliff, which still appears climbable." );
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CanyonBottom.identifier)));
		addDoorway(new Doorway(Direction.UP, this.rooms.get(CanyonView.identifier)));
	}
}
