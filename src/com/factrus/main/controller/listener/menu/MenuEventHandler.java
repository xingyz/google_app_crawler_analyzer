package com.factrus.main.controller.listener.menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.factrus.main.Main;
import com.factrus.main.analysis.reader.RDFReader;
import com.factrus.main.controller.tabs.TabApplicationsController;
import com.factrus.main.controller.views.TileViewController;
import com.factrus.main.helper.ApplicationSort;
import com.factrus.main.model.Application;
import com.factrus.main.scrapper.scrapper.ScrapperFacade;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MenuEventHandler {

	/**
	 * Menu > Help > About
	 * 
	 * @return aboutHandler
	 */
	public static EventHandler<ActionEvent> AboutHandler(){
		EventHandler<ActionEvent> aboutHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showStage();
			}
		};
		return aboutHandler;
	}

	/**
	 * Menu > File > openCSV
	 * 
	 * @return openCSVHandler
	 */
	public static EventHandler<ActionEvent> OpenRDFFileHandler() {
		EventHandler<ActionEvent> openFileHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				List<Application> apps = setupApplications();
				notifyAllObservers(apps);
			}
		};
		return openFileHandler;
	}
	
	/**
	 * Menu > File > Export RDF
	 * 
	 * @return aboutHandler
	 */
	public static EventHandler<ActionEvent> ExportToRDFFileHandler() {
		EventHandler<ActionEvent> exportToRDFHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String rdfPath = "src/com/factrus/resources/output.rdf";
				try {
					java.awt.Desktop.getDesktop().open(new File(rdfPath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		return exportToRDFHandler;
	}
	
	/**
	 * Menu > Edit > Sort By Name
	 * 
	 * @return aboutHandler
	 */
	public static EventHandler<ActionEvent> sortApplicationByNameHandler() {
		EventHandler<ActionEvent> sortApplicationByNameHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ApplicationSort.sortByField(Main.applications, ApplicationSort.Field.NAME, true);
				notifyAllObservers(Main.applications);
			}
		};
		return sortApplicationByNameHandler;
	}
	
	/**
	 * Menu > Edit > Sort By Rating
	 * 
	 * @return aboutHandler
	 */
	public static EventHandler<ActionEvent> sortApplicationByRatingHandler() {
		EventHandler<ActionEvent> sortApplicationByNameHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ApplicationSort.sortByField(Main.applications, ApplicationSort.Field.RATING, true);
				notifyAllObservers(Main.applications);
			}
		};
		return sortApplicationByNameHandler;
	}
	
	/**
	 * Menu > Edit > Sort By Rating
	 * 
	 * @return aboutHandler
	 */
	public static EventHandler<ActionEvent> sortApplicationByPriceHandler() {
		EventHandler<ActionEvent> sortApplicationByNameHandler = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ApplicationSort.sortByField(Main.applications, ApplicationSort.Field.PRICE, true);
				notifyAllObservers(Main.applications);
			}
		};
		return sortApplicationByNameHandler;
	}
	
	/**
	 * Helper function to setup the applications:
	 * - Read CSV
	 * - Export to RDF
	 * - Generate application map
	 * @param primaryStage
	 */
	private static List<Application> setupApplications() {
		ScrapperFacade scrapper = new ScrapperFacade();
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("EXCEL files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
		fileChooser.setTitle("Pick a *.csv file");
		File file = fileChooser.showOpenDialog(Main.mainStage);
		
		String inputCSV  = file.getAbsolutePath().toLowerCase().replace("\\", "/");
		String cpyInputCSV = inputCSV;
		String outputRDF = cpyInputCSV.substring(0, cpyInputCSV.lastIndexOf('/')).concat("/output.rdf");
		
		List<Application> applications = FXCollections.observableArrayList();
		try {
			scrapper.scrapeData(inputCSV, outputRDF);
			applications = RDFReader.parseFile(outputRDF);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return applications;
	}
	
	private static void notifyAllObservers(List<Application> apps){
		Main.refreshApplicationList(apps);
		TileViewController.refreshApplicationList(apps);
		TabApplicationsController.refreshApplicationList(apps);
	}


	/**
	 * Menu About Pop-Up Window
	 */
	public static void showStage(){
		Stage newStage = new Stage();
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("../fxml/layout/popup/about_popup.fxml"));
			Scene scene = new Scene(root,400,230);

			newStage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newStage.show();
	}


}
