package app;

import javafx.application.Application;
import data.*;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Showcase extends Application {

    SplitPane split_pane;

    <T extends Node> Button GetChartSwappingButton(String label, T chart){
        Button btn = new Button(label);
        btn.setOnAction(e -> {
            split_pane.getItems().remove(0);
            split_pane.getItems().add(0,chart);
        });
        return btn;
    }

    @Override
    public void start(Stage stage) throws Exception {
        int width = 1000;
        int height = 600;
        Datenbasis data = new ConcatenatedData();

        Datenbasis[] years = {new HeizwaermeBau2_2012(), new HeizwaermeBau2_2013(), new HeizwaermeBau2_2014()};

        LineChartTask line_charts = new LineChartTask(data);
        LineChart yearly_line_chart = line_charts.GetYearlyLineChart(years);

        Button button_to_yearly = GetChartSwappingButton("Go to yearly line chart",yearly_line_chart);
        LineChart years_line_chart = line_charts.GetThreeYearsLineChart();

        Button button_to_years = GetChartSwappingButton("Go to three years line chart",years_line_chart);

        BubbleChartTask bubble_charts = new BubbleChartTask(data);
        BubbleChart bubble_chart = bubble_charts.GetBubbleChart(years);
        Button button_to_bubble = GetChartSwappingButton("Go to bubble chart",bubble_chart);

        ScatterPlotTask scatter_charts = new ScatterPlotTask();
        ScatterChart scatter_chart = scatter_charts.GetScatterChart(years);
        Button button_to_scatter = GetChartSwappingButton("Go to scatter chart",scatter_chart);

        PieChartTask pie_charts = new PieChartTask();
        PieChart pie_chart = pie_charts.GetPieChart(data);
        Button button_to_pie = GetChartSwappingButton("Go to pie chart",pie_chart);

        AreaChartTask area_charts = new AreaChartTask();
        AreaChart area_chart = area_charts.GetAreaChart(years);
        Button button_to_area = GetChartSwappingButton("Go to area chart",area_chart);

        VBox buttons = new VBox(20);
        buttons.getChildren().addAll(button_to_yearly, button_to_years, button_to_area, button_to_bubble, button_to_pie, button_to_scatter);

        split_pane = new SplitPane(area_charts.GetAreaChart(years), buttons);

        split_pane.setOrientation(Orientation.VERTICAL);

        Scene scene = new Scene(split_pane, width, height);

        stage.setTitle("GVI Aufgabe 2");
        stage.setScene(scene);
        stage.show();
    }
}
