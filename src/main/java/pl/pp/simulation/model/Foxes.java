package pl.pp.simulation.model;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.charts.SimulationChart.simulationChart;
import static pl.pp.simulation.ui.panels.ControlPanel.foxParameter;
import static pl.pp.simulation.utils.ProgramData.steps;

public class Foxes {
    public static List<Fox> foxList = new LinkedList<>();
    public static List<Fox> newFoxList = new LinkedList<>();
    public static List<Fox> deathFoxList = new LinkedList<>();

    public static void move() {

        newFoxList.clear();
        deathFoxList.clear();
        for (Fox fox : foxList) {
            fox.move();
        }
        foxList.addAll(newFoxList);
        foxList.removeAll(deathFoxList);
    }

    public static void updateAmount() {
        int foxAmount = foxList.size();
        foxParameter.setValue(foxAmount);
        simulationChart.getFoxSeries().add(steps, foxAmount);
    }

    public static void draw(Graphics2D graphics2D) {
        for (Fox fox : foxList) {
            fox.draw(graphics2D);
        }
    }
}

