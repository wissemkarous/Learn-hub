package com.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVDataVisualization extends JFrame {

    public CSVDataVisualization() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CSV Data Visualization");
        setSize(800, 600);
        setLocationRelativeTo(null);

        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 500));

        setLayout(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Read data from the CSV file named "data.csv"
        try (BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 7) {
                    String hotelName = values[1];
                    int comfort = Integer.parseInt(values[2]);
                    int security = Integer.parseInt(values[3]);
                    int animation = Integer.parseInt(values[4]);
                    int cleanliness = Integer.parseInt(values[5]);

                    // Add data to the dataset
                    dataset.addValue(comfort, "Comfort", hotelName);
                    dataset.addValue(security, "Security", hotelName);
                    dataset.addValue(animation, "Animation", hotelName);
                    dataset.addValue(cleanliness, "Cleanliness", hotelName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Hotel Criteria Visualization",
                "Hotel",
                "Score",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setItemMargin(0.1);

        return chart;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CSVDataVisualization visualization = new CSVDataVisualization();
                visualization.setVisible(true);
            }
        });
    }
}
