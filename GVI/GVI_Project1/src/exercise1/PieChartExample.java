package exercise1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

public class PieChartExample extends Application {

	private static ObservableList<PieChart.Data> createPieDataSet(String[] label, Number[] data, int year) {
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

		for (int i = 0; i < data.length; i++) {
			list.add(new PieChart.Data(label[i] + ", " + year, data[i].doubleValue()));
		}
		return list;
	}

	public static void main(String[] args) {

		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {

		// data
		String[] months = { "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September",
				"Oktober", "November", "Dezember" };
		Number[] y2012 = { 128.52, 187.54, 63.16, 72.18, 0, 0, 0, 0, 6, 68.58, 84.54, 120.51 };
		Number[] y2013 = { 144.44, 133.07, 121.78, 63.86, 35.53, 18.57, 0, 0, 16.56, 48.53, 91.88, 115.2 };
		Number[] y2014 = { 113.77, 96.17, 77.74, 38.27, 29.79, 11.60, 0, 0, 16.85, 36.14, 67.55, 138.00 };

		// add data
		ObservableList<PieChart.Data> pieChartData2012;
		pieChartData2012 = createPieDataSet(months, y2012, 2012);

		ObservableList<PieChart.Data> pieChartData2013;
		pieChartData2013 = createPieDataSet(months, y2013, 2013);

		ObservableList<PieChart.Data> pieChartData2014;
		pieChartData2014 = createPieDataSet(months, y2014, 2014);

		ObservableList<PieChart.Data> completeData = FXCollections.observableArrayList();
		completeData.addAll(pieChartData2012);
		completeData.addAll(pieChartData2013);
		completeData.addAll(pieChartData2014);

		// create chart
		final PieChart pc = new PieChart(completeData);
		
		// add tooltips to every node
		for (final PieChart.Data data : pc.getData()) {
			Tooltip tooltip = new Tooltip();
			tooltip.setText(data.getName()+"\nHeizwert: " + data.getPieValue() + "\nMonat: " + data.getName().toString());
			Tooltip.install(data.getNode(), tooltip);
		}

		// render diagram
		Scene scene = new Scene(pc, 1000, 800);
		stage.setTitle("Heiwärmebedarf: HFT Bau 2");
		stage.setScene(scene);
		stage.show();

	}

}