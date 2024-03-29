package pl.pp.simulation.model;

import pl.pp.simulation.utils.ProgramData;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Grass extends Organism {
    public static int size = 8;

    public Grass() {
        Random random = new Random();
        x = random.nextInt(ProgramData.maxWidth - size);
        y = random.nextInt(ProgramData.maxHeight - size);
    }

    public void draw(Graphics2D graphics2D) {
        Ellipse2D.Double grassEllipse = new Ellipse2D.Double(x, y, size, size);
        graphics2D.setPaint(new Color(25, 128, 9));
        graphics2D.fill(grassEllipse);
    }


}

