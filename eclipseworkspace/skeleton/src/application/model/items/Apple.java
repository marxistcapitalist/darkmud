package application.model.items;

import application.MapManager;
import application.model.Item;
import application.model.interfaces.Consumable;
import application.model.interfaces.Inventoryable;

public class Apple extends Item implements Inventoryable, Consumable {
	
	private int health;
	
	public Apple() { super(); }
	
	public Apple(String name) {
		identifier = name;
	}
	
	public Apple(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;
		this.health = 2;
	}
	
	public Apple(String name, String description, String information, int health) {
		this(name, description, information);
		this.health = health;
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
		MapManager.changeHealth(this.health);
	}

}
