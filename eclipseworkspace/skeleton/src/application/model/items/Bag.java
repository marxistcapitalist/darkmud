package application.model.items;

import application.model.Item;
import application.model.interfaces.Containerable;
import application.model.interfaces.Inventoryable;

public class Bag extends Item implements Containerable, Inventoryable{

	public Bag () { super(); }
	
	public Bag(String name, Item... args) {
		identifier = name;
		for (int i = 0; i < args.length; i++) {
			super.addChild(args[i]);
		}
	}
	
	public Bag(String name, String description, Item... args) {
		this(name);
		super.description = description;
		for (int i = 0; i < args.length; i++) {
			super.addChild(args[i]);
		}
	}
	
	public Bag(String name, String description, String key, Item...args) {
		this(name);
		super.description = description;
		super.key = key;
		for (int i = 0; i < args.length; i++) {
			super.addChild(args[i]);
		}
	}

}
