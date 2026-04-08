package DesignPatterns.StructuralDesign.Facade.SubSystem;

public class DvdPlayer {
    public void on() { System.out.println("DVD Player: Powering on."); }
    public void off() { System.out.println("DVD Player: Shutting down."); }
    public void play(String movie) { System.out.println("DVD Player: Playing '" + movie + "'."); }
    public void stop() { System.out.println("DVD Player: Stopped."); }
}
