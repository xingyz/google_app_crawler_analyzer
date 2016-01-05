package com.factrus.main.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

import com.factrus.main.controller.listener.menu.MenuEventHandler;


public class MainController implements Initializable {
	

	/**
	 * Menu elements
	 */
	@FXML
	private MenuItem menu_about;
	@FXML
	private MenuItem openRDFFile;
	@FXML
	private MenuItem exportToRDF;
	@FXML
	private MenuItem sortByName;
	@FXML
	private MenuItem sortByRating;
	@FXML
	private MenuItem sortByPrice;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		menu_about.setOnAction(MenuEventHandler.AboutHandler());
		openRDFFile.setOnAction(MenuEventHandler.OpenRDFFileHandler());
		exportToRDF.setOnAction(MenuEventHandler.ExportToRDFFileHandler());
		sortByName.setOnAction(MenuEventHandler.sortApplicationByNameHandler());
		sortByRating.setOnAction(MenuEventHandler.sortApplicationByRatingHandler());
		sortByPrice.setOnAction(MenuEventHandler.sortApplicationByPriceHandler());
		
	}
	 
	
}
