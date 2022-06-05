package pl.pp.simulation;

import pl.pp.simulation.model.FoxesService;
import pl.pp.simulation.model.GrassService;
import pl.pp.simulation.model.HaresService;
import pl.pp.simulation.ui.SimulationComponent;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.steps;

public class Step {

    private Timer timer;

    private GrassService grassService;
    private HaresService haresService;
    private FoxesService foxesService;

    private SimulationComponent simulationComponent;
    private JLabel timeLabel;

    public Step() {
        System.out.println("Konstruktor - Step");
    }

    @PostConstruct
    private void init() {
        timer = new Timer(40, e -> {
            steps++;
            timeLabel.setText("Czas: " + steps);

            grassService.grow();
            haresService.move();
            foxesService.move();

            updateAmount();

            simulationComponent.repaint();
        });
    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void updateAmount() {
        grassService.updateAmount();
        haresService.updateAmount();
        foxesService.updateAmount();
    }

    public void setGrassService(GrassService grassService) {
        this.grassService = grassService;
    }

    public void setSimulationComponent(SimulationComponent simulationComponent) {
        this.simulationComponent = simulationComponent;
    }

    public void setHaresService(HaresService haresService) {
        this.haresService = haresService;
    }

    public void setFoxesService(FoxesService foxesService) {
        this.foxesService = foxesService;
    }

    public void setTimeLabel(JLabel timeLabel) {
        this.timeLabel = timeLabel;
    }
}