package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.Foxes;
import pl.pp.simulation.model.GrassUtils;
import pl.pp.simulation.model.Hares;
import pl.pp.simulation.ui.panels.ControlPanel;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panels.ScrollPanel.textArea;
import static pl.pp.simulation.utils.ProgramData.*;

public class ResetButton extends JButton {

    private StartButton startButton;
    private StopButton stopButton;
    private Step timer;

    public ResetButton(String text) {
        super(text);
        System.out.println("Konstruktor - ResetButton");

    }

    public void clear() {

        Hares.hareList.clear();
        GrassUtils.grassList.clear();
        Foxes.foxList.clear();
    }

    @PostConstruct
    private void init(){
        addActionListener(e -> {
            running = false;
            started = false;

            textArea.setText("");

            simulationChart.clear();

            startButton.setEnabled(true);
            stopButton.setEnabled(false);

            timer.stop();

            clear();

            ControlPanel.setEditableParameters();

            steps = 0;
            ControlPanel.timeLabel.setText("Czas: 0");

        });
    }

    public void setStartButton(StartButton startButton) {
        this.startButton = startButton;
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }

    public void setTimer(Step timer) {
        this.timer = timer;
    }
}