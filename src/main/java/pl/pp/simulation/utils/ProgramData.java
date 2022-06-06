package pl.pp.simulation.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.pp.simulation.config.SimulationConfig;

public class ProgramData {

    public static int frameWidth = 1400;
    public static int frameHeight = 1050;

    public static int maxWidth = 1200;
    public static int maxHeight = 900;

    public static boolean started = false;
    public static boolean running = false;
    public static ApplicationContext context = new AnnotationConfigApplicationContext(SimulationConfig.class);
    public static long steps = 0;


}
