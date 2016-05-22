package application.model.rooms;

import java.util.HashMap;

import application.model.Room;
import application.model.items.Chest;
import application.model.items.Scenery;
import application.model.items.Treasure;
import application.MapManager;
import application.model.Doorway;
import application.model.Doorway.Direction;
import application.model.Item;
 
public class Library extends Room {
	
	public static String identifier = "Library";

	public Library (HashMap<String, Room> rooms) { 
		super(rooms, "You observe a mysteriously well-maintained library for a house in such disrepair.\n All around are bookcases full of books, but what catches your eye is a\nbook that seems chained to a pedestal in the middle of the room", "You a well-kept library, full of books");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		// Add Doorways 
		addDoorway(new Doorway(Direction.EAST, this.rooms.get(House.identifier)));
		
		// Add Items, Enemies, Weapons, Bags, etc.
		addItem(new Chest("Book", "Mysterious") {
			@Override
			public void executePutIn(Item item) {
				super.executePutIn(item);
				int i = 0;
				for(Item trophy : this.getChildren()) {
					if(trophy instanceof Treasure)
						i++;
				}
				if(i == 3)
					MapManager.moveOnWin();
			}
		});
		addItem(new Scenery("Bookshelves", "Many", "conain various old tomes, from the Necronomicon to the Bible."));
	}
}
