package main;
import main.object.frames.Engine;
public class Main {
    public static void main(String[] args) {
        Engine engine = Engine.getEngine();
        engine.run();
    }
}