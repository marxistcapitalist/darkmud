package application.model.items;

import application.model.Item;
import application.model.interfaces.Consumable;
import application.model.interfaces.Statusable;

public class Rock extends Item implements Consumable, Statusable {

public Rock() { super(); }
	
	public Rock(String name) {
		identifier = name;
	}
	
	public Rock(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;	
	}
}
