package pl.pp.simulation.utils;

import pl.pp.simulation.MyComponent;
import pl.pp.simulation.SimulationChart;

import javax.swing.*;

public class Components {
    public static JButton startButton;
    public static JButton stopButton;
    public static JButton resetButton;
    public static MyComponent myComponent = new MyComponent();
    public static ParameterModel grassParameter;
    public static ParameterModel hareParameter;
    public static ParameterModel foxParameter;
    public static JLabel timeLabel;
    public static JTextArea textArea;
    public static SimulationChart simulationChart = new SimulationChart();
}
