package pl.pp.simulation;

import pl.pp.simulation.model.Foxes;
import pl.pp.simulation.model.GrassUtils;
import pl.pp.simulation.model.Hares;
import pl.pp.simulation.ui.SimulationComponent;

import javax.swing.*;

import static pl.pp.simulation.ui.panels.ControlPanel.timeLabel;
import static pl.pp.simulation.utils.ProgramData.steps;

public class Step {
    private Timer timer;

    public Step(SimulationComponent simulationComponent) {
        System.out.println("Konstruktor - Step");
        timer = new Timer(40, e -> {
            steps++;
            timeLabel.setText("Czas: " + steps);

            GrassUtils.grow();

            Hares.move();
            Foxes.move();

            updateAmount();
            simulationComponent.repaint();
        });
    }
    public void start(){
        timer.start();
    }

    public void stop(){
        timer.stop();
    }

    public void updateAmount() {
        GrassUtils.updateAmount();
        Hares.updateAmount();
        Foxes.updateAmount();

    }
}
