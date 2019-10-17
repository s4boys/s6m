package app;

import data.*;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LineChartTask {

    Datenbasis data_;

    public LineChartTask(Datenbasis data) {
        data_ = data;
    }

    private XYChart.Series<String, Number> createLineSeries(Datenbasis daten) {

        XYChart.Series result = new XYChart.Series<String, Number>();
        result.setName(daten.getName());

        for (int i = 0; i < daten.getBeobachtungsraum().length; i++) {
            result.getData().add(new XYChart.Data<String, Number>(
                    daten.getBeobachtungsraum()[i],
                    daten.getMerkmalsauspraegungen()[i].doubleValue()));
        }

        return result;
    }

    public LineChart GetThreeYearsLineChart() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(data_.getNameBeobachtungsraum());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(data_.getNameMerkmalsauspraegung());

        // Erstellen und Beschriften des Diagramms
        final LineChart chart_3_years = new LineChart(xAxis, yAxis);
        chart_3_years.setTitle(data_.getTopic());
        chart_3_years.getData().add(createLineSeries(data_));

        return chart_3_years;
    }

    public LineChart GetYearlyLineChart(Datenbasis[] years) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(data_.getNameBeobachtungsraum());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(data_.getNameMerkmalsauspraegung());

        final LineChart chart_yearly = new LineChart(xAxis, yAxis);
        chart_yearly.setTitle(data_.getTopic());

        for (Datenbasis year : years){
			chart_yearly.getData().add(createLineSeries(year));
		}
        return chart_yearly;
    }
}
