package DesignPatterns.StructuralDesign.Facade.SubSystem;

public class Amplifier {
    public void on() { System.out.println("Amplifier: Powering on."); }
    public void off() { System.out.println("Amplifier: Shutting down."); }
    public void setVolume(int level) { System.out.println("Amplifier: Volume set to " + level + "."); }
}
