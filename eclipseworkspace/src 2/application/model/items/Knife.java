package application.model.items;

import application.model.Item;
import application.model.interfaces.Inventoryable;
import application.model.interfaces.Keyedable;
import application.model.interfaces.Statusable;

public class Knife extends Item implements Inventoryable, Statusable, Keyedable {
	
	public Knife(String name) {
		identifier = name;
	}
	
	public Knife(String name, String description, String information, String key) {
		this(name);
		super.description = description;
		super.information = information;	
		super.key = key;	
	}

}
