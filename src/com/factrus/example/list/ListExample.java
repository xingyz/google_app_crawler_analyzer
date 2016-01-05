package com.factrus.example.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class ListExample extends Application {

	@Override public void start(Stage stage) {
        stage.setTitle("List Sample");

        ListView<String> list = new ListView<String>();
        ObservableList<String> items =FXCollections.observableArrayList (
            "Applications", "Developper", "Category", "Help");
        list.setItems(items);
        list.setPrefWidth(100);
        list.setPrefHeight(100);
        
        Scene scene  = new Scene(list,300,600);       
        stage.setScene(scene);
        stage.show();
        
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
	
	
}
