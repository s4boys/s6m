package diagram;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;



public class Heizwaerme extends Application {
	
	private static ObservableList<XYChart.Data<String, Number>> createXYDataSet(String[] label, Number[] data)
	{
		ObservableList<XYChart.Data<String, Number>> list = FXCollections.observableArrayList();
		
		for (int i = 0; i < data.length; i++) {
			list.add(new XYChart.Data<String, Number>(label[i], data[i]));
		}
		return list;
	}
	

	public static void main(String[] args) {
		

		launch(args);

		
		
		
		
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni",
				"Juli", "August", "September", "Oktober", "November", "Dezember"};
		Number[] y2012 = {128.52, 187.54, 63.16, 72.18, 0, 0, 0, 0, 6, 68.58, 84.54, 120.51};
		
		
		
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis   yAxis = new NumberAxis();
		
		yAxis.setAutoRanging(false);
		yAxis.setLowerBound(0);
		yAxis.setUpperBound(200);
		yAxis.setTickUnit(1.0);
		yAxis.setMinorTickVisible(false);
		
		final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		
		yAxis.setLabel("Heizwert");
		xAxis.setLabel("Monat");
		
		ObservableList<XYChart.Data<String, Number>> barChartData;
		barChartData = createXYDataSet(months, y2012);
		
		XYChart.Series<String, Number> series1 = new XYChart.Series<>(barChartData);
		bc.getData().add(series1);
		
        Scene scene  = new Scene(bc,800,600);
        stage.setTitle("GVI Beispiel: Sulendiagramm");
        stage.setScene(scene);
        stage.show();

        
        
	}		
	

}
