package application.model.input;

import java.util.ArrayList;
import java.util.Arrays;

import application.Main;
import application.MapManager;
import application.model.Doorway;
import application.model.Item;
import application.model.interfaces.Consumable;
import application.view.LogEntry.LogType;
import application.view.Logger;
import application.view.OverviewController;

public abstract class SmartParser {
	
	private static final String GO = "GO";
	private static final String IN = "IN";
	private static final String TAKE = "TAKE";
	private static final String PICK = "PICK";
	private static final String UP = "UP";
	private static final String DROP = "DROP";
	private static final String USE = "USE";
	private static final String ON = "ON";
	private static final String REST = "REST";
	private static final String PUT = "PUT";
	private static final String INSPECT = "INSPECT";
	private static final String FROM = "FROM";
	private static final String RESTART = "RESTART";
	private static final String QUIT = "QUIT";
	private static final String HELP = "HELP";
	private static final String THROW = "THROW";
	private static final String INVENTORY = "INVENTORY";
	private static final String AT = "AT";
	private static final String ALL = "ALL";
	private static final String EVERYTHING = "EVERYTHING";
	private static final String ROOM = "ROOM";
	private static final String OUT = "OUT";
	private static final String DOWN = "DOWN";
	
	private static final ArrayList<String> KEY_WORDS = new ArrayList<>(Arrays.asList(
			"GO", "TAKE", "PICK", "DROP", "USE","REST", "PUT", "INSPECT", 
			"RESTART", "QUIT", "HELP", "THROW", "INVENTORY", "ALL", "EVERYTHING", "ROOM" ));

	private static final ArrayList<String> IGNORED_WORDS = new ArrayList<>(Arrays.asList(
			"THE", "A", "ONE", "OF", "THAT", "THIS", "PLEASE", "NO","OVER", "THERE", "AND", "TO"));
	
	public static void parse (String input) {
		
		Logger.log(LogType.CHAT, input);
		input = input.toUpperCase() + " ";
		ArrayList<String> splitInput = new ArrayList<String>();
		while (input.length() > 1) {
			if (!IGNORED_WORDS.contains(input.substring(0, input.indexOf(" "))))
				splitInput.add(input.substring(0, input.indexOf(" ")));
			input = input.substring(input.indexOf(" ") + 1, input.length());
			System.out.print("looping");
		}
		for (int i = splitInput.size() - 1; i > 1; i--) {
			if (KEY_WORDS.contains(splitInput.get(i)))
				splitInput.remove(i);
		}
		System.out.println(splitInput);
		matcher(splitInput);
	}
	
