package application.model;

import java.util.ArrayList;

import application.MapManager;
import application.model.interfaces.Containerable;
import application.model.interfaces.Keyable;
import application.model.interfaces.Keyedable;
import application.model.interfaces.Killable;
import application.model.interfaces.Statusable;
import application.view.LogEntry.LogType;
import application.view.Logger;

public class Item {
	
	
	public String information = "normal...";
	public String identifier = "Item";
	private ArrayList<Item> children;
	public String description = "Plain";
	public String key = "";
	public boolean locked;
	
	
	public Item () {
		this.children = new ArrayList<Item>() {
			@Override
			public String toString() {
				String temp = "\n";
				for (Item item : children) {
					temp += "\t" + item.description + " " + item.identifier + "\n";
				}
				return temp;
			}
		
		};
	}

	public ArrayList<Item> getChildren() {
		return this.children;
	}
	
	public void setChildren (ArrayList<Item> children) {
		this.children = children;
	}
	
	public void addChild (Item item) {
		this.children.add(item);
	}
	
	//Inventoryable
	public void executeDrop () {
		Logger.log(LogType.ITEM, "You dropped the " + this.description + " " + this.identifier);
		MapManager.getCurrentRoom().getRoomItems().add(this);
		MapManager.getInventoryItems().remove(this);
	}
	//Inventoryable
	public void executeUse () {
		Logger.log(LogType.ITEM, "You used the " + this.description + " " + this.identifier);
	}
	public void executeUseConsumed () { 
		Logger.log(LogType.ITEM, "You used up the " + this.description + " " + this.identifier);
		MapManager.getInventoryItems().remove(this); 
		}
	public void executePutIn (Item item) { 
		Logger.log(LogType.ITEM, "You moved the " + item.identifier + " to the " + this.description + " " + this.identifier);
		this.children.add(item);
		MapManager.getInventoryItems().remove(item);
	}
	public void executeTake () { 
		Logger.log(LogType.ITEM, "You obtained the " + this.description + " " + this.identifier); 
		MapManager.getInventoryItems().add(this);
		MapManager.getCurrentRoom().getRoomItems().remove(this);
		}
	public void executeTakeFrom (Item item) { 
		Logger.log(LogType.ITEM, "You took the " + item.description + " " + item.identifier + " from the " + this.identifier);
		MapManager.getInventoryItems().add(item);
		this.children.remove(item);	
	}
	public void executeInspect () {
		if (this instanceof Containerable) {
			Logger.log(LogType.RESPONSE, "The " + this.identifier + " holds: " + this.children.toString());
			return;
		}
		if (MapManager.getInventoryItems().contains(this)) {
			Logger.log(LogType.RESPONSE, "You look at your " + this.description + " " + this.identifier + ", it " + this.information + ".");
			return;
		}
		Logger.log(LogType.RESPONSE, "You'll need to pick up the item to get a closer look!");
	}
	public void executeUsedUpon (Item item) { 
		if (item instanceof Keyedable && this instanceof Keyable) {
			if (item.key.equals(this.key)) {
				this.locked = false;
				Logger.log(LogType.RESPONSE, "You unlocked the " + this.identifier + " with the " + item.description + " " + item.identifier + ".");
				return;
			}
			Logger.log(LogType.RESPONSE, "You cannot unlock the " + this.identifier + " with this item.");
			return;
		}
		if (this instanceof Killable && item instanceof Statusable) {
			Logger.log(LogType.KILL, "You attacked the " + this.identifier + " with your " + item.description + " " + item.identifier + ", however you were hurt as well!");
			MapManager.decrementHealth();
			return;
		}
		Logger.log(LogType.RESPONSE, "You used the " + item.description + " " + item.identifier + " on the " + this.identifier);
	}
	public void executeUsedUponConsumed (Item item) { 
		if (item instanceof Keyedable && this instanceof Keyable) {
			if (item.key.equals(this.key)) {
				this.locked = false;
				Logger.log(LogType.ITEM, "The " + item.description + " " + item.identifier + " was consumed.");
				Logger.log(LogType.RESPONSE, "You unlocked the " + this.identifier + " with the " + item.description + " " + item.identifier + ".");
				MapManager.getCurrentRoom().getRoomItems().remove(item);
				return;
			}
			Logger.log(LogType.RESPONSE, "You cannot unlock the " + this.identifier + " with this item.");
			return;
		}
		if (this instanceof Killable && item instanceof Statusable) {
			Logger.log(LogType.ITEM, "The " + item.description + " " + item.identifier + " was consumed.");
			Logger.log(LogType.KILL, "You attacked the " + this.identifier + " with your " + item.description + " " + item.identifier + ", however you were hurt as well!");
			MapManager.decrementHealth();
			MapManager.getInventoryItems().remove(item);
			return;
		}
		Logger.log(LogType.ITEM, "You used the " + item.description + " " + item.identifier + " on the " + this.identifier);
	}
	public void executeThrow() { 
		Logger.log(LogType.ITEM, "You threw the " + this.identifier + " to the ground.");
		MapManager.getCurrentRoom().getRoomItems().add(this);
		MapManager.getInventoryItems().remove(this);
	}
	public void executeThrow(String target) { 
		Logger.log(LogType.ITEM, "You threw the " + this.identifier + " at the " + target + "... It clatters to the ground.");
		MapManager.getCurrentRoom().getRoomItems().add(this);
		MapManager.getInventoryItems().remove(this);
	}

}
