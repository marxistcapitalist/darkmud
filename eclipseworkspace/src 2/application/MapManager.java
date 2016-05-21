package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

import application.model.Item;
import application.model.Room;
import application.model.interfaces.Consumable;
import application.model.interfaces.Containerable;
import application.model.interfaces.Inventoryable;
import application.model.interfaces.Keyable;
import application.model.interfaces.Keyedable;
import application.model.interfaces.Killable;
import application.model.interfaces.Statusable;
import application.model.rooms.BehindHouse;
import application.model.rooms.CanyonBottom;
import application.model.rooms.CanyonView;
import application.model.rooms.Cellar;
import application.model.rooms.ClearingEast;
import application.model.rooms.ClearingNorth;
import application.model.rooms.EndOfRainbow;
import application.model.rooms.EndingRoom;
import application.model.rooms.ForestEast;
import application.model.rooms.ForestNorth;
import application.model.rooms.ForestPath;
import application.model.rooms.ForestSouth;
import application.model.rooms.ForestWest;
import application.model.rooms.GratingRoom;
import application.model.rooms.HalcyonFalls;
import application.model.rooms.HouseAttic;
import application.model.rooms.HouseDining;
import application.model.rooms.HouseLiving;
import application.model.rooms.NorthOfHouse;
import application.model.rooms.OnTheRainbow;
import application.model.rooms.RockyLedge;
import application.model.rooms.SouthOfHouse;
import application.model.rooms.StoneBarrow;
import application.model.rooms.UpATree;
import application.model.rooms.WestOfHouse;
import application.view.LogEntry.LogType;
import application.view.Logger;

public class MapManager {
	
	private static String room = "WestOfHouse";
	private static Health health = Health.HEALTHY;
	
	private static ArrayList<Item> inventory = new ArrayList<Item>() {
		@Override
		public String toString() {
			String temp = "\n";
			for (Item item : inventory) {
				temp += "\t" + item.description + " " + item.identifier + "\n";
			}
			return temp;
		}
	};
	
	
	private static HashMap<String, Room> rooms = new HashMap<String, Room>();
	
	public enum Health {
		HEALTHY ("Healthy"), HURT ("Hurt"), WOUNDED ("Wounded"), DEAD ("Dead");
		
		private String status;
		
		Health(String status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
			return this.status;
		}
	}
	
	public MapManager () throws InterruptedException {
		room = "WestOfHouse";
		health = Health.HEALTHY;
		inventory.clear();
		rooms.clear();
		
		rooms.put(BehindHouse.identifier, new BehindHouse(rooms));
		rooms.put(CanyonBottom.identifier, new CanyonBottom(rooms));
		rooms.put(CanyonView.identifier, new CanyonView(rooms));
		rooms.put(Cellar.identifier, new Cellar(rooms));
		rooms.put(ClearingEast.identifier, new ClearingEast(rooms));
		rooms.put(ClearingNorth.identifier, new ClearingNorth(rooms));
		rooms.put(EndOfRainbow.identifier, new EndOfRainbow(rooms));
		rooms.put(ForestEast.identifier, new ForestEast(rooms));
		rooms.put(ForestNorth.identifier, new ForestNorth(rooms));
		rooms.put(ForestPath.identifier, new ForestPath(rooms));
		rooms.put(ForestSouth.identifier, new ForestSouth(rooms));
		rooms.put(ForestWest.identifier, new ForestWest(rooms));
		rooms.put(GratingRoom.identifier, new GratingRoom(rooms));
		rooms.put(HalcyonFalls.identifier, new HalcyonFalls(rooms));
		rooms.put(HouseAttic.identifier, new HouseAttic(rooms));
		rooms.put(HouseDining.identifier, new HouseDining(rooms));
		rooms.put(HouseLiving.identifier, new HouseLiving(rooms));
		rooms.put(NorthOfHouse.identifier, new NorthOfHouse(rooms));
		rooms.put(OnTheRainbow.identifier, new OnTheRainbow(rooms));
		rooms.put(RockyLedge.identifier, new RockyLedge(rooms));
		rooms.put(SouthOfHouse.identifier, new SouthOfHouse(rooms));
		rooms.put(StoneBarrow.identifier, new StoneBarrow(rooms));
		rooms.put(UpATree.identifier, new UpATree(rooms));
		rooms.put(WestOfHouse.identifier, new WestOfHouse(rooms));
		rooms.put(EndingRoom.identifier, new EndingRoom(rooms));
		
		for (Entry<String, Room> room : rooms.entrySet()) {
			room.getValue().initialize();
		}
		
		Logger.log(LogType.ROOM, "You awake in the world, standing just west of a quaint, white house...");
		Logger.log(LogType.RESPONSE, "You can go: " + getCurrentRoom().getDoorwayDirections());

	}

