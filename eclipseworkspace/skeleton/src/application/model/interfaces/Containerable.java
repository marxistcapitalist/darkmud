package application.model.interfaces;

import application.model.Item;

public interface Containerable {
	
	//for items which can contain other items
	
	public void executeInspect();
	public void executeTakeFrom(Item item);
	public void executePutIn(Item item);

}
