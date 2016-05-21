package application.view;

import javafx.scene.image.ImageView;
import application.Main;
import application.view.icons.LogResources;

public class LogEntry {

	private LogType type;
	private String entry;

	public LogEntry() {
		this.type = LogType.DEFAULT;
		this.entry = "null";
	}

	public LogEntry(LogType type, String entry) {
		this();
		this.type = type;
		this.entry = entry;
	}

	public ImageView getGraphic() {

		switch (this.type) {
		case MAZE:
			//return new ImageView(Main.class.getResource(LogResources.maze).toExternalForm());
			return new ImageView("http://i.imgur.com/rBqpFzq.png");
		case CHAT:
			//return new ImageView(Main.class.getResource(LogResources.chat).toExternalForm());
			return new ImageView("http://i.imgur.com/O8ppn2d.png");
		case ROOM:
			//return new ImageView(Main.class.getResource(LogResources.room).toExternalForm());
			return new ImageView("http://i.imgur.com/wzRdV86.png");
		case ITEM:
			//return new ImageView(Main.class.getResource(LogResources.item).toExternalForm());
			return new ImageView("http://i.imgur.com/cNbKDHj.png");
		case KILL:
			//return new ImageView(Main.class.getResource(LogResources.kill).toExternalForm());
			return new ImageView("http://i.imgur.com/1OVsl0L.gif");
		case START:
			//return new ImageView(Main.class.getResource(LogResources.start).toExternalForm());
			return new ImageView("http://i.imgur.com/luI1qIp.png");
		case END:
			//return new ImageView(Main.class.getResource(LogResources.end).toExternalForm());
			return new ImageView("http://i.imgur.com/KXey3eL.png");
		case RESPONSE:
			//return new ImageView(Main.class.getResource(LogResources.response).toExternalForm());
			return new ImageView("http://i.imgur.com/EmpGfk4.png");
		case DEFAULT:
		default:
			//return new ImageView(Main.class.getResource(LogResources.def).toExternalForm());
			return new ImageView("http://i.imgur.com/0Q154IM.png");

		}
	}

	public String getText() {
		switch (this.type) {
		case CHAT:
			return "> " + this.entry;
		case ROOM:
			return this.entry;
		case ITEM:
			return this.entry + "!!";
		case KILL:
			return this.entry;
		case START:
			return "Player has entered the maze";
		case END:
			return this.entry;
		case RESPONSE:
			return this.entry;
		case DEFAULT:
		default:
			return this.entry;

		}
	}

	public static enum LogType {
		CHAT, ROOM, ITEM, KILL, START, END, RESPONSE, DEFAULT, MAZE
	}
}