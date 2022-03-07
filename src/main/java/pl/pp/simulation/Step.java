package pl.pp.simulation;

import pl.pp.simulation.model.Foxes;
import pl.pp.simulation.model.GrassUtils;
import pl.pp.simulation.model.Hares;
import pl.pp.simulation.model.Organisms;
import pl.pp.simulation.ui.SimulationComponent;

import javax.swing.*;

import static pl.pp.simulation.ui.panels.ControlPanel.timeLabel;
import static pl.pp.simulation.utils.ProgramData.steps;

public class Step extends Timer {
    public Step() {
        super(40, e -> {
            steps++;
            timeLabel.setText("Czas: " + steps);

            GrassUtils.grow();

            Hares.move();
            Foxes.move();

            Organisms.updateAmount();
            SimulationComponent.getInstance().repaint();
        });
    }
}
