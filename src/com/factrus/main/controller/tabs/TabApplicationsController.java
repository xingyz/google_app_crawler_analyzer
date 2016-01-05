package com.factrus.main.controller.tabs;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.factrus.main.Main;
import com.factrus.main.controller.listener.search.SearchEventHandler;
import com.factrus.main.custom.AutoCompleteComboBoxListener;
import com.factrus.main.model.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class TabApplicationsController  implements Initializable {

	@FXML
	private static ComboBox<Application> searchApp;
	private static ObservableList<Application> applicationNameList;
	
	private static AutoCompleteComboBoxListener<Object> aux;
	
	private static List<Application> applications;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Load applications
		applications = Main.applications;
		if(null == applications){
			applications = FXCollections.observableArrayList();
		}
		
		applicationNameList = FXCollections.observableArrayList();
		searchApp = new ComboBox<>();
		
		// Set list of applications
		setListOfApplications(applications);
	}
	
	public static void setListOfApplications(List<Application> applications){
		applicationNameList.clear();
		searchApp.getItems().clear();
		for(Application app: applications){
			applicationNameList.add(app);
		}
		searchApp.setItems(applicationNameList);
		searchApp.setOnAction(SearchEventHandler.newSearchEventHandler(searchApp));
		aux = new AutoCompleteComboBoxListener<Object>(searchApp);
	}

	public static void refreshApplicationList(List<Application> apps) {
		applications = apps;
		setListOfApplications(applications);
	}
	
	

}

