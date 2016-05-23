package application.model.rooms;

import java.util.HashMap;

import application.model.Doorway;
import application.model.Room;
import application.model.Doorway.Direction;
import application.model.items.AncientMap;

public class EndingRoom extends Room {

	public static String identifier = "EndingRoom";

	public EndingRoom (HashMap<String, Room> rooms) { 
		super(rooms, "Congratulations! Welcome to THE END! From here you may descend to any location on the map!");
		super.id = identifier;
	}
	
	@Override public void initialize () {
		addItem(new AncientMap("Map","Etherial", "weighs almost nothing and is translucent"));
		
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(HouseAttic.identifier), "Attic"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(BehindHouse.identifier), "Behind-House"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CanyonBottom.identifier), "Bottom-Of-Canyon"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(Cellar.identifier), "Cellar"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ClearingEast.identifier), "Eastern-Clearing"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ForestEast.identifier), "Eastern-Forest"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(EndOfRainbow.identifier), "End-Of-The-Rainbow"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ForestPath.identifier), "Forested-Path"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(GratingRoom.identifier), "Grating-Room"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(HouseDining.identifier), "Kitchen"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(HouseLiving.identifier), "Living-Room"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(NorthOfHouse.identifier), "North-Of-House"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ClearingNorth.identifier), "Northern-Clearing"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ForestNorth.identifier), "Northern-Forest"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(OnTheRainbow.identifier), "On-The-Rainbow"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(RockyLedge.identifier), "Rocky-Ledge"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(SouthOfHouse.identifier), "South-Of-House"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ForestSouth.identifier), "Southern-Forest"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(StoneBarrow.identifier), "Stone-Barrow"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(HalcyonFalls.identifier), "The-Halcyon-Falls"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(UpATree.identifier), "Up-A-Tree"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CanyonView.identifier), "View-Of-Canyon"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(WestOfHouse.identifier), "West-Of-House"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ForestWest.identifier), "Western-Forest"));
	}

}
