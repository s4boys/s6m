package exercise1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class BubbleChartExample extends Application {

	private static ObservableList<XYChart.Data<Number, Number>> createXYDataSet(Number[] label, Number[] data) {
		ObservableList<XYChart.Data<Number, Number>> list = FXCollections.observableArrayList();

		for (int i = 0; i < data.length; i++) {
			list.add(new XYChart.Data<Number, Number>(label[i], data[i]));
		}
		return list;
	}

	public static void main(String[] args) {

		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {

		// data
		Number[] months = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		Number[] y2012 = { 128.52, 187.54, 63.16, 72.18, 0, 0, 0, 0, 6, 68.58, 84.54, 120.51 };
		Number[] y2013 = { 144.44, 133.07, 121.78, 63.86, 35.53, 18.57, 0, 0, 16.56, 48.53, 91.88, 115.2 };
		Number[] y2014 = { 113.77, 96.17, 77.74, 38.27, 29.79, 11.60, 0, 0, 16.85, 36.14, 67.55, 138.00 };

		// create axis
		NumberAxis xAxis = new NumberAxis();
		NumberAxis yAxis = new NumberAxis();

		yAxis.setAutoRanging(false);
		yAxis.setLowerBound(0);
		yAxis.setUpperBound(200);
		yAxis.setTickUnit(1.0);
		yAxis.setMinorTickVisible(false);

		// create chart
		final BubbleChart<Number, Number> bc = new BubbleChart<>(xAxis, yAxis);
		yAxis.setLabel("Heizwärmebedarf");
		xAxis.setLabel("Monat");

		// add data
		ObservableList<XYChart.Data<Number, Number>> lineChartData;
		lineChartData = createXYDataSet(months, y2012);

		XYChart.Series<Number, Number> series1 = new XYChart.Series<>(lineChartData);
		series1.setName("2012");
		bc.getData().add(series1);

		lineChartData = createXYDataSet(months, y2013);

		XYChart.Series<Number, Number> series2 = new XYChart.Series<>(lineChartData);
		series2.setName("2013");
		bc.getData().add(series2);

		lineChartData = createXYDataSet(months, y2014);

		XYChart.Series<Number, Number> series3 = new XYChart.Series<>(lineChartData);
		series3.setName("2014");
		bc.getData().add(series3);

		// Add tooltips to every node
		for (final Series<Number, Number> series : bc.getData()) {
			for (final Data<Number, Number> data : series.getData()) {
				Tooltip tooltip = new Tooltip();
				tooltip.setText(series.getName()+"\nHeizwert: " + data.getYValue().toString() + "\nMonat: " + data.getXValue().toString());
				Tooltip.install(data.getNode(), tooltip);
			}
		}

		// render diagram
		Scene scene = new Scene(bc, 1000, 800);
		stage.setTitle("Heiwärmebedarf: HFT Bau 2");
		stage.setScene(scene);
		stage.show();

	}

}
