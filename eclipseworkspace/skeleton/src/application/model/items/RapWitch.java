package application.model.items;

import application.MapManager;
import application.model.Item;
import application.model.interfaces.Killable;
import application.model.interfaces.Statusable;
import application.model.rooms.BrushTower;
import application.view.Logger;
import application.view.LogEntry.LogType;

public class RapWitch extends Item implements Killable {
	
	public int health =  0;
	
	public RapWitch() { super(); }
	
	public RapWitch(String name) {
		identifier = name;
	}
	
	public RapWitch(String name, String description, String information, int health) {
		this(name);
		super.description = description;
		super.information = information;	
		this.health = health;
	}
	

	@Override
	public void executeUsedUpon(Item item) {
		super.executeUsedUpon(item);
		this.health -= 2;
		if (item instanceof Statusable) 
			this.health -= 10;
		if (this.health <= 0) {
			MapManager.getCurrentRoom().getRoomItems().remove(this);
			MapManager.getCurrentRoom().getRoomItems().add(new Treasure("Brush", "Pearled", "is inlaid with a beautiful pearl. It seems familiar somehow"));
			Logger.log(LogType.KILL, "You killed the Witch!");
			Logger.log(LogType.ITEM, "In exchange for freeing her, the woman leaves you a Mother of Pearl(TM) inlaid brush as a gift.");	
			BrushTower room = (BrushTower) MapManager.getCurrentRoom(); // As a result of this, this should ONLY exist in BrushTower room
			room.openRoom();
		}
	}

	@Override
	public void executeUsedUponConsumed(Item item) {
		super.executeUsedUponConsumed(item);
		this.health -= 1;
		if (item instanceof Statusable) 
			this.health -= 10;
		if (this.health <= 0) {
			MapManager.getCurrentRoom().getRoomItems().remove(this);
			MapManager.getCurrentRoom().getRoomItems().add(new Treasure("Brush", "Pearled", "is inlaid with a beautiful pearl. It seems familiar somehow"));
			Logger.log(LogType.KILL, "You killed the Witch!");
			Logger.log(LogType.ITEM, "In exchange for freeing her, the woman leaves you a Mother of Pearl(TM) inlaid brush as a gift.");	
			BrushTower room = (BrushTower) MapManager.getCurrentRoom();
			room.openRoom();
		}
	}
	
	@Override
	public void executeInspect() {
		Logger.log(LogType.RESPONSE, "The " + this.description + " " + this.identifier + " " + this.information + "!");	
	}

}
