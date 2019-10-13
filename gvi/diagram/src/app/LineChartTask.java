package app;

import javafx.application.Application;
import data.*;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LineChartTask extends Application {

	Scene scene_years, scene_yearly;

	private XYChart.Series<String,Number> createLineSeries(Datenbasis daten) {

		XYChart.Series result = new XYChart.Series<String,Number>();
		result.setName(daten.getName());
		
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

		Datenbasis data_12 = new HeizwaermeBau2_2012();
		Datenbasis data_13 = new HeizwaermeBau2_2013();
		Datenbasis data_14 = new HeizwaermeBau2_2014();
	    
	    CategoryAxis xAxis = new CategoryAxis();
	    xAxis.setLabel(data.getNameBeobachtungsraum());
	    NumberAxis yAxis = new NumberAxis();
	    yAxis.setLabel(data.getNameMerkmalsauspraegung());
	    
    	// Erstellen und Beschriften des Diagramms
       	final LineChart chart_3_years = new LineChart(xAxis,yAxis);
        chart_3_years.setTitle(data.getTopic());
        chart_3_years.getData().add(createLineSeries(data));

		CategoryAxis xAxis2 = new CategoryAxis();
		xAxis2.setLabel(data.getNameBeobachtungsraum());
		NumberAxis yAxis2 = new NumberAxis();
		yAxis2.setLabel(data.getNameMerkmalsauspraegung());

        final LineChart chart_yearly = new LineChart(xAxis2,yAxis2);
        chart_yearly.setTitle(data.getTopic());
        chart_yearly.getData().add(createLineSeries(data_12));
		chart_yearly.getData().add(createLineSeries(data_13));
		chart_yearly.getData().add(createLineSeries(data_14));

        // Rendern des Diagramms
		Button button_to_yearly = new Button("Go to yearly view");
		button_to_yearly.setOnAction(e -> stage.setScene(scene_years));
		VBox layout_yearly = new VBox(20);
		layout_yearly.getChildren().addAll(chart_yearly,button_to_yearly);
		scene_yearly = new Scene(layout_yearly,888,666);

		Button button_to_years = new Button("Go to three years");
		button_to_years.setOnAction(e -> stage.setScene(scene_yearly));
		VBox layout_years = new VBox(20);
		layout_years.getChildren().addAll(chart_3_years,button_to_years);
		scene_years = new Scene(layout_years,888,666);

        stage.setTitle("GVI Aufgabe 2: Liniendiagramm");
        stage.setScene(scene_yearly);
        stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
