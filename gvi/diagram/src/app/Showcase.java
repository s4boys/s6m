package app;

import javafx.application.Application;
import data.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Showcase extends Application {

    SplitPane split_pane;

    <T extends Node> Button GetChartSwappingButton(String label, T chart) {
        Button btn = new Button(label);
        btn.setOnAction(e -> {
            split_pane.getItems().remove(0);
            split_pane.getItems().add(0, chart);
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

        Button button_to_yearly = GetChartSwappingButton("Yearly line chart", yearly_line_chart);
        LineChart years_line_chart = line_charts.GetThreeYearsLineChart();

        Button button_to_years = GetChartSwappingButton("Line chart", years_line_chart);

        BubbleChartTask bubble_charts = new BubbleChartTask(data);
        BubbleChart bubble_chart = bubble_charts.GetBubbleChart(years);
        Button button_to_bubble = GetChartSwappingButton("Bubble chart", bubble_chart);

        ScatterPlotTask scatter_charts = new ScatterPlotTask();
        ScatterChart scatter_chart = scatter_charts.GetScatterChart(years);
        Button button_to_scatter = GetChartSwappingButton("Scatter chart", scatter_chart);

        PieChartTask pie_charts = new PieChartTask();
        PieChart pie_chart = pie_charts.GetPieChart(data);
        Button button_to_pie = GetChartSwappingButton("Pie chart", pie_chart);

        PieChart[] yearly_pie_charts = pie_charts.GetYearlyPieCharts(years);
        FlowPane pie_charts_pane = new FlowPane();
        pie_charts_pane.setHgap(10);
        pie_charts_pane.setVgap(10);
        pie_charts_pane.setPadding(new Insets(100, 0, 30, 30));
        pie_charts_pane.getChildren().addAll(yearly_pie_charts);
        Button button_to_yearly_pies = GetChartSwappingButton("Yearly pie charts", pie_charts_pane);

        AreaChartTask area_charts = new AreaChartTask();
        AreaChart area_chart = area_charts.GetAreaChart(years);
        Button button_to_area = GetChartSwappingButton("Area chart", area_chart);

        StackedAreaChart stacked_area_chart = area_charts.GetStackingAreaChart(years);
        Button button_to_stacked_area = GetChartSwappingButton("Stacked area chart", stacked_area_chart);

        FlowPane buttons = new FlowPane();
        buttons.setHgap(10);
        buttons.setVgap(10);
        buttons.setPadding(new Insets(100, 0, 30, 30));
        buttons.getChildren().addAll(
                button_to_years, button_to_yearly,
                button_to_pie, button_to_yearly_pies,
                button_to_area, button_to_stacked_area,
                button_to_bubble, button_to_scatter
        );

        split_pane = new SplitPane(years_line_chart, buttons);

        split_pane.setOrientation(Orientation.VERTICAL);

        Scene scene = new Scene(split_pane, width, height);

        stage.setTitle("GVI Aufgabe 2");
        stage.setScene(scene);
        stage.show();
    }
}
