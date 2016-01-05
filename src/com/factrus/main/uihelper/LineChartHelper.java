package com.factrus.main.uihelper;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LineChartHelper {

	public static XYChart.Series createLineChart(){
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Month");
		final LineChart<String,Number> lineChart = 
				new LineChart<String,Number>(xAxis,yAxis);

		lineChart.setTitle("Application Downloads, 2010");

		XYChart.Series series1 = new XYChart.Series();
		series1.setName("AngryBird");

		series1.getData().add(new XYChart.Data("Jan", 23));
		series1.getData().add(new XYChart.Data("Feb", 14));
		series1.getData().add(new XYChart.Data("Mar", 15));
		series1.getData().add(new XYChart.Data("Apr", 24));
		series1.getData().add(new XYChart.Data("May", 34));
		series1.getData().add(new XYChart.Data("Jun", 36));
		series1.getData().add(new XYChart.Data("Jul", 22));
		series1.getData().add(new XYChart.Data("Aug", 45));
		series1.getData().add(new XYChart.Data("Sep", 43));
		series1.getData().add(new XYChart.Data("Oct", 17));
		series1.getData().add(new XYChart.Data("Nov", 29));
		series1.getData().add(new XYChart.Data("Dec", 25));

		XYChart.Series series2 = new XYChart.Series();
		series2.setName("Facebook");
		series2.getData().add(new XYChart.Data("Jan", 33));
		series2.getData().add(new XYChart.Data("Feb", 34));
		series2.getData().add(new XYChart.Data("Mar", 25));
		series2.getData().add(new XYChart.Data("Apr", 44));
		series2.getData().add(new XYChart.Data("May", 39));
		series2.getData().add(new XYChart.Data("Jun", 16));
		series2.getData().add(new XYChart.Data("Jul", 55));
		series2.getData().add(new XYChart.Data("Aug", 54));
		series2.getData().add(new XYChart.Data("Sep", 48));
		series2.getData().add(new XYChart.Data("Oct", 27));
		series2.getData().add(new XYChart.Data("Nov", 37));
		series2.getData().add(new XYChart.Data("Dec", 29));

		XYChart.Series series3 = new XYChart.Series();
		series3.setName("CandyCrush");
		series3.getData().add(new XYChart.Data("Jan", 44));
		series3.getData().add(new XYChart.Data("Feb", 35));
		series3.getData().add(new XYChart.Data("Mar", 36));
		series3.getData().add(new XYChart.Data("Apr", 33));
		series3.getData().add(new XYChart.Data("May", 31));
		series3.getData().add(new XYChart.Data("Jun", 26));
		series3.getData().add(new XYChart.Data("Jul", 22));
		series3.getData().add(new XYChart.Data("Aug", 25));
		series3.getData().add(new XYChart.Data("Sep", 43));
		series3.getData().add(new XYChart.Data("Oct", 44));
		series3.getData().add(new XYChart.Data("Nov", 45));
		series3.getData().add(new XYChart.Data("Dec", 44));
    
		lineChart.getData().addAll(series1, series2, series3);
		
		return series1; 
	}
}
