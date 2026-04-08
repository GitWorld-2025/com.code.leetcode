package DesignPatterns.StructuralDesign.Facade;
import DesignPatterns.StructuralDesign.Facade.SubSystem.*;
class HomeTheaterFacade {
    private Amplifier amp;
    private DvdPlayer dvd;
    private Projector projector;
    private SmartLights lights;
    private StreamingService streaming;

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd, Projector projector,
                             SmartLights lights, StreamingService streaming) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.lights = lights;
        this.streaming = streaming;
    }

    public void watchMovie(String movie) {
        System.out.println("\n--- Preparing to watch: " + movie + " ---");
        lights.dim(15);
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(20);
        streaming.connect();
        streaming.stream(movie);
        System.out.println("--- Enjoy the movie! ---\n");
    }

    public void endMovie() {
        System.out.println("\n--- Shutting down home theater ---");
        streaming.disconnect();
        amp.off();
        projector.off();
        lights.on();
        System.out.println("--- Home theater off ---\n");
    }
}
