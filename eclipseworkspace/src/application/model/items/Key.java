package application.model.items;

import application.model.Item;
import application.model.interfaces.Inventoryable;
import application.model.interfaces.Keyedable;

public class Key extends Item implements Keyedable, Inventoryable {
	
	public Key() { super(); }
	
	public Key(String name) {
		identifier = name;
	}
	
	public Key(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;	
	}
	
	public Key(String name, String description, String information, String key) {
		this(name);
		super.description = description;
		super.information = information;	
		super.key = key;
	}

	@Override
	public void executeDrop() {
		super.executeDrop();
		
	}

	@Override
	public void executeTake() {
		super.executeTake();
		
	}

}
