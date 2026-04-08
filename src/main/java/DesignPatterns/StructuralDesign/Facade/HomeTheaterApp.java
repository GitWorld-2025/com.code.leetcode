package DesignPatterns.StructuralDesign.Facade;

import DesignPatterns.StructuralDesign.Facade.SubSystem.*;

public class HomeTheaterApp {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        SmartLights lights = new SmartLights();
        StreamingService streaming = new StreamingService();

        HomeTheaterFacade theater = new HomeTheaterFacade(amp, dvd, projector, lights, streaming);

        theater.watchMovie("Interstellar");
        theater.endMovie();
    }
}
