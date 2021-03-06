package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.MapManager;
import application.MapManager.Health;
 
public class FloweryField extends Room {
	
	public static String identifier = "FloweryField";

	public FloweryField (HashMap<String, Room> rooms) { 
		super(rooms, "Ah, these flowers are relly pretty...\nSuddenly, you are jumped upon by a hungry wolf. Dead.\nDidn't your mother tell you never to stray from the path?", "You see a beautiful flower field. The smell is quite alluring");
		super.id = identifier;
	}
	
	@Override public void initialize() {
		//addDoorway(new Doorway(Direction.WEST, this.rooms.get(FlowerTrailB.identifier), "", "impossiblekey"));
	}
	
	@Override public void enter() {
		MapManager.setHealth(Health.DEAD);
	}
}
