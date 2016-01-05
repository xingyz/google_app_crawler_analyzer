package com.factrus.example.piechart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * 
 * @author nicolas.husser
 *
 */
public class PieChartExample extends Application {

	@Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Select Applications");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("AngryBird", 13),
                new PieChart.Data("FourSquares", 25),
                new PieChart.Data("Facebook", 10),
                new PieChart.Data("Twitter", 22),
                new PieChart.Data("CandyCrush", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Select Applications");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
}
