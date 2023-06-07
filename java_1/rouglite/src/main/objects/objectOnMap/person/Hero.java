package main.objects.objectOnMap.person;

import main.engine.Engine;
import main.objects.ListObjectOnMap;

import java.util.*;

public class Hero extends Person {
    private int lvl;
    private int numberOfCoin;
    int[] currentLocation;
    int[] newLocation;

    HashMap<Character, Runnable> action = new HashMap<Character, Runnable>();
    Iterator<int[]> iterator;

    public Hero (String name, ListObjectOnMap listObjectOnMap) {
        this.listObjectOnMap = listObjectOnMap;
        this.name = name;
        this.charOnMap = '@';
        this.numberOfCoin = 0;
        this.maxHp = 100;
        this.currentHp = maxHp;
        this.damage = 10;
        this.locationList = new HashSet<int[]>();
    }
    public void addOnMap () {
        locationList.add(new int[] {1,1});
        listObjectOnMap.addObjectToList(charOnMap, locationList);
    }
    public void action (char inputChar) {
        //move logic
        action = new HashMap<Character, Runnable>();
        action.put('w', () -> {
            newLocation = new int[]{currentLocation[0] - 1, currentLocation[1]};
        });
        action.put('s', () -> {
            newLocation = new int[]{currentLocation[0] + 1, currentLocation[1]};
        });
        action.put('a', () -> {
            newLocation = new int[]{currentLocation[0], currentLocation[1] - 1};
        });
        action.put('d', () -> {
            newLocation = new int[]{currentLocation[0], currentLocation[1] + 1};
        });

        //start Action
        if (action.containsKey(inputChar)) {
            iterator = locationList.iterator();
            currentLocation = iterator.next();
            //move logic
            action.get(inputChar).run();
            //iteration logic
            if (iterationLogic(listObjectOnMap.hasObjectAtLocation(newLocation), newLocation)) {
                locationList.remove(currentLocation);
                locationList.add(newLocation);
                listObjectOnMap.addObjectToList(charOnMap, locationList);
            }
        } else {
            System.out.println("wrong input");
            Set<Character> keys = action.keySet();
            for (Character key : keys) {
                System.out.println("wrong input, use key:");
                System.out.print(key+"\t");
            }
        }
    }
    @Override
    public boolean iterationLogic(Character currentCharOnMap, int[] newLocation) {
        switch (currentCharOnMap) {
            case '#':
                return false;
            case '$':
                numberOfCoin++;
                listObjectOnMap.removeObjectToList(currentCharOnMap, newLocation);
                return true;
            case 't':
                Random random = new Random();

                HashSet<int[]> locationOfTeleport = listObjectOnMap.getListObjectOnMap().get(currentCharOnMap);

                boolean newLocationFound = false;
                while (!newLocationFound) {
                    for(int[] value : locationOfTeleport) {
                        if (!Arrays.equals(value, newLocation) && random.nextBoolean()) {
                            newLocation = value;
                            newLocationFound = true;
                            break;
                        }
                    }
                }
                locationList.remove(currentLocation);
                locationList.add(newLocation);
                listObjectOnMap.addObjectToList(charOnMap, locationList);
                return false;
            case 's':
                currentHp -= 10;
                return true;
        }
        return true;
    }
    public void getStatus () {
        System.out.println("[StatusBar] [Name: "+name+"] [HP: "+currentHp+"/"+maxHp+"] [numberOfCoin: "+numberOfCoin+"]");
    }
}