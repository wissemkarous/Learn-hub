package javaproject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DataVisualization {
    public static void createPieCharts(Map<String, Integer> criteriaScores) {
        // Create a dataset for the pie chart
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Assume criteriaScores is a Map<String, Integer> representing ratings for different criteria
        for (Map.Entry<String, Integer> entry : criteriaScores.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // Create a pie chart
        JFreeChart chart = ChartFactory.createPieChart(
                "Criteria Ratings",
                dataset,
                true,
                true,
                false
        );

        // Customize the pie plot if needed
        PiePlot plot = (PiePlot) chart.getPlot();
        // You can customize section colors or other properties

        // Create a chart panel and add it to a JFrame or any other container
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));

        // Create a new JFrame to display the pie chart
        JFrame pieChartFrame = new JFrame("Pie Chart");
        pieChartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pieChartFrame.getContentPane().add(chartPanel);
        pieChartFrame.pack();
        pieChartFrame.setLocationRelativeTo(null);
        pieChartFrame.setVisible(true);
    }
}

