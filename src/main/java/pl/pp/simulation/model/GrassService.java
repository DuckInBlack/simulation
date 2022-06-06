package pl.pp.simulation.model;


import pl.pp.simulation.charts.SimulationChart;
import pl.pp.simulation.utils.ParameterModel;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static pl.pp.simulation.utils.ProgramData.steps;

public class GrassService {
    private final List<Grass> grassList = new LinkedList<>();
    private int frequency = 5;

    private SimulationChart simulationChart;
    private ParameterModel grassParameter;

    public List<Grass> getGrassList() {
        return grassList;
    }

    public void setSimulationChart(SimulationChart simulationChart) {
        this.simulationChart = simulationChart;
    }

    public void setGrassParameter(ParameterModel grassParameter) {
        this.grassParameter = grassParameter;
    }

    public void draw(Graphics2D graphics2D) {
        for (Grass grass : grassList) {
            grass.draw(graphics2D);
        }
    }

    public void updateAmount() {
        int grassAmount = grassList.size();
        grassParameter.setValue(grassAmount);
        simulationChart.getGrassSeries().add(steps, grassAmount);
    }

    public void grow() {
        frequency = 5;
        if (steps % frequency == 0) {
            grassList.add(new Grass());
        }
    }
}

