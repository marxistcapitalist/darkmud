package application.model.items;

import application.model.Item;
import application.model.interfaces.Inventoryable;
import application.model.interfaces.Keyedable;
import application.model.interfaces.Statusable;

public class Carpet extends Item implements Keyedable, Inventoryable, Statusable {

	public  Carpet() {
		super();
	}

	public Carpet(String name) {
		identifier = name;
	}

	public Carpet(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;
	}

	public Carpet(String name, String description, String information, String key) {
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
