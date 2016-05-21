package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Chest;
import application.model.items.Key;
import application.model.items.Scenery;
import application.view.Logger;
import application.view.LogEntry.LogType;
 
public class Cellar extends Room {

	public static String identifier = "Cellar";

	public Cellar (HashMap<String, Room> rooms) { 
		super(rooms, "The trap door crashes shut, and you hear someone barring it.");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.UP, this.rooms.get(HouseLiving.identifier), "Trapdoor", "houseknife") {
			@Override
			public void executeInspect() {
				Logger.log(LogType.RESPONSE, "It seems you could use a small knife to cut the old, rusted hinges.");
			}
		});
		
		addItem(new Chest("Corner","Dark",
				new Key("Key","Rusted","looks important, but obtaining it may have caused your doom", "gratingkey")
				));
		
	}
}
