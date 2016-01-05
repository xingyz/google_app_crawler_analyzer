package com.factrus.main;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.factrus.main.analysis.reader.RDFReader;
import com.factrus.main.scrapper.scrapper.ScrapperFacade;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {

	public static List<com.factrus.main.model.Application> applications;
	public static Map<String,com.factrus.main.model.Application> appMap;
	public static Stage mainStage;
	
	@Override
	public void start(Stage primaryStage) {
		mainStage = primaryStage;
		
		// Setup applications from file picker
		setupApplications(primaryStage);

		try {
			Parent root = FXMLLoader.load(getClass().getResource("../fxml/layout/Main.fxml"));
			Scene scene = new Scene(root,1080,800);

			// Link stylesheets
			scene.getStylesheets().add(getClass().getResource("../fxml/styles/main.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("FactrUs");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Helper function to setup the applications:
	 * - Read CSV
	 * - Export to RDF
	 * - Generate application map
	 * @param primaryStage
	 */
	private void setupApplications(Stage primaryStage) {
		ScrapperFacade scrapper = new ScrapperFacade();
		FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = 
                new FileChooser.ExtensionFilter("EXCEL files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
		fileChooser.setTitle("Pick a *.csv file");
		File file = fileChooser.showOpenDialog(primaryStage);
		
		String inputCSV  = file.getAbsolutePath().replace("\\", "/");
		String cpyInputCSV = inputCSV;
		String outputRDF = cpyInputCSV.substring(0, cpyInputCSV.lastIndexOf('/')).concat("/output.rdf");
		
		
		try {
			//scrapper.scrapeData(inputCSV, outputRDF);
			applications = RDFReader.parseFile(outputRDF);
			appMap = generateMap();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static Map<String, com.factrus.main.model.Application> generateMap() {
		appMap = new HashMap<String,com.factrus.main.model.Application>();
		
		for(com.factrus.main.model.Application app: applications){
			appMap.put(app.getName(), app);
		}
		
		return appMap;
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}

	public static void refreshApplicationList(
			List<com.factrus.main.model.Application> apps) {
		applications = apps;
		appMap = generateMap();
	}

}