	private static void matcher (ArrayList<String> input) {
		switch(input.get(0)) {
		case GO:
			switch (input.size()) {
			case 1:
				Logger.log(LogType.DEFAULT, "You must supply a direction.");
				return;
			case 2:
				for (Doorway doorway : MapManager.getCurrentRoom().getDoorways()) {
					if (input.get(1).contains(doorway.getDirection().toString().toUpperCase())) {
						if (doorway.islocked) {
							Logger.log(LogType.RESPONSE, "This way is currently impassable!");
							return;
						}
						MapManager.movePlayer(doorway.getLeadsTo());
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "You can't go that way, silly!");
				return;
			case 3:
				if (input.get(1).equals(IN) || input.get(1).equals(UP) || input.get(1).equals(OUT) || input.get(1).equals(DOWN)) {
					for (Doorway doorway : MapManager.getCurrentRoom().getDoorways()) {
						if (doorway.getInformation().toUpperCase().contains(input.get(2))) {
							if (doorway.islocked) {
								if(doorway.key.equals("treeclimber")) {
									Logger.log(LogType.RESPONSE, "You'll need something to climb this!");
									return;
								}
								if (doorway.key.equals("housecarpet")) {
									Logger.log(LogType.RESPONSE, "Try moving the carpet first, idiot...");
									return;
								}
								Logger.log(LogType.RESPONSE, "The " + doorway.getInformation().substring(0, doorway.getInformation().indexOf(" - ")) + " is locked :(");
								return;
							}
							MapManager.movePlayer(doorway.getLeadsTo());
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There's nowhere to go in!");
					return;
				}
				Logger.log(LogType.DEFAULT, "Go where?");
				return;
			}
			error();
			return;
		case PICK:
			input.remove(0);
			input.add(0, TAKE);
			if (input.get(1).equals(UP))
				input.remove(1);
		case TAKE:
			switch (input.size()) {
			case 1:
				Logger.log(LogType.DEFAULT, "Take What?");
				return;
			case 2:
				if (input.get(1).equals(ALL) || input.get(1).equals(EVERYTHING)) {
					if (!MapManager.getCurrentRoom().getTypedItems("Inventoryable").isEmpty()) {
						for (Item item : MapManager.getCurrentRoom().getTypedItems("Inventoryable")) {
							item.executeTake();
						}
						return;
					}
					Logger.log(LogType.RESPONSE, "There's nothing in this room that you can pick up!");
					return;
				}
				for (Item item : MapManager.getCurrentRoom().getTypedItems("Inventoryable")) {
					if (item.identifier.equalsIgnoreCase(input.get(1))) {
						item.executeTake();
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "I don't see any " + input.get(1) + " that you can pick up?");
				return;
			case 3:
				for (Item item : MapManager.getCurrentRoom().getTypedItems("Inventoryable")) {
					if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
						item.executeTake();
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "I don't see any " + input.get(1) + " " + input.get(2) + ".");
				return;
			case 4:
				if (input.get(2).equals(FROM)) {
					for (Item container : MapManager.getCurrentRoom().getTypedItems("Containerable")) {
						if (container.identifier.equalsIgnoreCase(input.get(3))) {
							for (Item item : container.getChildren()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									container.executeTakeFrom(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "I don't see any " + input.get(1) + " in this " + input.get(3) + "...");
							return;
						}
					}
					for (Item container : MapManager.getTypedInventoryItems("Containerable")) {
						if (container.identifier.equalsIgnoreCase(input.get(3))) {
							for (Item item : container.getChildren()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									container.executeTakeFrom(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "I don't see any " + input.get(1) + " in this " + input.get(3) + "...");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There doesn't seem to be a " + input.get(3) + " here...");
					return;
				}
				error();
				return;
			case 5:
				if (input.get(2).equals(FROM)) {
					for (Item container : MapManager.getCurrentRoom().getTypedItems("Containerable")) {
						if (container.description.equalsIgnoreCase(input.get(3)) && container.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : container.getChildren()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									container.executeTakeFrom(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "I don't see any " + input.get(1) + " in this " + input.get(3) + input.get(4) + "...");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There doesn't seem to be a " + input.get(3) + " " + input.get(4) + " here...");
					return;
				}else if (input.get(3).equals(FROM)) {
					for (Item container : MapManager.getCurrentRoom().getTypedItems("Containerable")) {
						if (container.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : container.getChildren()) {
								if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
									container.executeTakeFrom(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "I don't see any " + input.get(1) + " " + input.get(2) + " in this " + input.get(4) + "...");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There doesn't seem to be a " + input.get(4) + " here...");
					return;
				}
				error();
				return;
			case 6: 
				if (input.get(3).equals(FROM)) {
					for (Item container : MapManager.getCurrentRoom().getTypedItems("Containerable")) {
						if (container.description.equalsIgnoreCase(input.get(4)) && container.identifier.equalsIgnoreCase(input.get(5))) {
							for (Item item : container.getChildren()) {
								if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
									container.executeTakeFrom(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "I don't see any " + input.get(1) + " " + input.get(2) + " in this " + input.get(4) + input.get(5) + "...");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There doesn't seem to be a " + input.get(4) + " " + input.get(5) + " here...");
					return;
				}
				error();
				return;
			}
			error();
			return;
		case THROW:
			switch (input.size()) {
			case 1:
				Logger.log(LogType.RESPONSE, "You flail wildly at the air.");
				return;
			case 2:
				for (Item item : MapManager.getInventoryItems()) {
					if (item.identifier.equalsIgnoreCase(input.get(1))) {
						item.executeThrow();
						return;
					}
				}
				error();
				return;
			case 3:
				for (Item item : MapManager.getInventoryItems()) {
					if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
						item.executeThrow();
						return;
					}
				}
				error();
				return;
			case 4:
				if (input.get(2).equals(AT)) {
					for (Item roomitem : MapManager.getCurrentRoom().getRoomItems()) {
						if (roomitem.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									item.executeThrow(roomitem.identifier);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + "!");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "You can't throw at something that doesn't exist...");
					return;
				}
				error();
				return;
			case 5:
				if (input.get(2).equals(AT)) {
					for (Item roomitem : MapManager.getCurrentRoom().getRoomItems()) {
						if (roomitem.description.equalsIgnoreCase(input.get(3)) && roomitem.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									item.executeThrow(roomitem.description + " " + roomitem.identifier);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any" + input.get(1) + " !");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "You can't throw at something that doesn't exist...");
					return;
				}else if (input.get(3).equals(AT)) {
					for (Item roomitem : MapManager.getCurrentRoom().getRoomItems()) {
						if (roomitem.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
									item.executeThrow(roomitem.identifier);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any" + input.get(1) + input.get(2) + " !");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "You can't throw at something that doesn't exist...");
					return;
				}
				error();
				return;
			case 6:
				if (input.get(3).equals(AT)) {
					for (Item roomitem : MapManager.getCurrentRoom().getRoomItems()) {
						if (roomitem.description.equalsIgnoreCase(input.get(4)) && roomitem.identifier.equalsIgnoreCase(input.get(5))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
									item.executeThrow(roomitem.description + " " + roomitem.identifier);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any" + input.get(1) + input.get(2) + " !");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "You can't throw at something that doesn't exist...");
					return;
				}
				error();
				return;
			}
			error();
			return;
		case DROP:
			switch (input.size()) {
			case 1: 
				Logger.log(LogType.DEFAULT, "*Drops the bass*");
				return;
			case 2:
				if (input.get(1).equals(ALL) || input.get(1).equals(EVERYTHING)) {
					if (!MapManager.getInventoryItems().isEmpty()) {
						for (int i = MapManager.getInventoryItems().size() -1 ; i >= 0; i--) {
							MapManager.getInventoryItems().get(i).executeDrop();
						}
						return;
					}
					Logger.log(LogType.RESPONSE, "You have nothing with you to drop!");
					return;
				}
				for (Item item : MapManager.getInventoryItems()) {
					if (item.identifier.equalsIgnoreCase(input.get(1))) {
						item.executeDrop();
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "You don't have any" + input.get(1) + " !");
				return;
			case 3:
				for (Item item : MapManager.getInventoryItems()) {
					if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
						item.executeDrop();
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "You don't have any" + input.get(1) + input.get(2) + " !");
				return;
			}
			if (input.size() < 4) {
				error();
				return;
			}
			input.remove(0);
			input.add(0, PUT);
		case PUT:
			switch (input.size()) {
			case 1:
				Logger.log(LogType.RESPONSE, "What?");
				return;
			case 2:
				Logger.log(LogType.RESPONSE, "Put it what?");
				return;
			case 3:
				Logger.log(LogType.RESPONSE, "Where?");
				return;
			case 4:
				if (input.get(2).equals(IN) || input.get(2).equals(ON)) {
					for (Item container : MapManager.getCurrentRoom().getTypedItems("Containerable")) {
						if (container.identifier.equalsIgnoreCase(input.get(3))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									container.executePutIn(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + ".");
							return;
						}
					}
					for (Item container : MapManager.getTypedInventoryItems("Containerable")) {
						if (container.identifier.equalsIgnoreCase(input.get(3))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									container.executePutIn(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + ".");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There doesn't seem to be a " + input.get(3) + " here...");
					return;
				}
				error();
				return;
			case 5:
				if (input.get(2).equals(IN) || input.get(2).equals(ON)) {
					for (Item container : MapManager.getCurrentRoom().getTypedItems("Containerable")) {
						if (container.description.equalsIgnoreCase(input.get(3)) && container.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									container.executePutIn(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + ".");
							return;
						}
					}
					for (Item container : MapManager.getTypedInventoryItems("Containerable")) {
						if (container.description.equalsIgnoreCase(input.get(3)) && container.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.identifier.equalsIgnoreCase(input.get(1))) {
									container.executePutIn(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + ".");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There doesn't seem to be a " + input.get(3) + " " + input.get(4) + " here...");
					return;
				}else if (input.get(3).equals(IN) || input.get(3).equals(ON)) {
					for (Item container : MapManager.getCurrentRoom().getTypedItems("Containerable")) {
						if (container.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
									container.executePutIn(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + " " + input.get(2) + ".");
							return;
						}
					}
					for (Item container : MapManager.getTypedInventoryItems("Containerable")) {
						if (container.identifier.equalsIgnoreCase(input.get(4))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
									container.executePutIn(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + " " + input.get(2) + ".");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There doesn't seem to be a " + input.get(4) + " here...");
					return;
				}
				error();
				return;
			case 6: 
				if (input.get(3).equals(IN) || input.get(3).equals(ON)) {
					for (Item container : MapManager.getCurrentRoom().getTypedItems("Containerable")) {
						if (container.description.equalsIgnoreCase(input.get(4)) && container.identifier.equalsIgnoreCase(input.get(5))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
									container.executePutIn(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + " " + input.get(2) + ".");
							return;
						}
					}
					for (Item container : MapManager.getTypedInventoryItems("Containerable")) {
						if (container.description.equalsIgnoreCase(input.get(4)) && container.identifier.equalsIgnoreCase(input.get(5))) {
							for (Item item : MapManager.getInventoryItems()) {
								if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
									container.executePutIn(item);
									return;
								}
							}
							Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + " " + input.get(2) + ".");
							return;
						}
					}
					Logger.log(LogType.DEFAULT, "There doesn't seem to be a " + input.get(4) + input.get(5) + " here...");
					return;
				}
				error();
				return;
			}
			error();
			return;
		case USE:
			switch (input.size()) {
			case 2:
				for (Item item : MapManager.getInventoryItems()) {
					if (item.identifier.equalsIgnoreCase(input.get(1))) {
						if (item instanceof Consumable) {
							item.executeUseConsumed();
							return;
						}
						item.executeUse();
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + ".");
				return;
			case 3:
				for (Item item : MapManager.getInventoryItems()) {
					if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
						if (item instanceof Consumable) {
							item.executeUseConsumed();
							return;
						}
						item.executeUse();
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "You don't have any " + input.get(1) + ".");
				return;
			case 4:
				if (input.get(2).equals(ON)) {
					for (Item item : MapManager.getInventoryItems()) {
						for (Item roomitem : MapManager.getCurrentRoom().getRoomItems()) {
							if (item.identifier.equalsIgnoreCase(input.get(1)) && roomitem.identifier.equalsIgnoreCase(input.get(3))) {
								if (item instanceof Consumable) {
									roomitem.executeUsedUponConsumed(item);
									return;
								}
								roomitem.executeUsedUpon(item);
								return;
							}
						}
						for (Doorway doorway : MapManager.getCurrentRoom().getDoorways()) {
							if (item.identifier.equalsIgnoreCase(input.get(1)) && doorway.getInformation().toUpperCase().contains(input.get(3))) {
								if (item instanceof Consumable) {
									doorway.unlockItemConsumed(item);
									return;
								}
								doorway.unlock(item);
								return;
							}
						}
						
					}
					Logger.log(LogType.DEFAULT, "You can't perform an action on a non-existant object!");
					return;
				}
				error();
				return;
			case 5:
				if (input.get(2).equals(ON)) {
					for (Item item : MapManager.getInventoryItems()) {
						for (Item roomitem : MapManager.getCurrentRoom().getRoomItems()) {
							if (item.identifier.equalsIgnoreCase(input.get(1)) && roomitem.description.equalsIgnoreCase(input.get(3)) && roomitem.identifier.equalsIgnoreCase(input.get(4))) {
								if (item instanceof Consumable) {
									roomitem.executeUsedUponConsumed(item);
									return;
								}
								roomitem.executeUsedUpon(item);
								return;
							}
						}
					}
					Logger.log(LogType.DEFAULT, "You can't perform an action on a non-existant object!");
					return;
				} else if (input.get(3).equals(ON)) {
					for (Item item : MapManager.getInventoryItems()) {
						for (Item roomitem : MapManager.getCurrentRoom().getRoomItems()) {
							if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2)) && roomitem.identifier.equalsIgnoreCase(input.get(4))) {
								if (item instanceof Consumable) {
									roomitem.executeUsedUponConsumed(item);
									return;
								}
								roomitem.executeUsedUpon(item);
								return;
							}
						}
					}
					for (Item item : MapManager.getInventoryItems()) {
						for (Doorway doorway : MapManager.getCurrentRoom().getDoorways()) {
							if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2)) && doorway.getInformation().toUpperCase().contains(input.get(4))) {
								if (item instanceof Consumable) {
									doorway.unlockItemConsumed(item);
									return;
								}
								doorway.unlock(item);
								return;
							}
						}
					}
					Logger.log(LogType.DEFAULT, "You can't perform an action on a non-existant object!");
					return;
				} else 
				error();
				return;
			case 6: 
				if (input.get(3).equals(ON)) {
					for (Item item : MapManager.getInventoryItems()) {
						for (Item roomitem : MapManager.getCurrentRoom().getRoomItems()) {
							if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2)) && roomitem.description.equalsIgnoreCase(input.get(4)) && roomitem.identifier.equalsIgnoreCase(input.get(5))) {
								if (item instanceof Consumable) {
									roomitem.executeUsedUponConsumed(item);
									return;
								}
								roomitem.executeUsedUpon(item);
								return;
							}
						}
					}
					Logger.log(LogType.DEFAULT, "You can't perform an action on a non-existant object!");
					return;
				}
				error();
				return;
			}
			error();
			return;
		case INSPECT:
			switch (input.size()) {
			case 1:
				Logger.log(LogType.DEFAULT, "I need something to inspect...");
				return;
			case 2:
				if (input.get(1).equals(ROOM)) {
					Logger.log(LogType.RESPONSE, MapManager.getCurrentRoom().getVerboseInformation());
					return;
				}
				for (Item item : MapManager.getInventoryItems()) {
					if (item.identifier.equalsIgnoreCase(input.get(1))) {
						item.executeInspect();
						return;
					}
				}
				for (Item item : MapManager.getCurrentRoom().getRoomItems()) {
					if (item.identifier.equalsIgnoreCase(input.get(1))) {
						item.executeInspect();
						return;
					}
				}
				for (Doorway doorway : MapManager.getCurrentRoom().getDoorways()) {
					if (doorway.getInformation().equalsIgnoreCase(input.get(1))) {
						doorway.executeInspect();
						return;
					}
				}
				for (Doorway doorway : MapManager.getCurrentRoom().getDoorways()) {
					if (doorway.getInformation().contains(" - ") && doorway.getInformation().substring(0, doorway.getInformation().indexOf(" - ")).equalsIgnoreCase(input.get(1))) {
						doorway.executeInspect();
						return;
					}
				}
				for (Doorway doorway : MapManager.getCurrentRoom().getDoorways()) {
					if (doorway.getDirection().toString().equalsIgnoreCase(input.get(1))) {
						doorway.executeInspect();
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "I don't see a " + input.get(1) + " anywhere?");
				return;
			case 3:
				for (Item item : MapManager.getInventoryItems()) {
					if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
						item.executeInspect();
						return;
					}
				}
				for (Item item : MapManager.getCurrentRoom().getRoomItems()) {
					if (item.description.equalsIgnoreCase(input.get(1)) && item.identifier.equalsIgnoreCase(input.get(2))) {
						item.executeInspect();
						return;
					}
				}
				Logger.log(LogType.DEFAULT, "I don't see a " + input.get(1) + " anywhere?");
				return;
			}
			error();
			return;
		case REST:
			input.remove(0);
			input.add(0, INVENTORY);
		case INVENTORY:
			Logger.log(LogType.RESPONSE, "Room: " + MapManager.getCurrentRoomName() + "\nStatus: " + MapManager.getHealth() + "\nInventory: " + MapManager.getInventoryItems().toString());
			return;
		case RESTART:
			Logger.log(LogType.END, "You have left the game!");
			Logger.log(LogType.START, "You have entered the game!");
			OverviewController.resetGame();
			return;
		case HELP:
			OverviewController.observableLog.remove(OverviewController.observableLog.size() -1);
			OverviewController.paneReference.getSelectionModel().select(OverviewController.helpReference);
			return;
		case QUIT:
			Logger.log(LogType.END, "Quitting the game...");
			Main.getPrimaryStage().close();
			break;
		default:
			error();
			break;
		}		
	}

	private static void error() {
		Logger.log(LogType.DEFAULT, "I don't understand");
	}
	
	

}
