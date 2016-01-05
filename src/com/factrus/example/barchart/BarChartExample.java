package com.factrus.example.barchart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class BarChartExample  extends Application {
	
	final static String angryBird = "AngryBird";
    final static String fourSquares = "FourSquares";
    final static String facebook = "Facebook";
    final static String twitter = "Twitter";
    final static String candyCrush = "CandyCrush";
 
    @Override public void start(Stage stage) {
        stage.setTitle("Select Applications");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Select Applications");
        xAxis.setLabel("Application");       
        yAxis.setLabel("Value");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");       
        series1.getData().add(new XYChart.Data(angryBird, 25601.34));
        series1.getData().add(new XYChart.Data(fourSquares, 20148.82));
        series1.getData().add(new XYChart.Data(facebook, 10000));
        series1.getData().add(new XYChart.Data(twitter, 35407.15));
        series1.getData().add(new XYChart.Data(candyCrush, 12000));      
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(angryBird, 57401.85));
        series2.getData().add(new XYChart.Data(fourSquares, 41941.19));
        series2.getData().add(new XYChart.Data(facebook, 45263.37));
        series2.getData().add(new XYChart.Data(twitter, 117320.16));
        series2.getData().add(new XYChart.Data(candyCrush, 14845.27));  
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(angryBird, 45000.65));
        series3.getData().add(new XYChart.Data(fourSquares, 44835.76));
        series3.getData().add(new XYChart.Data(facebook, 18722.18));
        series3.getData().add(new XYChart.Data(twitter, 17557.31));
        series3.getData().add(new XYChart.Data(candyCrush, 92633.68));  
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
