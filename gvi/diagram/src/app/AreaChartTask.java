package app;

import data.*;
import javafx.scene.chart.*;

public class AreaChartTask{

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

    public StackedAreaChart GetStackingAreaChart(Datenbasis[] years){
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(years[0].getNameBeobachtungsraum());
        NumberAxis yAxis = new NumberAxis(0,500,125);
        yAxis.setLabel(years[0].getNameMerkmalsauspraegung());

        // Erstellen und Beschriften des Diagramms
        final StackedAreaChart<String,Number> area_chart = new StackedAreaChart<String,Number>(xAxis,yAxis);

        area_chart.setTitle(years[0].getTopic());

        for (Datenbasis year: years){
            area_chart.getData().add(createLineSeries(year));
        }
        return area_chart;
    }

    public AreaChart GetAreaChart(Datenbasis [] years)  {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(years[0].getNameBeobachtungsraum());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(years[0].getNameMerkmalsauspraegung());

        // Erstellen und Beschriften des Diagramms
        final AreaChart<String,Number> area_chart = new AreaChart<String,Number>(xAxis,yAxis);

        area_chart.setTitle(years[0].getTopic());

        for (Datenbasis year: years){
            area_chart.getData().add(createLineSeries(year));
        }
        return area_chart;
    }
}
