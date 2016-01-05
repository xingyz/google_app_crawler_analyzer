package com.factrus.main.controller.listener.search;

import com.factrus.main.Main;
import com.factrus.main.controller.listener.view.ApplicationTileEventHandler;
import com.factrus.main.model.Application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;

public class SearchEventHandler {

	// Will be set when view is loaded
	private static ScrollPane appScrollPane;
	
	public static EventHandler newSearchEventHandler(final ComboBox combobox){
		return new EventHandler() {
			@Override
			public void handle(Event t) {
				System.out.println(t.getEventType());
				// Get Application
				String appName  = combobox.getSelectionModel().selectedItemProperty().getValue().toString();
				
				if(null != appName){
					Application app = Main.appMap.get(appName);
					
					ApplicationTileEventHandler.populateApplicationData(app);
					hideApplicationListView();
				}
			}
		};
	}
	
	public static void setAppScrollPane(ScrollPane pane){
		appScrollPane = pane;
	}
	
	private static void hideApplicationListView() {
		appScrollPane.toBack();
	}
	
}
