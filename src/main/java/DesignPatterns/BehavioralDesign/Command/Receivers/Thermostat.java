package DesignPatterns.BehavioralDesign.Command.Receivers;

public class Thermostat {
    private int currentTemperature = 20;

    public void setTemperature(int temp) {
        System.out.println("Thermostat set to " + temp + "C");
        currentTemperature = temp;
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }
}
