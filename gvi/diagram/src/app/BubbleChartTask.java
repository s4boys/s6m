package app;

import data.*;
import javafx.scene.chart.*;

public class BubbleChartTask {

    Datenbasis data_;

    public BubbleChartTask(Datenbasis data) {
        data_ = data;
    }

    private XYChart.Series createLineSeries(Datenbasis daten, int year) {

        XYChart.Series result = new XYChart.Series();
        result.setName(daten.getName());

        for (int i = 0; i < daten.getBeobachtungsraum().length; i++) {
            Number value = daten.getMerkmalsauspraegungen()[i].doubleValue() / 200;
            result.getData().add(new XYChart.Data(i+1,year,value));
        }

        return result;
    }

    public BubbleChart GetBubbleChart(Datenbasis[]years) throws Exception {

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel(years[0].getNameBeobachtungsraum());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(years[0].getName());
        yAxis.setAutoRanging(false);
        yAxis.setTickUnit(1);
        yAxis.setLowerBound(2010);
        yAxis.setUpperBound(2016);

        // Erstellen und Beschriften des Diagramms
        final BubbleChart<Number,Number> bubble_chart = new BubbleChart<>(xAxis,yAxis);

        bubble_chart.setTitle(years[0].getTopic());

        for (Datenbasis year: years){
            bubble_chart.getData().add(createLineSeries(year,Integer.parseInt(year.getName())));
        }
        return bubble_chart;
    }
}
