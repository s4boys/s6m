package app;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import data.*;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class PieChartTask extends Application{

	private ObservableList<PieChart.Data> createPieDataSet(Datenbasis daten) {

		ObservableList<PieChart.Data> list = 
				FXCollections.observableArrayList();
	
		for (int i = 0; i < daten.getBeobachtungsraum().length; i++) {
			list.add(new PieChart.Data(
					daten.getBeobachtungsraum()[i], 
					daten.getMerkmalsauspraegungen()[i].doubleValue()));
		}

		return list;
	}
	
	@Override
	public void start(Stage stage) throws Exception {
	    Datenbasis data = new ConcatenatedData();
		
	    ObservableList<PieChart.Data> pieChartData = createPieDataSet(data);
	    
    	// Erstellen und Beschriften des Diagramms
       	final PieChart chart = new PieChart(pieChartData);
        chart.setTitle(data.getTopic());
        
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
