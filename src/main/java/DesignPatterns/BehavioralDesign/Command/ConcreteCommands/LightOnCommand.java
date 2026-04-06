package DesignPatterns.BehavioralDesign.Command.ConcreteCommands;

import DesignPatterns.BehavioralDesign.Command.Command;
import DesignPatterns.BehavioralDesign.Command.Receivers.Light;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() { light.on(); }

    @Override
    public void undo() { light.off(); }
}
