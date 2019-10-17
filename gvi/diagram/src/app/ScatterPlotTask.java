package app;

import data.*;
import javafx.scene.chart.*;

public class ScatterPlotTask{



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

    public ScatterChart GetScatterChart(Datenbasis[] years) throws Exception {

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(years[0].getNameBeobachtungsraum());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(years[0].getNameMerkmalsauspraegung());

        // Erstellen und Beschriften des Diagramms
        final ScatterChart<String,Number> scatter_chart = new ScatterChart<>(xAxis,yAxis);

        scatter_chart.setTitle(years[0].getTopic());

        for (Datenbasis year : years){
            scatter_chart.getData().add(createLineSeries(year));
        }
        return scatter_chart;

    }
}
