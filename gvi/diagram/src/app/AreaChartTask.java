package app;

import javafx.application.Application;
import data.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AreaChartTask extends Application {

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
        Datenbasis data_12 = new HeizwaermeBau2_2012();
        Datenbasis data_13 = new HeizwaermeBau2_2013();
        Datenbasis data_14 = new HeizwaermeBau2_2014();

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel(data_12.getNameBeobachtungsraum());
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel(data_12.getNameMerkmalsauspraegung());

        // Erstellen und Beschriften des Diagramms
        final AreaChart<String,Number> area_chart = new AreaChart<String,Number>(xAxis,yAxis);


        area_chart.setTitle(data_12.getTopic());
        area_chart.getData().add(createLineSeries(data_12));
        area_chart.getData().add(createLineSeries(data_13));
        area_chart.getData().add(createLineSeries(data_14));

        // Rendern des Diagramms
        Scene scene = new Scene(area_chart,888,666);

        stage.setTitle("GVI Aufgabe 3: Flächendiagramm");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
