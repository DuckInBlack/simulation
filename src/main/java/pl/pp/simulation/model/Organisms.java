package pl.pp.simulation.model;


import pl.pp.simulation.ui.panels.ControlPanel;

import java.awt.*;

public class Organisms {
    public static void clear() {

        Hares.hareList.clear();
        GrassUtils.grassList.clear();
        Foxes.foxList.clear();
    }

    public static void init() {
        for (int i = 0; i < ControlPanel.hareParameter.getValue(); i++) {
            Hares.hareList.add(new Hare());
        }
        for (int i = 0; i < ControlPanel.foxParameter.getValue(); i++) {
            Foxes.foxList.add(new Fox());
        }
        for (int i = 0; i < ControlPanel.grassParameter.getValue(); i++) {
            GrassUtils.grassList.add(new Grass());
        }
    }

    public static void draw(Graphics2D graphics2D) {
        Hares.draw(graphics2D);
        GrassUtils.draw(graphics2D);
        Foxes.draw(graphics2D);
    }

    public static void updateAmount() {
        GrassUtils.updateAmount();
        Hares.updateAmount();
        Foxes.updateAmount();

    }
}

