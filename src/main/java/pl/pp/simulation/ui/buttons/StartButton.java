package pl.pp.simulation.ui.buttons;


import pl.pp.simulation.Step;
import pl.pp.simulation.model.*;
import pl.pp.simulation.utils.ParameterModel;

import javax.annotation.PostConstruct;
import javax.swing.*;

import static pl.pp.simulation.utils.ProgramData.running;
import static pl.pp.simulation.utils.ProgramData.started;

public class StartButton extends JButton {
    public ParameterModel grassParameter;
    public ParameterModel hareParameter;
    public ParameterModel foxParameter;

    private StopButton stopButton;
    private Step timer;
    private GrassService grassService;
    private FoxesService foxesService;
    private HaresService haresService;

    public StartButton(String text) {
        super(text);
        System.out.println("Konstruktor - StartButton");
    }

    @PostConstruct
    private void init() {
        addActionListener(e -> {
            stopButton.setStartButton(this);
            if (!started) {
                createObjects();
            }

            running = true;
            started = true;

            setEnabled(false);
            stopButton.setEnabled(true);

            grassParameter.setEditable(false);
            hareParameter.setEditable(false);
            foxParameter.setEditable(false);

            timer.start();

        });
    }

    public void createObjects() {
        for (int i = 0; i < hareParameter.getValue(); i++) {
            haresService.getHareList().add(new Hare());
        }
        for (int i = 0; i < foxParameter.getValue(); i++) {
            foxesService.getFoxList().add(new Fox());
        }
        for (int i = 0; i < grassParameter.getValue(); i++) {
            grassService.getGrassList().add(new Grass());
        }
    }

    public void setNotEditableParameters() {
        grassParameter.setEditable(false);
        hareParameter.setEditable(false);
        foxParameter.setEditable(false);
    }

    public void setStopButton(StopButton stopButton) {
        this.stopButton = stopButton;
    }

    public void setTimer(Step timer) {
        this.timer = timer;
    }

    public void setGrassService(GrassService grassService) {
        this.grassService = grassService;
    }

    public void setFoxesService(FoxesService foxesService) {
        this.foxesService = foxesService;
    }

    public void setHaresService(HaresService haresService) {
        this.haresService = haresService;
    }

    public void setGrassParameter(ParameterModel grassParameter) {
        this.grassParameter = grassParameter;
    }

    public void setHareParameter(ParameterModel hareParameter) {
        this.hareParameter = hareParameter;
    }

    public void setFoxParameter(ParameterModel foxParameter) {
        this.foxParameter = foxParameter;
    }
}

