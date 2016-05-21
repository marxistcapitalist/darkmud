package application.view;

import application.view.LogEntry.LogType;


public abstract class Logger {
	
	public static void log (LogType type, String entry) {
		OverviewController.observableLog.add(new LogEntry(type, entry));
	}
}
