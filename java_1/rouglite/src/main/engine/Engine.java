package main.engine;

import main.objects.Map;
import main.objects.objectOnMap.Coin;
import main.objects.ListLocationAndObjectOnMap;
import main.objects.objectOnMap.Teleport;
import main.objects.objectOnMap.Wall;
import main.objects.objectOnMap.person.Enemy.PatrolEnemy;
import main.objects.objectOnMap.person.Enemy.PursuingEnemy;
import main.objects.objectOnMap.person.Hero;
import main.objects.objectOnMap.person.Spike;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static Engine engine;
    //default settings map
    public int numberOfRowsMap = 25;
    public int numberOfColumnsMap = 25;
    Scanner scanner = new Scanner(System.in);
    public Random random = new Random();
    private Engine() {
    }
    public static Engine getEngine() {
        if (engine == null) {
            engine = new Engine();
        }
        return engine;
    }
    public void run() {
        //start
        ListLocationAndObjectOnMap listLocationAndObjectOnMap = new ListLocationAndObjectOnMap();

        Map map = new Map(listLocationAndObjectOnMap);

        Hero hero = new Hero("Heroin", listLocationAndObjectOnMap);
        hero.addOnMap();

        Wall wall = new Wall(listLocationAndObjectOnMap);
        wall.addOnMap();

        Coin coin = new Coin(listLocationAndObjectOnMap);
        coin.addOnMap();

        Teleport teleport = new Teleport(listLocationAndObjectOnMap);
        teleport.addOnMap();

        Spike spike = new Spike(listLocationAndObjectOnMap);
        spike.addOnMap();

        PatrolEnemy patrolEnemy1 = new PatrolEnemy(listLocationAndObjectOnMap);
        patrolEnemy1.addOnMap();
        PursuingEnemy pursuingEnemy1 = new PursuingEnemy(listLocationAndObjectOnMap);
        pursuingEnemy1.addOnMap();
        PatrolEnemy patrolEnemy2 = new PatrolEnemy(listLocationAndObjectOnMap);
        patrolEnemy2.addOnMap();
        PursuingEnemy pursuingEnemy2 = new PursuingEnemy(listLocationAndObjectOnMap);
        pursuingEnemy2.addOnMap();
        PatrolEnemy patrolEnemy3 = new PatrolEnemy(listLocationAndObjectOnMap);
        patrolEnemy3.addOnMap();
        PursuingEnemy pursuingEnemy3 = new PursuingEnemy(listLocationAndObjectOnMap);
        pursuingEnemy3.addOnMap();

        map.generateMap();
        map.renderMap();
        hero.getStatus();
        //run
        while (true) {
            char inputChar = scanner.next().charAt(0);
            hero.action (inputChar);
            patrolEnemy1.action();
            pursuingEnemy1.action();
            patrolEnemy2.action();
            pursuingEnemy2.action();
            patrolEnemy3.action();
            pursuingEnemy3.action();

            map.generateMap();
            map.renderMap();
            hero.getStatus();
        }
    }
}