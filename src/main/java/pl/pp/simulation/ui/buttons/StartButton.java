package pl.pp.simulation.ui.buttons;


import pl.pp.simulation.model.Fox;
import pl.pp.simulation.model.Grass;
import pl.pp.simulation.model.Hare;
import pl.pp.simulation.ui.panels.ControlPanel;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.*;
import static pl.pp.simulation.utils.ProgramData.running;

public class StartButton extends JButton {

    private static final StartButton startButton = new StartButton("Start");

    public static StartButton getInstance() {
        return startButton;
    }

    private StartButton(String text) {
        super(text);

        addActionListener(e -> {
            if (!started) {
                for (int i = 0; i < ControlPanel.hareParameter.getValue(); i++) {
                    hareList.add(new Hare());
                }
            }
            if (!started) {
                for (int i = 0; i < ControlPanel.foxParameter.getValue(); i++) {
                    foxList.add(new Fox());
                }
            }
            if (!started) {
                for (int i = 0; i < ControlPanel.grassParameter.getValue(); i++) {
                    grassList.add(new Grass());
                }
            }

            running = true;
            started = true;

            setEnabled(false);
            StopButton.getInstance().setEnabled(true);

            ControlPanel.grassParameter.setEditable(false);
            ControlPanel.hareParameter.setEditable(false);
            ControlPanel.foxParameter.setEditable(false);

            timer.start();

        });
    }
}
