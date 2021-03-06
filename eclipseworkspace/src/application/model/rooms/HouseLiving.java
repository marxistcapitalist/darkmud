package application.model.rooms;

import java.util.HashMap;

import application.MapManager;
import application.model.Doorway;
import application.model.Item;
import application.model.Doorway.Direction;
import application.model.Room;
import application.model.items.Chest;
import application.model.items.Key;
import application.model.items.Paper;
import application.model.items.Scenery;
import application.model.items.Sword;
import application.model.items.Treasure;
import application.view.Logger;
import application.view.LogEntry.LogType;
 
public class HouseLiving extends Room {
	
	public static String identifier = "HouseLiving";

	public HouseLiving (HashMap<String, Room> rooms) { 
		super(rooms, "This is the living room, there is a strange door with gothic lettering which is nailed shut");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(Cellar.identifier), "Trapdoor", "housecarpet") {
			@Override 
			public void unlock(Item item) {
				Logger.log(LogType.RESPONSE, "It's not locked");
			}
			
			@Override
			public void executeInspect() {
				Logger.log(LogType.RESPONSE, "Seems to be covered...");	
			}
		});
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(HouseDining.identifier)));
		
		addItem(new Chest("Case", "Trophy") {
			@Override
			public void executePutIn(Item item) {
				super.executePutIn(item);
				int counter = 0;
				for (Item trophy : this.getChildren()) {
					if (trophy instanceof Treasure) {
						counter++;
					}
				}
				if (counter == 4) {
					MapManager.moveOnWin();
				}
			}
		});
		
		addItem(new Scenery("Fireplace","Old","doesn't seem to have been used in a while"));
		addItem(new Chest("Mantle", "Fireplace",
				new Sword("Sword", "Elvish","seems to be quite ancient, but still in good condition"),
				new Paper("Bauble", "Small", "looks baubley")
				));
		addItem(new Chest("Table","Coffee",
				new Paper("Newspaper","Rolled","is an issue of US NEWS & DUNGEON REPORT")
				));
		addItem(new Key("Carpet", "House","was covering the trapdoor","housecarpet") {
			@Override 
			public void executeTake() {
				super.executeTake();
				getDoorways().get(0).unlock();
			}
		});
	}
}
