package application.model.items;

import application.model.Item;
import application.model.interfaces.Inventoryable;

public class Paper extends Item implements Inventoryable{

	public Paper() { super(); }
	
	public Paper(String name) {
		identifier = name;
	}
	
	public Paper(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;	
	}
	
}
