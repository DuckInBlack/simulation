package pl.pp.simulation.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Collections;
import java.util.Comparator;

import static pl.pp.simulation.ui.panels.ScrollPanel.textArea;
import static pl.pp.simulation.utils.Utils.getDistance;
import static pl.pp.simulation.utils.Utils.multipleFoxes;


public class Fox extends Animal {

    public Fox() {
        super();
    }

    public Fox(double x, double y) {
        super(x, y);
    }

    @Override
    public void move() {
        super.move();
        if (hunger > deathlyHunger) {
            foxesService.getDeathFoxList().add(this);
        }
    }

    @Override
    public void init() {
        visibility = 50;
        maxSpeed = 12;
    }

    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double hareEllipse = new Ellipse2D.Double(x, y, size, size);
        graphics2D.setPaint(Color.RED);
        graphics2D.fill(hareEllipse);
    }

    public void changeSpeed() {
        if (getVisibleHares().size() > 0) {
            Hare nearestHare = Collections.min(getVisibleHares(), Comparator.comparingDouble((Hare hare) -> getDistance(this, hare)));
            adjustSpeedTo(nearestHare);
            eatIfContact(nearestHare);
        } else if (desireForParenthood >= minimumDesireForParenthood && getVisibleFoxes().size() > 0 && hunger < minimumHunger * 2) {
            Fox nearestFox = Collections.min(getVisibleFoxes(), Comparator.comparingDouble((Fox fox) -> getDistance(this, fox)));
            adjustSpeedTo(nearestFox);
            multipleIfContact(nearestFox);

        } else {
            randomChangeSpeed();
        }
    }

    private void multipleIfContact(Fox nearestFox) {
        double distance = getDistance(nearestFox, this);
        if (distance < size) {
            multipleFoxes(this, nearestFox);
        }
    }

    private void eatIfContact(Hare nearestHare) {
        double distance = getDistance(nearestHare, this);

        if (distance < size) {
            eatHare(nearestHare);
        }
    }

    private void eatHare(Hare nearestHare) {
        haresService.getHareList().remove(nearestHare);
        textArea.append("\n Zjedzenie zająca");
        hunger -= reducingHungerByHare;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
