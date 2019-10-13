package app;

import javafx.application.Application;
import data.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BubbleChartTask extends Application {

    private XYChart.Series createLineSeries(Datenbasis daten,int year) {

        XYChart.Series result = new XYChart.Series();
        result.setName(daten.getName());

        for (int i = 0; i < daten.getBeobachtungsraum().length; i++) {
            Number value = daten.getMerkmalsauspraegungen()[i].doubleValue() / 200;
            result.getData().add(new XYChart.Data(i+1,year,value));
        }

        return result;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Datenbasis data_12 = new HeizwaermeBau2_2012();
        Datenbasis data_13 = new HeizwaermeBau2_2013();
        Datenbasis data_14 = new HeizwaermeBau2_2014();

        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel(data_12.getNameBeobachtungsraum());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(data_12.getName());
        yAxis.setAutoRanging(false);
        yAxis.setTickUnit(1);
        yAxis.setLowerBound(2010);
        yAxis.setUpperBound(2016);

        // Erstellen und Beschriften des Diagramms
        final BubbleChart<Number,Number> scatter_chart = new BubbleChart<>(xAxis,yAxis);

        scatter_chart.setTitle(data_12.getTopic());
        scatter_chart.getData().add(createLineSeries(data_12,Integer.parseInt(data_12.getName())));
        scatter_chart.getData().add(createLineSeries(data_13,Integer.parseInt(data_13.getName())));
        scatter_chart.getData().add(createLineSeries(data_14,Integer.parseInt(data_14.getName())));

        // Rendern des Diagramms
        Scene scene = new Scene(scatter_chart,888,666);

        stage.setTitle("GVI Aufgabe 3: Flächendiagramm");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