	public static Room getCurrentRoom () {
		return rooms.get(room);
	}
	
	public static ArrayList<Item> getInventoryItems() {
		return inventory;
	}
	
	public static String getCurrentRoomName() {
		return room;
	}
	
	public static String getHealth() {
		return health.toString();
	}
	
	public static void incrementHealth() {
		switch (health) {
		case HEALTHY:
			Logger.log(LogType.RESPONSE, "You were already at full health");
			break;
		case HURT:
			Logger.log(LogType.RESPONSE, "Status increased to HEALTHY");
			health = Health.HEALTHY;
			break;
		case WOUNDED:
			Logger.log(LogType.RESPONSE, "Status increased to HURT");
			health = Health.HURT;
			break;
		case DEAD:
			Logger.log(LogType.RESPONSE, "You are already dead... you lost.");
			break;
		}
	}
	
	public static void decrementHealth() {
		switch (health) {
		case DEAD: 
			Logger.log(LogType.RESPONSE, "Your dead body loses even more life... somehow.");
			break;
		case WOUNDED:
			Logger.log(LogType.RESPONSE, "Your status was reduced to DEAD.");
			health = Health.DEAD;
			break;
		case HURT:
			Logger.log(LogType.RESPONSE, "Your status was reduced to WOUNDED.");
			health = Health.WOUNDED;
			break;
		case HEALTHY:
			Logger.log(LogType.RESPONSE, "Your status was reduced to HURT.");
			health = Health.HURT;
			break;
		}
	}


	public static ArrayList<Item> getTypedInventoryItems(String classtype) {
		ArrayList<Item> temp = new ArrayList<>();
		if (inventory != null) {
			if (classtype.equalsIgnoreCase("consumable")) {
				for (Item item : inventory) {
					if (item instanceof Consumable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("containerable")) {
				for (Item item : inventory) {
					if (item instanceof Containerable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("inventoryable")) {
				for (Item item : inventory) {
					if (item instanceof Inventoryable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("keyable")) {
				for (Item item : inventory) {
					if (item instanceof Keyable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("keyedable")) {
				for (Item item : inventory) {
					if (item instanceof Keyedable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("killable")) {
				for (Item item : inventory) {
					if (item instanceof Killable)
						temp.add(item);
				}
			}
			if (classtype.equalsIgnoreCase("statusable")) {
				for (Item item : inventory) {
					if (item instanceof Statusable)
						temp.add(item);
				}
			}		
		}
		return temp;
	}
	
	public static void movePlayer(Room leadsTo) {
		room = leadsTo.id;
		Logger.log(LogType.ROOM, leadsTo.getDescription());
		Logger.log(LogType.RESPONSE, "You can go: " + rooms.get(room).getDoorwayInformation());
	}
	
	public static void moveOnWin() {
		room = "EndingRoom";
		Logger.log(LogType.ROOM, rooms.get(room).getDescription());
		Logger.log(LogType.END, "You have won the game!");
	}
	
	public static Collection<Room> getAllRoomsUnnamed() {
		return rooms.values();
	}
}