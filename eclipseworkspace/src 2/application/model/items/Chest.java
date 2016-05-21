package application.model.items;

import application.model.Item;
import application.model.interfaces.Containerable;
import application.model.interfaces.Keyable;

public class Chest extends Item implements Containerable, Keyable {

public Chest() { super(); }
	
	public Chest(String name, Item... args) {
		identifier = name;
		for (int i = 0; i < args.length; i++) {
			super.addChild(args[i]);
		}
	}
	
	public Chest(String name, String description, Item... args) {
		this(name);
		super.description = description;
		for (int i = 0; i < args.length; i++) {
			super.addChild(args[i]);
		}
	}
	
	public Chest(String name, String description, String key, Item...args) {
		this(name);
		super.description = description;
		super.key = key;
		for (int i = 0; i < args.length; i++) {
			super.addChild(args[i]);
		}
	}

	@Override
	public void executeInspect() {
		super.executeInspect();
	}

	@Override
	public void executeTakeFrom(Item item) {
		super.executeTakeFrom(item);
	}

	@Override
	public void executePutIn(Item item) {
		super.executePutIn(item);
		
	}

}
