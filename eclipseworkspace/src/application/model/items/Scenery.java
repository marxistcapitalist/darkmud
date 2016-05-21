package application.model.items;

import application.model.Item;
import application.view.Logger;
import application.view.LogEntry.LogType;

public class Scenery extends Item {

public Scenery() { super(); }
	
	public Scenery(String name) {
		identifier = name;
	}
	
	public Scenery(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;	
	}
	
	@Override
	public void executeInspect () {
		Logger.log(LogType.RESPONSE, "The " + identifier + " " + information + ".");
	}
	
}
