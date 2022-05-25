package pl.pp.simulation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.pp.simulation.Step;
import pl.pp.simulation.ui.MyFrame;
import pl.pp.simulation.ui.SimulationComponent;
import pl.pp.simulation.ui.buttons.ResetButton;
import pl.pp.simulation.ui.buttons.StartButton;
import pl.pp.simulation.ui.buttons.StopButton;
import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.ui.panels.ScrollPanel;

@Configuration
public class SimulationConfig {

    @Bean
    public StopButton stopButton() {
        StopButton stopButton = new StopButton("Stop");
        stopButton.setTimer(timer());
        return stopButton;
    }

    @Bean
    public StartButton startButton() {
        StartButton startButton = new StartButton("Start");
        startButton.setStopButton(stopButton());
        startButton.setTimer(timer());
        return startButton;
    }

    @Bean
    public ResetButton resetButton() {
        ResetButton resetButton = new ResetButton("Reset");
        resetButton.setStartButton(startButton());
        resetButton.setStopButton(stopButton());
        resetButton.setTimer(timer());
        return resetButton;
    }

    @Bean
    public Step timer() {
        return new Step(simulationComponent());
    }

    @Bean
    public ControlPanel controlPanel(){
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.setResetButton(resetButton());
        controlPanel.setStartButton(startButton());
        controlPanel.setStopButton(stopButton());
        return controlPanel;
    }

    @Bean
    public ScrollPanel scrollPanel(){
        return new ScrollPanel();
    }

    @Bean
    public SimulationComponent simulationComponent(){
        return new SimulationComponent();
    }

    @Bean
    public MyFrame myFrame(){
        MyFrame myFrame = new MyFrame();
        myFrame.setSimulationComponent(simulationComponent());
        myFrame.setControlPanel(controlPanel());
        myFrame.setScrollPanel(scrollPanel());
        return myFrame;
    }


}
