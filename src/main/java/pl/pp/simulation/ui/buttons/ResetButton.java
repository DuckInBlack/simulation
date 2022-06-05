package pl.pp.simulation.ui.buttons;

import pl.pp.simulation.Step;
import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
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
    private GrassService grassService;
    private FoxesService foxesService;
    private HaresService haresService;

    private JLabel timeLabel;

    public ResetButton(String text) {
        super(text);
        System.out.println("Konstruktor - ResetButton");
    }

    public void clear() {
        haresService.getHareList().clear();
        grassService.getGrassList().clear();
        foxesService.getFoxList().clear();
    }

    @PostConstruct
    private void init() {
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
            timeLabel.setText("Czas: 0");

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

    public void setGrassService(GrassService grassService) {
        this.grassService = grassService;
    }

    public void setFoxesService(FoxesService foxesService) {
        this.foxesService = foxesService;
    }

    public void setHaresService(HaresService haresService) {
        this.haresService = haresService;
    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }
}