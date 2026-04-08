package DesignPatterns.StructuralDesign.Facade.SubSystem;

public class Projector {
    public void on() { System.out.println("Projector: Warming up."); }
    public void off() { System.out.println("Projector: Cooling down."); }
    public void wideScreenMode() { System.out.println("Projector: Widescreen mode enabled."); }
}
