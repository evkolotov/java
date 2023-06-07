package main.engine;

import main.objects.Map;
import main.objects.objectOnMap.Coin;
import main.objects.ListObjectOnMap;
import main.objects.objectOnMap.Teleport;
import main.objects.objectOnMap.Wall;
import main.objects.objectOnMap.person.Enemy.PatrolEnemy;
import main.objects.objectOnMap.person.Hero;
import main.objects.objectOnMap.person.Spike;

import java.util.Scanner;

public class Engine {
    private static Engine engine;
    //default settings map
    public int numberOfRowsMap = 25;
    public int numberOfColumnsMap = 25;
    Scanner scanner = new Scanner(System.in);
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
        ListObjectOnMap listObjectOnMap = new ListObjectOnMap();

        Map map = new Map(listObjectOnMap);

        Hero hero = new Hero("Heroin", listObjectOnMap);
        hero.addOnMap();

        Wall wall = new Wall(listObjectOnMap);
        wall.addOnMap();

        Coin coin = new Coin(listObjectOnMap);
        coin.addOnMap();

        Teleport teleport = new Teleport(listObjectOnMap);
        teleport.addOnMap();

        Spike spike = new Spike(listObjectOnMap);
        spike.addOnMap();

        PatrolEnemy patrolEnemy = new PatrolEnemy("patrolEnemy", listObjectOnMap);
        patrolEnemy.addOnMap();

        map.generateMap();
        map.renderMap();
        hero.getStatus();
//        //run
        while (hero.currentHp > 0) {
            char inputChar = System.console().readPassword()[0];
            hero.action (inputChar);
            patrolEnemy.action();


            map.generateMap();
            map.renderMap();
            hero.getStatus();
        }
        System.out.println("\n"+"YOU DIED");
    }
}