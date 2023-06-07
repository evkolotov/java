package main;
import main.engine.Engine;
public class Main {
    public static void main(String[] args) {
        Engine engine = Engine.getEngine();
        engine.run();
    }
}