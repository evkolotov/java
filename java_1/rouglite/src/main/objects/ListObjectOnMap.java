package main.objects;

import main.engine.Engine;
import main.objects.ObjectOnMapChecker;

import java.util.*;
import java.util.Map;

public class ListObjectOnMap implements ObjectOnMapChecker {
    private HashMap<Character, HashSet<int[]>> listObjectOnMap;
    public ListObjectOnMap() {
        listObjectOnMap = new HashMap<>();
    }

    public void addObjectToList(Character charOnMap, HashSet<int[]> locationList) {
        listObjectOnMap.put(charOnMap, locationList);
    }
    public void removeObjectToList(Character currentCharOnMap, int[] location) {
        listObjectOnMap.get(currentCharOnMap).removeIf(ints -> Arrays.equals(ints, location));
    }

    public HashMap<Character, HashSet<int[]>> getListObjectOnMap() {
        return listObjectOnMap;
    }
    @Override
    public char hasObjectAtLocation(int[] location) {
        for (Map.Entry<Character, HashSet<int[]>> entry : listObjectOnMap.entrySet()) {
            for (int[] loc : entry.getValue()) {
                if (Arrays.equals(loc, location)) {
                    return entry.getKey();
                }
            }
        }
        return '.';
    }


}
