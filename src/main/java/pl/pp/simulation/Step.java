package pl.pp.simulation;

import javax.swing.*;

import static pl.pp.simulation.Components.*;
import static pl.pp.simulation.ProgramData.*;

public class Step  extends Timer {
    public Step() {
        super(40, e -> {
            steps++;
            timeLabel.setText("Czas: " + steps);

            newHareList.clear();
            for (Hare hare : hareList) {
                hare.move();
            }
            hareList.addAll(newHareList);

            hareParameter.setValue(hareList.size());

            myComponent.repaint();
        });
    }
}
