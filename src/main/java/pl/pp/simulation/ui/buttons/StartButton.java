package pl.pp.simulation.ui.buttons;


import pl.pp.simulation.model.*;
import pl.pp.simulation.ui.panels.ControlPanel;
import pl.pp.simulation.utils.ParameterModel;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.*;

public class StartButton extends JButton {
    public ParameterModel grassParameter = ControlPanel.grassParameter;
    public ParameterModel hareParameter = ControlPanel.hareParameter;
    public ParameterModel foxParameter = ControlPanel.foxParameter;

    private static final StartButton START_BUTTON = new StartButton("Start");

    public static StartButton getInstance() {
        return START_BUTTON;
    }

    private StartButton(String text) {
        super(text);

        addActionListener(e -> {
            if (!started) {
                init();
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

    public void init() {
        for (int i = 0; i < hareParameter.getValue(); i++) {
            Hares.hareList.add(new Hare());
        }
        for (int i = 0; i < foxParameter.getValue(); i++) {
            Foxes.foxList.add(new Fox());
        }
        for (int i = 0; i < grassParameter.getValue(); i++) {
            GrassUtils.grassList.add(new Grass());
        }
    }
}

