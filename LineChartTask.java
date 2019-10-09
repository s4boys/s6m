package project_one;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import data.*;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import project_one.*;

public class LineChartTask extends Application {
	private XYChart.Series<String,Number> createLineSeries(Datenbasis daten) {

		XYChart.Series result = new XYChart.Series<String,Number>();
		result.setName("series name");
		
		for (int i = 0; i < daten.getBeobachtungsraum().length; i++) {
			result.getData().add(new XYChart.Data<String,Number>(
					daten.getBeobachtungsraum()[i], 
					daten.getMerkmalsauspraegungen()[i].doubleValue()));
		}

		return result;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	    Datenbasis data = new ConcatenatedData();
	    
	    CategoryAxis xAxis = new CategoryAxis();
	    xAxis.setLabel(data.getNameBeobachtungsraum());
	    NumberAxis yAxis = new NumberAxis();
	    yAxis.setLabel(data.getNameMerkmalsauspraegung());
	    
    	// Erstellen und Beschriften des Diagramms
       	final LineChart chart = new LineChart(xAxis,yAxis);
        chart.setTitle(data.getTopic());
        
        chart.getData().add(createLineSeries(data));
        
        // Rendern des Diagramms
        Scene scene = new Scene(chart,888,666);
        stage.setTitle("GVI Aufgabe 1: Tortendiagramm");
        stage.setScene(scene);
        stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
