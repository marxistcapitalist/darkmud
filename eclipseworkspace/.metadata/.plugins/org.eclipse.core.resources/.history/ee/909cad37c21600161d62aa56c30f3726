package application.model.items;

import application.MapManager;
import application.model.Item;
import application.model.interfaces.Killable;
import application.model.interfaces.Statusable;
import application.view.Logger;
import application.view.LogEntry.LogType;

public class Grue extends Item implements Killable {
	
	public int health =  0;
	
	public Grue() { super(); }
	
	public Grue(String name) {
		identifier = name;
	}
	
	public Grue(String name, String description, String information, int health) {
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
			MapManager.getCurrentRoom().getRoomItems().add(new Treasure("Bracelet", "Saphire", "looks to be in an elven style"));
			Logger.log(LogType.KILL, "You killed the Grue!");
			Logger.log(LogType.ITEM, "Something shiny dropped to the ground!!");	
		}
	}

	@Override
	public void executeUsedUponConsumed(Item item) {
		super.executeUsedUponConsumed(item);
		this.health -= 1;
		if (this.health <= 0) {
			MapManager.getCurrentRoom().getRoomItems().remove(this);
			MapManager.getCurrentRoom().getRoomItems().add(new Treasure("Bracelet", "Saphire", "looks to be in an elven style"));
			Logger.log(LogType.KILL, "You killed the Grue!");
			Logger.log(LogType.ITEM, "Something shiny dropped to the ground!!");	
		}
	}
	
	@Override
	public void executeInspect() {
		Logger.log(LogType.RESPONSE, "The " + this.description + " " + this.identifier + " " + this.information + "!");	
	}

}
