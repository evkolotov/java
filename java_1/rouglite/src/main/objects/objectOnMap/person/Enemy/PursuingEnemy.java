package main.objects.objectOnMap.person.Enemy;

import main.engine.Engine;
import main.objects.ListLocationAndObjectOnMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.Collections;


public class PursuingEnemy extends Enemy {
    public PursuingEnemy (ListLocationAndObjectOnMap listLocationAndObjectOnMap) {
        //ObjectOnMap
        this.charOnMap = 'd';
        this.currentLocation = new int[]{0,0};
        this.listLocationAndObjectOnMap = listLocationAndObjectOnMap;
        this.maxHp = 30;
        this.currentHp = maxHp;
        this.damage = 5;
        this.numberOfRowsMap = Engine.getEngine().numberOfRowsMap;
        this.numberOfColumnsMap = Engine.getEngine().numberOfColumnsMap;
        //Person
        this.newLocation = new int[]{0,0};
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
        newLocation = findPathToHero();
        if (newLocation != null && iterationLogic()) {
            listLocationAndObjectOnMap.removeObjectFromListLocationAndObjectOnMap(currentLocation);
            currentLocation = newLocation;
            listLocationAndObjectOnMap.addObjectToListLocationAndObjectOnMap(currentLocation, this);
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
            case '#', 's', 'b', 'd', 't':
                return false;
            case '$':
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
    public boolean iterationLogicForFindPath (int[] checkLocation) {
        if (listLocationAndObjectOnMap.hasObjectAtLocation(checkLocation) == null) {
            return false;
        }
        char charOnNewLocation = listLocationAndObjectOnMap.hasObjectAtLocation(checkLocation).charOnMap;
        //CharForFindPerson
        ArrayList<Character> charStopForMove = new ArrayList<>();
        charStopForMove.add('#');
        charStopForMove.add('s');
        charStopForMove.add('b');
        charStopForMove.add('d');
        charStopForMove.add('t');
        return charStopForMove.contains(charOnNewLocation);
    }
    public int[] findPathToHero() {
        ArrayList<int[]> listHeroLocation = listLocationAndObjectOnMap.getListLocationByChar('@');
        if(listHeroLocation.size()==0) {
            return null;
        }
        int[] locationHero = listHeroLocation.get(0);

        //create mapForSearch, 0 empty, 1 busy
        int[][] mapForSearch = new int[numberOfRowsMap][numberOfColumnsMap];
        for (int i=0; i<numberOfRowsMap; i++) {
            for (int j=0; j<numberOfColumnsMap; j++) {
                int[] checkLocation = new int [] {i, j};
                if (iterationLogicForFindPath(checkLocation)) {
                    mapForSearch[i][j] = 1;
                }else {
                    mapForSearch[i][j] = 0;
                }
            }
        }

        List<int[]> path = new ArrayList<>();
        path.add(currentLocation);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(currentLocation);

        int[][] parents = new int[numberOfRowsMap][numberOfColumnsMap];
        for (int i = 0; i < numberOfRowsMap; i++) {
            for (int j = 0; j < numberOfColumnsMap; j++) {
                parents[i][j] = -1;
            }
        }

        boolean isFound = false;
        while (!queue.isEmpty() && !isFound) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if ((dx == 0 && dy == 0) || Math.abs(dx) == Math.abs(dy)) {
                        continue;
                    }
                    int newRow = row + dx;
                    int newCol = col + dy;
                    if (newRow >= 0 && newRow < numberOfRowsMap && newCol >= 0 && newCol < numberOfColumnsMap && mapForSearch[newRow][newCol] == 0 && parents[newRow][newCol] == -1) {
                        parents[newRow][newCol] = row * numberOfColumnsMap + col;
                        if (newRow == locationHero[0] && newCol == locationHero[1]) {
                            isFound = true;
                            break;
                        }
                        queue.add(new int[] {newRow, newCol});
                    }
                }
            }
        }

        if (isFound) {
            int[] current = locationHero;
            while (!Arrays.equals(current, currentLocation)) {
                path.add(current);
                int parent = parents[current[0]][current[1]];
                current = new int[] {parent / numberOfColumnsMap, parent % numberOfColumnsMap};
            }
            Collections.reverse(path);
        } else {
            path = null;
            return null;
        }
        return path.get(0);
    }
}
