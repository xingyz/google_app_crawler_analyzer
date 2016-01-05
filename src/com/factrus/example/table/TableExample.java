package com.factrus.example.table;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableExample extends Application {

	private TableView<ApplicationModel> table = new TableView<ApplicationModel>();
	
	private final ObservableList<ApplicationModel> data =
	        FXCollections.observableArrayList(
	            new ApplicationModel("AngryBird", "RoyoNova", "Game"),
	            new ApplicationModel("Facebook", "Facebook", "Social"),
	            new ApplicationModel("Twitter", "Twitter", "Social"),
	            new ApplicationModel("FourSqaures", "Devlopy", "Social"),
	            new ApplicationModel("CandyCrush", "Random", "Game")
	        );


	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(500);
        stage.setHeight(500);

		final Label label = new Label("Application Records");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		TableColumn appName = new TableColumn("App Name");
		appName.setMinWidth(150);
		appName.setCellValueFactory(
                new PropertyValueFactory<ApplicationModel, String>("name"));
		
		TableColumn appDeveloper = new TableColumn("Developer");
		appDeveloper.setMinWidth(150);
		appDeveloper.setCellValueFactory(
                new PropertyValueFactory<ApplicationModel, String>("developer"));
		
		TableColumn category = new TableColumn("Category");
		category.setMinWidth(150);
		category.setCellValueFactory(
                new PropertyValueFactory<ApplicationModel, String>("category"));
		
		table.setItems(data);
		table.getColumns().addAll(appName, appDeveloper, category);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
	}

}
