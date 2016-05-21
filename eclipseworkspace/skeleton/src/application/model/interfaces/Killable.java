package application.model.interfaces;

import application.model.Item;

public interface Killable {
	
	//for items which can be killed
	
	public void executeUsedUpon(Item item);
	public void executeUsedUponConsumed(Item item);

}
