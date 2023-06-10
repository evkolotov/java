package main.engine;

import main.objects.ArrowKeys;
import main.objects.HeroPanel;
import main.objects.Map;
import main.objects.objectOnMap.Coin;
import main.objects.ListLocationAndObjectOnMap;
import main.objects.objectOnMap.Teleport;
import main.objects.objectOnMap.Wall;
import main.objects.objectOnMap.person.Enemy.PatrolEnemy;
import main.objects.objectOnMap.person.Enemy.PursuingEnemy;
import main.objects.objectOnMap.person.Hero;
import main.objects.objectOnMap.person.Spike;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static Engine engine;
    //default settings map
    public int numberOfRowsMap = 30;
    public int numberOfColumnsMap = 50;
    Scanner scanner = new Scanner(System.in);
    public Random random = new Random();
    public char inputChar;
    public static boolean inputProcessed = false;
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

        PatrolEnemy patrolEnemy4 = new PatrolEnemy(listLocationAndObjectOnMap);
        patrolEnemy4.addOnMap();
        PursuingEnemy pursuingEnemy4 = new PursuingEnemy(listLocationAndObjectOnMap);
        pursuingEnemy4.addOnMap();

        PatrolEnemy patrolEnemy5 = new PatrolEnemy(listLocationAndObjectOnMap);
        patrolEnemy5.addOnMap();
        PursuingEnemy pursuingEnemy5 = new PursuingEnemy(listLocationAndObjectOnMap);
        pursuingEnemy5.addOnMap();

        map.generateMap();
        map.renderMap();
        hero.getStatus();

        JFrame frame = new JFrame("ArrowKeysExample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ArrowKeys arrowKeys = new ArrowKeys(map);
        frame.getContentPane().add(arrowKeys);
        HeroPanel heroPanel = new HeroPanel(hero);
        heroPanel.updateHeroPanel();
        frame.getContentPane().add(heroPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        arrowKeys.requestFocusInWindow();

        //run
        heroPanel.updateHeroPanel();

        while (true) {
            inputChar = '#';

            while (!inputProcessed) {
                synchronized (Engine.getEngine()) {
                    try {
                        Engine.getEngine().wait(); // ожидание, пока inputProcessed не станет true
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            inputProcessed = false;

            hero.action(inputChar);
            map.generateMap();
            heroPanel.updateHeroPanel();

            patrolEnemy1.action();
            pursuingEnemy1.action();

            patrolEnemy2.action();
            pursuingEnemy2.action();

            patrolEnemy3.action();
            pursuingEnemy3.action();

            patrolEnemy4.action();
            pursuingEnemy4.action();

            patrolEnemy5.action();
            pursuingEnemy5.action();

            map.generateMap();
        }
    }
}