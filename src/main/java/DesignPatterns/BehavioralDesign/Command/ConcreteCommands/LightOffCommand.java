package DesignPatterns.BehavioralDesign.Command.ConcreteCommands;

import DesignPatterns.BehavioralDesign.Command.Command;
import DesignPatterns.BehavioralDesign.Command.Receivers.Light;

public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() { light.off(); }

    @Override
    public void undo() { light.on(); }
}
