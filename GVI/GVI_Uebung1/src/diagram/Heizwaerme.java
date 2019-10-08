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

	private static ObservableList<XYChart.Data<String, Number>> createXYDataSet(String[] label, Number[] data) {
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

		// data
		String[] months = { "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		Number[] y2012 = { 128.52, 187.54, 63.16, 72.18, 0, 0, 0, 0, 6, 68.58, 84.54, 120.51 };
		Number[] y2013 = { 144.44, 133.07, 121.78, 63.86, 35.53, 18.57, 0, 0, 16.56, 48.53, 91.88, 115.2};
		Number[] y2014 = { 113.77, 96.17, 77.74, 38.27, 29.79, 11.60, 0, 0, 16.85, 36.14, 67.55, 138.00};

		// create axis
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis 	 yAxis = new NumberAxis();

		yAxis.setAutoRanging(false);
		yAxis.setLowerBound(0);
		yAxis.setUpperBound(200);
		yAxis.setTickUnit(1.0);
		yAxis.setMinorTickVisible(false);

		// create chart
		final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
		yAxis.setLabel("Heizwärmebedarf");
		xAxis.setLabel("Monat");

		//add data
		ObservableList<XYChart.Data<String, Number>> barChartData;
		barChartData = createXYDataSet(months, y2012);

		XYChart.Series<String, Number> series1 = new XYChart.Series<>(barChartData);
		series1.setName("2012");
		bc.getData().add(series1);
		
		barChartData = createXYDataSet(months, y2013);

		XYChart.Series<String, Number> series2 = new XYChart.Series<>(barChartData);
		series2.setName("2013");
		bc.getData().add(series2);
		
		barChartData = createXYDataSet(months, y2014);

		XYChart.Series<String, Number> series3 = new XYChart.Series<>(barChartData);
		series3.setName("2014");
		bc.getData().add(series3);

		// render diagram
		Scene scene = new Scene(bc, 1000, 800);
		stage.setTitle("GVI Beispiel: Säulendiagramm");
		stage.setScene(scene);
		stage.show();

	}

}
