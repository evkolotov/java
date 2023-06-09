package main.objects.objectOnMap.person;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Hero extends Person {
    private String name;
    private int lvl;
    private int currentExp;
    private int numberOfCoin;
    public Hero (String name, ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //ObjectOnMap
        this.charOnMap = '@';
        this.currentLocation = new int[]{0,0};
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.maxHp = 100;
        this.currentHp = maxHp;
        this.damage = 15;
        //Person
        this.newLocation = new int[]{0,0};
        //PersonAction
        this.action = new HashMap<Character, Runnable>();
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
        //Hero
        this.name = name;
        this.lvl = 1;
        this.currentExp = 0;
        this.numberOfCoin = 0;
    }
    public void addOnMap () {
        currentLocation = new int[]{1,1};
        listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
    }
    public void action (char inputChar) {
        if (!checkExistence()) {
            return;
        }
        //start Action
        if (action.containsKey(inputChar)) {
            action.get(inputChar).run();
            int[] locationForCheck = newLocation;
            if (iterationLogic()) {
                listLocationAndObjectOnMap.removeObjectFromListLocationAndObjectOnMap(currentLocation);
                currentLocation = newLocation;
                listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
            }
        } else {
            System.out.println("wrong input");
            Set<Character> keys = action.keySet();
            for (Character key : keys) {
                System.out.println("wrong input, use key:");
                System.out.print(key+"\t");
            }
        }
        if (currentHp <= 0) {
            dispose();
        }
        if (currentExp > 100){
            currentExp %= 100;
            lvl++;
            maxHp += 10;
            currentHp = maxHp;
            damage += 5;
        }
    }
    @Override
    public boolean iterationLogic() {
        if (listLocationAndObjectOnMap.hasObjectAtLocation(newLocation) == null){
            //if none, can move
            return true;
        }
        char charOnNewLocation = listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).charOnMap;
        switch (charOnNewLocation) {
            case '#':
                return false;
            case '$':
                numberOfCoin++;
                listLocationAndObjectOnMap.removeObjectFromListLocationAndObjectOnMap(newLocation);
                return true;
            case 't':
                ArrayList<int[]> locationTeleport = listLocationAndObjectOnMap.getListLocationByChar(charOnNewLocation);
                //if all teleport in bad position, destroy teleport
                int counter = 0;
                while (counter<10) {
                    counter++;
                    int[] randomNewLocation = locationTeleport.get(Engine.getEngine().random.nextInt(locationTeleport.size()));
                    if (randomNewLocation != newLocation) {
                        //add list location around teleport
                        ArrayList<int[]> listLocationAroundChosenTeleport = new ArrayList<>();
                        listLocationAroundChosenTeleport.add(new int[] {randomNewLocation[0]+1, randomNewLocation[1]});
                        listLocationAroundChosenTeleport.add(new int[] {randomNewLocation[0]-1, randomNewLocation[1]});
                        listLocationAroundChosenTeleport.add(new int[] {randomNewLocation[0], randomNewLocation[1]+1});
                        listLocationAroundChosenTeleport.add(new int[] {randomNewLocation[0], randomNewLocation[1]-1});
                        //check location around chosen teleport
                        for (int[] location : listLocationAroundChosenTeleport) {
                            if (listLocationAndObjectOnMap.hasObjectAtLocation(location) == null) {
                                newLocation = location;
                                return true;
                            }
                        }
                    }
                }
                return true;
            case 's':
                currentHp -= listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).damage;
                return false;
            case 'b', 'd':
                listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).currentHp -= damage;
                if (listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).currentHp <= 0) {
                    currentExp += listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).maxHp;
                    listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).dispose();
                    System.out.println("you killed the enemy");
                    System.out.println("We're Watching You. Scum");
                } else {
                    System.out.println("you attacked the enemy, for what?");
                }
                return false;
        }
        return false;
    }
    public void getStatus () {
        System.out.println("[StatusBar] [Name: "+name+
                "] [lvl: "+lvl+
                "] [exp: "+currentExp+
                "] [HP: "+currentHp+"/"+maxHp+
                "] [Damage: "+damage+
                "] [numberOfCoin: "+numberOfCoin+"]");
    }
    public void dispose() {
        System.out.println("YOU DIED, THANKS");
        listLocationAndObjectOnMap.removeObjectFromListLocationAndObjectOnMap(currentLocation);
    }
}
