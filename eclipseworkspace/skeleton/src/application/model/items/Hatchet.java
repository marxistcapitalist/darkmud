package application.model.items;

import application.model.interfaces.Inventoryable;
import application.model.interfaces.Statusable;
import application.view.Logger;
import application.view.LogEntry.LogType;

public class Hatchet extends Treasure implements Inventoryable, Statusable {
	
public Hatchet() { super(); }
	
	public Hatchet(String name) {
		identifier = name;
	}
	
	public Hatchet(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;	
	}

	@Override
	public void executeTake() {
		super.executeTake();
		Logger.log(LogType.RESPONSE, "(This treasure doubles as a weapon! Nice!)");
	}

}
