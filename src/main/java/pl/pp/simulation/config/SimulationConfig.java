package pl.pp.simulation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import pl.pp.simulation.Step;
import pl.pp.simulation.charts.SimulationChart;
import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.ui.panels.ScrollPanel;
import pl.pp.simulation.utils.ParameterModel;

import javax.swing.*;
import java.util.Objects;

@Configuration
@PropertySource("simulation.properties")
public class SimulationConfig {

    @Autowired
    private Environment environment;

    @Bean
    public StopButton stopButton() {
        StopButton stopButton = new StopButton(environment.getProperty("button.stop.text"));
        stopButton.setTimer(timer());
        return stopButton;
    }

    @Bean
    public StartButton startButton() {
        StartButton startButton = new StartButton(environment.getProperty("button.start.text"));
        startButton.setStopButton(stopButton());
        startButton.setTimer(timer());
        startButton.setGrassService(grassService());
        startButton.setFoxesService(foxesService());
        startButton.setHaresService(haresService());

        startButton.setFoxParameter(foxParameter());
        startButton.setHareParameter(hareParameter());
        startButton.setGrassParameter(grassParameter());

        return startButton;
    }

    @Bean
    public ResetButton resetButton() {
        ResetButton resetButton = new ResetButton(environment.getProperty("button.reset.text"));
        resetButton.setStartButton(startButton());
        resetButton.setStopButton(stopButton());
        resetButton.setGrassService(grassService());
        resetButton.setFoxesService(foxesService());
        resetButton.setHaresService(haresService());
        resetButton.setTimer(timer());
        resetButton.setTimeLabel(timeLabel());
        resetButton.setSimulationChart(simulationChart());

        resetButton.setFoxParameter(foxParameter());
        resetButton.setHareParameter(hareParameter());
        resetButton.setGrassParameter(grassParameter());
        return resetButton;
    }

    @Bean
    public Step timer() {
        Step step = new Step();
        step.setSimulationComponent(simulationComponent());
        step.setGrassService(grassService());
        step.setFoxesService(foxesService());
        step.setHaresService(haresService());
        step.setTimeLabel(timeLabel());
        return step;
    }

    @Bean
    public GrassService grassService() {
        GrassService grassService = new GrassService();
        grassService.setSimulationChart(simulationChart());
        grassService.setGrassParameter(grassParameter());
        return grassService;
    }

    @Bean
    public FoxesService foxesService() {
        FoxesService foxesService = new FoxesService();
        foxesService.setSimulationChart(simulationChart());
        foxesService.setFoxParameter(foxParameter());
        return foxesService;
    }

    @Bean
    public HaresService haresService() {
        HaresService haresService = new HaresService();
        haresService.setSimulationChart(simulationChart());
        haresService.setHareParameter(hareParameter());
        return haresService;
    }

    @Bean
    public ParameterModel grassParameter() {
        String label = environment.getProperty("parameter.grass.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.grass.value")));
        return new ParameterModel(label, defaultValue);
    }

    @Bean
    public ParameterModel hareParameter() {
        String label = environment.getProperty("parameter.hare.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.hare.value")));
        return new ParameterModel(label, defaultValue);
    }

    @Bean
    public ParameterModel foxParameter() {
        String label = environment.getProperty("parameter.fox.label");
        int defaultValue = Integer.parseInt(Objects.requireNonNull(environment.getProperty("parameter.fox.value")));
        return new ParameterModel(label, defaultValue);
    }


    @Bean
    public SimulationChart simulationChart() {
        return new SimulationChart();
    }

    @Bean
    public JButton chartButton() {
        return new JButton(environment.getProperty("chart.button.text"));
    }

    @Bean
    public ControlPanel controlPanel() {
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setResetButton(resetButton());
        controlPanel.setStartButton(startButton());
        controlPanel.setStopButton(stopButton());
        controlPanel.setTimeLabel(timeLabel());
        controlPanel.setSimulationChart(simulationChart());
        controlPanel.setChartButton(chartButton());

        controlPanel.setFoxParameter(foxParameter());
        controlPanel.setHareParameter(hareParameter());
        controlPanel.setGrassParameter(grassParameter());
        return controlPanel;
    }

    @Bean
    public ScrollPanel scrollPanel() {
        return new ScrollPanel();
    }

    @Bean
    public JLabel timeLabel() {
        return new JLabel(environment.getProperty("time.label"));
    }

    @Bean
    public SimulationComponent simulationComponent() {
        SimulationComponent simulationComponent = new SimulationComponent();
        simulationComponent.setGrassService(grassService());
        simulationComponent.setFoxesService(foxesService());
        simulationComponent.setHaresService(haresService());
        return simulationComponent;
    }

    @Bean
    public MyFrame myFrame() {
        MyFrame myFrame = new MyFrame();
        myFrame.setSimulationComponent(simulationComponent());
        myFrame.setControlPanel(controlPanel());
        myFrame.setScrollPanel(scrollPanel());
        return myFrame;
    }


}
