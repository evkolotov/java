package main.objects.objectOnMap.person.Enemy;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;

import java.util.ArrayList;
import java.util.HashMap;

public class PatrolEnemy extends Enemy {
    char currentDirection = 'w';
    public PatrolEnemy (ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //ObjectOnMap
        this.charOnMap = 'b';
        this.currentLocation = new int[]{0,0};
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.maxHp = 30;
        this.currentHp = maxHp;
        this.damage = 5;
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
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
    }
    public void addOnMap () {
        boolean newLocationSelected = false;
        while (!newLocationSelected) {
            int currentY = Engine.getEngine().random.nextInt(numberOfRowsMap);
            int currentX = Engine.getEngine().random.nextInt(numberOfColumnsMap);
            newLocation = new int[] {currentY,currentX};
            if (listLocationAndObjectOnMap.hasObjectAtLocation(newLocation) == null) {
                currentLocation = newLocation;
                listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
                newLocationSelected = true;
            }
        }
    }
    public void action () {
        if (!checkExistence()) {
            return;
        }
        boolean actionSuccess = false;
        //counter break cycle if person cant choose direction
        int counter = 0;
        while (!actionSuccess && counter < 10) {
            counter++;
            action.get(currentDirection).run();
            if (iterationLogic()) {
                listLocationAndObjectOnMap.removeObjectFromListLocationAndObjectOnMap(currentLocation);
                currentLocation = newLocation;
                listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
                actionSuccess = true;
            } else {
                char[] chars = {'w', 's', 'a', 'd'};
                currentDirection = chars[Engine.getEngine().random.nextInt(chars.length)];
            }
        }
        if (currentHp <= 0) {
            dispose();
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
            case '#', 's', 'b', 'd':
                return false;
            case '$', '-':
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
            case '@':
                listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).currentHp -= damage;
                if (listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).currentHp <= 0) {
                    listLocationAndObjectOnMap.hasObjectAtLocation(newLocation).dispose();
                }
                newLocation = currentLocation;
                return true;
        }
        return false;
    }

}
