package pl.pp.simulation.model;

import pl.pp.simulation.utils.Utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Collections;
import java.util.Comparator;

import static pl.pp.simulation.ui.panels.ScrollPanel.textArea;
import static pl.pp.simulation.utils.Utils.getDistance;
import static pl.pp.simulation.utils.Utils.multipleHares;

public class Hare extends Animal {

    public Hare() {
        super();
    }

    public Hare(double x, double y) {
        super(x, y);
    }

    @Override
    public void init() {
        visibility = 55;
        maxSpeed = 10;
    }

    @Override
    public void move() {
        super.move();

        if (hunger > deathlyHunger) {
            haresService.getDeathHareList().add(this);
        }
    }

    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double hareEllipse = new Ellipse2D.Double(x, y, size, size);
        graphics2D.setPaint(Color.DARK_GRAY);
        graphics2D.fill(hareEllipse);
    }

    public void changeSpeed() {
        if (getVisibleFoxes().size() > 0) {
            Fox nearestFox = Collections.min(getVisibleFoxes(),
                    Comparator.comparingDouble((Fox fox) -> getDistance(this, fox)));
            runAwayFrom(nearestFox);
        } else if (hunger >= minimumHunger && getVisibleGrass().size() > 0) {
            Grass nearestGrass = Collections.min(getVisibleGrass(),
                    Comparator.comparingDouble((Grass grass) -> getDistance(this, grass)));
            adjustSpeedTo(nearestGrass);
            eatIfContact(nearestGrass);
        } else if (desireForParenthood >= minimumDesireForParenthood && getVisibleHares().size() > 0
                && hunger < minimumHunger * 2) {
            Hare nearestHare = Collections.min(getVisibleHares(),
                    Comparator.comparingDouble((Hare hare) -> getDistance(this, hare)));
            adjustSpeedTo(nearestHare);
            multipleIfContact(nearestHare);
        } else {
            randomChangeSpeed();
        }
    }

    private void multipleIfContact(Hare nearestHare) {
        double distance = Utils.getDistance(nearestHare, this);
        if (distance < size) {
            multipleHares(this, nearestHare);
        }
    }

    private void eatIfContact(Grass nearestGrass) {
        double distance = getDistance(nearestGrass, this);

        if (distance < size) {
            eatGrass(nearestGrass);
        }
    }

    private void eatGrass(Grass nearestGrass) {
        grassService.getGrassList().remove(nearestGrass);
        textArea.append("\n Zjedzenie trawy");
        hunger -= reducingHungerByGrass;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
