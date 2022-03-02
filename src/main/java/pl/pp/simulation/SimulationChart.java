package pl.pp.simulation;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

import static javax.swing.WindowConstants.*;

public class SimulationChart extends JFrame {
    private XYSeries hareSeries;

    public SimulationChart() {
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Wykres");

        XYSeriesCollection dataset = getDataSet();
        JFreeChart freeChart = getChart(dataset);
        ChartPanel chartPanel = new ChartPanel(freeChart);

        add(chartPanel);
        pack();
    }

    private JFreeChart getChart(XYSeriesCollection dataset) {
        return ChartFactory.createXYLineChart(
                "Ilość organizmów w zależności od czasu",
                "czas",
                "Ilość",
                dataset
        );
    }

    private XYSeriesCollection getDataSet() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        hareSeries = new XYSeries("zające");

        dataset.addSeries(hareSeries);
        return dataset;
    }
    public void addPoint(double x, double y){
        hareSeries.add(x,y);
    }
}
