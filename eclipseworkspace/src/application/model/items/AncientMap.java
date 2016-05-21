package application.model.items;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import application.model.Item;
import application.model.interfaces.Inventoryable;
import application.view.Logger;
import application.view.LogEntry.LogType;

public class AncientMap extends Item implements Inventoryable{
	
public AncientMap() { super(); }
	
	public AncientMap(String name) {
		identifier = name;
	}
	
	public AncientMap(String name, String description, String information) {
		this(name);
		super.description = description;
		super.information = information;	
	}
	
	public AncientMap(String name, String description, String information, String key) {
		this(name);
		super.description = description;
		super.information = information;	
		super.key = key;
	}

	@Override
	public void executeDrop() {
		Logger.log(LogType.RESPONSE, "You cannot drop this item.");
		
	}

	@Override
	public void executeUse() {
		super.executeUse();
		try {
			Desktop.getDesktop().browse(new URI("http://i.imgur.com/2pNUncP.gif"));
		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
