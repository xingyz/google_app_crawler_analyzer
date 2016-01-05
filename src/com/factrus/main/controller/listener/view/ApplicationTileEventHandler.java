package com.factrus.main.controller.listener.view;

import com.factrus.main.controller.views.TileViewController;
import com.factrus.main.model.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ApplicationTileEventHandler {

	// Will be set when view is loaded
	private static ScrollPane appScrollPane;
	private static Pane barChartPane;
	private static Pane pieChartPane;
	private static String VIEW_BAR = "BAR";
	private static String VIEW_PIE = "PIE";
	
	/**
	 * @ONCLICK_EVENT: Event fired on click
	 * 
	 * @return EventHandler
	 */
	public static EventHandler<MouseEvent> newApplicationClickTileEventHandler(final Application app){
		return new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		    	 populateApplicationData(app);
		    	 hideApplicationListView();
		         event.consume();
		     }
		};
	}
	
	/**
	 * @ON_MOUSE_ENTER_EVENT: Event fired on hover
	 * 
	 * @return EventHandler
	 */
	public static EventHandler<MouseEvent> newApplicationMouseEnterTileEventHandler(final Pane hoverPane){
		return new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		         // Run code here like pop up window
		    	 hoverPane.getStyleClass().remove("tile");
		    	 hoverPane.getStyleClass().add("tile_hover");
		    	 
		         event.consume();
		     }
		};
	}
	
	/**
	 * @ON_MOUSE_LEAVE_EVENT: Event fired on mouse leave
	 * 
	 * @return EventHandler
	 */
	public static EventHandler<MouseEvent> newApplicationMouseLeaveTileEventHandler(final Pane hoverPane){
		return new EventHandler<MouseEvent>() {
		     @Override
		     public void handle(MouseEvent event) {
		         // Run code here like pop up window
		    	 hoverPane.getStyleClass().remove("tile_hover");
		    	 hoverPane.getStyleClass().add("tile");
		    	 
		         event.consume();
		     }
		};
	}
	
	/**
	 * @ON_CLICK: Close application detail view
	 * @param applicationDetailPane
	 * @return
	 */
	public static EventHandler<ActionEvent> newApplicationDetailCloseEvent(final Pane applicationDetailPane){
		return new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	applicationDetailPane.toBack();
		    }
		};
	}
	
	public static void populateApplicationData(Application app){
		
		ObservableList<PieChart.Data> pieChartData = createRatingPieChart(app);
		XYChart.Series<String, Long> series = createRatingBarChart(app);
		Image largeIcon = new Image(app.getIconURL(),true);
		
		TileViewController.setAppDetail_largeIcon(largeIcon);
		TileViewController.setAppDetail_barrating(series);
		TileViewController.setAppDetail_pierating(pieChartData);
		TileViewController.setAppDetail_developer(app.getDeveloper());
		TileViewController.setAppDetail_downloads(app.getDownloads());
		TileViewController.setAppDetail_name(app.getName());
		TileViewController.setAppDetail_price((app.getPrice().equals("0") ? "Free" : app.getPrice()));
		TileViewController.setAppDetail_rating(app.getRating());
	}
	
	/**
	 * Helper function to populate the BarChart data
	 * 
	 * @return the series
	 */
	private static Series<String, Long> createRatingBarChart(Application app) {
		XYChart.Series<String, Long> series = new XYChart.Series<>();
		
		series.getData().add(new XYChart.Data<>("★★★★★", Long.parseLong(app.getStarOne().replaceAll(",", ""))));
		series.getData().add(new XYChart.Data<>("★★★★☆", Long.parseLong(app.getStarTwo().replaceAll(",", ""))));
		series.getData().add(new XYChart.Data<>("★★★☆☆", Long.parseLong(app.getStarThree().replaceAll(",", ""))));
		series.getData().add(new XYChart.Data<>("★★☆☆☆", Long.parseLong(app.getStarFour().replaceAll(",", ""))));
		series.getData().add(new XYChart.Data<>("★☆☆☆☆", Long.parseLong(app.getStarFive().replaceAll(",", ""))));
		
		return series;
	}

	/**
	 * Helper function to populate the PieChart data
	 * 
	 * @return the data
	 */
	private static ObservableList<Data> createRatingPieChart(Application app) {
		
		Long star1 = Long.parseLong(app.getStarOne().replaceAll(",", ""));
		Long star2 = Long.parseLong(app.getStarTwo().replaceAll(",", ""));
		Long star3 = Long.parseLong(app.getStarThree().replaceAll(",", ""));
		Long star4 = Long.parseLong(app.getStarFour().replaceAll(",", ""));
		Long star5 = Long.parseLong(app.getStarFive().replaceAll(",", ""));
		
		
		ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("★★★★★", star1),
                new PieChart.Data("★★★★☆", star2),
                new PieChart.Data("★★★☆☆", star3),
                new PieChart.Data("★★☆☆☆", star4),
                new PieChart.Data("★☆☆☆☆", star5));
		
		return pieChartData;
	}

	public static void setAppScrollPane(ScrollPane pane){
		appScrollPane = pane;
	}
	public static void setBarChartPane(Pane pane){
		barChartPane = pane;
	}
	public static void setPieChartPane(Pane pane){
		pieChartPane = pane;
	}
	
	private static void hideApplicationListView() {
		appScrollPane.toBack();
	}

	public static EventHandler<ActionEvent> newGraphSwitchViewEvent() {
		return new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	System.out.println("Hey");
		    	if(TileViewController.GRAPH_VIEW.equals(VIEW_BAR)){
		    		barChartPane.toBack();
		    		TileViewController.GRAPH_VIEW = VIEW_PIE;
		    	}else{
		    		barChartPane.toFront();
		    		TileViewController.GRAPH_VIEW = VIEW_BAR;
		    	}		    	
		    }
		};
	}
	
}
