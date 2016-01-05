package com.factrus.main.controller.views;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import com.factrus.main.Main;
import com.factrus.main.controller.listener.search.SearchEventHandler;
import com.factrus.main.controller.listener.view.ApplicationTileEventHandler;
import com.factrus.main.model.Application;
import com.factrus.main.view.ApplicationTile;


public class TileViewController   implements Initializable {

	private static List<Application> applications;
	
	/**
	 * Application List Pane
	 */
	@FXML
	private TilePane tileAppView;
	private static TilePane tileAppView_;
	@FXML
	private ScrollPane appScrollPane;
	@FXML
	private Pane applicationDetailPane;
	@FXML
	private Button closeAppDetail;
	
	/**
	 * Application Detail Pane
	 */
	@FXML
	private Label appDetail_name;
	private static Label appDetail_name_;
	@FXML
	private Label appDetail_developer;
	private static Label appDetail_developer_;
	@FXML
	private Label appDetail_downloads;
	private static Label appDetail_downloads_;
	@FXML
	private Label appDetail_rating;
	private static Label appDetail_rating_;
	@FXML
	private Label appDetail_price;
	private static Label appDetail_price_;
	@FXML
	private PieChart appDetail_pierating;
	private static PieChart appDetail_pierating_;
	@FXML
	private BarChart<String,Long> appDetail_barating;
	private static BarChart<String,Long> appDetail_barating_;
	@FXML
	private ImageView largeIcon;
	private static ImageView largeIcon_;
	
	/**
	 * Change graph view
	 */
	@FXML
	private Button switchGraph;
	@FXML
	private Pane barPane;
	@FXML
	private Pane piePane;
	
	public static String GRAPH_VIEW;
	private static String VIEW_BAR = "BAR";
	private static String VIEW_PIE = "PIE";
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Set application list
		applications = Main.applications;
		if(null == applications){
			applications = FXCollections.observableArrayList();
		}
		tileAppView_ = tileAppView;
		appDetail_name_ = appDetail_name;
		appDetail_developer_ = appDetail_developer;
		appDetail_downloads_ = appDetail_downloads;
		appDetail_rating_ = appDetail_rating;
		appDetail_price_ = appDetail_price;
		appDetail_pierating_ = appDetail_pierating;
		appDetail_barating_ = appDetail_barating;
		largeIcon_ = largeIcon;
		// Set scroll pane in different controllers to handle it's view
		ApplicationTileEventHandler.setAppScrollPane(appScrollPane);
		ApplicationTileEventHandler.setBarChartPane(barPane);
		ApplicationTileEventHandler.setPieChartPane(piePane);
		SearchEventHandler.setAppScrollPane(appScrollPane);
		
		appScrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		closeAppDetail.setOnAction(ApplicationTileEventHandler.newApplicationDetailCloseEvent(applicationDetailPane));
		switchGraph.setOnAction(ApplicationTileEventHandler.newGraphSwitchViewEvent());
		GRAPH_VIEW = VIEW_PIE;
		
		populateAppList();
	}
	
	public static void populateAppList(){
		tileAppView_.getChildren().clear();
	    for (Application app: applications) {
	    	tileAppView_.getChildren().add(createElement(app));
	    }
	}
	
	public static void refreshApplicationList(List<Application> apps){
		applications = apps;
		populateAppList();
	}
	
	/*
	 * DEBUG: Have to put the actual application tiles here
	 */
	private static ApplicationTile createElement(Application app) {		
		ApplicationTile tile = new ApplicationTile(app);
        return tile;
    }
	
	// Get all the application details
	public static String getAppDetail_name() 	  	 {	return appDetail_name_.getText();		}
	public static String getAppDetail_developer() 	 {	return appDetail_developer_.getText();	}
	public static String getAppDetail_downloads() 	 {	return appDetail_downloads_.getText();	}
	public static String getAppDetail_rating() 	 	 {	return appDetail_rating_.getText();	}
	public static String getAppDetail_price() 	 	 {	return appDetail_price_.getText();	}
	public static PieChart getAppDetail_pierating() {	return appDetail_pierating_;	}
	public static BarChart getAppDetail_barrating() {	return appDetail_barating_;	}
	// Set all the application details
	public static void setAppDetail_developer(String developer) 	 {	appDetail_developer_.setText("DEVELOPER: "+developer);}
	public static void setAppDetail_name(String name)			 	 {	appDetail_name_.setText("NAME: "+name);			}
	public static void setAppDetail_downloads(String downloads) 	 {	appDetail_downloads_.setText("DOWNLOADS: "+downloads);}
	public static void setAppDetail_price(String price)			 	 {	appDetail_price_.setText("PRICE: "+price);			}
	public static void setAppDetail_rating(String rating) 	 		 {	appDetail_rating_.setText("RATING: "+rating+"/5");}
	public static void setAppDetail_largeIcon(Image icon)		 	 {	largeIcon_.setImage(icon);}
	public static void setAppDetail_pierating(ObservableList<PieChart.Data> pieChartData) {	appDetail_pierating_.setData(pieChartData);	}
	public static void setAppDetail_barrating(Series<String, Long> series) {	
		appDetail_barating_.getData().clear();
		appDetail_barating_.getData().add(series);
	}
	
}
