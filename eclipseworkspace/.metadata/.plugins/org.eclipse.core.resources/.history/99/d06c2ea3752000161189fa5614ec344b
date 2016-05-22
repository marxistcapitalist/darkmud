package application.model.items;

import application.MapManager;
import application.model.Item;
import application.model.interfaces.Consumable;
import application.model.interfaces.Inventoryable;

public class Apple extends Item implements Inventoryable, Consumable {
	
	public Apple() { super(); }
	
	public Apple(String name) {
		identifier = name;
	}
	
	public Apple(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;	
	}

	@Override
	public void executeDrop() {
		super.executeDrop();
	}

	@Override
	public void executeTake() { 
		super.executeTake();
	}

	@Override
	public void executeUseConsumed() {
		super.executeUseConsumed();
		if (description.equalsIgnoreCase("rotten"))
			MapManager.decrementHealth();
		else
			MapManager.incrementHealth();
	}

}
