package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import data.*;
import javafx.scene.chart.PieChart;

public class PieChartTask {

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

	public PieChart[] GetYearlyPieCharts(Datenbasis[] years){
		PieChart[] charts = new PieChart[3];

		for (int i = 0; i < charts.length; i++){
			ObservableList<PieChart.Data> data = createPieDataSet(years[i]);
			charts[i] = new PieChart(data);
			charts[i].setTitle(years[i].getName());
		}
		return charts;
	}

	public PieChart GetPieChart(Datenbasis data){
	    ObservableList<PieChart.Data> pieChartData = createPieDataSet(data);
	    
    	// Erstellen und Beschriften des Diagramms
       	final PieChart chart = new PieChart(pieChartData);
        chart.setTitle(data.getTopic());

        return chart;
	}
}
