package main.object.frames;

public class Engine {
    private static Engine engine;
    //
    private Engine() {
        //int();
    }
    public static Engine getEngine() {
        if (engine == null) {
            engine = new Engine();
        }
        return engine;
    }
    public void run() {
        //run
    }
}
