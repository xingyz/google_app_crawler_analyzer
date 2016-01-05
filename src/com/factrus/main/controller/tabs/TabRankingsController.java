package com.factrus.main.controller.tabs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class TabRankingsController  implements Initializable {

	@FXML
	private ChoiceBox rankBy;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setRankByChoiceBox();
		
	}
	
	
	
	
	private void setRankByChoiceBox(){
		ObservableList data = FXCollections.observableArrayList(
			"Developer",
			"Downloads"
		);
		rankBy.setItems(data);
		rankBy.getSelectionModel().selectFirst();
	}

}
