package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.Doorway;
import application.model.Doorway.Direction;
 
public class BreadcrumbD extends Room {
	
	public static String identifier = "BreadcrumbD";

	public BreadcrumbD (HashMap<String, Room> rooms) { 
		super(rooms, "You are standing at the end of the trail of breadcrumbs", "You observe the end of the breadcrumb trail");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.WEST, this.rooms.get(BreadcrumbC.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		
	}
}
