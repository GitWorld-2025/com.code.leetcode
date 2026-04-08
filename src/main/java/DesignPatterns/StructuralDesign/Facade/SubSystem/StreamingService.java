package DesignPatterns.StructuralDesign.Facade.SubSystem;

public class StreamingService {
    public void connect() { System.out.println("Streaming: Connected to service."); }
    public void disconnect() { System.out.println("Streaming: Disconnected."); }
    public void stream(String movie) { System.out.println("Streaming: Now streaming '" + movie + "'."); }
}
