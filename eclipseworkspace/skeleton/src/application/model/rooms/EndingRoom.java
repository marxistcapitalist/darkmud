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
		
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(Bedroom.identifier), "Bedroom"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(BreadcrumbA.identifier), "BreadcrumbA"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(BreadcrumbB.identifier), "BreadcrumbB"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(BreadcrumbC.identifier), "BreadcrumbC"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(BreadcrumbD.identifier), "BreadcrumbD"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(BriarPatch.identifier), "BriarPatch"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(BrushTower.identifier), "BrushTower"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CandyHouse.identifier), "CandyHouse"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CandyKitchen.identifier), "CandyKitchen"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CandyOven.identifier), "CandyKitchenOven"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CandyStorage.identifier), "CandyStorage"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CandyYard.identifier), "CandyYard"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(Clearing.identifier), "Clearing"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ClearingE.identifier), "ClearingEast"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ClearingN.identifier), "ClearingNorth"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ClearingW.identifier), "ClearingWest"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(CrossRoads.identifier), "Crossroads"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(FlowerTrailA.identifier), "FlowerTrailA"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(FlowerTrailB.identifier), "FlowerTrailB"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(FlowerTrailC.identifier), "FlowerTrailC"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(FlowerTrailD.identifier), "FlowerTrailD"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(FlowerTrailE.identifier), "FlowerTrailE"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(FloweryField.identifier), "FloweryField"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ForestA.identifier), "ForestA"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ForestPath.identifier), "ForestPath"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(FrontYard.identifier), "FrontYard"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(GrandmaCabin.identifier), "GrandmaCabin"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(Grassland.identifier), "Grassland"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(GrueStorage.identifier), "GrueStorage"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(House.identifier), "House"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(HouseKitchen.identifier), "HouseKitchen"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(Library.identifier), "Library"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(OldStaircase.identifier), "OldStaircase"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(ToadstoolRing.identifier), "ToadstoolRing"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(WolfStomach.identifier), "WolfStomach"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(WornRoadA.identifier), "WornRoadA"));
		addDoorway(new Doorway(Direction.DOWN, this.rooms.get(WornRoadB.identifier), "WorkRoadB"));
	}

}
