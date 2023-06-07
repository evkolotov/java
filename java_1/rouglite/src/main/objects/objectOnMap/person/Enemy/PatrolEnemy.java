package main.objects.objectOnMap.person.Enemy;

import main.engine.Engine;
import main.objects.ListObjectOnMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class PatrolEnemy extends Enemy {
    int[] currentLocation;
    int[] newLocation;
    boolean switchLogicForMove = true;
    int numberOfDirection = 2;
    Iterator<int[]> iterator;
    public PatrolEnemy (String name, ListObjectOnMap listObjectOnMap) {
        this.listObjectOnMap = listObjectOnMap;
        this.name = name;
        this.charOnMap = 'b';
        this.maxHp = 30;
        this.currentHp = maxHp;
        this.damage = 5;
        this.locationList = new HashSet<int[]>();
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
    }
    public void addOnMap () {
        Random random = new Random();
        int[] newLocation;
        do {
            newLocation = new int[] {random.nextInt(numberOfRowsMap), random.nextInt(numberOfColumnsMap)};
        } while (listObjectOnMap.hasObjectAtLocation(newLocation) != '.');
        locationList.add(newLocation);
        listObjectOnMap.addObjectToList(charOnMap, locationList);
    }
    public void action () {
        boolean actionSuccess = false;
        while (!actionSuccess) {
            iterator = locationList.iterator();
            currentLocation = iterator.next();
            iterator = locationList.iterator();
            currentLocation = iterator.next();
            //move logic
            if (switchLogicForMove) {
                newLocation = new int[]{currentLocation[0] - 1, currentLocation[1]};
            } else {
                newLocation = new int[]{currentLocation[0] + 1, currentLocation[1]};
            }
            //iteration logic
            if (iterationLogic(listObjectOnMap.hasObjectAtLocation(newLocation), newLocation)) {
                locationList.remove(currentLocation);
                locationList.add(newLocation);
                listObjectOnMap.addObjectToList(charOnMap, locationList);
                actionSuccess = !actionSuccess;
            } else {
                switchLogicForMove = !switchLogicForMove;
            }
        }
    }

    @Override
    public boolean iterationLogic(Character currentCharOnMap, int[] newLocation) {
        switch (currentCharOnMap) {
            case '#', 's':
                return false;
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
        }
        return true;
    }
}
