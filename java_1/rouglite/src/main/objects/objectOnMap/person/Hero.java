package main.objects.objectOnMap.person;

import main.objects.objectOnMap.ListObjectOnMap;

import java.util.*;

public class Hero extends Person {
    private int lvl;
    private int numberOfCoin;
    private ListObjectOnMap listObjectOnMap;
    HashMap<Character, Runnable> action = new HashMap<Character, Runnable>();


    int[] currentLocation;
    int[] newLocation;
    Iterator<int[]> iterator;
    public Hero (String name, ListObjectOnMap listObjectOnMap) {
        this.listObjectOnMap = listObjectOnMap;
        this.name = name;
        this.charOnMap = '@';
        this.numberOfCoin = 0;
        this.hp = 100;
        this.damage = 10;
        this.location = new HashSet<int[]>();
        location.add(new int[] {1,1});
    }
    public void action (char inputChar) {
        action = new HashMap<Character, Runnable>();
        action.put('w', () -> {
            iterator = location.iterator();
            currentLocation = iterator.next();
            newLocation = new int[]{currentLocation[0] - 1, currentLocation[1]};
            iteractionLogic(listObjectOnMap.hasObjectAtLocation(newLocation), newLocation);
            if (listObjectOnMap.hasObjectAtLocation(newLocation) != '#') {
                location.remove(currentLocation);
                location.add(newLocation);
            }
        });
        action.put('s', () -> {
            iterator = location.iterator();
            currentLocation = iterator.next();
            newLocation = new int[]{currentLocation[0] + 1, currentLocation[1]};
            iteractionLogic(listObjectOnMap.hasObjectAtLocation(newLocation), newLocation);
            if (listObjectOnMap.hasObjectAtLocation(newLocation) != '#') {
                location.remove(currentLocation);
                location.add(newLocation);
            }
        });
        action.put('a', () -> {
            iterator = location.iterator();
            currentLocation = iterator.next();
            newLocation = new int[]{currentLocation[0], currentLocation[1] - 1};
            iteractionLogic(listObjectOnMap.hasObjectAtLocation(newLocation), newLocation);
            if (listObjectOnMap.hasObjectAtLocation(newLocation) != '#') {
                location.remove(currentLocation);
                location.add(newLocation);
            }
        });
        action.put('d', () -> {
            iterator = location.iterator();
            currentLocation = iterator.next();
            newLocation = new int[]{currentLocation[0], currentLocation[1] + 1};
            iteractionLogic(listObjectOnMap.hasObjectAtLocation(newLocation), newLocation);
            if (listObjectOnMap.hasObjectAtLocation(newLocation) != '#') {
                location.remove(currentLocation);
                location.add(newLocation);
            }
        });
        if (action.containsKey(inputChar)) {
            action.get(inputChar).run();
        } else {
            System.out.println("wrong input");
            Set<Character> keys = action.keySet();
            for (Character key : keys) {
                System.out.print(key+"\t");
            }
        }

    }

    @Override
    public void iteractionLogic (Character currentCharOnMap, int[] newLocation) {
        switch (currentCharOnMap) {
            case '$':
                numberOfCoin++;
                System.out.println("numberOfCoin: "+numberOfCoin);

                listObjectOnMap.removeObjectToList(currentCharOnMap, newLocation);
        }
    }
}
