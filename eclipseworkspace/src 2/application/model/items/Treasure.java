package application.model.items;

import application.model.Item;
import application.model.interfaces.Inventoryable;
import application.model.interfaces.Keyedable;
import application.view.LogEntry.LogType;
import application.view.Logger;

public class Treasure extends Item implements Inventoryable , Keyedable {

	public Treasure() { super(); }
	
	public Treasure(String name) {
		identifier = name;
	}
	
	public Treasure(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;	
	}
	
	public Treasure(String name, String description, String information, String key) {
		this(name);
		super.description = description;
		super.information = information;	
		super.key = key;
	}
	
	@Override
	public void executeDrop() {
		super.executeDrop();
		Logger.log(LogType.RESPONSE, "I'd pick that back up if I were you");
	}

	@Override
	public void executeTake() {
		super.executeTake();
		Logger.log(LogType.RESPONSE, "You obtained a Treasure!");	
	}

}
