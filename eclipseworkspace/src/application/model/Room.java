package application.model;

import java.util.ArrayList;
import java.util.HashMap;


import application.model.interfaces.Consumable;
import application.model.interfaces.Containerable;
import application.model.interfaces.Inventoryable;
import application.model.interfaces.Keyable;
import application.model.interfaces.Keyedable;
import application.model.interfaces.Killable;
import application.model.interfaces.Statusable;

public class Room {
	
	private String description;
	public String id;
	
	protected HashMap<String, Room> rooms;
	private ArrayList<Doorway> doorways = new ArrayList<Doorway>()  {
		@Override
		public String toString() {
			String temp = "";
			for (Doorway doorway : doorways) {
				temp = temp + doorway.getInformation() + "\n";
			}
			temp += "\n";
			return temp;
		}
	};
	
	private ArrayList<Item>items = new ArrayList<Item>() {
		@Override
		public String toString() {
			String temp = "";
			for (Item item : items) {
				temp = temp + item.description + " " + item.identifier + "\n";
			}
			return temp;
		}
	};
	
	
	public Room (HashMap<String, Room> rooms, String description) {
		this.rooms = rooms;
		this.description = description;
	}
	
	public ArrayList<String> getDoorwayInformations() {
		if (this.doorways != null) {
			ArrayList<String> temp = new ArrayList<String>();
			for (Doorway doorway : doorways) {
				if (!doorway.getInformation().equals("" ))
					temp.add(doorway.getInformation());
			}
			return temp;
		}
		return new ArrayList<String>();
	}
	
	public ArrayList<String> getDoorwayDirections() {
		if (this.doorways != null) {
			ArrayList<String> temp = new ArrayList<String>();
			for (Doorway doorway : doorways)
				temp.add(doorway.direction.toString());
			return temp;
		}
		return new ArrayList<String>();
	}
	
	public ArrayList<Item> getRoomItems() {
		if (this.items != null)
			return this.items;
		return new ArrayList<Item>();
	}

	
	
	public ArrayList<Item> getTypedItems(String classtype) {
		ArrayList<Item> temp = new ArrayList<>();
		if (this.items != null) {
			if (classtype.equalsIgnoreCase("consumable")) {
				for (Item item : this.items) {
					if (item instanceof Consumable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("containerable")) {
				for (Item item : this.items) {
					if (item instanceof Containerable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("inventoryable")) {
				for (Item item : this.items) {
					if (item instanceof Inventoryable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("keyable")) {
				for (Item item : this.items) {
					if (item instanceof Keyable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("keyedable")) {
				for (Item item : this.items) {
					if (item instanceof Keyedable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("killable")) {
				for (Item item : this.items) {
					if (item instanceof Killable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("statusable")) {
				for (Item item : this.items) {
					if (item instanceof Statusable)
						temp.add(item);
				}
			}		
		}
		return temp;
	}
	
	public String getDoorwayInformation() {
		String temp = "[";
		for (Doorway doorway : doorways) {
			temp += doorway.getDirection().toString() + ", ";
		}
		temp = temp.substring(0, temp.length()-2) + "]";
		return temp;
	}
	
	public String getVerboseInformation() {
		return doorways.toString() + items.toString();
	}
	
	public void addDoorway(Doorway doorway) {
		this.doorways.add(doorway);
	}
	
	public ArrayList<Doorway> getDoorways() {
		return this.doorways;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public String getDescription () {
		return this.description + ".";
	}
	
	public void initialize() { }
}
