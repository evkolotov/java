package main.engine;

import main.objects.Map;
import main.objects.objectOnMap.Coin;
import main.objects.objectOnMap.ListObjectOnMap;
import main.objects.objectOnMap.Wall;
import main.objects.objectOnMap.person.Hero;

import java.util.Scanner;

public class Engine {
    private static Engine engine;
    //default settings map
    private int numberOfRowsMap = 25;
    private int numberOfColumnsMap = 25;

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
        Map map = new Map(numberOfRowsMap, numberOfColumnsMap);

        ListObjectOnMap listObjectOnMap = new ListObjectOnMap();

        Hero hero = new Hero("Heroin", listObjectOnMap);
        listObjectOnMap.addObjectToList(hero.charOnMap, hero.getLocation());

        Wall wall = new Wall(numberOfRowsMap, numberOfColumnsMap);
        listObjectOnMap.addObjectToList(wall.charOnMap, wall.getLocation());

        Coin coin = new Coin(numberOfRowsMap, numberOfColumnsMap);
        coin.addCoinOnMap(listObjectOnMap);
        listObjectOnMap.addObjectToList(coin.charOnMap, coin.getLocation());

        map.generateMap(listObjectOnMap.getListObjectOnMap());
        map.renderMap();

//        //run
        while (true) {
            char inputChar = scanner.next().charAt(0);
            hero.action (inputChar);


            map.generateMap(listObjectOnMap.getListObjectOnMap());
            map.renderMap();
        }

    }
}