package main.objects.objectOnMap.person;

import main.engine.Engine;
import main.objects.Inventory;
import main.objects.ListLocationAndObjectOnMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Hero extends Person {
    public String name;
    public int lvl;
    public int currentExp;
    public int numberOfCoin;
    private Inventory inventory;
    private HashMap<Character, Runnable> actionInventory;
    public Hero (String name, ListLocationAndObjectOnMap listLocationAndObjectOnMap, Inventory inventory) {
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
        action.put('i', () -> {
            Engine.getEngine().inventoryVisible = !Engine.getEngine().inventoryVisible;
            inventory.setVisible(Engine.getEngine().inventoryVisible);
        });
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
        //hero action inventory
        this.actionInventory = new HashMap<Character, Runnable>();
        actionInventory.put('i', () -> {
            Engine.getEngine().inventoryVisible = !Engine.getEngine().inventoryVisible;
            inventory.setVisible(Engine.getEngine().inventoryVisible);
        });
        actionInventory.put('w', () -> {
            inventory.currentSlotInventoryUp();
        });
        actionInventory.put('s', () -> {
            inventory.currentSlotInventoryDown();
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
        if (action.containsKey(inputChar) || actionInventory.containsKey(inputChar)) {
            if (Engine.getEngine().inventoryVisible) {
                try {
                    actionInventory.get(inputChar).run();
                } catch (NullPointerException e) {}
                return;
            } else {
                try {
                    action.get(inputChar).run();
                } catch (NullPointerException e) {}
            }
            int[] locationForCheck = newLocation;
            if (iterationLogic()) {
                listLocationAndObjectOnMap.removeObjectFromListLocationAndObjectOnMap(currentLocation);
                currentLocation = newLocation;
                listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
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

    public String getName() {
        return name;
    }
    public int getLvl() {
        return lvl;
    }
    public int getCurrentExp() {
        return currentExp;
    }
    public int getMaxHp() {
        return maxHp;
    }
    public int getCurrentHp() {
        return currentHp;
    }
    public int getDamage() {
        return damage;
    }
    public int getNumberOfCoin() {
        return numberOfCoin;
    }
}
