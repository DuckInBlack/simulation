package pl.pp.simulation.model;


import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panels.ControlPanel.grassParameter;
import static pl.pp.simulation.utils.ProgramData.steps;

public class GrassUtils {
    public static List<Grass> grassList = new LinkedList<>();
    private static int frequency = 5;

    public static void draw(Graphics2D graphics2D) {
        for (Grass grass : grassList) {
            grass.draw(graphics2D);
        }
    }

    public static void updateAmount() {
        int grassAmount = GrassUtils.grassList.size();
        grassParameter.setValue(grassAmount);
        simulationChart.getGrassSeries().add(steps, grassAmount);
    }

    public static void grow() {
        frequency = 5;
        if (steps % frequency == 0) {
            GrassUtils.grassList.add(new Grass());
        }
    }
}

