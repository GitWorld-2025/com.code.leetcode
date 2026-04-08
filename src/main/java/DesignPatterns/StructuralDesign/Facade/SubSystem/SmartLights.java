package DesignPatterns.StructuralDesign.Facade.SubSystem;

public class SmartLights {
    public void dim(int level) { System.out.println("Lights: Dimmed to " + level + "%."); }
    public void on() { System.out.println("Lights: Full brightness."); }
}
