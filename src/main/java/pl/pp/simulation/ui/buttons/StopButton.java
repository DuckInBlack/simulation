package pl.pp.simulation.ui.buttons;

import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.timer;
import static pl.pp.simulation.utils.ProgramData.running;

public class StopButton extends JButton {
    private static final StopButton stopButton = new StopButton("Stop");

    public static StopButton getInstance() {
        return stopButton;
    }

    private StopButton(String text) {
        super(text);

        setEnabled(false);
        addActionListener(e -> {
            StartButton.getInstance().setEnabled(true);
            setEnabled(false);
            running = false;
            timer.stop();

        });
    }
}
