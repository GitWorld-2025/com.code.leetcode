package DesignPatterns.BehavioralDesign.Command;

import DesignPatterns.BehavioralDesign.Command.ConcreteCommands.LightOffCommand;
import DesignPatterns.BehavioralDesign.Command.ConcreteCommands.LightOnCommand;
import DesignPatterns.BehavioralDesign.Command.ConcreteCommands.SetTemperatureCommand;
import DesignPatterns.BehavioralDesign.Command.Invoker.RemoteControl;
import DesignPatterns.BehavioralDesign.Command.Receivers.Light;
import DesignPatterns.BehavioralDesign.Command.Receivers.Thermostat;

public class SmartHomeApp {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);
        Command setTemp = new SetTemperatureCommand(thermostat, 25);

        RemoteControl remote = new RemoteControl();

        System.out.println("--- Executing Commands ---");
        remote.executeCommand(lightOn);
        remote.executeCommand(setTemp);
        remote.executeCommand(lightOff);

        System.out.println("\n--- Undoing Commands ---");
        remote.undoLast();
        remote.undoLast();
        remote.undoLast();
        remote.undoLast();
    }
}
